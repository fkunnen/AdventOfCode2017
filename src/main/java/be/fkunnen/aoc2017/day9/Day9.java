package be.fkunnen.aoc2017.day9;

public class Day9 {

    public int streamProcessing(String input) {
        String brackets = input
                .replaceAll("!.", "")
                .replaceAll("<.*?>", "")
                .replaceAll(",", "");

        return sumGroups(brackets, 0, 0, 0);

    }

    private int sumGroups(String brackets, int sum, int level, int character){
        if (character == brackets.length()){
            return sum;
        }

        if (brackets.charAt(character) == '{'){
            return sumGroups(brackets, sum, ++level, ++character);
        }
        else {
            return sumGroups(brackets, sum + level, --level, ++character);
        }
    }

}
