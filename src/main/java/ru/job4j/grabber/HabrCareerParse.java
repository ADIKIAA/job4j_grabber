package ru.job4j.grabber;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.utils.DateTimeParser;
import ru.job4j.grabber.utils.HabrCareerDateTimeParser;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HabrCareerParse implements Parse {

    private static final String SOURCE_LINK = "https://career.habr.com";

    private static final String PAGE_LINK = String.format("%s/vacancies/java_developer", SOURCE_LINK);

    private  final DateTimeParser dateTimeParser;

    public HabrCareerParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public List<Post> list(String linkForParse) throws IOException {
        List<Post> list = new ArrayList<>();
        HabrCareerDateTimeParser parser = new HabrCareerDateTimeParser();
        for (int i = 1; i <= 5; i++) {
            Connection connection = Jsoup.connect(String.format(
                    "%s/vacancies/java_developer?page=%d", linkForParse, i));
            Document document = connection.get();
            Elements rows = document.select(".vacancy-card__inner");
            rows.forEach(row -> {
                Element titleElement = row.select(".vacancy-card__title").first();
                Element linkElement = titleElement.child(0);
                Element dateElement = row.select(".vacancy-card__date").first().child(0);
                String description;
                try {
                    description = retrieveDescription(linkElement.attr("href"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                String vacancyName = titleElement.text();
                String link = String.format("%s%s", linkForParse, linkElement.attr("href"));
                String date = dateElement.attr("datetime");
                try {
                    list.add(new Post(vacancyName, link, description, parser.parse(date)));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        return list;
    }

    private static String retrieveDescription(String link) throws IOException {
        Connection connection = Jsoup.connect(String.format("%s%s", SOURCE_LINK, link));
        Document document = connection.get();
        Elements desc = document.select(".vacancy-description__text").first().getAllElements();
        return desc.text();
    }
}

