package be.fkunnen.aoc2017.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class Program {

    private String name;
    private int weight;
    private List<Program> heldPrograms = new ArrayList<>();

    public Program(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    public int getWeight(){
        return weight;
    }

    public List<Program> getHeldPrograms() {
        return heldPrograms;
    }

    public void addHeldPrograms(List<Program> heldPrograms){
        this.heldPrograms.addAll(heldPrograms);
    }

    public int totalWeight(){
        return weight + heldPrograms.stream().map(p -> p.totalWeight()).reduce(0, (x, y) -> x + y);
    }

    public List<Integer> weightsOfChildren() {
        return heldPrograms.stream().map(p -> p.totalWeight()).collect(toList());
    }

    public boolean hasUnbalancedWeights() {
        return weightsOfChildren().stream().distinct().collect(toList()).size() > 1;
    }

    public boolean haveChildrenBalancedWeights(){
        return getHeldPrograms().stream().map(p -> !p.hasUnbalancedWeights()).reduce(true, (x, y) -> x && y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Program program = (Program) o;
        return Objects.equals(name, program.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Program{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", heldPrograms=" + heldPrograms +
                '}';
    }

    public String getName() {
        return name;
    }
}
