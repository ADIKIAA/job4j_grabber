package ru.job4j.grabber;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Objects;

public class Post {

    public int id;

    public String title;

    public String link;

    public String description;

    public LocalDateTime created;

    public Post(ResultSet resultSet, String title, String link, String description, LocalDateTime created)
            throws SQLException {
        this.id = resultSet.getInt(1);
        this.title = title;
        this.link = link;
        this.description = description;
        this.created = created;
    }

    public Post(String title, String link, String description, LocalDateTime created)
            throws SQLException {
        this.title = title;
        this.link = link;
        this.description = description;
        this.created = created;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        return id == post.id && Objects.equals(link, post.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, link);
    }

    @Override
    public String toString() {
        return "Post{"
                + "id=" + id
                + ", title='" + title + '\''
                + ", link='" + link + '\''
                + ", description='" + description + '\''
                + ", date=" + created
                + '}';
    }
}
