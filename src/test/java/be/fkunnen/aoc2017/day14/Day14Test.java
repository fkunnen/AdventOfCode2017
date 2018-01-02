package be.fkunnen.aoc2017.day14;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day14Test {
    
    private Day14 day14 = new Day14();

    @Test
    public void diskDegragmentation_example() {
        String input = "flqrgnkx";

        int usedSquares = day14.diskDefragmentation(input);

        assertThat(usedSquares).isEqualTo(8108);
    }

    @Test
    public void diskDefragmentation() {
        String input = "amgozmfv";

        System.out.println("Day 14 part 1: " + day14.diskDefragmentation(input));
    }
}
