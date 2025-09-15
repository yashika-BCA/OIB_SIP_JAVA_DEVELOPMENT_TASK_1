import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RegisterFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public RegisterFrame() {
        setTitle("Create Account");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("SansSerif", Font.BOLD, 50);
        Font inputFont = new Font("SansSerif", Font.PLAIN, 35);

        // Title
        JLabel title = new JLabel("Create a New Account");
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

        // Register Button
        gbc.gridx = 0; gbc.gridy++;
        gbc.gridwidth = 2;
        JButton registerBtn = new JButton("Create Account");
        registerBtn.setFont(inputFont);
        add(registerBtn, gbc);

        registerBtn.addActionListener(e -> registerUser());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void registerUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            String query = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Account created successfully!");
            dispose();
            new LoginFrame(); // redirect to login
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(this, "Username already exists. Choose another.");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error creating account: " + ex.getMessage());
        }
    }
}

