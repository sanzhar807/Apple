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
public class Film_Category {

    Integer category_id;
    Integer film_id;
    String last_update;

    @Step("Get all film category")
    public static List<Film_Category> getAllFilmActors() throws SQLException {
        String query = "select * from Film_Category;";
        try (ResultSet resultSet = DB_Connection.makeQuery(query)) {
            return new BeanProcessor().toBeanList(resultSet, Film_Category.class);
        }
    }

    @Step("Get film category by film id")
    public static List<Film_Category> getByFilmId(int filmId) throws SQLException {
        String query = "select * from film_actor where film_id = ?;";
        try (ResultSet resultSet = DB_Connection.makeQuery(query, filmId)) {
            return new BeanProcessor().toBeanList(resultSet, Film_Category.class);
        }
    }

    @Step("Insert film actor")
    public static void insert(int actorId, int filmId) throws SQLException {
        String query = "INSERT INTO film_actor (film_id, category_id, last_update) VALUES (?, ?, NOW())";
        DB_Connection.makeUpdate(query, actorId, filmId);
    }

    @Step("Update film category actor id and film id")
    public static void update(int oldActorId, int oldFilmId, int newActorId, int newFilmId) throws SQLException {
        String query = """
                UPDATE Film_Category
                SET film_id = ?, category_id = ?, last_update = NOW()
                WHERE film_id = ? AND category_id = ?
                """;
        DB_Connection.makeUpdate(query, newActorId, newFilmId, oldActorId, oldFilmId);
    }

    public static void delete(int film_id, int category_id) throws SQLException {
        String query = "DELETE FROM Film_Category WHERE film_id = ? AND category_id = ?";
        DB_Connection.makeUpdate(query, film_id, category_id);
    }
}