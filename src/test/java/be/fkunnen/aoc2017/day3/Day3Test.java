package be.fkunnen.aoc2017.day3;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static be.fkunnen.aoc2017.day3.Day3.POINT_NUMBER_1_IN_SPIRAL;

public class Day3Test {
    
    private Day3 day3 = new Day3();

    @Test
    public void manhattanDistance_1_0steps() {
        int steps = day3.manhattanDistance(1L);

        Assertions.assertThat(steps).isEqualTo(0);
    }

    @Test
    public void manhattanDistance_12_3steps() {
        int steps = day3.manhattanDistance(12L);

        Assertions.assertThat(steps).isEqualTo(3);
    }

    @Test
    public void manhattanDistance_23_2steps() {
        int steps = day3.manhattanDistance(23L);

        Assertions.assertThat(steps).isEqualTo(2);
    }

    @Test
    public void manhattanDistance_26_5steps() {
        int steps = day3.manhattanDistance(26L);

        Assertions.assertThat(steps).isEqualTo(5);
    }

    @Test
    public void manhattanDistance_1024_31steps() {
        int steps = day3.manhattanDistance(1024L);

        Assertions.assertThat(steps).isEqualTo(31);
    }

    @Test
    public void manhattanDistance() {
        System.out.println("Day 3 part 1: " + day3.manhattanDistance(325489L));
    }

    @Test
    public void manhattanDistanceFormulae_23() {
        Point point23 = new Point(0, 2);
        int steps = day3.manhattanDistance(POINT_NUMBER_1_IN_SPIRAL, point23);

        Assertions.assertThat(steps).isEqualTo(2);
    }

    @Test
    public void manhattanDistanceFormulae_12() {
        Point point12 = new Point(2, 1);
        int steps = day3.manhattanDistance(POINT_NUMBER_1_IN_SPIRAL, point12);

        Assertions.assertThat(steps).isEqualTo(3);
    }

    @Test
    public void manhattanDistanceFormulae_21() {
        Point point21 = new Point(-2, -2);
        int steps = day3.manhattanDistance(POINT_NUMBER_1_IN_SPIRAL, point21);

        Assertions.assertThat(steps).isEqualTo(4);
    }

}
