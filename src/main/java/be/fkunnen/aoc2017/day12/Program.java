package be.fkunnen.aoc2017.day12;

import java.util.*;

public class Program {

    private String id;
    private List<Program> connectedPrograms = new ArrayList<>();

    public Program(String id){
        this.id = id;
    }

    public void addConnectedPrograms(List<Program> programs){
        connectedPrograms.addAll(programs);
    }

    public Set<Program> getAllConnectedPrograms(){
        return getAllConnectedPrograms(new HashSet<>());
    }

    private Set<Program> getAllConnectedPrograms(Set<Program> alreadyConnectedPrograms) {
        alreadyConnectedPrograms.add(this);

        for (Program connectedProgram : connectedPrograms){
            if (!alreadyConnectedPrograms.contains(connectedProgram)){
                alreadyConnectedPrograms.addAll(connectedProgram.getAllConnectedPrograms(alreadyConnectedPrograms));
            }
        }

        return alreadyConnectedPrograms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Program program = (Program) o;
        return Objects.equals(id, program.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Program{" +
                "id='" + id + '\'' +
                '}';
    }
}
