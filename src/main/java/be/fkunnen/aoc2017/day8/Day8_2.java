package be.fkunnen.aoc2017.day8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

public class Day8_2 {

    private ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");


    public int registers(String input) throws ScriptException {
        Map<String, List<Integer>> registers = extractRegisters(input);
        List<String> instructions = extractInstructions(input);
        List<String> conditions = extractConditions(input);

        for (int i = 0; i < instructions.size(); i++){
            if (evaluateCondition(conditions.get(i), registers)){
                evaluateInstruction(instructions.get(i), registers);
            }
        }

        return registers.values().stream().flatMap(List::stream).max(Integer::compareTo).get();
    }

    private Map<String, List<Integer>> extractRegisters(String input) {
        return stream(input.split("\n")).map(s -> s.split(" ")[0]).distinct().collect(toMap(s -> s, v -> asList(0)));
    }

    private List<String> extractInstructions(String input){
        return stream(input.split("\n"))
                .map(s -> s.split(" if ")[0])
                .map(s -> s.replaceAll("inc", "+"))
                .map(s -> s.replaceAll("dec", "-"))
                .collect(Collectors.toList());
    }

    private List<String> extractConditions(String input){
        return stream(input.split("\n")).map(s -> s.split(" if ")[1]).collect(Collectors.toList());
    }

    private boolean evaluateCondition(String condition, Map<String, List<Integer>> registers) throws ScriptException {
        String registerName = String.valueOf(condition.split(" ")[0]);

        String adaptedCondition = condition.replaceAll(registerName, String.valueOf(registers.get(registerName).get(registers.get(registerName).size()-1)));

        return (boolean) engine.eval(adaptedCondition);
    }

    private void evaluateInstruction(String instruction, Map<String, List<Integer>> registers) throws ScriptException {
        String registerName = String.valueOf(instruction.split(" ")[0]);

        String adaptedInstruction = instruction.replaceAll(registerName, String.valueOf(registers.get(registerName).get(registers.get(registerName).size()-1)));

        int newRegisterValue = (int) engine.eval(adaptedInstruction);

        List<Integer> newValues = new ArrayList<>(registers.get(registerName));
        newValues.add(newRegisterValue);
        registers.put(registerName, newValues);
    }

}
