package be.fkunnen.aoc2017.day5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day5_2 {

    public int twistyTrampolineSteps(String input) {
        List<Integer> instructions = parseInputToAListOfNumbers(input);
        int numberOfInstructions = instructions.size();

        int currentInstructionNumber = 0;
        int steps = 0;

        while (currentInstructionNumber < numberOfInstructions){
            int offSet = instructions.get(currentInstructionNumber);
            int nextInstructionNumber = currentInstructionNumber + offSet;

            instructions.set(currentInstructionNumber, getNewOffSetAtCurrentInstructionNumber(offSet));

            currentInstructionNumber = nextInstructionNumber;

            steps++;
        }

        return steps;
    }

    private int getNewOffSetAtCurrentInstructionNumber(int offSet) {
        if (offSet >= 3){
            return offSet - 1;
        }
        return offSet + 1;
    }

    private List<Integer> parseInputToAListOfNumbers(String number){
        return Arrays.stream(number.split("\n"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

}
