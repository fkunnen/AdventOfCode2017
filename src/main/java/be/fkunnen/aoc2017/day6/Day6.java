package be.fkunnen.aoc2017.day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day6 {

    public int memoryReallocation(String input) {
        List<Integer> memoryBanks = parseInputToAListOfNumbers(input);

        int redistributionCycles = 0;

        List<List<Integer>> seenConfigurationsAfterReallocation = new ArrayList<>();

        boolean keepGoing = true;
        while (keepGoing){

            List<Integer> reallocatedMemoryBanks = reallocateMemoryBanks(memoryBanks);

            if (isInfiniteLoopDetected(reallocatedMemoryBanks, seenConfigurationsAfterReallocation)){
                keepGoing = false;
            }

            seenConfigurationsAfterReallocation.add(reallocatedMemoryBanks);
            memoryBanks = reallocatedMemoryBanks;
            redistributionCycles++;
        }

        return redistributionCycles;
    }

    private List<Integer> reallocateMemoryBanks(List<Integer> memoryBanks) {
        List<Integer> reallocatedMemoryBanks = new ArrayList<>(memoryBanks);
        int maxValue = reallocatedMemoryBanks.stream().max(Integer::compareTo).get();
        int indexOfMaxValue = getIndexOfMaxValue(reallocatedMemoryBanks, maxValue);
        int numberOfMemoryBanks = reallocatedMemoryBanks.size();

        reallocatedMemoryBanks.set(indexOfMaxValue, 0);

        for (int i = 1; i <= maxValue; i++){
            int indexToLowerValueWith1 = (indexOfMaxValue + i) % numberOfMemoryBanks;
            reallocatedMemoryBanks.set(indexToLowerValueWith1, reallocatedMemoryBanks.get(indexToLowerValueWith1) + 1);
        }

        return reallocatedMemoryBanks;
    }

    private int getIndexOfMaxValue(List<Integer> memoryBanks, int maxValue){
        int index = 0;
        while (true){
            if (memoryBanks.get(index) == maxValue){
                return index;
            }
            index++;
        }
    }

    private boolean isInfiniteLoopDetected(List<Integer> reallocatedMemoryBanks, List<List<Integer>> seenConfigurationsAfterReallocation) {
        return seenConfigurationsAfterReallocation.contains(reallocatedMemoryBanks);
    }

    private List<Integer> parseInputToAListOfNumbers(String input){
        return Arrays.stream(input.split("\t"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
