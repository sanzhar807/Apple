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
public class Film_Actor {

    Integer actor_id;
    Integer film_id;
    String last_update;

    @Step("Get all film actors")
    public static List<Film_Actor> getAllFilmActors() throws SQLException {
        String query = "select * from film_actor;";
        try (ResultSet resultSet = DB_Connection.makeQuery(query)) {
            return new BeanProcessor().toBeanList(resultSet, Film_Actor.class);
        }
    }

    @Step("Get film actor by")
    public static Film_Actor getByActorAndFilm(int actorId, int filmId) throws SQLException {
        String query = "select * from film_actor where actor_id = ? and film_id = ?;";
        ResultSet resultSet = DB_Connection.makeQuery(query, actorId, filmId);

        if (!resultSet.next()) {
            return null;
        } else {
            return new BeanProcessor().toBean(resultSet, Film_Actor.class);
        }
    }

    @Step("Get film actor by id")
    public static List<Film_Actor> getByActorId(int actorId) throws SQLException {
        String query = "select * from film_actor where actor_id = ?;";
        try (ResultSet resultSet = DB_Connection.makeQuery(query, actorId)) {
            return new BeanProcessor().toBeanList(resultSet, Film_Actor.class);
        }
    }

    @Step("Get film actor by film id")
    public static List<Film_Actor> getByFilmId(int filmId) throws SQLException {
        String query = "select * from film_actor where film_id = ?;";
        try (ResultSet resultSet = DB_Connection.makeQuery(query, filmId)) {
            return new BeanProcessor().toBeanList(resultSet, Film_Actor.class);
        }
    }

    @Step("Insert film actor")
    public static void insert(int actorId, int filmId) throws SQLException {
        String query = "INSERT INTO film_actor (actor_id, film_id, last_update) VALUES (?, ?, NOW())";
        DB_Connection.makeUpdate(query, actorId, filmId);
    }

    @Step("Update film actor by actor id and film id ")
    public static void update(int oldActorId, int oldFilmId, int newActorId, int newFilmId) throws SQLException {
        String query = """
                UPDATE film_actor
                SET actor_id = ?, film_id = ?, last_update = NOW()
                WHERE actor_id = ? AND film_id = ?
                """;
        DB_Connection.makeUpdate(query, newActorId, newFilmId, oldActorId, oldFilmId);
    }

    @Step("Delete film actor")
    public static void delete(int actorId, int filmId) throws SQLException {
        String query = "DELETE FROM film_actor WHERE actor_id = ? AND film_id = ?";
        DB_Connection.makeUpdate(query, actorId, filmId);
    }
}