package cinemaproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {

    public static void main(String[] args) {
        // JDBC URL for MySQL database named "cinemasphere" on localhost
        String url = "jdbc:mysql://localhost:3306/cinemasphere";
        String user = "root"; // MySQL username
        String password = ""; // MySQL password

        // Try-with-resources to automatically close the connection
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Check if the connection is successful
            if (connection != null) {
                System.out.println("Connected to the database");
            } else {
                System.out.println("Failed to connect to the database");
            }
        } catch (SQLException e) {
            // Handle any SQL errors
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
}
