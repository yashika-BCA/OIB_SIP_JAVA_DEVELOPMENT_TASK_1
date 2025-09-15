import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {
    private JPanel contentPanel;

    public Dashboard() {
        setTitle("Reservation Dashboard");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenuItem resItem = new JMenuItem("Book Ticket");
        JMenuItem cancelItem = new JMenuItem("Cancel Ticket");
        JMenuItem viewItem = new JMenuItem("View Bookings");
        menu.add(resItem);
        menu.add(cancelItem);
        menu.add(viewItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Toolbar
        JToolBar toolBar = new JToolBar();
        JButton resBtn = new JButton("Book Ticket");
        JButton cancelBtn = new JButton("Cancel Ticket");
        JButton viewBtn = new JButton("View Bookings");
        toolBar.add(resBtn);
        toolBar.add(cancelBtn);
        toolBar.add(viewBtn);
        add(toolBar, BorderLayout.NORTH);

        // Content Panel
        contentPanel = new JPanel(new BorderLayout());
        add(contentPanel, BorderLayout.CENTER);

        // Default Home Screen
        showDefaultPanel();

        // Action Listeners — pass `this` to each panel
        resItem.addActionListener(e -> showPanel(new ReservationFormPanel(this)));
        cancelItem.addActionListener(e -> showPanel(new CancellationFormPanel(this)));
        viewItem.addActionListener(e -> showPanel(new BookingTablePanel(this)));

        resBtn.addActionListener(e -> showPanel(new ReservationFormPanel(this)));
        cancelBtn.addActionListener(e -> showPanel(new CancellationFormPanel(this)));
        viewBtn.addActionListener(e -> showPanel(new BookingTablePanel(this)));

        setVisible(true);
    }

    // Method to switch panels
    public void showPanel(JPanel panel) {
        contentPanel.removeAll();
        contentPanel.add(panel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    // Method called by Back button
    public void showDefaultPanel() {
        contentPanel.removeAll();
        JLabel welcome = new JLabel("Welcome to Reservation System", SwingConstants.CENTER);
        welcome.setFont(new Font("Serif", Font.BOLD, 40));
        contentPanel.add(welcome, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
