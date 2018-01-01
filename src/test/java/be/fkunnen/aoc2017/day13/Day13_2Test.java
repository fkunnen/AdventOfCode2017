package be.fkunnen.aoc2017.day13;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day13_2Test {

    private Day13_2 day13_2 = new Day13_2();

    @Test
    public void packetScanners_example() {
        String input =
                "0: 3\n" +
                "1: 2\n" +
                "4: 4\n" +
                "6: 4";

        int delay = day13_2.packetScanners(input);

        Assertions.assertThat(delay).isEqualTo(10);
    }

    @Test
    public void packetScanners() {
        String input =
                "0: 3\n" +
                "1: 2\n" +
                "2: 4\n" +
                "4: 8\n" +
                "6: 5\n" +
                "8: 6\n" +
                "10: 6\n" +
                "12: 4\n" +
                "14: 6\n" +
                "16: 6\n" +
                "18: 17\n" +
                "20: 8\n" +
                "22: 8\n" +
                "24: 8\n" +
                "26: 9\n" +
                "28: 8\n" +
                "30: 12\n" +
                "32: 12\n" +
                "34: 10\n" +
                "36: 12\n" +
                "38: 12\n" +
                "40: 8\n" +
                "42: 12\n" +
                "44: 12\n" +
                "46: 10\n" +
                "48: 12\n" +
                "50: 12\n" +
                "52: 14\n" +
                "54: 14\n" +
                "56: 12\n" +
                "58: 14\n" +
                "60: 14\n" +
                "62: 14\n" +
                "64: 14\n" +
                "66: 14\n" +
                "68: 12\n" +
                "70: 14\n" +
                "72: 14\n" +
                "74: 14\n" +
                "76: 14\n" +
                "80: 18\n" +
                "82: 14\n" +
                "90: 18";

        System.out.println("Day 13 part 2: " + day13_2.packetScanners(input));
    }
}
