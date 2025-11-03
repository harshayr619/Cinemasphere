package cinemaproject1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.*;

public class home extends JFrame {

    public home() {
        setTitle("CinemaSphere");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        getContentPane().setBackground(Color.BLACK); // Set background color to black

        // Use BorderLayout for the content pane
        getContentPane().setLayout(new BorderLayout());

        // Create label "CinemaSphere" at top center with shiny green color
        JLabel titleLabel = new JLabel("CinemaSphere", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40)); // Set font size to 40 and make it bold
        titleLabel.setForeground(new Color(255, 255, 255));
        add(titleLabel, BorderLayout.NORTH);

        // Create menu bar with center-aligned elements
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.CENTER));
        menuBar.setBackground(new Color(47, 99, 79)); // Set menu bar background color

        // Create text label for HD movies
        JLabel hdMoviesLabel = new JLabel("HD movies at smallest size");
        hdMoviesLabel.setForeground(Color.WHITE); // Set text color to white

        // Create search menu
        JMenu searchMenu = new JMenu("Search");
        searchMenu.setFont(new Font("Arial", Font.PLAIN, 16));
        searchMenu.setForeground(Color.WHITE);
        searchMenu.setBackground(new Color(0, 102, 204));
        searchMenu.setFocusPainted(false);
        searchMenu.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        JTextField searchField = new JTextField(15);
        JButton searchButton = new JButton("Go");
        searchButton.setBackground(new Color(0, 164, 204));
        searchMenu.add(searchField);
        searchMenu.add(searchButton);

        // ActionListener for search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the text entered in the search field
                String searchText = searchField.getText().toLowerCase(); // Convert to lowercase for case-insensitive search

                // Check if the search text matches any movie
                if (searchText.equals("avengers endgame")) {
                    // Open Avengers page
                    avengers avengersPage = new avengers();
                    avengersPage.setVisible(true);
                    dispose(); // Close the current frame
                } else if (searchText.equals("interstellar")) {
                    // Open Interstellar page
                    interstellar interstellarPage = new interstellar();
                    interstellarPage.setVisible(true);
                    dispose(); // Close the current frame
                } else if (searchText.equals("thor")) {
                    // Open Thor page
                    thor thorPage = new thor();
                    thorPage.setVisible(true);
                    dispose(); // Close the current frame
                } else if (searchText.equals("conjuring")) {
                    // Open Conjuring page
                    conjuring conjuringPage = new conjuring();
                    conjuringPage.setVisible(true);
                    dispose(); // Close the current frame
                } else {
                    // Display a message if the movie is not found
                    JOptionPane.showMessageDialog(null, "Movie not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Create categories panel
        JPanel categoriesPanel = new JPanel();
        categoriesPanel.setBackground(new Color(47, 79, 79)); // Set background color
        categoriesPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center-align buttons

        // Create category buttons
        String[] categories = {"Action", "Sci-Fi", "Horror"};
        for (String category : categories) {
            JButton categoryButton = new JButton(category);
            categoryButton.setForeground(Color.WHITE); // Set text color
            categoryButton.setBackground(new Color(0, 76, 34)); // Set background color
            categoryButton.setFocusPainted(false); // Remove focus border
            categoryButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add padding
            categoryButton.addActionListener(e -> {
                // Handle category button click
                switch (category) {
                    case "Action":
                        // Open Action category page
                        action actionPage = new action();
                        actionPage.setVisible(true);
                        dispose(); // Close current frame
                        break;
                    case "Sci-Fi":
                        // Open Sci-Fi category page
                        SciFi sciFiPage = new SciFi();
                        sciFiPage.setVisible(true);
                        dispose(); // Close current frame
                        break;
                    case "Horror":
                        // Open Horror category page
                        horror horrorPage = new horror();
                        horrorPage.setVisible(true);
                        dispose(); // Close current frame
                        break;
                }
            });
            categoriesPanel.add(categoryButton); // Add category button to the panel
        }

        // Create trending button
        JButton trendingButton = new JButton("Trending");
        trendingButton.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font size and style
        trendingButton.setForeground(Color.WHITE); // Set text color
        trendingButton.setBackground(new Color(0, 76, 34)); // Set background color
        trendingButton.setFocusPainted(false); // Remove focus border
        trendingButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        trendingButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Open trending page
                trending trendingPage = new trending();
                trendingPage.setVisible(true);
                dispose(); // Close current frame
            }
        });

        // Create subscription button
        JButton subscriptionButton = new JButton("Subscription");
        subscriptionButton.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font size and style
        subscriptionButton.setForeground(Color.WHITE); // Set text color
        subscriptionButton.setBackground(new Color(0, 76, 34)); // Set background color
        subscriptionButton.setFocusPainted(false); // Remove focus border
        subscriptionButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        subscriptionButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Open subscription page
                subscribe subscribePage = new subscribe();
                subscribePage.setVisible(true);
                dispose(); // Close current frame
            }
        });

        // Create register/login menu
        JMenu userMenu = new JMenu("User");
         categoriesPanel.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font size and style
