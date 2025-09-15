import java.sql.*;

public class TestConnection {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/reservation_system", "root", "root@2024");
            System.out.println("Connected successfully!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
