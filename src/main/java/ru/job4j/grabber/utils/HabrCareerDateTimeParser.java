package ru.job4j.grabber.utils;

import java.time.LocalDateTime;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

public class HabrCareerDateTimeParser implements DateTimeParser {

    @Override
    public LocalDateTime parse(String parse) {
        return LocalDateTime.parse(parse.substring(0, 19), ISO_LOCAL_DATE_TIME);
    }
}