userMenu.setForeground(Color.WHITE); // Set text color
userMenu.setBackground(new Color(0, 102, 204)); // Set background color
userMenu.setFocusPainted(false); // Remove focus border
userMenu.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        JMenuItem registerItem = new JMenuItem("Register");
        JMenuItem logoutItem = new JMenuItem("Logout");
        userMenu.add(registerItem);
        userMenu.add(logoutItem);

        // Add ActionListener to registerItem
        registerItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the registration action here
                // Open the signIn page
                signIn signInPage = new signIn();
                signInPage.setVisible(true);
                dispose(); // Close the current frame


            }
        });

        // Add ActionListener to registerItem
        logoutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the registration action here
                // Open the signIn page
                login signInPage = new login();
                signInPage.setVisible(true);
                dispose(); // Close the current frame


            }
        });

        // Add menu to the menu bar
        menuBar.add(userMenu);

        // Add components to menu bar with appropriate spacing
        menuBar.add(hdMoviesLabel);
        menuBar.add(Box.createHorizontalStrut(100)); // Add space between HD movies label and search menu
        menuBar.add(searchMenu);
        menuBar.add(Box.createHorizontalStrut(100)); // Add space between search and categories
        menuBar.add(new JLabel("Categories")); // Add label for categories
        menuBar.add(categoriesPanel); // Add categories panel
        menuBar.add(Box.createHorizontalStrut(100)); // Add space between categories and trending button
        menuBar.add(trendingButton);
        menuBar.add(Box.createHorizontalStrut(100)); // Add space between trending button and subscription button
        menuBar.add(subscriptionButton);

        // Set modern colors for menu bar components
        searchMenu.setForeground(Color.GREEN);
        userMenu.setForeground(Color.GREEN);

        // Add menu bar to the frame
        setJMenuBar(menuBar);

        // Create a label for the paragraph with HTML formatting
        JLabel paragraphLabel = new JLabel("<html><h1 style='text-align: center;font-size:25px;color:black;margin-bottom:50px;'>CINEMA SPHERE</h1>"
                + "<div style='color:black;margin-bottom:50px; background-color:white;'>"
                + "<p>Welcome to CinemaSphere! We provide a wide range of HD movies in various genres. "
                + "Browse through our categories, search for your favorite movies, and enjoy streaming with ease.</p><br><hr>"
                + "<h1 style='text-align: center;font-size:25px;color:green;'>Popular Downloads:</h1>"
                + "</div><br></html>");
        paragraphLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font size and style
        paragraphLabel.setVerticalAlignment(SwingConstants.CENTER); // Align text vertically to center
        paragraphLabel.setHorizontalAlignment(SwingConstants.CENTER); // Align text horizontally to center
        paragraphLabel.setOpaque(true); // Make the label opaque to show the background color
        paragraphLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        // Add the paragraph label just below the label "CinemaSphere"
        add(paragraphLabel, BorderLayout.NORTH);

        // Create a panel to hold the images and captions
        JPanel imagePanel = new JPanel(new GridLayout(1, 1, 2, 2)); // 1 row, 2 columns
        imagePanel.setBackground(Color.BLACK); // Set background color to black

        // Set the border color of the panel to black
        imagePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Set preferred size of the image panel
        imagePanel.setPreferredSize(new Dimension(300, 430));

        // Add images with captions to the panel
        String[] imagePaths = {"C:\\Users\\hp\\OneDrive\\Documents\\NetBeansProjects\\cinemaproject1\\src\\cinemaproject1\\avengersend.jpg",
                "C:\\Users\\hp\\OneDrive\\Documents\\NetBeansProjects\\cinemaproject1\\src\\cinemaproject1\\interstellar.jpg",
                "C:\\Users\\hp\\OneDrive\\Documents\\NetBeansProjects\\cinemaproject1\\src\\cinemaproject1\\thor.jpg",
                "C:\\Users\\hp\\OneDrive\\Documents\\NetBeansProjects\\cinemaproject1\\src\\cinemaproject1\\conjuring.jpg"};
        String[] captions = {"<html><bold><h2>Avengers:Endgame</h2></html>", "<html><bold><h2>Interstellar</h2></html>",
                "<html><bold><h2>Thor:Rangnarok</h2></html>", "<html><bold><h2>The Conjuring</h2></html>"};
        for (int i = 0; i < 4; i++) {
            ImageIcon imageIcon = new ImageIcon(imagePaths[i]); // Load the image
            Image image = imageIcon.getImage().getScaledInstance(280, 380, Image.SCALE_SMOOTH); // Resize the image
            JLabel imageLabel = new JLabel(new ImageIcon(image)); // Create a label with the resized image
            JLabel captionLabel = new JLabel(captions[i], SwingConstants.CENTER); // Create a label for the caption
            JPanel imageCaptionPanel = new JPanel(new BorderLayout()); // Panel to hold image and caption
            imageCaptionPanel.add(imageLabel, BorderLayout.CENTER); // Add image to the panel
            imageCaptionPanel.add(captionLabel, BorderLayout.SOUTH); // Add caption below the image
            imagePanel.add(imageCaptionPanel); // Add image panel to the main panel

            int index = i; // Assign the value of i to index for use inside the MouseAdapter

            // Add mouse listener to caption label
            captionLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (index == 0) {
                        // Clicked on Avengers caption, navigate to Avengers page
                        avengers avengersPage = new avengers();
                        avengersPage.setVisible(true);
                        dispose(); // Close the current frame
                    } else if (index == 1) {
                        // Clicked on Interstellar caption, navigate to Interstellar page
                        interstellar interstellarPage = new interstellar();
                        interstellarPage.setVisible(true);
                        dispose(); // Close the current frame
                    } else if (index == 2) {
                        // Clicked on Thor caption, navigate to Thor page
                        thor thorPage = new thor();
                        thorPage.setVisible(true);
                        dispose(); // Close the current frame
                    } else if (index == 3) {
                        // Clicked on Conjuring caption, navigate to Conjuring page
                        conjuring conjuringPage = new conjuring();
                        conjuringPage.setVisible(true);
                        dispose(); // Close the current frame
                    }
                    // You can add similar conditions for other images if needed
                }
            });
        }

        // Add the image panel to the frame
        add(imagePanel, BorderLayout.CENTER);

        // Create a scroll pane to add scrolling functionality
        JScrollPane scrollPane = new JScrollPane(imagePanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Add the scroll pane to the frame
        add(scrollPane, BorderLayout.CENTER);

        // Display subscription message when the homepage is loaded
        displaySubscriptionMessage();
    }

    private void displaySubscriptionMessage() {
        // Show a JOptionPane with the message and OK button
        JOptionPane.showMessageDialog(this,
                "Please take a subscription before downloading movies.",
                "Subscription Required",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            home frame = new home();
            frame.setVisible(true);
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
            .addGap(0, 615, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 696, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
