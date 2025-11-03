package cinemaproject1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class subscribe extends JFrame {

    private final String url = "jdbc:mysql://localhost:3306/cinemasphere";
    private final String user = "root";
    private final String password = "";

    public subscribe() {
        setTitle("Buy Subscription");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600); // Increased size
        setLocationRelativeTo(null);

        // Set background color
        getContentPane().setBackground(new Color(41, 47, 51)); // Dark Gray

        // Create panel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(41, 47, 51)); // Dark Gray

        // Set GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Adjusted insets for spacing
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title Label
        JLabel titleLabel = new JLabel("Buy Subscription");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Larger and bold
        titleLabel.setForeground(Color.WHITE); // Set label text color

        // Labels and TextFields
        JLabel nameLabel = new JLabel("Name:");
        formatLabel(nameLabel);
        JTextField nameField = createTextField();

        JLabel emailLabel = new JLabel("Email:");
        formatLabel(emailLabel);
        JTextField emailField = createTextField();

        JLabel addressLabel = new JLabel("Address:");
        formatLabel(addressLabel);
        JTextField addressField = createTextField();

        JLabel cityLabel = new JLabel("City:");
        formatLabel(cityLabel);
        JTextField cityField = createTextField();

        JLabel stateLabel = new JLabel("State:");
        formatLabel(stateLabel);
        JTextField stateField = createTextField();

        // Subscribe Button
        JButton subscribeButton = new JButton("Subscribe");
        subscribeButton.setFont(new Font("Arial", Font.BOLD, 18)); // Set button font
        subscribeButton.setForeground(Color.WHITE); // Set button text color
        subscribeButton.setBackground(new Color(0, 123, 255)); // Dark Blue
        subscribeButton.setFocusPainted(false); // Remove focus border

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 18)); // Set button font
        backButton.setForeground(Color.WHITE); // Set button text color
        backButton.setBackground(new Color(255, 69, 0)); // Orange Red
        backButton.setFocusPainted(false); // Remove focus border

backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Open trending page
                home homePage = new home();
                homePage.setVisible(true);
                dispose(); // Close current frame
            }
        });

        // Add components to panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(nameLabel, gbc);
        gbc.gridx = 1;
        panel.add(nameField, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        panel.add(emailLabel, gbc);
        gbc.gridx = 1;
        panel.add(emailField, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        panel.add(addressLabel, gbc);
        gbc.gridx = 1;
        panel.add(addressField, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        panel.add(cityLabel, gbc);
        gbc.gridx = 1;
        panel.add(cityField, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        panel.add(stateLabel, gbc);
        gbc.gridx = 1;
        panel.add(stateField, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        panel.add(backButton, gbc);

        gbc.gridx = 1;
        panel.add(subscribeButton, gbc);

        add(panel);

        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handle back button click event
                // For now, simply dispose the current frame
                dispose();
            }
        });

        subscribeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handle subscribe button click event
                String name = nameField.getText();
                String email = emailField.getText();
                String address = addressField.getText();
                String city = cityField.getText();
                String state = stateField.getText();

                // Validate email and phone
                if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(null, "Invalid email address");
                    return;
                }

                // Check if any field is empty
                if (name.isEmpty() || email.isEmpty() || address.isEmpty() || city.isEmpty() || state.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields are required");
                    return;
                }

                // Insert subscriber record into database
                try (Connection conn = DriverManager.getConnection(url, user, password)) {
                    String sql = "INSERT INTO subscriber (name, email, address, city, state) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement statement = conn.prepareStatement(sql);
                    statement.setString(1, name);
                    statement.setString(2, email);
                    statement.setString(3, address);
                    statement.setString(4, city);
                    statement.setString(5, state);
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(null, "Make Payment");
                        // Open payment page
                        payment paymentPage = new payment();
                        paymentPage.setVisible(true);
                        dispose(); // Close current frame
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
    }

    private void formatLabel(JLabel label) {
        label.setForeground(Color.WHITE); // Set label text color
        label.setFont(new Font("Arial", Font.BOLD, 16)); // Set label font
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField(20);
        textField.setBackground(new Color(57, 62, 70)); // Darker Gray
        textField.setForeground(Color.WHITE); // Set text field text color
        textField.setBorder(BorderFactory.createLineBorder(Color.WHITE)); // Set border color
        textField.setFont(new Font("Arial", Font.PLAIN, 16)); // Set text field font
        return textField;
    }

    private boolean isValidEmail(String email) {
        // Regular expression for validating email
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            subscribe subscriptionPage = new subscribe();
            subscriptionPage.setVisible(true);
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

    
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(subscribe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(subscribe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(subscribe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(subscribe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

