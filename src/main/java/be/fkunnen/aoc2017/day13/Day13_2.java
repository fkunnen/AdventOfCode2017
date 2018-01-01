package be.fkunnen.aoc2017.day13;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;

public class Day13_2 {

    public int packetScanners(String input) {
        int numberOfLayers = extraNumberOfLayers(input);

        Map<Integer, Integer> depthToRangeMap = extractDepthToRangeMap(input, numberOfLayers);

        int delay = 0;
        boolean isCaught = true;
        while (isCaught) {
            isCaught = false;
            for (int depth = 0; depth < numberOfLayers; depth++) {
                Integer range = depthToRangeMap.get(depth);
                if (isCaught(depth + delay, range)) {
                    isCaught = true;
                    delay++;
                    break;
                }
            }
        }

        return delay;
    }

    private boolean isCaught(int depth, Integer range) {
        return range > 0 && depth % (2 * (range-1)) == 0;
    }

    private int extraNumberOfLayers(String input) {
        return stream(input.split("\n")).map(s -> s.split(":")[0]).map(Integer::valueOf).reduce((first, second) -> second).get() + 1;
    }

    private Map<Integer, Integer> extractDepthToRangeMap(String input, int numberOfLayers) {
        Map<Integer, Integer> depthToRangeMap = IntStream.range(0, numberOfLayers).boxed().collect(Collectors.toMap(i -> i, i -> 0));

        for (String line : input.split("\n")){
            depthToRangeMap.put(Integer.valueOf(line.split(": ")[0]), Integer.valueOf(line.split(": ")[1]));
        }

        return depthToRangeMap;
    }

}
