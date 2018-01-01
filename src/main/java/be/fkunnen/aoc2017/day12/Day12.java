package be.fkunnen.aoc2017.day12;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class Day12 {

    //"0 <-> 889, 1229, 1736\n"

    public int digitalPlumber(String input) {
        Map<String, Program> nameToProgramsMap = extractPrograms(input);
        addConnectedPrograms(nameToProgramsMap, input);

        return nameToProgramsMap.get("0").getAllConnectedPrograms().size();
    }

    private Map<String, Program> extractPrograms(String input) {
        return stream(input.split("\n")).map(s -> s.split(" <-> ")[0]).collect(toMap(s -> s, Program::new));
    }

    private void addConnectedPrograms(Map<String, Program> nameToProgramsMap, String input) {
        List<String> programInformations = asList(input.split("\n"));

        for (String programInformation : programInformations){
            Program program = nameToProgramsMap.get(programInformation.split(" <-> ")[0]);

            List<Program> connectedPrograms = extractConnectedPrograms(programInformation.split(" <-> ")[1], nameToProgramsMap);

            program.addConnectedPrograms(connectedPrograms);
        }
    }

    private List<Program> extractConnectedPrograms(String connectedProgramsInformation, Map<String, Program> nameToProgramsMap) {
        return stream(connectedProgramsInformation.split(", ")).map(nameToProgramsMap::get).collect(toList());
    }

}
