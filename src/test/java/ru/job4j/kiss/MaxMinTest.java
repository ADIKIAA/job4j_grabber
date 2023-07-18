package ru.job4j.kiss;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class MaxMinTest {

    @Test
    void testMaxIsTrue() {
        MaxMin comp = new MaxMin();
        List<Integer> values = List.of(1, 34, 15);
        int rsl = comp.max(values, Integer::compareTo);
        int expected = 34;
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    void testMinIsTrue() {
        MaxMin comp = new MaxMin();
        List<Integer> values = List.of(1, 34, 15);
        int rsl = comp.min(values, Integer::compareTo);
        int expected = 1;
        assertThat(rsl).isEqualTo(expected);
    }

}