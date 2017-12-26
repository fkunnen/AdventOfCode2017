package be.fkunnen.aoc2017.day3;

import org.junit.Test;

import java.util.List;

import static be.fkunnen.aoc2017.day3.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    public void nextPointNorth() {
        Point point = new Point(3, -4);

        Point nextPoint = point.nextPoint(NORTH);

        assertThat(nextPoint).isEqualTo(new Point(3, -3));
    }

    @Test
    public void nextPointEast() {
        Point point = new Point(3, -4);

        Point nextPoint = point.nextPoint(EAST);

        assertThat(nextPoint).isEqualTo(new Point(4, -4));
    }

    @Test
    public void nextPointSouth() {
        Point point = new Point(3, -4);

        Point nextPoint = point.nextPoint(SOUTH);

        assertThat(nextPoint).isEqualTo(new Point(3, -5));
    }

    @Test
    public void nextPointWest() {
        Point point = new Point(3, -4);

        Point nextPoint = point.nextPoint(WEST);

        assertThat(nextPoint).isEqualTo(new Point(2, -4));
    }

    @Test
    public void neighbouringPoints() {
        Point point = new Point(1, -4);

        List<Point> neighboringPoints = point.neighbouringPoints();

        assertThat(neighboringPoints).containsExactlyInAnyOrder(getExpectedPoints());

    }

    private Point[] getExpectedPoints() {
        return new Point[] {
            new Point(2, -4),
            new Point(2, -3),
            new Point(1, -3),
            new Point(0, -3),
            new Point(0, -4),
            new Point(0, -5),
            new Point(1, -5),
            new Point(2, -5),
        };
    }


}