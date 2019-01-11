package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSqlExample {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cef345", "postgres", "postgres")) {

            System.out.println("Java JDBC PostgreSQL Example");
            // When this class first attempts to establish a connection, it automatically loads any JDBC 4.0 drivers found within
            // the class path. Note that your application must manually load any JDBC drivers prior to version 4.0.
//			Class.forName("org.postgresql.Driver");

            System.out.println("Connected to PostgreSQL database!");
            Statement statement = connection.createStatement();
            System.out.println("Reading car records...");
            System.out.printf("%-30.30s  %-30.30s%n", "Matricule Number", "Name");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.student_entity");
            while (resultSet.next()) {
                System.out.printf("%-30.30s  %-30.30s%n", resultSet.getString("matricule_number"), resultSet.getString("name"));
            }

        } /*catch (ClassNotFoundException e) {
			System.out.println("PostgreSQL JDBC driver not found.");
			e.printStackTrace();
		}*/ catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
}

