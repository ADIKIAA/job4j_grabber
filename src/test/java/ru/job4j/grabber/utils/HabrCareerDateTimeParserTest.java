package ru.job4j.grabber.utils;

import junit.framework.TestCase;
import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HabrCareerDateTimeParserTest {
    @Test
    void firsTestIsTrue() {
        String dateFromHabr = "2023-06-20T21:36:18+03:00";
        HabrCareerDateTimeParser parser = new HabrCareerDateTimeParser();
        assertThat(parser.parse(dateFromHabr)).isEqualTo(LocalDateTime
                .of(2023, 6, 20, 21, 36, 18));
    }

    @Test
    void secondTestIsTrue() {
        String dateFromHabr = "2023-06-14T21:30:42+03:00";
        HabrCareerDateTimeParser parser = new HabrCareerDateTimeParser();
        assertThat(parser.parse(dateFromHabr)).isEqualTo(LocalDateTime
                .of(2023, 6, 14, 21, 30, 42));
    }
}