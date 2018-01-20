package be.fkunnen.aoc2017.day16;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class ExchangeTest {

    @Test
    public void move() {
        Exchange exchange = new Exchange(3, 4);

        List<String> programs = Stream.of("a", "b", "c", "d", "e").collect(toList());
        exchange.move(programs);

        assertThat(programs).containsExactly("a", "b", "c", "e", "d");
    }
}