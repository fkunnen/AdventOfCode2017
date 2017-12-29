package be.fkunnen.aoc2017.day10;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class Day10_2 {

    public String knotHash(List<Integer> circularList, String inputLengths) {
        List<Integer> adaptedInputLengths = adaptInputLengths(inputLengths);

        List<Integer> sparseHash = knotHash(circularList, adaptedInputLengths, 0, 0);

        return denseHash(sparseHash);
    }

    private List<Integer> adaptInputLengths(String inputLengths) {
        List<Integer> lengthsFromAscii = inputLengths.chars().boxed().collect(toList());
        List<Integer> extraLengths = IntStream.of(17, 31, 73, 47, 23).boxed().collect(toList());
        lengthsFromAscii.addAll(extraLengths);

        return lengthsFromAscii;
    }

    private List<Integer> knotHash(List<Integer> circularList, List<Integer> inputLengths, int currentPosition, int skipSize){
        if (skipSize == 64 * inputLengths.size()){
            return circularList;
        }

        int length = inputLengths.get(skipSize % inputLengths.size());

        List<Integer> listToReverse = getListToReverse(circularList, currentPosition, length);
        Collections.reverse(listToReverse);

        List<Integer> newCircularList = getNewCircularList(circularList, listToReverse, currentPosition, length);
        int newCurrentPosition = (currentPosition + length + skipSize) % circularList.size();

        return knotHash(newCircularList, inputLengths, newCurrentPosition, ++skipSize);
    }

    private List<Integer> getListToReverse(List<Integer> circularList, int currentPosition, int length) {
        List<Integer> listToReverse = new ArrayList<>();

        for (int i = 0; i < length; i++){
            listToReverse.add(circularList.get((currentPosition + i) % circularList.size()));
        }

        return listToReverse;
    }

    private List<Integer> getNewCircularList(List<Integer> circularList, List<Integer> reversedList, int currentPosition, int length) {
        List<Integer> newCircularList = new ArrayList<>(circularList);

        for (int i = 0; i < length; i++){
            newCircularList.set((currentPosition + i) % circularList.size(), reversedList.get(i));
        }

        return newCircularList;
    }

    private String denseHash(List<Integer> sparseHash) {
        StringBuilder denseHash = new StringBuilder("");
        for (int i = 0; i < 16; i++){
            String denseHashPart = Integer.toHexString(sparseHash.subList(16 * i, 16 * i + 16).stream().reduce(0, (x, y) -> x ^ y));
            denseHash.append(StringUtils.leftPad(denseHashPart, 2, '0'));
        }

        return denseHash.toString();
    }
}
