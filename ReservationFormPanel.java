import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ReservationFormPanel extends JPanel {
    public ReservationFormPanel(Dashboard dashboard) {
        setLayout(new BorderLayout());

        // ReservationForm must extend JPanel
        JPanel formPanel = new ReservationForm();
        add(formPanel, BorderLayout.CENTER);

        // Back Button
        JButton backBtn = new JButton("Back");
        backBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
        backBtn.addActionListener(e -> dashboard.showDefaultPanel());

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottomPanel.add(backBtn);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}
