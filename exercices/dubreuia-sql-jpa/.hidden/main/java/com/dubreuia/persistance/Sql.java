package com.dubreuia.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sql {

    private static final String URL = "jdbc:sqlite:/home/alex/Project/renault-digital-2020/exercices/dubreuia-sql-jpa/database.db";

    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL)) {
            if (!isStudentPresent(connection, "Barack", "Obama")) {
                addStudent(connection, "Barack", "Obama", "1961-08-04", null);
            }
            printStudents(connection);
        }
    }

    /**
     * Imprime dans la console les étudiants de la table "students", ligne par ligne, selon le format suivant :
     * <p>
     * 5, Alexandre, DuBreuil, 1987-11-20, 0.0
     * <p>
     * Vous allez devoir utiliser les méthodes suivantes :
     * <p>
     * - {@link DriverManager#getConnection(String)} pour récupérer la connexion à la base de donnée
     * - {@link Connection#prepareStatement(String)} pour préparer la requête SQL
     * - {@link PreparedStatement#executeQuery(String)} pour exécuter la requête
     * - {@link ResultSet#next()}} pour itérer sur les résultats
     * - {@link ResultSet#getInt(String)}} pour récupérer une colonne de type int
     * - {@link ResultSet#getString(String)}} pour récupérer une colonne de type String
     * - {@link ResultSet#getDouble(String)}} pour récupérer une colonne de type Double
     */
    private static void printStudents(Connection connection)
            throws SQLException {
        String sql = "SELECT * FROM students";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + ", "
                        + resultSet.getString("first_name") + ", "
                        + resultSet.getString("last_name") + ", "
                        + resultSet.getString("birthdate") + ", "
                        + resultSet.getDouble("note"));
            }
        }
    }

    /**
     * Ajoute un étudiant dans la table "students".
     * <p>
     * - {@link DriverManager#getConnection(String)} pour récupérer la connexion à la base de donnée
     * - {@link Connection#prepareStatement(String)} pour préparer la requête SQL
     * - {@link PreparedStatement#setString(int, String)} pour ajouter une valeur String à la requête
     * - {@link PreparedStatement#setDouble(int, double)} pour ajouter une valeur double à la requête
     * - {@link PreparedStatement#executeUpdate()} pour exécuter la requête
     */
    private static void addStudent(Connection connection, String firstName, String lastName, String birthdate,
                                   Double note)
            throws SQLException {
        String sql = "INSERT INTO students VALUES (NULL, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, birthdate);
            statement.setObject(4, note);
            int result = statement.executeUpdate();
            System.out.println(result);
        }
    }

    /**
     * Retourne vrai si l'étudiant est présent dans la table "students".
     * <p>
     * - {@link DriverManager#getConnection(String)} pour récupérer la connexion à la base de donnée
     * - {@link Connection#prepareStatement(String)} pour préparer la requête SQL
     * - {@link PreparedStatement#executeQuery(String)} pour exécuter la requête
     * - {@link ResultSet#next()}} pour récupérer le résultat
     * - {@link ResultSet#getInt(String)}} pour récupérer le résultat
     */
    private static boolean isStudentPresent(Connection connection, String firstName, String lastName)
            throws SQLException {
        String sql = "SELECT count(*) FROM students WHERE first_name = ? AND last_name = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                return resultSet.getInt(1) >= 1;
            }
        }
    }

}
