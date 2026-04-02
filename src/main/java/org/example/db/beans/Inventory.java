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

public class Inventory {
    Integer inventory_id;
    Short film_id;
    Short store_id;
    String last_update;

    @Step("Get all inventory")
    public static List<Inventory> getAllInventory() throws SQLException {
        String query = "SELECT * FROM inventory;";
        try (ResultSet resultSet = DB_Connection.makeQuery(query)) {
            return new BeanProcessor().toBeanList(resultSet, Inventory.class);
        }
    }

    @Step("Get inventory by")
    public static Inventory getBy(String column, int value) throws SQLException {
        String query = "SELECT * FROM inventory WHERE " + column + " = ?;";
        ResultSet resultSet = DB_Connection.makeQuery(query, value);
        if (!resultSet.next()) {
            return null;
        } else {
            return new BeanProcessor().toBean(resultSet, Inventory.class);
        }
    }

    @Step("Insert inventory")
    public static void insert(Short filmId, Short storeId) throws SQLException {
        String query = "INSERT INTO inventory (film_id, store_id, last_update) VALUES (?, ?, NOW())";
        DB_Connection.makeUpdate(query, filmId, storeId);
    }

    @Step("Update inventory")
    public static void update(int inventoryId, Short filmId, Short storeId) throws SQLException {
        String query = "UPDATE inventory SET film_id = ?, store_id = ?, last_update = NOW() WHERE inventory_id = ?";
        DB_Connection.makeUpdate(query, filmId, storeId, inventoryId);
    }

    @Step("Delete inventory")
    public static void delete(int inventoryId) throws SQLException {
        String query = "DELETE FROM inventory WHERE inventory_id = ?";
        DB_Connection.makeUpdate(query, inventoryId);
    }
}
