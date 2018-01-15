package be.fkunnen.aoc2017.day15;

import org.apache.commons.lang3.StringUtils;

public class Day15 {

    private static final int FACTOR_A = 16807;
    private static final int FACTOR_B = 48271;

    private static final int NUMBER_OF_DUELS = 40000000;

    public int duelingGenerators(int generatorA, int generatorB) {
        int judgeCount = 0;

        long valueA = generatorA;
        long valueB = generatorB;

        for (int i = 0; i < NUMBER_OF_DUELS; i++){
            valueA = (valueA * FACTOR_A) % Integer.MAX_VALUE;
            valueB = (valueB * FACTOR_B) % Integer.MAX_VALUE;

            if (sameLast16bits(valueA, valueB)){
                judgeCount++;
            }
        }

        return judgeCount;
    }

    private boolean sameLast16bits(long valueA, long valueB) {
        String binaryValueA = StringUtils.leftPad(Long.toBinaryString(valueA), 16, '0');
        String binaryValueB = StringUtils.leftPad(Long.toBinaryString(valueB), 16, '0');

        String last16bitsBinaryValueA = binaryValueA.substring(binaryValueA.length() - 16, binaryValueA.length());
        String last16bitsBinaryValueB = binaryValueB.substring(binaryValueB.length() - 16, binaryValueB.length());

        return last16bitsBinaryValueA.equals(last16bitsBinaryValueB);
    }
}
