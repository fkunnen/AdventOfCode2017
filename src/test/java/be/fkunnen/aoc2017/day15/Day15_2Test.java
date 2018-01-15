package be.fkunnen.aoc2017.day15;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day15_2Test {

    private Day15_2 day15_2 = new Day15_2();


    @Test
    public void duelingGenerators_example() {
        int generatorA = 65;
        int generatorB = 8921;

        int judgeCount = day15_2.duelingGenerators(generatorA, generatorB);

        assertThat(judgeCount).isEqualTo(309);
    }

    @Test
    public void duelingGenerators() {
        int generatorA = 512;
        int generatorB = 191;

        System.out.println("Day 15 part 2: " + day15_2.duelingGenerators(generatorA, generatorB));
    }
}
