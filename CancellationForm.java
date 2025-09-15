import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CancellationForm extends JPanel {
    JTextField pnrField;
    JTextArea resultArea;

    public CancellationForm() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font inputFont = new Font("SansSerif", Font.PLAIN, 40);

        JLabel title = new JLabel("Cancel Your Ticket");
        title.setFont(new Font("Serif", Font.BOLD, 30));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(title, gbc);

        gbc.gridwidth = 1; gbc.gridy++;
        add(new JLabel("Enter PNR Number:"), gbc);
        pnrField = new JTextField(20); pnrField.setFont(inputFont);
        gbc.gridx = 1; add(pnrField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        JButton fetchBtn = new JButton("Fetch Details");
        fetchBtn.setFont(inputFont);
        add(fetchBtn, gbc);

        gbc.gridx = 1;
        JButton cancelBtn = new JButton("Cancel Ticket");
        cancelBtn.setFont(inputFont);
        add(cancelBtn, gbc);

        gbc.gridx = 0; gbc.gridy++; gbc.gridwidth = 2;
        resultArea = new JTextArea(8, 35);
        resultArea.setFont(inputFont);
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea), gbc);

        fetchBtn.addActionListener(e -> fetchDetails());
        cancelBtn.addActionListener(e -> cancelTicket());
    }

    private void fetchDetails() {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM reservations WHERE pnr = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(pnrField.getText()));
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String details = "Passenger: " + rs.getString("passenger_name") + "\n"
                        + "Train No: " + rs.getString("train_no") + "\n"
                        + "Seat No: " + rs.getString("seat_no") + "\n"
                        + "Date: " + rs.getDate("travel_date") + "\n"
                        + "Source: " + rs.getString("source") + "\n"
                        + "Destination: " + rs.getString("destination") + "\n"
                        + "Status: " + rs.getString("status");
                resultArea.setText(details);
            } else {
                resultArea.setText("No reservation found for PNR: " + pnrField.getText());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching details: " + ex.getMessage());
        }
    }


    private void cancelTicket() {
        // JDBC logic to insert into cancellations and update status
        // Plug in your existing code here
        JOptionPane.showMessageDialog(this, "Ticket cancelled successfully!");
    }
}
