package cinemaproject1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class creditcard extends JFrame {

    // Database connection details
    private final String url = "jdbc:mysql://localhost:3306/cinemasphere";
    private final String user = "root";
    private final String password = "";

    public creditcard() {
        setTitle("Credit Card Payment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Set background color
        getContentPane().setBackground(Color.BLACK);

        // Create panel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.BLACK); // Set panel background color

        // Set GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8); // Adjusted insets for spacing
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title label
        JLabel titleLabel = new JLabel("Credit Card Payment");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Set title font
        titleLabel.setForeground(Color.WHITE); // Set title text color
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center align title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        // Card number label and text field
        JLabel cardNumberLabel = new JLabel("Card Number:");
        cardNumberLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Set label font
        cardNumberLabel.setForeground(Color.WHITE); // Set label text color
        JTextField cardNumberField = new JTextField(15);
        cardNumberField.setFont(new Font("Arial", Font.PLAIN, 14)); // Set text field font
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(cardNumberLabel, gbc);
        gbc.gridx = 1;
        panel.add(cardNumberField, gbc);

        // Expiry date label and text field
        JLabel expiryDateLabel = new JLabel("Expiry Date:");
        expiryDateLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Set label font
        expiryDateLabel.setForeground(Color.WHITE); // Set label text color
        JTextField expiryDateField = new JTextField(10);
        expiryDateField.setFont(new Font("Arial", Font.PLAIN, 14)); // Set text field font
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(expiryDateLabel, gbc);
        gbc.gridx = 1;
        panel.add(expiryDateField, gbc);

        // CVV label and text field
        JLabel cvvLabel = new JLabel("CVV:");
        cvvLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Set label font
        cvvLabel.setForeground(Color.WHITE); // Set label text color
        JTextField cvvField = new JTextField(5);
        cvvField.setFont(new Font("Arial", Font.PLAIN, 14)); // Set text field font
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(cvvLabel, gbc);
        gbc.gridx = 1;
        panel.add(cvvField, gbc);

        // Payment button
        JButton paymentButton = new JButton("Make Payment");
        paymentButton.setFont(new Font("Arial", Font.BOLD, 14)); // Set button font
        paymentButton.setForeground(Color.WHITE); // Set button text color
        paymentButton.setBackground(new Color(51, 153, 255)); // Set button background color
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(paymentButton, gbc);

        // Add components to the frame
        add(panel);

        // ActionListener for payment button
        paymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if any of the fields are empty
                if (cardNumberField.getText().isEmpty() || expiryDateField.getText().isEmpty() || cvvField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method if any field is empty
                }

                // Perform payment action here
                String cardNumber = cardNumberField.getText();
                String expiryDate = expiryDateField.getText();
                String cvv = cvvField.getText();

                // Insert data into the database
                insertData(cardNumber, expiryDate, cvv);

                JOptionPane.showMessageDialog(null, "Payment successful!\nData stored in database.", "Payment Status", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    // Method to insert data into the database
    private void insertData(String cardNumber, String expiryDate, String cvv) {
        String query = "INSERT INTO creditcard (card_number, expiry_date, cvv) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, cardNumber);
            preparedStatement.setString(2, expiryDate);
            preparedStatement.setString(3, cvv);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            creditcard paymentPage = new creditcard(); // Changed the class name
            paymentPage.setVisible(true);
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
