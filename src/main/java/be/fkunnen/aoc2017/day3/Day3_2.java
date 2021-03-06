package be.fkunnen.aoc2017.day3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static be.fkunnen.aoc2017.day3.Direction.EAST;
import static be.fkunnen.aoc2017.day3.Direction.turnLeft;
import static java.lang.Math.abs;

public class Day3_2 {


    public long spiralSumAdjacentSquares(long input) {
        Map<Point, Long> pointsToSumsMap = new HashMap<>();

        // Initialize Point(0,0) with sum 1 and set initial direction to EAST
        Direction currentDirection = EAST;
        Point point = new Point(0,0);
        long sum = 1L;

        pointsToSumsMap.put(point, sum);

        while (sum < input){
            point = point.nextPoint(currentDirection);

            sum = sumOfNeighbourPoints(point, pointsToSumsMap);
            pointsToSumsMap.put(point, sum);

            if (doINeedToMakeATurnInTheSpiral(point)){
                currentDirection = turnLeft(currentDirection);
            }
        }

        return sum;
    }

    private long sumOfNeighbourPoints(Point point, Map<Point, Long> pointsToSumsMap) {
        List<Point> neighbourPoints = point.neighbourPoints();

        long sum = 0;
        for (Point neighbourPoint : neighbourPoints){
            if (pointsToSumsMap.containsKey(neighbourPoint)){
                sum += pointsToSumsMap.get(neighbourPoint);
            }
        }

        return sum;
    }


    public boolean doINeedToMakeATurnInTheSpiral(Point currentPointInSpiral){
        int x = currentPointInSpiral.getX();
        int y = currentPointInSpiral.getY();

        return isTurnInRightLowerCorner(x, y) || isTurnInOtherCorners(x, y);
    }

    private boolean isTurnInOtherCorners(int x, int y) {
        return abs(x) == abs(y) && !(x > 0 && y < 0);
    }

    private boolean isTurnInRightLowerCorner(int x, int y) {
        return x > 0 && x + y == 1;
    }

}
