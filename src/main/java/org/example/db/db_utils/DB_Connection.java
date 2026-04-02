package org.example.db.db_utils;


import lombok.Getter;
import org.example.gorest.ConfigurationManager;
import org.postgresql.ds.PGSimpleDataSource;

import java.sql.*;

public class DB_Connection {

    @Getter
    private static Connection connection;
    private  static Statement statement;

    private DB_Connection(){
        //singleton pattern
    }
    private static PGSimpleDataSource getBaseDataSource(String dataBase){
        PGSimpleDataSource pgSimpleDataSource = new PGSimpleDataSource(){{
            setServerName(ConfigurationManager.getBaseConfig().server());
            setPortNumber(ConfigurationManager.getBaseConfig().port());
            setUser(ConfigurationManager.getBaseConfig().user());
            setPassword("1234");
            setDatabaseName(dataBase);
        }};
        return pgSimpleDataSource;
    }

    public static void openConnection(String dataBase) throws SQLException {
        if(connection == null){
            connection = getBaseDataSource(dataBase).getConnection();
            statement = connection.createStatement();
        }
    }

    public static void closeConnection(){
        try {
            if(statement != null){
                statement.close();
                statement = null;
            }
            if(connection != null){
                connection.close();
                connection = null;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    // метод по созданию запроса
    //select* from users; = запрос без параметров
    //select* from users  where user.name = 'John'; = запрос с параметром
    //и наш метод принимает оба варианта
    // если есть параметры используем statement
    // если нет параметры используем connection
    ////select* from users  where user.name = '?' and id = ? --String query;
    ////'John', S-->Object params ('John' -> begin from index 1, S -> index 2)
    public static ResultSet makeQuery(String query, Object... params) throws SQLException { //второй параметр не обязательный
        if (params.length == 0){
            return statement.executeQuery(query);
        }else {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                //                        i+1 за-за того что в JDBC индексы начинаются с 1однерки, а в JAVA с 0нолика
                preparedStatement.setObject(i+1, params[i]);  //select* from users  where user.id = ? and name = '?', '5', 'alex'
            }
            return preparedStatement.executeQuery();
        }

    }


    // INSERT, UPDATE, DELETE — универсальный метод (аналог makeQuery)
    public static void makeUpdate(String query, Object... params) throws SQLException {
        if (params.length == 0) {
            statement.executeUpdate(query);
        } else {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            preparedStatement.executeUpdate();
        }
    }



}
