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

public class Actor {
    Integer actor_id;
    String first_name;
    String last_name;
    String last_update;

    @Step("Get all actors")
    public static List<Actor> getAllActors() throws SQLException {
        String query = "select * from actor;";
        try (ResultSet resultSet = DB_Connection.makeQuery(query)){
            return new BeanProcessor().toBeanList(resultSet,Actor.class);
        }
    }

    @Step("Get actor by")
    public static Actor getBy(String column, int value) throws SQLException {
        String query = "select * from actor where " + column + " =?; ";
        ResultSet resultSet = DB_Connection.makeQuery(query,value);
        if(!resultSet.next()){
            return null;
        }else {
            return new BeanProcessor().toBean(resultSet, Actor.class);
        }
    }

    @Step("Insert actor")
    public static void insert(String firstName, String lastName) throws SQLException {
        String query = "INSERT INTO actor (first_name, last_name, last_update) VALUES (?, ?, NOW())";
        DB_Connection.makeUpdate(query, firstName, lastName);
    }

    @Step("Update actor first name/last name")
    public static void update(int actorId, String firstName, String lastName) throws SQLException {
        String query = "UPDATE actor SET first_name = ?, last_name = ?, last_update = NOW() WHERE actor_id = ?";
        DB_Connection.makeUpdate(query,firstName, lastName, actorId);
    }

    @Step("Delete actor")
    public static void delete(int actorId) throws SQLException {
        String query = "DELETE FROM actor WHERE actor_id = ?";
        DB_Connection.makeUpdate(query, actorId);
    }
}
