package be.fkunnen.aoc2017.day11;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static be.fkunnen.aoc2017.day11.Direction.*;
import static java.lang.Math.abs;

public class Hex {


    private static final Map<Direction, Hex> NEIGHBOURS = initNeighbours();

    private int col;
    private int row;


    public Hex(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public Hex getNeighbourHex(Direction direction){
        Hex neighbour = NEIGHBOURS.get(direction);
        return new Hex(getCol() + neighbour.getCol(),getRow() + neighbour.getRow());
    }

    private int manhattanDistance(Hex hex){
        int colDifference = getCol() - hex.getCol();
        int rowDifference = getRow() - hex.getRow();
        int delta = rowDifference - colDifference;
        return IntStream.of(abs(colDifference), abs(rowDifference), abs(delta)).max().getAsInt();
    }

    public int manhattanDistance(){
        return manhattanDistance(new Hex(0,0));
    }

    private static Map<Direction, Hex> initNeighbours() {
        Map<Direction, Hex> neighbours = new HashMap<>();
        neighbours.put(NORTH, new Hex(0, 1));
        neighbours.put(NORTH_EAST, new Hex(1, 1));
        neighbours.put(SOUTH_EAST, new Hex(1, 0));
        neighbours.put(SOUTH, new Hex(0, -1));
        neighbours.put(SOUTH_WEST, new Hex(-1, -1));
        neighbours.put(NORTH_WEST, new Hex(-1, 0));
        return neighbours;
    }

    @Override
    public String toString() {
        return "Hex{" +
                "col=" + col +
                ", row=" + row +
                '}';
    }
}
