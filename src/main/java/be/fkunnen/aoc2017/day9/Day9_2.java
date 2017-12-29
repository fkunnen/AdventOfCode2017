package be.fkunnen.aoc2017.day9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day9_2 {

    public int streamProcessing(String input) {
        String withoutEscapedCharacters = input.replaceAll("!.", "");

        Pattern pattern = Pattern.compile("<(.*?)>");
        Matcher matcher = pattern.matcher(withoutEscapedCharacters);

        int sum = 0;
        while (matcher.find()) {
            sum += matcher.group().length()-2;
        }

        return sum;
    }

}
