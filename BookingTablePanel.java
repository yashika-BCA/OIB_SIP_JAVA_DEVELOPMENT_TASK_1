import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class BookingTablePanel extends JPanel {
    JTable table;

    public BookingTablePanel(Dashboard dashboard) {
        setLayout(new BorderLayout());

        String[] columns = {"PNR", "Passenger", "Train No", "Seat No", "Date", "Source", "Destination", "Status"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM reservations ORDER BY travel_date DESC";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] row = {
                        rs.getInt("pnr"),
                        rs.getString("passenger_name"),
                        rs.getString("train_no"),
                        rs.getString("seat_no"),
                        rs.getDate("travel_date"),
                        rs.getString("source"),
                        rs.getString("destination"),
                        rs.getString("status")
                };
                model.addRow(row);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading bookings: " + ex.getMessage());
        }

        // Back Button
        JButton backBtn = new JButton("Back");
        backBtn.setFont(new Font("SansSerif", Font.PLAIN, 30));
        backBtn.addActionListener(e -> dashboard.showDefaultPanel());

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottomPanel.add(backBtn);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}
