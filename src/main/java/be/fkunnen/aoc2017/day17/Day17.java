package be.fkunnen.aoc2017.day17;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Day17 {

    private static final Integer MAX_NUMBER_TO_INSERT = 2017;


    public int spinlock(int numberOfSteps) {
        List<Integer> circularBuffer = IntStream.of(0).boxed().collect(toList());

        int currentPosition = 0;
        int numberToInsert = 1;

        circularBuffer = spinlock(circularBuffer, currentPosition, numberOfSteps, numberToInsert);

        return circularBuffer.get(circularBuffer.indexOf(MAX_NUMBER_TO_INSERT)+1);
    }

    private List<Integer> spinlock(List<Integer> circularBuffer, int currentPosition, int numberOfSteps, int numberToInsert){
        if (numberToInsert > MAX_NUMBER_TO_INSERT){
            return circularBuffer;
        }

        int positionToAddValueInCircularBuffer = getPosition(circularBuffer, currentPosition, numberOfSteps);
        circularBuffer.add(positionToAddValueInCircularBuffer, numberToInsert);
        System.out.println(circularBuffer);

        return spinlock(circularBuffer, circularBuffer.indexOf(numberToInsert), numberOfSteps, ++numberToInsert);
    }

    private int getPosition(List<Integer> circularBuffer, int currentPosition, int numberOfSteps) {
        return (currentPosition + numberOfSteps) % circularBuffer.size() + 1;
    }
}
