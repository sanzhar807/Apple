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

public class Address {

    Integer address_id;
    String address;
    String address2;
    String district;
    Integer city_id;
    String postal_code;
    String phone;
    String last_update;

    @Step("Get all address")
    public static List<Address> getAllAddress() throws SQLException {
        String query = "select * from address;";
        try(ResultSet resultSet = DB_Connection.makeQuery(query)) {
            return new BeanProcessor().toBeanList(resultSet,Address.class);
        }
    }

    @Step("Get address by")
    public static Address getBy(String column, int value) throws SQLException {
        String query = "select * from address where " + column + " = ?";
        ResultSet resultSet = DB_Connection.makeQuery(query,value);
        if(!resultSet.next()){
            return null;
        }else {
            return new BeanProcessor().toBean(resultSet,Address.class);
        }
    }

    @Step("Insert address")
    public static void insert(String address, String address2, String district,
                              Integer city_id,String postal_code,String last_update) throws SQLException {
        String query = "INSERT INTO address(address, address2, distinct, city_id, postal_code," +
                "phone, last_update) VALUES(?,?,?,?,?,?,NOW())";
        DB_Connection.makeUpdate(query,address,address2,district,city_id,postal_code);
    }

    @Step("Update address address/district/phone")
    public static void update(int address_id,String address,String district,String phone) throws SQLException {
        String query = "UPDATE address SET address = ?, district = ? , phone = ? = NOW() WHERE address_id = ?";
        DB_Connection.makeUpdate(query,address,district,phone);
    }

    @Step("Delete address")
    public static void delete(int address_id) throws SQLException {
        String query = "DELETE FROM address WHERE address_id = ?";
        DB_Connection.makeUpdate(query,address_id);
    }
}
