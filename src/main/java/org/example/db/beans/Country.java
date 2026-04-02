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

public class Country {

    Integer country_id;
    String country;
    String last_update;

    @Step("Get all countries")
    public static List<Country> getAllCountries() throws SQLException {
        String query = "select * from country;";
        try (ResultSet resultSet = DB_Connection.makeQuery(query)){
            return new BeanProcessor().toBeanList(resultSet, Country.class);
        }
    }

    @Step("Get country by")
    public static Country getBy(String column, int value) throws SQLException {
        String query = "select * from country where " + column + " = ?;";
        ResultSet resultSet = DB_Connection.makeQuery(query, value);

        if(!resultSet.next()){
            return null;
        } else {
            return new BeanProcessor().toBean(resultSet, Country.class);
        }
    }

    @Step("Insert country")
    public static void insert(String countryName) throws SQLException {
        String query = "INSERT INTO country (country, last_update) VALUES (?, NOW())";
        DB_Connection.makeUpdate(query, countryName);
    }

    @Step("Update country")
    public static void update(int countryId, String countryName) throws SQLException {
        String query = "UPDATE country SET country = ?, last_update = NOW() WHERE country_id = ?";
        DB_Connection.makeUpdate(query, countryName, countryId);
    }

    @Step("Delete country")
    public static void delete(int countryId) throws SQLException {
        String query = "DELETE FROM country WHERE country_id = ?";
        DB_Connection.makeUpdate(query, countryId);
    }
}
