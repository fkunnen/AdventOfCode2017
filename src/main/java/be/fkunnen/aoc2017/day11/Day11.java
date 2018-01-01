package be.fkunnen.aoc2017.day11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day11 {

    public int hexEd(String input) {
        List<Direction> directions = Arrays.stream(input.split(",")).map(Direction::valueFromString).collect(Collectors.toList());

        Hex hex = new Hex(0,0);

        for (Direction direction : directions){
            hex = hex.getNeighbourHex(direction);
        }

        return hex.manhattanDistance();
    }


}
