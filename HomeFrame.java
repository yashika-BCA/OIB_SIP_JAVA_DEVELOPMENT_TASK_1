import javax.swing.*;
import java.awt.*;

public class HomeFrame extends JFrame {
    public HomeFrame() {
        setTitle("Gajanan Train Reservation System");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Welcome Message
        JLabel welcomeLabel = new JLabel("Welcome to Gajanan Train Reservation System", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 50));
        add(welcomeLabel, BorderLayout.CENTER);

        // Proceed Button
        JButton proceedBtn = new JButton("Proceed to Login");
        proceedBtn.setFont(new Font("SansSerif", Font.PLAIN, 35));
        proceedBtn.addActionListener(e -> {
            dispose(); // close home screen
            new AuthFrame(); // open authentication screen
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(proceedBtn);
        add(bottomPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null); // center on screen
        setVisible(true);
    }
}
