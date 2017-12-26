package be.fkunnen.aoc2017.day3;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day3_2Test {

    private Day3_2 day3_2 = new Day3_2();

    @Test
    public void spiralSumAdjacentSquares(){
        System.out.println(day3_2.spiralSumAdjacentSquares(325489L));
    }

    @Test
    public void spiralSumAdjacentSquares_input6_nextNumberInSpiralIs10() {
        long nextNumberInSpiral = day3_2.spiralSumAdjacentSquares(6L);

        assertThat(nextNumberInSpiral).isEqualTo(10);
    }

    @Test
    public void spiralSumAdjacentSquares_input800_nextNumberInSpiralIs806() {
        long nextNumberInSpiral = day3_2.spiralSumAdjacentSquares(800L);

        assertThat(nextNumberInSpiral).isEqualTo(806);
    }

    @Test
    public void doINeedToMakeATurnInTheSpiral_Point3Minus3_false() {
        Point point = new Point(3, -3);

        boolean turn = day3_2.doINeedToMakeATurnInTheSpiral(point);

        assertThat(turn).isFalse();
    }

    @Test
    public void doINeedToMakeATurnInTheSpiral_Point3Minus2_true() {
        Point point = new Point(3, -2);

        boolean turn = day3_2.doINeedToMakeATurnInTheSpiral(point);

        assertThat(turn).isTrue();
    }

    @Test
    public void doINeedToMakeATurnInTheSpiral_Point3_3_true() {
        Point point = new Point(3, 3);

        boolean turn = day3_2.doINeedToMakeATurnInTheSpiral(point);

        assertThat(turn).isTrue();
    }

    @Test
    public void doINeedToMakeATurnInTheSpiral_PointMinus3_3_true() {
        Point point = new Point(-3, 3);

        boolean turn = day3_2.doINeedToMakeATurnInTheSpiral(point);

        assertThat(turn).isTrue();
    }

    @Test
    public void doINeedToMakeATurnInTheSpiral_PointMinus3Minus3_true() {
        Point point = new Point(-3, -3);

        boolean turn = day3_2.doINeedToMakeATurnInTheSpiral(point);

        assertThat(turn).isTrue();
    }
}
