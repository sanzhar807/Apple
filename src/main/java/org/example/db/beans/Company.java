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

public class Company {
    Integer id;
    String name;

    @Step("Get all companies")
    public static List<Company> getAllCompany() throws SQLException {
        String query = "select * from company;";
        try (ResultSet resultSet = DB_Connection.makeQuery(query)){
            return new BeanProcessor().toBeanList(resultSet,Company.class);
        }
    }

    @Step("Get company by")
    public static Company getBy(String column, int value) throws SQLException {
        String query = "select * from company where " + column + " =?; ";
        ResultSet resultSet = DB_Connection.makeQuery(query,value);
        if(!resultSet.next()){
            return null;
        }else {
            return new BeanProcessor().toBean(resultSet, Company.class);
        }
    }

    @Step("Insert company")
    public static void insert(String name) throws SQLException {
        String query = "INSERT INTO company (name) VALUES (?, ?)";
        DB_Connection.makeUpdate(query, name);
    }

    @Step("Update company ")
    public static void update(int actorId, String Name) throws SQLException {
        String query = "UPDATE company SET name = ?  WHERE id = ?";
        DB_Connection.makeUpdate(query,Name, actorId);
    }

    @Step("Delete company")
    public static void delete(int id) throws SQLException {
        String query = "DELETE FROM company WHERE actor_id = ?";
        DB_Connection.makeUpdate(query, id);
    }
}