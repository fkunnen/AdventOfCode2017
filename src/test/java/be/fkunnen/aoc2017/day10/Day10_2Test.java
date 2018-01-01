package be.fkunnen.aoc2017.day10;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Day10_2Test {

    private Day10_2 day10_2 = new Day10_2();

    @Test
    public void knotHash_emptyHash() {
        List<Integer> circularList = IntStream.rangeClosed(0, 255).boxed().collect(toList());
        String inputLengths = "";

        String denseHash = day10_2.knotHash(circularList, inputLengths);

        Assertions.assertThat(denseHash).isEqualTo("a2582a3a0e66e6e86e3812dcb672a272");
    }

    @Test
    public void knotHash_AoC_2017() {
        List<Integer> circularList = IntStream.rangeClosed(0, 255).boxed().collect(toList());
        String inputLengths = "AoC 2017";

        String denseHash = day10_2.knotHash(circularList, inputLengths);

        Assertions.assertThat(denseHash).isEqualTo("33efeb34ea91902bb2f59c9920caa6cd");
    }

    @Test
    public void knotHash_1comma2comma3() {
        List<Integer> circularList = IntStream.rangeClosed(0, 255).boxed().collect(toList());
        String inputLengths = "1,2,3";

        String denseHash = day10_2.knotHash(circularList, inputLengths);

        Assertions.assertThat(denseHash).isEqualTo("3efbe78a8d82f29979031a4aa0b16a9d");
    }

    @Test
    public void knotHash_1comma2comma4() {
        List<Integer> circularList = IntStream.rangeClosed(0, 255).boxed().collect(toList());
        String inputLengths = "1,2,4";

        String denseHash = day10_2.knotHash(circularList, inputLengths);

        Assertions.assertThat(denseHash).isEqualTo("63960835bcdc130f0b66d7ff4f6a5a8e");
    }

    @Test
    public void knotHash() {
        List<Integer> circularList = IntStream.rangeClosed(0, 255).boxed().collect(toList());
        String inputLengths = "14,58,0,116,179,16,1,104,2,254,167,86,255,55,122,244";

        System.out.println("Day 10 part 2: " + day10_2.knotHash(circularList, inputLengths));

    }
}
