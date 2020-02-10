package com.dubreuia.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sql {

    private static final String URL = "jdbc:sqlite:/home/alex/Project/renault-digital-2020/exercices/dubreuia-sql-jpa/database.db";

    public static void main(String[] args) throws SQLException {
        if (!isStudentPresent("Barack", "Obama")) {
            addStudent("Barack", "Obama", "1961-08-04", null);
        }
        printStudents();
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
    private static void printStudents() throws SQLException {
        try (Connection connection = DriverManager.getConnection(Sql.URL)) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                var id = resultSet.getInt("id");
                var firstName = resultSet.getString("first_name");
                var lastName = resultSet.getString("last_name");
                var birthdate = resultSet.getString("birthdate");
                var note = resultSet.getString("note");
                System.out.println(id + ", " + firstName + ", " + lastName + ", " + birthdate + ", " + note);
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
    private static void addStudent(String firstName, String lastName, String birthdate, Double note) throws SQLException {
        try (Connection connection = DriverManager.getConnection(Sql.URL)) {
            var preparedStatement = connection.prepareStatement("INSERT INTO students VALUES (NULL, ?, ?, ?, ?)");
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, birthdate);
            preparedStatement.setObject(4, note);
            var resultSet = preparedStatement.executeUpdate();

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
    private static boolean isStudentPresent(String firstName, String lastName) throws SQLException {
        try (Connection connection = DriverManager.getConnection(Sql.URL)) {
            String sql = "SELECT COUNT(*) " +
                    "FROM students " +
                    "WHERE first_name = '" + firstName + "' " +
                    "AND last_name ='" + lastName + "'";
            var preparedStatement = connection.prepareStatement(sql);
            var resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            return 0 < count;
        }
    }

}
