package be.fkunnen.aoc2017.day14;

import be.fkunnen.aoc2017.day10.Day10_2;
import be.fkunnen.aoc2017.day3.Point;
import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Day14_2 {

    private Day10_2 day10_2 = new Day10_2();

    public int diskDefragmentation(String input) {
        List<Integer> circularList = IntStream.rangeClosed(0, 255).boxed().collect(toList());

        List<Point> points = pointsOfUsedSquares(input, circularList);

        return countRegions(points);
    }

    private int countRegions(List<Point> points) {
        Set<Point> consideredPoints = new HashSet<>();
        int regions = 0;

        for (Point point : points){
            if (!consideredPoints.contains(point)) {
                List<Point> neighbourPoints = getAllNeighbourPoints(point, points, new ArrayList<>());
                consideredPoints.addAll(neighbourPoints);
                regions++;
            }
        }

        return regions;
    }

    private List<Point> getAllNeighbourPoints(Point point, List<Point> points, List<Point> foundNeighbours) {
        List<Point> neighbourPoints = point.directNeighbourPoints();
        foundNeighbours.add(point);

        for (Point neighbourPoint : neighbourPoints){
            if (points.contains(neighbourPoint) && !foundNeighbours.contains(neighbourPoint)){
                getAllNeighbourPoints(neighbourPoint, points, foundNeighbours);
            }
        }

        return foundNeighbours;
    }

    private List<Point> pointsOfUsedSquares(String input, List<Integer> circularList) {
        List<Point> points = new ArrayList<>();

        for (int i=0; i < 128; i++) {
            String denseHash = day10_2.knotHash(circularList, input + "-" + i);
            String binaryDenseHash = hexadecimalToBinary(denseHash);
            for (int j = 0; j < 128; j++){
                if ('1' == binaryDenseHash.charAt(j)){
                    points.add(new Point(i, j));
                }
            }
        }

        return points;
    }

    private String hexadecimalToBinary(String denseHash) {
        return StringUtils.leftPad(new BigInteger(denseHash, 16).toString(2), 128, '0');
    }

}
