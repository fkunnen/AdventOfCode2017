package be.fkunnen.aoc2017.day16;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class SpinTest {

    @Test
    public void move() {
        Spin spin = new Spin(3);

        List<String> programs = Stream.of("a", "b", "c", "d", "e").collect(toList());
        spin.move(programs);

        assertThat(programs).containsExactly("c", "d", "e", "a", "b");
    }
}