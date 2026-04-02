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

public class Staff {

    Integer staff_id;
    String first_name;
    String last_name;
    Integer address_id;
    String email;
    Integer store_id;
    Boolean active;
    String username;
    String password;
    String last_update;

    @Step("Get all staff")
    public static List<Staff> getAllStaff() throws SQLException {
        String query = "select * from staff;";
        try (ResultSet resultSet = DB_Connection.makeQuery(query)) {
            return new BeanProcessor().toBeanList(resultSet, Staff.class);
        }
    }

    @Step("Get staff by")
    public static Staff getBy(String column, int value) throws SQLException {
        String query = "select * from staff where " + column + " = ?;";
        ResultSet resultSet = DB_Connection.makeQuery(query, value);
        if (!resultSet.next()) {
            return null;
        } else {
            return new BeanProcessor().toBean(resultSet, Staff.class);
        }
    }

    @Step("Insert staff")
    public static void insert(String first_name,
                              String last_name,
                              Integer address_id,
                              String email,
                              Integer store_id,
                              Boolean active,
                              String username,
                              String password) throws SQLException {
        String query = """
                INSERT INTO staff (first_name, last_name, address_id, email, store_id, active, username, password)
                VALUES (?, ?, ?, ?,? ,? ,? ,? NOW())
                """;
        DB_Connection.makeUpdate(query, first_name,last_name,address_id,email,store_id,active,username,password);
    }

    @Step("Update staff")
    public static void update(Integer staff_id,Boolean active)throws SQLException {
        String query = """
                UPDATE staff
                SET active = ?, last_update = NOW()
                WHERE staff_id = ?
                """;
        DB_Connection.makeUpdate(query, active,staff_id);
    }

    @Step("Delete staff")
    public static void delete(Integer staff_id) throws SQLException {
        String query = "DELETE FROM staff WHERE staff_id = ?";
        DB_Connection.makeUpdate(query, staff_id);
    }
}
