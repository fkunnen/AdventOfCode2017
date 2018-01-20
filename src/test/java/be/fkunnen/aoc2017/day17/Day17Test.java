package be.fkunnen.aoc2017.day17;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day17Test {

    private Day17 day17 = new Day17();


    @Test
    public void spinlock_3steps() {
        int numberOfSteps = 3;

        int numberAfterLastValueWritten = day17.spinlock(numberOfSteps);

        Assertions.assertThat(numberAfterLastValueWritten).isEqualTo(638);
    }

    @Test
    public void spinlock() {
        int numberOfSteps = 344;

        System.out.println("Day 17 part 1: " + day17.spinlock(numberOfSteps));
    }
}
