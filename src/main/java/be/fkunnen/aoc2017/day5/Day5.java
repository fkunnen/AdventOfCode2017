package be.fkunnen.aoc2017.day5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day5 {

    public int twistyTrampolineSteps(String input) {
        List<Integer> instructions = parseInputToAListOfNumbers(input);
        int numberOfInstructions = instructions.size();

        int currentInstructionNumber = 0;
        int steps = 0;

        while (currentInstructionNumber < numberOfInstructions){
            int offSet = instructions.get(currentInstructionNumber);
            int nextInstructionNumber = currentInstructionNumber + offSet;

            instructions.set(currentInstructionNumber, offSet + 1);

            currentInstructionNumber = nextInstructionNumber;

            steps++;
        }

        return steps;
    }

    private List<Integer> parseInputToAListOfNumbers(String input){
        return Arrays.stream(input.split("\n"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

}
