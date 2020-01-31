package com.dubreuia.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sql {

    private static final String URL = "jdbc:sqlite:/home/alex/Project/renault-digital-2020/exercices/dubreuia-sql-jpa/database.db";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL)) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + ", "
                        + resultSet.getString(2) + ", "
                        + resultSet.getString(3) + ", "
                        + resultSet.getString(4) + ", "
                        + resultSet.getDouble(5));
            }
            boolean execute = statement.execute();
            System.out.println(execute);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}