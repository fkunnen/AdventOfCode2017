package be.fkunnen.aoc2017.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Day2 {
    public int checksumMaxMinDifference(String spreadSheet) {
        List<List<Integer>> spreadSheetRows = convertSpreadSheetToNumbersInRowsAndColumns(spreadSheet);

        int checksum = 0;
        for (List<Integer> row : spreadSheetRows){
            checksum += maxValue(row) - minValue(row);
        }

        return checksum;
    }

    public int checksumDivisionDivisibles(String spreadSheet) {
        List<List<Integer>> spreadSheetRows = convertSpreadSheetToNumbersInRowsAndColumns(spreadSheet);

        int checksum = 0;
        for (List<Integer> row : spreadSheetRows){
            checksum += divisionDivisibles(row);
        }

        return checksum;
    }

    private int maxValue(List<Integer> numbers) {
        return numbers.stream().max(Integer::compareTo).get();
    }

    private int minValue(List<Integer> numbers) {
        return numbers.stream().min(Integer::compareTo).get();
    }

    private int divisionDivisibles(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++){
            for (int j = 0; j < numbers.size(); j++){
                if ( i != j && numbers.get(i) % numbers.get(j) == 0){
                    return numbers.get(i) / numbers.get(j);
                }
            }
        }
        return 0;
    }

    private List<List<Integer>> convertSpreadSheetToNumbersInRowsAndColumns(String spreadSheet) {
        List<List<Integer>> spreadSheetRowsAndColumns = new ArrayList<>();
        String rowSeparator = "\n";
        String columnSeparator = "\t";


        List<String> rows = asList(spreadSheet.split(rowSeparator));

        for (String row : rows){
            spreadSheetRowsAndColumns.add(
                Arrays.stream(row.split(columnSeparator))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList())
            );
        }

        return spreadSheetRowsAndColumns;
    }
}
