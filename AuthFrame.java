import javax.swing.*;
import java.awt.*;

public class AuthFrame extends JFrame {
    public AuthFrame() {
        setTitle("User Authentication");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font btnFont = new Font("SansSerif", Font.BOLD, 50);

        JLabel title = new JLabel("Sigh in or sign up:");
        title.setFont(new Font("Serif", Font.BOLD, 35));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(title, gbc);

        gbc.gridwidth = 1; gbc.gridy++;
        JButton loginBtn = new JButton("Login");
        loginBtn.setFont(btnFont);
        loginBtn.addActionListener(e -> {
            dispose();
            new LoginFrame(); // next step
        });
        add(loginBtn, gbc);

        gbc.gridx = 1;
        JButton registerBtn = new JButton("Create New Account");
        registerBtn.setFont(btnFont);
        registerBtn.addActionListener(e -> {
            dispose();
            new RegisterFrame(); // next step
        });
        add(registerBtn, gbc);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
