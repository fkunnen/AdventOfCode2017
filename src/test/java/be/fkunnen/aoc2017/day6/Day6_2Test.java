package be.fkunnen.aoc2017.day6;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day6_2Test {

    private Day6_2 day6_2 = new Day6_2();

    @Test
    public void memoryReallocation_example() {
        String input = "0\t2\t7\t0";

        int steps = day6_2.memoryReallocation(input);

        Assertions.assertThat(steps).isEqualTo(4);
    }

    @Test
    public void memoryReallocation() {
        String input =
                "11\t11\t13\t7\t0\t15\t5\t5\t4\t4\t1\t1\t7\t1\t15\t11";

        System.out.println("Day 6 part 2: " + day6_2.memoryReallocation(input));
    }

}
