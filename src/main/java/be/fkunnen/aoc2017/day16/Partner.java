package be.fkunnen.aoc2017.day16;

import java.util.Collections;
import java.util.List;

public class Partner implements DanceMove {

    private String programNameA;
    private String programNameB;

    public Partner(String programNameA, String programNameB) {
        this.programNameA = programNameA;
        this.programNameB = programNameB;
    }

    @Override
    public void move(List<String> input) {
        Collections.swap(input, input.indexOf(programNameA), input.indexOf(programNameB));
    }

}
