package cinemaproject1;

import javax.swing.JOptionPane;

import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;

public class signIn extends javax.swing.JFrame {

    String url = "jdbc:mysql://localhost:3306/cinemasphere";
    String user = "root";
    String password = "";

    /**
     * Creates new form Register
     */
    public signIn() {
        initComponents();
    }

    private String validateName(String name) {
        if (name == null || name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name cannot be empty.", "Name", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        // Check for allowed characters (letters, spaces, apostrophes, hyphens)
        if (!name.matches("^[a-zA-Z \\-']+$")) {
            JOptionPane.showMessageDialog(this, "Name can only contain letters, spaces, apostrophes, and hyphens.", "Name", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        // Optionally, check for minimum and maximum length
        if (name.length() < 2 || name.length() > 50) {
            JOptionPane.showMessageDialog(this, "Name must be between 2 and 50 characters long.", "Name", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        // Name is valid, return it
        return name.trim(); // Remove leading/trailing whitespace
    }

    private String validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email address cannot be empty.", "Email", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        return email.trim();
    }

    private String validatePhone(String phone) {
        if (phone == null || phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Phone number cannot be empty.", "Phone Number", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        // Regular expression for basic phone number format (adjust based on your region)
        String phoneRegex = "^[\\d+-]*$"; // Allows digits and hyphens

        // Optionally, check for specific length based on your region
        int minLength = 10; // Adjust minimum length as needed
        int maxLength = 13; // Adjust maximum length as needed
        if (!phone.matches(phoneRegex) || phone.length() < minLength || phone.length() > maxLength) {
            String errorMessage = "Please enter a valid phone number (";
            errorMessage += minLength + "-" + maxLength + " digits allowed).";
            JOptionPane.showMessageDialog(this, errorMessage, "Phone Number", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        return phone.trim();
    }

    private String validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password cannot be empty.", "Password", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        return password;
    }

    @SuppressWarnings("checked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        submit = new javax.swing.JLabel();
        Phone = new javax.swing.JTextField();
        Password = new javax.swing.JTextField();
        Name = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hospital");
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);

        getContentPane().setBackground(Color.BLACK);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setText("Register");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        jPanel1.setBackground(Color.BLACK);

        jLabel2.setForeground(Color.WHITE);
        jLabel2.setText("Name");

        jLabel3.setForeground(Color.WHITE);
        jLabel3.setText("Email");

        jLabel4.setForeground(Color.WHITE);
        jLabel4.setText("Phone");

        jLabel5.setForeground(Color.WHITE);
        jLabel5.setText("Set Password");

        submit.setBackground(new java.awt.Color(255, 69, 0));
        submit.setForeground(Color.WHITE);
        submit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        submit.setText("Submit");
        submit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        submit.setOpaque(true); // Make the button opaque
        submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Phone, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(submit)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(141, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(254, 254, 254))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void submitMouseClicked(java.awt.event.MouseEvent evt) {

        System.out.println("mouse clicked");
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users ("
                    + "name VARCHAR(100),"
                    + "email VARCHAR(100) primary key,"
                    + "phone VARCHAR(15),"
                    + "password VARCHAR(100)"
                    + ")";

            try (Statement statement = conn.createStatement()) {
                statement.executeUpdate(createTableSQL);
                System.out.println("Table created successfully!");
            } catch (SQLException ex) {
                System.out.println("Failed to create table: " + ex.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println("Connection failed: " + ex.getMessage());
        }

        String validatedName = validateName(Name.getText());
        String validatedEmail = validateEmail(Email.getText());
        String validatedPhone = validatePhone(Phone.getText());
        String validatedPassword = validatePassword(Password.getText());

        if (validatedName == null || validatedEmail == null || validatedPhone == null || validatedPassword == null) {
            return; // Exit early if validation fails
        }

        // Insert data into the table
        String insertSQL = "INSERT INTO users (name, email, phone, password) VALUES ('"
                + validatedName + "', '" + validatedEmail + "', '" + validatedPhone + "', '" + validatedPassword + "')";

        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(insertSQL);
            this.setVisible(false);
            login anotherPage;
            anotherPage = new login();
            anotherPage.setVisible(true);
            System.out.println("Data inserted successfully!");

        } catch (SQLException ex) {
            System.out.println("Failed to insert data: " + ex.getMessage());
        }
        // Hide the current frame (Register frame)

    }

    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new signIn().setVisible(true);
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JTextField Email;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField Password;
    private javax.swing.JTextField Phone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel submit;
    // End of variables declaration
}

