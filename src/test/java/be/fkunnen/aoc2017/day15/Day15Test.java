package be.fkunnen.aoc2017.day15;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day15Test {

    private Day15 day15 = new Day15();


    @Test
    public void duelingGenerators_example() {
        int generatorA = 65;
        int generatorB = 8921;

        int judgeCount = day15.duelingGenerators(generatorA, generatorB);

        assertThat(judgeCount).isEqualTo(588);
    }

    @Test
    public void duelingGenerators() {
        int generatorA = 512;
        int generatorB = 191;

        System.out.println("Day 15 part 1: " + day15.duelingGenerators(generatorA, generatorB));
    }
}
