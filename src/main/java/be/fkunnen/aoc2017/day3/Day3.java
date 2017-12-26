package be.fkunnen.aoc2017.day3;


import static java.lang.Math.*;

public class Day3 {

    static final Point POINT_NUMBER_1_IN_SPIRAL = new Point(0, 0);


    public int manhattanDistance(long numberInSpiral) {
        long maxNumberOnThisLevelInSpiral = closestNumberLargerThanNumberInSpiralThatHasAnOddIntegerSquareRoot(numberInSpiral);

        int minimumDistance = (int) ((sqrt(maxNumberOnThisLevelInSpiral) - 1) / 2);

        // The point location of maxNumberOnThisLevelInSpiral is now new Point(minimumDistance, -minimumDistance)
        int x = minimumDistance;
        int y = -minimumDistance;

        long difference = maxNumberOnThisLevelInSpiral - numberInSpiral;
        for (int i = 0; i < difference; i++){
            if (i >= 6 * minimumDistance){
                // In this case lower the y-coordinate
                y--;
            }
            else if (i >= 4 * minimumDistance){
                // In this case raise the x-coordinate
                x++;
            }
            else if (i >= 2 * minimumDistance){
                // In this case raise the y-coordinate
                y++;
            }
            else {
                // In this case lower the x-coordinate
                x--;
            }
        }

        Point pointOfNumberInSpiral = new Point(x, y);

        return manhattanDistance(POINT_NUMBER_1_IN_SPIRAL, pointOfNumberInSpiral);
    }

    private long closestNumberLargerThanNumberInSpiralThatHasAnOddIntegerSquareRoot(long numberInSpiral) {
        double squareRoot = (long) ceil(sqrt(numberInSpiral));

        if (squareRoot % 2 == 0){
            squareRoot++;
        }

        return (long) Math.pow(squareRoot, 2);
    }

    public int manhattanDistance(Point point1, Point point2){
        return abs(point1.getX() - point2.getX()) + abs(point1.getY() - point2.getY());
    }

}
