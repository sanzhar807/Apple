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

public class City {

    Integer city_id;
    String city;
    Integer country_id;
    String last_update;

    @Step("Get all cities")
    public static List<City> getAllCities() throws SQLException {
        String query = "select * from city;";
        try (ResultSet resultSet = DB_Connection.makeQuery(query)){
            return new BeanProcessor().toBeanList(resultSet, City.class);
        }
    }

    @Step("Get city by")
    public static City getBy(String column, int value) throws SQLException {
        String query = "select * from city where " + column + " = ?;";
        ResultSet resultSet = DB_Connection.makeQuery(query, value);

        if(!resultSet.next()){
            return null;
        } else {
            return new BeanProcessor().toBean(resultSet, City.class);
        }
    }

    @Step("Insert city")
    public static void insert(String cityName, int countryId) throws SQLException {
        String query = "INSERT INTO city (city, country_id, last_update) VALUES (?, ?, NOW())";
        DB_Connection.makeUpdate(query, cityName, countryId);
    }

    @Step("Update city")
    public static void update(int cityId, String cityName, int countryId) throws SQLException {
        String query = "UPDATE city SET city = ?, country_id = ?, last_update = NOW() WHERE city_id = ?";
        DB_Connection.makeUpdate(query, cityName, countryId, cityId);
    }

    @Step("Delete city")
    public static void delete(int cityId) throws SQLException {
        String query = "DELETE FROM city WHERE city_id = ?";
        DB_Connection.makeUpdate(query, cityId);
    }
}