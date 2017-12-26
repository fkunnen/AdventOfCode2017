package be.fkunnen.aoc2017.day4;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;

public class Day4_2 {

    public int numberOfValidPassphrases(String input) {
        List<String> lines = asList(input.split("\n"));
        int numberOfValidLines = lines.size();

        for (String line : lines){
            List<String> words = getWordsWithLettersScrambledAlphabetically(line);
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

    private List<String> getWordsWithLettersScrambledAlphabetically(String line) {
        List<String> wordsWithLettersScrambledAlphabetically = new ArrayList<>();

        List<String> words = asList(line.split(" "));
        for (String word : words){
            List<String> letters = asList(word.split(""));
            letters.sort(String::compareTo);
            wordsWithLettersScrambledAlphabetically.add(letters.stream().collect(joining()));
        }

        return wordsWithLettersScrambledAlphabetically;
    }

}
