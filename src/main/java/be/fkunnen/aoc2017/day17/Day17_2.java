package be.fkunnen.aoc2017.day17;

public class Day17_2 {

    private static final Integer MAX_NUMBER_TO_INSERT = 50000000;

    public int spinlock(int numberOfSteps) {
        int maxNumberAtFirstPosition = 0;
        int position = 0;

        for (int i = 1; i <= MAX_NUMBER_TO_INSERT; i++){
            position = getPosition(i, position, numberOfSteps);
            if (position == 1){
                maxNumberAtFirstPosition = i;
            }
        }

        return maxNumberAtFirstPosition;
    }

    private int getPosition(int bufferLength, int currentPosition, int numberOfSteps) {
        return (currentPosition + numberOfSteps) % bufferLength + 1;
    }

}
