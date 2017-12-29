package be.fkunnen.aoc2017.day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day10 {

    public int knotHash(List<Integer> circularList, List<Integer> inputLengths) {
        return knotHash(circularList, inputLengths, 0, 0);
    }

    private int knotHash(List<Integer> circularList, List<Integer> inputLengths, int currentPosition, int skipSize){
        if (skipSize == inputLengths.size()){
            return circularList.get(0) * circularList.get(1);
        }

        int length = inputLengths.get(skipSize);

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
}
