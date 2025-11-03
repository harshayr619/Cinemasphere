package cinemaproject1;
import javax.swing.*;
import java.awt.*;

public class horror extends JFrame {

    public horror() {
        setTitle("CinemaSphere");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        getContentPane().setBackground(Color.BLACK); // Set background color to black

        // Use BorderLayout for the content pane
        getContentPane().setLayout(new BorderLayout());

        // Create label "CinemaSphere" at top center with shiny green color
        JLabel titleLabel = new JLabel("Cinemasphere", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30)); // Set font size to 30 and make it bold
        titleLabel.setForeground(new Color(255, 255, 255));

        // Create panel to hold the title label
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Left-align the title
        titlePanel.setBackground(new Color(47, 79, 79)); // Set background color to match menu bar
        titlePanel.add(titleLabel); // Add title label to the panel

        // Create menu bar with left-aligned elements
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.setBackground(new Color(47, 99, 79)); // Set menu bar background color

        JButton homeButton = new JButton("Home");
homeButton.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font size and style
homeButton.setForeground(Color.WHITE); // Set text color
homeButton.setBackground(new Color(0, 76, 34)); // Set background color
homeButton.setFocusPainted(false); // Remove focus border
homeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add padding

        homeButton.addActionListener((e) -> {
            // Action for home button
        });

        // Create search menu
        JMenu searchMenu = new JMenu("Search");
        searchMenu.setFont(new Font("Arial", Font.PLAIN, 16));
        searchMenu.setForeground(Color.WHITE);
        searchMenu.setBackground(new Color(0, 102, 204));
        searchMenu.setFocusPainted(false);
        searchMenu.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); 
        JTextField searchField = new JTextField(15);
        JButton searchButton = new JButton("Go");
        searchMenu.add(searchField);
        searchMenu.add(searchButton);

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
        categoriesPanel.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font size and style
trendingButton.setForeground(Color.WHITE); // Set text color
trendingButton.setBackground(new Color(0, 76, 34)); // Set background color
trendingButton.setFocusPainted(false); // Remove focus border
trendingButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); 

// Create subscription button
JButton subscriptionButton = new JButton("Subscription");
subscriptionButton.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font size and style
subscriptionButton.setForeground(Color.WHITE); // Set text color
subscriptionButton.setBackground(new Color(0, 76, 34)); // Set background color
subscriptionButton.setFocusPainted(false); // Remove focus border
subscriptionButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

         // Create register/login menu
        JMenu userMenu = new JMenu("User");
         categoriesPanel.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font size and style
