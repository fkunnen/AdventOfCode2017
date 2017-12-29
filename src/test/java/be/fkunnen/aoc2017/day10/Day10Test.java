package be.fkunnen.aoc2017.day10;

import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class Day10Test {

    private Day10 day10 = new Day10();

    @Test
    public void knotHash_example() {
        List<Integer> circularList = IntStream.rangeClosed(0, 4).boxed().collect(toList());
        List<Integer> inputLengths = IntStream.of(3, 4, 1, 5).boxed().collect(toList());

        int result = day10.knotHash(circularList, inputLengths);

        assertThat(result).isEqualTo(12);
    }

    @Test
    public void knotHash() {
        List<Integer> circularList = IntStream.rangeClosed(0, 255).boxed().collect(toList());
        List<Integer> inputLengths = IntStream.of(14, 58, 0, 116, 179, 16, 1, 104, 2, 254, 167, 86, 255, 55, 122, 244).boxed().collect(toList());

        System.out.println("Day 10 part 1: " + day10.knotHash(circularList, inputLengths));

    }
}
