package be.fkunnen.aoc2017.day16;

import java.util.Collections;
import java.util.List;

public class Exchange implements DanceMove {

    private int positionA;
    private int positionB;

    public Exchange(int positionA, int positionB) {
        this.positionA = positionA;
        this.positionB = positionB;
    }

    @Override
    public void move(List<String> input) {
        Collections.swap(input, positionA, positionB);
    }

}
