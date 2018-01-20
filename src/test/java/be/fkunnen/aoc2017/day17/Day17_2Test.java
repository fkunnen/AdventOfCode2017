package be.fkunnen.aoc2017.day17;

import org.junit.Test;

public class Day17_2Test {

    private Day17_2 day17_2 = new Day17_2();

    @Test
    public void spinlock() {
        int numberOfSteps = 344;

        System.out.println("Day 17 part 2: " + day17_2.spinlock(numberOfSteps));
    }
}
