package be.fkunnen.aoc2017.day14;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day14_2Test {
    
    private Day14_2 day14_2 = new Day14_2();

    @Test
    public void diskDegragmentation_example() {
        String input = "flqrgnkx";

        int regions = day14_2.diskDefragmentation(input);

        assertThat(regions).isEqualTo(1242);
    }

    @Test
    public void diskDefragmentation() {
        String input = "amgozmfv";

        System.out.println("Day 14 part 2: " + day14_2.diskDefragmentation(input));
    }
}
