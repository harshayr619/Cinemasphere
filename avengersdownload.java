package cinemaproject1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class avengersdownload extends JFrame {

    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cinemasphere";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    // JDBC variables for managing connection
    private static Connection connection;

    public avengersdownload() {
        setTitle("Download Avengers:Endgame Torrent");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null); // Center the frame on the screen
        setResizable(false); // Lock the window from maximizing

        // Create panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 0, 10)); // 2 rows, 1 column, gap of 10 between components
        panel.setBackground(new Color(47, 79, 79)); // Set background color

        // Create button for downloading Interstellar torrent
        JButton downloadButton = new JButton("Download");
        downloadButton.setForeground(Color.WHITE); // Set text color
        downloadButton.setBackground(new Color(0, 102, 204)); // Set background color
        downloadButton.setFocusPainted(false); // Remove focus border
        downloadButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15)); // Add padding
        panel.add(downloadButton);

        // Add action listener to download button
        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Connect to the database
                    connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

                    // Prepare statement to retrieve the Interstellar torrent file
                    String retrieveTorrentSQL = "SELECT torrent_file FROM movies WHERE title = ?";
                    PreparedStatement statement = connection.prepareStatement(retrieveTorrentSQL);
                    statement.setString(1, "Avengers:Endgame");
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        // Get the Interstellar torrent file data from the result set
                        Blob torrentBlob = resultSet.getBlob("torrent_file");
                        InputStream inputStream = torrentBlob.getBinaryStream();

                        // Save the Interstellar torrent file to the user's downloads folder
                        String downloadsPath = System.getProperty("user.home") + "/Downloads";
                        File torrentFile = new File(downloadsPath, "Avengers Endgame 720p.torrent");
                        Files.copy(inputStream, torrentFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                        JOptionPane.showMessageDialog(null, "Avengers:Endgame torrent downloaded successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Avengers:Endgame movie record not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    // Close database resources
                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (SQLException | IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error downloading Avengers:Endgame torrent.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Create back button
        JButton backButton = new JButton("Back");
        backButton.setForeground(Color.WHITE); // Set text color
        backButton.setBackground(new Color(255, 51, 51)); // Set background color
        backButton.setFocusPainted(false); // Remove focus border
        backButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15)); // Add padding
        panel.add(backButton);

        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Open subscription page
                avengers avengersPage = new avengers();
                avengersPage.setVisible(true);
                dispose(); // Close current frame
            }
        });

        // Add panel to the frame
        getContentPane().add(panel, BorderLayout.CENTER);

        // Make the buttons smaller
        Dimension buttonSize = new Dimension(150, 30);
        downloadButton.setPreferredSize(buttonSize);
        backButton.setPreferredSize(buttonSize);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            avengersdownload downloadPage = new avengersdownload();
            downloadPage.setVisible(true);
        });
    }
}



   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
                

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

