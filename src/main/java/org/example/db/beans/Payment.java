package org.example.db.beans;

import io.qameta.allure.Step;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apache.commons.dbutils.BeanProcessor;
import org.example.db.db_utils.DB_Connection;

import java.math.BigDecimal;
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

public class Payment {
    Integer payment_id;
    Short customer_id;
    Short staff_id;
    Integer rental_id;
    BigDecimal amount;
    String payment_date;

    @Step("Get all payments")
    public static List<Payment> getAllPayments() throws SQLException {
        String query = "SELECT * FROM payment;";
        try (ResultSet resultSet = DB_Connection.makeQuery(query)) {
            return new BeanProcessor().toBeanList(resultSet, Payment.class);
        }
    }

    @Step("Get payment by")
    public static Payment getBy(String column, int value) throws SQLException {
        String query = "SELECT * FROM payment WHERE " + column + " = ?;";
        ResultSet resultSet = DB_Connection.makeQuery(query, value);
        if (!resultSet.next()) {
            return null;
        } else {
            return new BeanProcessor().toBean(resultSet, Payment.class);
        }
    }

    @Step("Insert payment")
    public static void insert(Short customerId, Short staffId, Integer rentalId,
                              BigDecimal amount) throws SQLException {
        String query = "INSERT INTO payment (customer_id, staff_id, rental_id, amount, payment_date) " +
                "VALUES (?, ?, ?, ?, NOW())";
        DB_Connection.makeUpdate(query, customerId, staffId, rentalId, amount);
    }

    @Step("Update payment")
    public static void update(int paymentId, Short customerId, Short staffId,
                              Integer rentalId, BigDecimal amount) throws SQLException {
        String query = "UPDATE payment SET customer_id = ?, staff_id = ?, rental_id = ?, " +
                "amount = ?, payment_date = NOW() WHERE payment_id = ?";
        DB_Connection.makeUpdate(query, customerId, staffId, rentalId, amount, paymentId);
    }

    @Step("Delete payment")
    public static void delete(int paymentId) throws SQLException {
        String query = "DELETE FROM payment WHERE payment_id = ?";
        DB_Connection.makeUpdate(query, paymentId);
    }
}