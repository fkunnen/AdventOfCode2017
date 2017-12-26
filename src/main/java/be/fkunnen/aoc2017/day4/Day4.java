package be.fkunnen.aoc2017.day4;

import java.util.Arrays;
import java.util.List;

public class Day4 {


    public int numberOfValidPassphrases(String input) {
        List<String> lines = Arrays.asList(input.split("\n"));
        int numberOfValidLines = lines.size();

        for (String line : lines){
            List<String> words = Arrays.asList(line.split(" "));
            words.sort(String::compareTo);
            for (int i = 0; i < words.size(); i++){
                if (words.get(i).equals(words.get((i+1)%words.size()))){
                    numberOfValidLines--;
                    break;
                }
            }
        }

        return numberOfValidLines;
    }
}
