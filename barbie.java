package cinemaproject1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class barbie extends JFrame {

    public barbie() {
        setTitle("CinemaSphere");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Create panel to hold the title label
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Left-align the title
        titlePanel.setBackground(new Color(47, 79, 79)); // Set background color to match menu bar

        // Create label "CinemaSphere" at top center with shiny green color
        JLabel titleLabel = new JLabel("Cinemasphere", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30)); // Set font size to 30 and make it bold
        titleLabel.setForeground(new Color(255, 255, 255));
        titlePanel.add(titleLabel); // Add title label to the panel

        // Create menu bar with left-aligned elements
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.setBackground(new Color(47, 79, 79)); // Set menu bar background color

        // Create "Home" button with modern design and colors
        JButton homeButton = new JButton("Home");
        homeButton.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font size and style
        homeButton.setForeground(Color.WHITE); // Set text color
        homeButton.setBackground(new Color(0, 76, 34)); // Set background color
        homeButton.setFocusPainted(false); // Remove focus border
        homeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add padding

       homeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Open payment page
                home homePage = new home();
                homePage.setVisible(true);
                dispose(); // Close current frame
            }
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

        //Create categories panel
        JPanel categoriesPanel = new JPanel();
        categoriesPanel.setBackground(new Color(47, 79, 79)); // Set background color
        categoriesPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

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
        userMenu.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font size and style
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
        menuBar.add(Box.createHorizontalStrut(70)); // Add space between Home button and search menu
        menuBar.add(searchMenu);
        menuBar.add(Box.createHorizontalStrut(70)); // Add space between search menu and categories
        menuBar.add(categoriesPanel);
        menuBar.add(Box.createHorizontalStrut(70)); // Add space between categories and trending button
        menuBar.add(trendingButton);
        menuBar.add(Box.createHorizontalStrut(70)); // Add space between trending button and subscription button
        menuBar.add(subscriptionButton);
        menuBar.add(Box.createHorizontalStrut(70)); // Add space between subscription button and user menu
        menuBar.add(userMenu);

        // Set modern colors for menu bar components
        searchMenu.setForeground(Color.GREEN);
        categoriesPanel.setForeground(Color.GREEN);
        userMenu.setForeground(Color.GREEN);
        searchButton.setForeground(Color.GREEN);
        searchButton.setBackground(new Color(0, 128, 0)); // Shiny green color

        // Create a black panel with GridBagLayout
        JPanel blackPanel = new JPanel(new GridBagLayout());
        blackPanel.setBackground(Color.BLACK);

        // Create constraints for GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Add menu bar to the frame
        blackPanel.add(menuBar, gbc);

        // Increment gridy for next component
        gbc.gridy++;

        // Create a paragraph at the center using HTML format
        String paragraphHTML = "<html><div style='text-align:center; color: white;font-size:13px;'>"
                + "<h1><b><big>Barbie (2023)</big></h1><br><h2><b>Action/Adventure/Fantasy</b></h2><br>"
+"Barbie and Ken are having the time of their lives in the colorful and seemingly perfect world of Barbie Land.<br>"
+ " However, when they get a chance to go to the real world, they soon discover the joys and perils of living among humans.<br>"
+ "</div></html>";

        JLabel paragraphLabel = new JLabel(paragraphHTML);
        paragraphLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font size and style
        paragraphLabel.setVerticalAlignment(SwingConstants.TOP); // Align text vertically to top
        paragraphLabel.setHorizontalAlignment(SwingConstants.CENTER); // Align text horizontally to center
        blackPanel.add(paragraphLabel, gbc);

        // Increment gridy for next component
        gbc.gridy++;

        // Create an image label
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\hp\\OneDrive\\Documents\\NetBeansProjects\\"
+ "cinemaproject1\\src\\cinemaproject1\\barbie_1.jpg"); // Replace "your_image_path.jpg" with the actual path to your image
        Image image = imageIcon.getImage().getScaledInstance(280, 380, Image.SCALE_SMOOTH); // Set image size to 280x380 pixels
        imageIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon);
        blackPanel.add(imageLabel, gbc);

        // Increment gridy for next component
        gbc.gridy++;

        // Create panel for torrent magnet buttons
        JPanel torrentPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        torrentPanel.setOpaque(false); // Make the panel transparent

        // Create torrent buttons with modern design and colors
        JButton torrent720Button = new JButton("720p Magnet");
        torrent720Button.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font size and style
        torrent720Button.setForeground(Color.WHITE); // Set text color
        torrent720Button.setBackground(new Color(0, 102, 204)); // Set background color
        torrent720Button.setFocusPainted(false); // Remove focus border
        torrent720Button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add padding

        JButton torrent1080Button = new JButton("1080p Magnet");
        torrent1080Button.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font size and style
        torrent1080Button.setForeground(Color.WHITE); // Set text color
        torrent1080Button.setBackground(new Color(0, 102, 204)); // Set background color
        torrent1080Button.setFocusPainted(false); // Remove focus border
        torrent1080Button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add padding

        // Add action listeners to the buttons (replace "your_magnet_links_here" with actual magnet links)
        torrent720Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open magnet link for 720p quality
                openMagnetLink("your_720p_magnet_link_here");
            }

            private void openMagnetLink(String your_720p_magnet_link_here) {
                // Add code to open magnet link
            }
        });

        torrent1080Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open magnet link for 1080p quality
                openMagnetLink("your_1080p_magnet_link_here");
            }

            private void openMagnetLink(String your_1080p_magnet_link_here) {
                // Add code to open magnet link
            }
        });

        // Add buttons to the panel
        torrentPanel.add(torrent720Button);
        torrentPanel.add(torrent1080Button);

        // Add torrent panel to black panel
        blackPanel.add(torrentPanel, gbc);

        // Increment gridy for next component
        gbc.gridy += 2; // Adjust for additional space

        // Create labels for director and cast
        JLabel directorLabel = new JLabel("<html><div style='text-align:center; color: white;font-size:13px;margin-left:520px;'><u>Director:</u><p style='color:blue;font-size:15px;'> Greta Gerwig</div></html>");
        JLabel castLabel1 = new JLabel("<html><div style='text-align:center; color: white;font-size:13px;margin-left:500px;'><u>Cast:</u> Margot Robbie</div></html>");
        JLabel castLabel2 = new JLabel("<html><div style='text-align:center; color: white;font-size:13px;margin-left:500px;'><u>Cast:</u> Emma Mackey</div></html>");
        JLabel castLabel3 = new JLabel("<html><div style='text-align:center; color: white;font-size:13px;margin-left:500px;'><u>Cast:</u> Ryan Gosling</html>");

        // Increment gridy for next component
        gbc.gridy++;

        // Add director and cast labels
        blackPanel.add(directorLabel, gbc);
        gbc.gridy++;
        blackPanel.add(castLabel1, gbc);
        gbc.gridy++;
        blackPanel.add(castLabel2, gbc);
        gbc.gridy++;
        blackPanel.add(castLabel3, gbc);

        // Create a scroll pane for the black panel with vertical scrollbar
        JScrollPane scrollPane = new JScrollPane(blackPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            barbie frame = new barbie();
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
}
