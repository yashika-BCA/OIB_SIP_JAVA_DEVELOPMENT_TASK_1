import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReservationForm extends JPanel {
    JTextField nameField, trainField, seatField, dateField, sourceField, destField;

    public ReservationForm() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("SansSerif", Font.BOLD, 40);
        Font inputFont = new Font("SansSerif", Font.PLAIN, 40);

        JLabel title = new JLabel("Book Your Ticket");
        title.setFont(new Font("Serif", Font.BOLD, 30));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(title, gbc);

        gbc.gridwidth = 1; gbc.gridy++;
        add(new JLabel("Passenger Name:"), gbc);
        nameField = new JTextField(20); nameField.setFont(inputFont);
        gbc.gridx = 1; add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Train No:"), gbc);
        trainField = new JTextField(20); trainField.setFont(inputFont);
        gbc.gridx = 1; add(trainField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Seat No:"), gbc);
        seatField = new JTextField(20); seatField.setFont(inputFont);
        gbc.gridx = 1; add(seatField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Travel Date (YYYY-MM-DD):"), gbc);
        dateField = new JTextField(20); dateField.setFont(inputFont);
        gbc.gridx = 1; add(dateField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Source:"), gbc);
        sourceField = new JTextField(20); sourceField.setFont(inputFont);
        gbc.gridx = 1; add(sourceField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Destination:"), gbc);
        destField = new JTextField(20); destField.setFont(inputFont);
        gbc.gridx = 1; add(destField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        JButton bookBtn = new JButton("Book Now");
        bookBtn.setFont(inputFont);
        gbc.gridwidth = 2;
        add(bookBtn, gbc);

        bookBtn.addActionListener(e -> bookTicket());
    }

    private void bookTicket() {
        // JDBC logic to insert into reservations table
        // You can plug in your existing DB code here
        JOptionPane.showMessageDialog(this, "Ticket booked successfully!");
    }
}
