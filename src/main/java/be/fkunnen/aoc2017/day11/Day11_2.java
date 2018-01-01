package be.fkunnen.aoc2017.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day11_2 {

    public int hexEd(String input) {
        List<Direction> directions = Arrays.stream(input.split(",")).map(Direction::valueFromString).collect(Collectors.toList());

        List<Integer> distances = new ArrayList<>();

        Hex hex = new Hex(0,0);

        for (Direction direction : directions){
            hex = hex.getNeighbourHex(direction);
            distances.add(hex.manhattanDistance());
        }

        return distances.stream().max(Integer::compareTo).get();
    }


}
