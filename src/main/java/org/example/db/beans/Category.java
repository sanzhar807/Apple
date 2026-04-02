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

public class Category {

    Integer category_id;
    String name;
    String last_update;

    @Step("Get all category")
    public static List<Category> getAllCategory() throws SQLException {
        String query = "select * from category;";
        try(ResultSet resultSet = DB_Connection.makeQuery(query)){
            return new BeanProcessor().toBeanList(resultSet,Category.class);
        }
    }

    @Step("Get category by")
    public static Category getBy(String column,int value) throws SQLException {
        String query = "select * from category where " + column + "=?;";
        ResultSet resultSet = DB_Connection.makeQuery(query,value);
        if(!resultSet.next()){
            return null;
        }else {
            return new BeanProcessor().toBean(resultSet,Category.class);
        }
    }

    @Step("Insert category")
    public static void insert(String name,String last_update) throws SQLException {
        String query = "INSERT INTO category (name,last_update) VALUES(?,?);";
        DB_Connection.makeUpdate(query,name,last_update);
    }

    @Step("Update category name/last update")
    public static void update(int category_id,String name,String last_update) throws SQLException {
        String query = "UPDATE category SET name = ?,last_update = ? WHERE category_id = ?";
        DB_Connection.makeUpdate(query,name,last_update,category_id);
    }

    @Step("Delete category")
    public static void delete(int category_id) throws SQLException {
        String query = "DELETE FROM category WHERE category_id = ?";
        DB_Connection.makeUpdate(query,category_id);
    }
}
