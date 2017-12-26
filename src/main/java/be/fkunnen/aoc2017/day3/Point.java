package be.fkunnen.aoc2017.day3;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static be.fkunnen.aoc2017.day3.Direction.EAST;
import static be.fkunnen.aoc2017.day3.Direction.NORTH;
import static be.fkunnen.aoc2017.day3.Direction.SOUTH;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point nextPoint(Direction currentDirection) {
        if (currentDirection == NORTH){
            return new Point(x, y+1);
        }
        else if (currentDirection == EAST){
            return new Point(x+1, y);
        }
        else if (currentDirection == SOUTH){
            return new Point(x, y-1);
        }
        else {
            return new Point(x-1, y);
        }
    }

    public List<Point> neighbouringPoints(){
        return Arrays.asList(
                new Point(x+1, y),
                new Point(x+1,y+1),
                new Point(x, y+1),
                new Point(x-1,y+1),
                new Point(x-1, y),
                new Point(x-1,y-1),
                new Point(x,y -1),
                new Point(x+1,y-1)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}
