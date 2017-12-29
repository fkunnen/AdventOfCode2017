package be.fkunnen.aoc2017.day8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

public class Day8 {

    private ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");


    public int registers(String input) throws ScriptException {
        Map<String, Integer> registers = extractRegisters(input);
        List<String> instructions = extractInstructions(input);
        List<String> conditions = extractConditions(input);

        for (int i = 0; i < instructions.size(); i++){
            if (evaluateCondition(conditions.get(i), registers)){
                evaluateInstruction(instructions.get(i), registers);
            }
        }

        return registers.values().stream().max(Integer::compareTo).get();
    }

    private Map<String, Integer> extractRegisters(String input) {
        return stream(input.split("\n")).map(s -> s.split(" ")[0]).distinct().collect(toMap(s -> s, v -> 0));
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

    private boolean evaluateCondition(String condition, Map<String, Integer> registers) throws ScriptException {
        String registerName = String.valueOf(condition.split(" ")[0]);

        String adaptedCondition = condition.replaceAll(registerName, String.valueOf(registers.get(registerName)));

        return (boolean) engine.eval(adaptedCondition);
    }

    private void evaluateInstruction(String instruction, Map<String, Integer> registers) throws ScriptException {
        String registerName = String.valueOf(instruction.split(" ")[0]);

        String adaptedInstruction = instruction.replaceAll(registerName, String.valueOf(registers.get(registerName)));

        int newRegisterValue = (int) engine.eval(adaptedInstruction);

        registers.put(registerName, newRegisterValue);
    }

}
