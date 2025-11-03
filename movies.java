package cinemaproject1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class movies {

    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cinemasphere";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    // JDBC variables for opening, closing, and managing connection
    private static Connection connection;

    public static void main(String[] args) {
        try {
            // Connect to the MySQL database
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Create the "movies" table
            createMoviesTable();

            // Insert movie records
       
            insertMovie("Avengers:Endgame", "C:\\Users\\hp\\OneDrive\\Documents\\"
                    + "NetBeansProjects\\cinemaproject1\\src\\cinemaproject1\\The Avengersendgame(2019) [720p] [BluRay].torrent");// Replace with actual file path
            insertMovie("Thor:Rangnorok", "C:\\Users\\hp\\OneDrive\\Documents\\NetBeansProjects\\cinemaproject1\\src\\cinemaproject1\\"
                    + "Thorragnorok (20017) [720p] [BluRay].torrent");// Replace with actual file path
            insertMovie("The Conjuring", "C:\\Users\\hp\\OneDrive\\Documents\\NetBeansProjects\\cinemaproject1\\src\\cinemaproject1\\"
                    + "The Conjuring (2013) [720p] [BluRay] [YTS.MX].torrent");
            insertMovie("Interstellar", "C:\\Users\\hp\\OneDrive\\Documents\\NetBeansProjects\\cinemaproject1\\src\\"
                    + "cinemaproject1\\Interstellar (2014) 720p.BluRay.torrent");
                    
            // Close the connection
            connection.close();
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void createMoviesTable() throws SQLException {
        // SQL statement to create the "movies" table
        String createTableSQL = "CREATE TABLE IF NOT EXISTS movies ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "title VARCHAR(100) NOT NULL,"
                + "torrent_file LONGBLOB NOT NULL"
                + ")";

        // Create a prepared statement
        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            // Execute the SQL statement
            statement.execute();
        }

        // Print a message indicating that the table is created
        System.out.println("Table 'movies' created successfully.");
    }

    private static void insertMovie(String title, String filePath) throws SQLException, FileNotFoundException {
        // SQL statement to insert a movie record
        String insertSQL = "INSERT INTO movies (title, torrent_file) VALUES (?, ?)";

        // Create a prepared statement
        try (PreparedStatement statement = connection.prepareStatement(insertSQL)) {
            // Set parameters for the prepared statement
            statement.setString(1, title); // Title of the movie
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            statement.setBinaryStream(2, fis, (int) file.length()); // Torrent file

            // Execute the prepared statement
            statement.executeUpdate();
        }

        // Print a message indicating that the movie record is inserted
        System.out.println("Movie record for '" + title + "' inserted successfully.");
    }
}
