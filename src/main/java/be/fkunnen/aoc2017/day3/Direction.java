package be.fkunnen.aoc2017.day3;

public enum Direction {

    NORTH,
    EAST,
    SOUTH,
    WEST;

    public static Direction turnLeft(Direction currentDirection){
        if (currentDirection == NORTH){
            return WEST;
        } else if (currentDirection == EAST){
            return NORTH;
        }  else if (currentDirection == SOUTH){
            return EAST;
        } else {
            return SOUTH;
        }
    }

}
