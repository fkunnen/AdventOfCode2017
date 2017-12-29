package be.fkunnen.aoc2017.day7;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Day7_2 {


    public int recursiveCircus(String input) {
        Map<String, Program> nameToProgramsMap = getAllPrograms(input);
        addHeldPrograms(nameToProgramsMap, input);

        Program program = findProgramToRebalance(nameToProgramsMap.values());

        return findBalancedWeightOfWrongHeldProgram(program.getHeldPrograms(), program.weightsOfChildren());
    }

    private Map<String, Program> getAllPrograms(String input) {
        Map<String, Program> programs = new HashMap<>();

        List<String> programInformations = asList(input.split("\n"));

        for (String programInformation : programInformations){
            String programName = extractProgramName(programInformation);
            int programWeight = extraProgramWeight(programInformation);

            Program program = new Program(programName, programWeight);
            programs.put(programName, program);
        }

        return programs;
    }

    private String extractProgramName(String programInformation) {
        return programInformation.split(" ")[0];
    }

    private int extraProgramWeight(String programInformation) {
        Pattern pattern = Pattern.compile("\\((.*?)\\)");
        Matcher matcher = pattern.matcher(programInformation);
        matcher.find();
        return new Integer(matcher.group(1));
    }

    private List<Program> extractHeldPrograms(String programInformation, Map<String, Program> knownPrograms) {

        Pattern pattern = Pattern.compile("->\\s(.*)");
        Matcher matcher = pattern.matcher(programInformation);
        if (matcher.find()) {
            return Arrays.stream(matcher.group(1).split(", "))
                    .map(s -> knownPrograms.get(s))
                    .collect(toList());
        }

        return new ArrayList<>();
    }

    private void addHeldPrograms(Map<String, Program> nameToProgramsMap, String input) {
        List<String> programInformations = asList(input.split("\n"));

        for (String programInformation : programInformations){
            Program program = nameToProgramsMap.get(programInformation.split(" ")[0]);

            List<Program> heldPrograms = extractHeldPrograms(programInformation, nameToProgramsMap);

            program.addHeldPrograms(heldPrograms);
        }
    }

    private Program findProgramToRebalance(Collection<Program> programs) {
        return programs.stream().filter(p -> p.hasUnbalancedWeights() && p.haveChildrenBalancedWeights()).findFirst().get();
    }

    private int findBalancedWeightOfWrongHeldProgram(List<Program> heldPrograms, List<Integer> weightsOfHeldPrograms) {

        int correctChildWeight = weightsOfHeldPrograms.stream().filter(i -> Collections.frequency(weightsOfHeldPrograms, i) > 1).findFirst().get();
        int wrongChildWeight = weightsOfHeldPrograms.stream().filter(i -> Collections.frequency(weightsOfHeldPrograms, i) == 1).findFirst().get();

        Program wrongProgram = findProgramWithWrongTotalWeight(heldPrograms, wrongChildWeight);
        return wrongProgram.getWeight() + correctChildWeight - wrongChildWeight;
    }

    private Program findProgramWithWrongTotalWeight(List<Program> heldPrograms, int wrongChildWeight) {
        return heldPrograms.stream().filter(p -> wrongChildWeight == p.totalWeight()).findFirst().get();
    }

}