userMenu.setForeground(Color.WHITE); // Set text color
userMenu.setBackground(new Color(0, 102, 204)); // Set background color
userMenu.setFocusPainted(false); // Remove focus border
userMenu.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        JMenuItem registerItem = new JMenuItem("Register");
        JMenuItem loginItem = new JMenuItem("Login");
        JMenuItem logoutItem = new JMenuItem("Logout");
        userMenu.add(registerItem);
        userMenu.add(loginItem);
        userMenu.add(logoutItem);

        // Add components to menu bar with appropriate spacing
        menuBar.add(titlePanel); // Add the title panel to the menu bar
        menuBar.add(Box.createHorizontalStrut(70)); // Add space between title and Home button
        menuBar.add(homeButton);
        menuBar.add(Box.createHorizontalStrut(70)); // Add space between HD movies label and search menu
        menuBar.add(searchMenu);
        menuBar.add(Box.createHorizontalStrut(70)); // Add space between search menu and categories
        menuBar.add(categoriesPanel);
        menuBar.add(Box.createHorizontalStrut(70)); // Add space between categories and trending button
        menuBar.add(trendingButton);
        menuBar.add(Box.createHorizontalStrut(70)); // Add space between trending button and subscription button
        menuBar.add(subscriptionButton);
        menuBar.add(Box.createHorizontalStrut(70)); // Add space between trending button and user menu
        menuBar.add(userMenu);

        // Set modern colors for menu bar components
        searchMenu.setForeground(Color.GREEN);
        categoriesPanel.setForeground(Color.GREEN);
        userMenu.setForeground(Color.GREEN);
        searchButton.setForeground(Color.GREEN);
        searchButton.setBackground(new Color(0, 128, 0)); // Shiny green color

        // Add menu bar to the frame
        setJMenuBar(menuBar);

        // Create a label for the paragraph with HTML formatting
        JLabel paragraphLabel = new JLabel("<html><h1 style='text-align: center;font-size:24px;color:white;'><u>Horror Movies:</u></h1>" +
                "</div><br></html>");
        paragraphLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font size and style
        paragraphLabel.setVerticalAlignment(SwingConstants.CENTER); // Align text vertically to center
        paragraphLabel.setHorizontalAlignment(SwingConstants.CENTER); // Align text horizontally to center
        // Make the label opaque to show the background color
        paragraphLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        // Add the paragraph label just below the label "CinemaSphere"
        add(paragraphLabel, BorderLayout.NORTH);
        paragraphLabel.setPreferredSize(new Dimension(100, 80));


        // Create a panel to hold the images and captions
        JPanel imagePanel = new JPanel(new GridLayout(2, 3, 10, 10)); // 2 rows, 3 columns
        imagePanel.setBackground(Color.BLACK); // Set background color to black
        // Add images with captions to the panel
        String[] imagePaths = {
            "C:\\Users\\hp\\OneDrive\\Documents\\NetBeansProjects\\"
+ "cinemaproject1\\src\\cinemaproject1\\annabelle.jpg",
            "C:\\Users\\hp\\OneDrive\\Documents\\NetBeansProjects\\cinemaproject1"
+ "\\src\\cinemaproject1\\annabelle2.jpg",
            "C:\\Users\\hp\\OneDrive\\Documents\\NetBeansProjects\\cinemaproject1"
+ "\\src\\cinemaproject1\\conjuring2.jpg",
            "C:\\Users\\hp\\OneDrive\\Documents\\NetBeansProjects\\cinemaproject1"
+ "\\src\\cinemaproject1\\conjuring3.jpg",
            "C:\\Users\\hp\\OneDrive\\Documents\\NetBeansProjects\\cinemaproject1"
+ "\\src\\cinemaproject1\\nun.jpg",
            "C:\\Users\\hp\\OneDrive\\Documents\\NetBeansProjects\\cinemaproject1"
+ "\\src\\cinemaproject1\\nun2.jpg"
        };
        String[] captions = {"<html><h2 style='color:white;'>Annabelle</html></h2>", "<html><h2 style='color:white;'>Annabelle:Creation</html></h2>",
"<html><h2 style='color:white;'>The Conjuring 2</html></h2>", "<html><h2 style='color:white;'>The Conjuring:The Devil Made Me Do It</html></h2>", "<html><h2 style='color:white;'>The Nun II</html></h2>", "<html><h2 style='color:white;'>Man of Steel</html></h2>"};
        for (int i = 0; i < 6; i++) {
            ImageIcon imageIcon = new ImageIcon(imagePaths[i]); // Load the image
            Image image = imageIcon.getImage().getScaledInstance(280, 380, Image.SCALE_SMOOTH); // Resize the image
            JLabel imageLabel = new JLabel(new ImageIcon(image)); // Create a label with the resized image
            JLabel captionLabel = new JLabel(captions[i], SwingConstants.CENTER); // Create a label for the caption
            JPanel imageCaptionPanel = new JPanel(new BorderLayout()); // Panel to hold image and caption
            imageCaptionPanel.add(imageLabel, BorderLayout.CENTER); // Add image to the panel
            imageCaptionPanel.add(captionLabel, BorderLayout.SOUTH); // Add caption below the image
            imageCaptionPanel.setBackground(Color.BLACK); // Set background color of the panel to black
            imagePanel.add(imageCaptionPanel); // Add image panel to the main panel
        }

        // Create a scroll pane and add the image panel to it
        JScrollPane scrollPane = new JScrollPane(imagePanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // Add the scroll pane to the frame
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            horror frame = new horror();
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

