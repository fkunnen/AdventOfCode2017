package be.fkunnen.aoc2017.day16;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Day16 {

    public String permutationPromenade(List<String> programs, String input){
        List<DanceMove> danceMoves = retrieveDanceMoves(input);

        for (DanceMove danceMove : danceMoves){
            danceMove.move(programs);
        }

        return programs.stream().reduce("", String::concat);
    }

    private List<DanceMove> retrieveDanceMoves(String input) {
        List<DanceMove> danceMoves = new ArrayList<>();

        List<String> moveDescriptions = asList(input.split(","));

        for (String moveDescription : moveDescriptions){
            char moveIdentifier = moveDescription.charAt(0);
            String moveDetails = moveDescription.substring(1, moveDescription.length());
            if (moveIdentifier == 's'){
                danceMoves.add(spin(moveDetails));
            } else if (moveIdentifier == 'x'){
                danceMoves.add(exchange(moveDetails));
            } else if (moveIdentifier == 'p'){
                danceMoves.add(partner(moveDetails));
            }

        }

        return danceMoves;
    }

    private DanceMove spin(String moveDetails) {
        return new Spin(Integer.valueOf(moveDetails));
    }

    private DanceMove exchange(String moveDetails) {
        return new Exchange(Integer.valueOf(moveDetails.split("/")[0]), Integer.valueOf(moveDetails.split("/")[1]));
    }

    private DanceMove partner(String moveDetails) {
        return new Partner(moveDetails.split("/")[0], moveDetails.split("/")[1]);
    }


}
