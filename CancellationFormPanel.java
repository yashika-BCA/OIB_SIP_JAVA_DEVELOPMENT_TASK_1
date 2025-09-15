import javax.swing.*;
import java.awt.*;

public class CancellationFormPanel extends JPanel {
    public CancellationFormPanel(Dashboard dashboard) {
        setLayout(new BorderLayout());

        // CancellationForm must extend JPanel
        JPanel cancelPanel = new CancellationForm();
        add(cancelPanel, BorderLayout.CENTER);

        // Back Button
        JButton backBtn = new JButton("Back");
        backBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
        backBtn.addActionListener(e -> dashboard.showDefaultPanel());

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottomPanel.add(backBtn);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}
