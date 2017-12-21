package day1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day1 {

    public int inverseCaptchaNext(String input) {
        List<Integer> numbers = parseInputToAListOfNumbers(input);

        int sum = 0;
        for (int i = 0; i < numbers.size(); i++){
            if (numbers.get(i).equals(numbers.get((i + 1) % numbers.size()))) {
                sum += numbers.get(i);
            }
        }

        return sum;
    }

    public int inverseCaptchaHalfway(String input) {
        List<Integer> numbers = parseInputToAListOfNumbers(input);

        int sum = 0;
        for (int i = 0; i < numbers.size(); i++){
            if (numbers.get(i).equals(numbers.get((i + numbers.size() / 2) % numbers.size()))) {
                sum += numbers.get(i);
            }
        }

        return sum;
    }

    private List<Integer> parseInputToAListOfNumbers(String number){
        return Arrays.stream(number.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
