package be.fkunnen.aoc2017.day14;

import be.fkunnen.aoc2017.day10.Day10_2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.countMatches;

public class Day14 {

    private Day10_2 day10_2 = new Day10_2();

    public int diskDefragmentation(String input) {
        List<Integer> circularList = IntStream.rangeClosed(0, 255).boxed().collect(toList());

        List<String> binaryDenseHashes = new ArrayList<>();

        for (int i=0; i < 128; i++) {
            String denseHash = day10_2.knotHash(circularList, input + "-" + i);
            binaryDenseHashes.add(hexadecimalToBinary(denseHash));
        }

        return binaryDenseHashes.stream().map(s -> countMatches(s, "1")).reduce(0, (x, y) -> x + y);
    }

    private String hexadecimalToBinary(String denseHash) {
        return new BigInteger(denseHash, 16).toString(2);
    }

}
