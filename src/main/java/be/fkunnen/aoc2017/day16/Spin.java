package be.fkunnen.aoc2017.day16;

import java.util.Collections;
import java.util.List;

public class Spin implements DanceMove{

    private int numberOfPrograms;

    public Spin(int numberOfPrograms) {
        this.numberOfPrograms = numberOfPrograms;
    }

    @Override
    public void move(List<String> input) {
        for (int i = 0; i < numberOfPrograms; i++) {
            String lastProgram = input.get(input.size()-1);
            input.remove(input.size()-1);
            input.add(0, lastProgram);
        }
    }

}
