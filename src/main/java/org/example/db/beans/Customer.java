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

public class Customer {

    Integer customer_id;
    Integer store_id;
    String first_name;
    String last_name;
    String email;
    Integer address_id;
    Boolean activebool;
    String create_date;
    String last_update;
    Integer active;

    @Step("Get all customers")
    public static List<Customer> getAllCustomers() throws SQLException {
        String query = "select * from customer;";
        try (ResultSet resultSet = DB_Connection.makeQuery(query)){
            return new BeanProcessor().toBeanList(resultSet, Customer.class);
        }
    }

    @Step("Get customer by")
    public static Customer getBy(String column, int value) throws SQLException {
        String query = "select * from customer where " + column + " = ?;";
        ResultSet resultSet = DB_Connection.makeQuery(query, value);

        if(!resultSet.next()){
            return null;
        } else {
            return new BeanProcessor().toBean(resultSet, Customer.class);
        }
    }

    @Step("Insert customer")
    public static void insert(Integer storeId, String firstName, String lastName,
                              String email, Integer addressId, Boolean activeBool) throws SQLException {

        String query = """
                INSERT INTO customer (store_id, first_name, last_name, email, address_id, activebool, create_date)
                VALUES (?, ?, ?, ?, ?, ?, NOW())
                """;

        DB_Connection.makeUpdate(query, storeId, firstName, lastName, email, addressId, activeBool);
    }

    @Step("Update customer")
    public static void update(Integer customerId, String firstName, String lastName, String email) throws SQLException {

        String query = """
                UPDATE customer 
                SET first_name = ?, last_name = ?, email = ?, last_update = NOW()
                WHERE customer_id = ?
                """;

        DB_Connection.makeUpdate(query, firstName, lastName, email, customerId);
    }

    @Step("Delete customer")
    public static void delete(Integer customerId) throws SQLException {
        String query = "DELETE FROM customer WHERE customer_id = ?";
        DB_Connection.makeUpdate(query, customerId);
    }
}
