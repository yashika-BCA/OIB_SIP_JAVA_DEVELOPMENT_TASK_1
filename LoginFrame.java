import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("User Login");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("SansSerif", Font.BOLD, 50);
        Font inputFont = new Font("SansSerif", Font.PLAIN, 35);

        // Title
        JLabel title = new JLabel("Login to Your Account");
        title.setFont(new Font("Serif", Font.BOLD, 35));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(title, gbc);

        // Username
        gbc.gridwidth = 1; gbc.gridy++;
        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(labelFont);
        add(userLabel, gbc);

        gbc.gridx = 1;
        usernameField = new JTextField(20);
        usernameField.setFont(inputFont);
        add(usernameField, gbc);

        // Password
        gbc.gridx = 0; gbc.gridy++;
        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(labelFont);
        add(passLabel, gbc);

        gbc.gridx = 1;
        passwordField = new JPasswordField(20);
        passwordField.setFont(inputFont);
        add(passwordField, gbc);

        // Login Button
        gbc.gridx = 0; gbc.gridy++;
        gbc.gridwidth = 2;
        JButton loginBtn = new JButton("Login");
        loginBtn.setFont(inputFont);
        add(loginBtn, gbc);

        loginBtn.addActionListener(e -> authenticate());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void authenticate() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                dispose();
                new Dashboard(); // Launch dashboard
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials. Try again.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error during login: " + ex.getMessage());
        }
    }
}

