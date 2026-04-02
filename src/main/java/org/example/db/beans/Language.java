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

public class Language {
    Integer language_id;
    String name;
    String last_update;

    @Step("Get all language")
    public static List<Language> getAllLanguages() throws SQLException {
        String query = "SELECT * FROM language;";
        try (ResultSet resultSet = DB_Connection.makeQuery(query)) {
            return new BeanProcessor().toBeanList(resultSet, Language.class);
        }
    }

    @Step("Get language by")
    public static Language getBy(String column, int value) throws SQLException {
        String query = "SELECT * FROM language WHERE " + column + " = ?;";
        ResultSet resultSet = DB_Connection.makeQuery(query, value);
        if (!resultSet.next()) {
            return null;
        } else {
            return new BeanProcessor().toBean(resultSet, Language.class);
        }
    }

    @Step("Insert language")
    public static void insert(String name) throws SQLException {
        String query = "INSERT INTO language (name, last_update) VALUES (?, NOW())";
        DB_Connection.makeUpdate(query, name);
    }

    @Step("Update language by name")
    public static void update(int languageId, String name) throws SQLException {
        String query = "UPDATE language SET name = ?, last_update = NOW() WHERE language_id = ?";
        DB_Connection.makeUpdate(query, name, languageId);
    }

    @Step("Delete language")
    public static void delete(int languageId) throws SQLException {
        String query = "DELETE FROM language WHERE language_id = ?";
        DB_Connection.makeUpdate(query, languageId);
    }
}