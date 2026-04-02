package org.example.db.beans;

import io.qameta.allure.Step;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apache.commons.dbutils.BeanProcessor;
import org.example.db.db_utils.DB_Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Film {

    Integer film_id;
    String title;
    String description;
    Integer release_year;
    Integer language_id;
    Integer rental_duration;
    Double rental_rate;
    Integer length;
    Double replacement_cost;
    String rating;
    String last_update;

    // tricky поля
    String special_features;
    String fulltext;

    @Step("Get all films")
    public static List<Film> getAllFilms() throws SQLException {
        String query = "select * from film;";
        try (ResultSet rs = DB_Connection.makeQuery(query)) {
            return new BeanProcessor().toBeanList(rs, Film.class);
        }
    }

    @Step("Get film by")
    public static Film getById(int id) throws SQLException {
        String query = "select * from film where film_id = ?";
        ResultSet rs = DB_Connection.makeQuery(query, id);

        if (!rs.next()) return null;

        return new BeanProcessor().toBean(rs, Film.class);
    }

    @Step("Update fil, by title")
    public static void updateTitle(Integer filmId, String title) throws SQLException {
        String query = """
            UPDATE film
            SET title = ?, last_update = NOW()
            WHERE film_id = ?
            """;

        DB_Connection.makeUpdate(query, title, filmId);
    }

    @Step("Delete film")
    public static void delete(int id) throws SQLException {
        String query = "DELETE FROM film WHERE film_id = ?";
        DB_Connection.makeUpdate(query, id);
    }
}
