package be.fkunnen.aoc2017.day15;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.leftPad;

public class Day15_2 {

    private static final int FACTOR_A = 16807;
    private static final int FACTOR_B = 48271;

    private static final int NUMBER_OF_DUELS = 5000000;

    public int duelingGenerators(int generatorA, int generatorB) {
        int judgeCount = 0;

        List<Long> valuesGeneratorA = getValuesGeneratorA(generatorA);
        List<Long> valuesGeneratorB = getValuesGeneratorB(generatorB);

        for (int i = 0; i < NUMBER_OF_DUELS; i++){

            if (sameLast16bits(valuesGeneratorA.get(i), valuesGeneratorB.get(i))){
                judgeCount++;
            }
        }

        return judgeCount;
    }

    private List<Long> getValuesGeneratorA(long valueA) {
        List<Long> result = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_DUELS; i++) {
            valueA = (valueA * FACTOR_A) % Integer.MAX_VALUE;

            while (!multipleOf4(valueA)){
                valueA = (valueA * FACTOR_A) % Integer.MAX_VALUE;
            }

            result.add(valueA);
        }
        return result;
    }

    private List<Long> getValuesGeneratorB(long valueB) {
        List<Long> result = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_DUELS; i++) {
            valueB = (valueB * FACTOR_B) % Integer.MAX_VALUE;

            while (!multipleOf8(valueB)){
                valueB = (valueB * FACTOR_B) % Integer.MAX_VALUE;
            }

            result.add(valueB);
        }

        return result;
    }


    private boolean sameLast16bits(long valueA, long valueB) {
        String binaryValueA = leftPad(Long.toBinaryString(valueA), 16, '0');
        String binaryValueB = leftPad(Long.toBinaryString(valueB), 16, '0');

        String last16bitsBinaryValueA = binaryValueA.substring(binaryValueA.length() - 16, binaryValueA.length());
        String last16bitsBinaryValueB = binaryValueB.substring(binaryValueB.length() - 16, binaryValueB.length());

        return last16bitsBinaryValueA.equals(last16bitsBinaryValueB);
    }


    private boolean multipleOf4(long valueA) {
        return valueA % 4 == 0;
    }

    private boolean multipleOf8(long valueB) {
        return valueB % 8 == 0;
    }

}
