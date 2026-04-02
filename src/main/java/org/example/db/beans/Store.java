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
public class Store {
    Integer store_id;
    Integer manager_staff_id;
    Integer address_id;
    String last_update;

    @Step("Get all stores")
    public static List<Store> getAllStore() throws SQLException {
        String query = "select * from store;";
        try (ResultSet resultSet = DB_Connection.makeQuery(query)) {
            return new BeanProcessor().toBeanList(resultSet, Store.class);
        }
    }

    @Step("Get store by")
    public static Store getBy(String column, int value) throws SQLException {
        String query = "select * from store where " + column + " = ?;";
        ResultSet resultSet = DB_Connection.makeQuery(query, value);
        if (!resultSet.next()) {
            return null;
        } else {
            return new BeanProcessor().toBean(resultSet, Store.class);
        }
    }

    @Step("Delete store")
    public static void delete(Integer store_id) throws SQLException {
        String query = "DELETE FROM store WHERE store_id = ?";
        DB_Connection.makeUpdate(query, store_id);
    }
}
