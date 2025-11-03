package cinemaproject1;

import javax.swing.*;
import java.awt.*;

public class upi extends JFrame {

    public upi() {
        setTitle("UPI Payment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        // Set background color
        getContentPane().setBackground(Color.BLACK);

        // Create panel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.BLACK); // Set panel background color

        // Set GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8); // Adjusted insets for spacing
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Form heading label
        JLabel headingLabel = new JLabel("UPI");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Set heading font
        headingLabel.setForeground(Color.WHITE); // Set heading text color
        headingLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center align heading
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(headingLabel, gbc);

        // UPI ID label and text field
        JLabel upiIdLabel = new JLabel("Enter UPI ID:");
        upiIdLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Set label font
        upiIdLabel.setForeground(Color.WHITE); // Set label text color
        JTextField upiIdTextField = new JTextField(20); // Text field for UPI ID
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(upiIdLabel, gbc);
        gbc.gridx = 1;
        panel.add(upiIdTextField, gbc);

        // Fixed amount label
        JLabel fixedAmountLabel = new JLabel("Amount: 500 Rupees");
        fixedAmountLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Set label font
        fixedAmountLabel.setForeground(Color.WHITE); // Set label text color
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(fixedAmountLabel, gbc);

        // Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 14)); // Set button font
        submitButton.setForeground(Color.WHITE); // Set button text color
        submitButton.setBackground(new Color(51, 153, 255)); // Set button background color
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(submitButton, gbc);

        // Add panel to the frame
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            upi upiPage = new upi();
            upiPage.setVisible(true);
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

