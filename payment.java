
package cinemaproject1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class payment extends JFrame {

    public payment() {
        setTitle("Make Payments");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Set background color
        getContentPane().setBackground(new Color(40, 45, 50));

        // Create panel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(40, 45, 50)); // Set panel background color

        // Set GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8); // Adjusted insets for spacing
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title label
        JLabel titleLabel = new JLabel("Make Payments");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Set title font
        titleLabel.setForeground(Color.WHITE); // Set title text color
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center align title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        // Payment amount label
        JLabel amountLabel = new JLabel("Amount to Pay: 500 Rupees");
        amountLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Set label font
        amountLabel.setForeground(Color.WHITE); // Set label text color
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(amountLabel, gbc);

        // Payment method label and combo box
        JLabel methodLabel = new JLabel("Payment Method:");
        methodLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Set label font
        methodLabel.setForeground(Color.WHITE); // Set label text color
        String[] methods = {"Credit Card", "UPI",};
        JComboBox<String> methodComboBox = new JComboBox<>(methods);
        methodComboBox.setFont(new Font("Arial", Font.PLAIN, 14)); // Set combo box font
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(methodLabel, gbc);
        gbc.gridx = 1;
        panel.add(methodComboBox, gbc);

        // Payment button
        JButton paymentButton = new JButton("Make Payment");
        paymentButton.setFont(new Font("Arial", Font.BOLD, 14)); // Set button font
        paymentButton.setForeground(Color.WHITE); // Set button text color
        paymentButton.setBackground(new Color(51, 153, 255)); // Set button background color
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(paymentButton, gbc);

        // MouseListener for the payment button
        paymentButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Determine selected payment method
                String selectedMethod = (String) methodComboBox.getSelectedItem();

                // Open corresponding payment page
                if (selectedMethod.equals("Credit Card")) {
                    creditcard creditCardPage = new creditcard();
                    creditCardPage.setVisible(true);
                } else if (selectedMethod.equals("UPI")) {
                    // Open UPI payment page
                    upi upiPage = new upi();
                    upiPage.setVisible(true);
                }

                // Close current page if needed
                dispose(); // This will close the current frame (payment page)
            }
        });

        // Add components to the frame
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            payment paymentPage = new payment();
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
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

