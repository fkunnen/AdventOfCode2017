package be.fkunnen.aoc2017.day7;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.*;
import static java.util.Arrays.asList;

public class Day7 {


    public String recursiveCircus(String input) {
        List<String> allPrograms = getAllPrograms(input);
        List<String> allHeldPrograms = getAllHeldPrograms(input);

        // AllPrograms = allHeldPrograms + 1 program, that's the one we need'
        for (String program : allPrograms){
            if (!allHeldPrograms.contains(program)){
                return program;
            }
        }
        return "";
    }

    private List<String> getAllPrograms(String input) {
        List<String> programs = new ArrayList<>();

        List<String> lines = asList(input.split("\n"));

        for (String line : lines){
            programs.add(line.split(" ")[0]);
        }

        return programs;
    }

    private List<String> getAllHeldPrograms(String input) {
        Set<String> programs = new HashSet<>();

        List<String> lines = asList(input.split("\n"));

        for (String line : lines){
            List<String> lineElements = asList(line.split("-> "));
            if (lineElements.size() > 1){
                List<String> heldPrograms = asList(lineElements.get(1).split(", "));
                programs.addAll(heldPrograms);
            }
        }

        return new ArrayList<>(programs);
    }
}
