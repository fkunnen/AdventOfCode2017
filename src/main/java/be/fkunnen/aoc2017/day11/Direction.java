package be.fkunnen.aoc2017.day11;

public enum Direction {

    NORTH("n"),
    NORTH_EAST("ne"),
    SOUTH_EAST("se"),
    SOUTH("s"),
    SOUTH_WEST("sw"),
    NORTH_WEST("nw");

    private String directionStr;

    Direction(String directionStr) {
        this.directionStr = directionStr;
    }

    private String getDirectionStr(){
        return directionStr;
    }

    public static Direction valueFromString(String directionStr){
        for (Direction direction : Direction.values()) {
            if (direction.getDirectionStr().equalsIgnoreCase(directionStr)) {
                return direction;
            }
        }
        throw new IllegalArgumentException("Unknown direction");
    }
}
