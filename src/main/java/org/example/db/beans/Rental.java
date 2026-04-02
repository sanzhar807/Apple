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
public class Rental {

    Integer rental_id;
    String rental_date;
    Integer inventory_id;
    Integer customer_id;
    String return_date;
    Integer staff_id;
    String last_update;

    @Step("Get all rentals")
    public static List<Rental> getAllRentals() throws SQLException {
        String query = "select * from rental;";
        try (ResultSet resultSet = DB_Connection.makeQuery(query)) {
            return new BeanProcessor().toBeanList(resultSet, Rental.class);
        }
    }

    @Step("Get rental by")
    public static Rental getBy(String column, int value) throws SQLException {
        String query = "select * from rental where " + column + " = ?;";
        ResultSet resultSet = DB_Connection.makeQuery(query, value);

        if (!resultSet.next()) {
            return null;
        } else {
            return new BeanProcessor().toBean(resultSet, Rental.class);
        }
    }

    @Step("Insert rental")
    public static void insert(String rentalDate,
                              Integer inventoryId,
                              Integer customerId,
                              Integer staffId) throws SQLException {
        String query = """
                INSERT INTO rental (rental_date, inventory_id, customer_id, staff_id, last_update)
                VALUES (?, ?, ?, ?, NOW())
                """;
        DB_Connection.makeUpdate(query, rentalDate, inventoryId, customerId, staffId);
    }

    @Step("Update rental")
    public static void update(Integer rentalId,
                              String returnDate,
                              Integer staffId) throws SQLException {
        String query = """
                UPDATE rental
                SET return_date = ?, staff_id = ?, last_update = NOW()
                WHERE rental_id = ?
                """;
        DB_Connection.makeUpdate(query, returnDate, staffId, rentalId);
    }

    @Step("Delete rental")
    public static void delete(Integer rentalId) throws SQLException {
        String query = "DELETE FROM rental WHERE rental_id = ?";
        DB_Connection.makeUpdate(query, rentalId);
    }
}
