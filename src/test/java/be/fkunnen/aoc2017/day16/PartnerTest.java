package be.fkunnen.aoc2017.day16;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class PartnerTest {

    @Test
    public void move() {
        Partner partner = new Partner("e", "b");

        List<String> programs = Stream.of("a", "b", "c", "d", "e").collect(toList());
        partner.move(programs);

        assertThat(programs).containsExactly("a", "e", "c", "d", "b");
    }
}