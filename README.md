# OIB_SIP_JAVA_DEVELOPMENT_TASK_1
# 🚆 Gajanan Train Reservation System

A full-stack desktop application built using **Java Swing** and **MySQL**, designed to simulate a real-world train reservation system. It includes user authentication, ticket booking, cancellation, and a dynamic dashboard — all wrapped in a clean, modular GUI.

---

## 🧩 Features

- 🔐 **User Authentication**
  - Create Account / Login
  - Secure access to dashboard

- 🎫 **Ticket Booking**
  - Enter passenger details
  - Assign seat and travel date
  - Auto-generated PNR

- ❌ **Ticket Cancellation**
  - Fetch reservation by PNR
  - Cancel ticket and update status

- 📋 **View Bookings**
  - Tabular display of all reservations
  - Sorted by travel date

- 🖥️ **Dashboard Navigation**
  - Modular panels with Back button integration
  - Menu bar and toolbar for quick access

---

## 🛠️ Technologies Used

| Layer         | Technology         |
|---------------|--------------------|
| Frontend      | Java Swing (GUI)   |
| Backend       | JDBC + MySQL       |
| Database      | MySQL              |
| IDE           | IntelliJ / Eclipse |
| Build Tool    | Manual / JAR       |

---

## 📦 Project Structure

GajananReservationSystem/ ├── src/ │ ├── HomeFrame.java │ ├── AuthFrame.java │ ├── LoginFrame.java │ ├── RegisterFrame.java │ ├── Dashboard.java │ ├── ReservationFormPanel.java │ ├── CancellationFormPanel.java │ ├── BookingTablePanel.java │ └── DBConnection.java ├── lib/ │ └── mysql-connector-java-8.x.x.jar ├── schema.sql ├── README.md └── .gitignore


---

## 🗃️ Database Setup

1. Create a database named `gajanan_reservation`
2. Run the `schema.sql` file to create tables:
   - `users` (for authentication)
   - `reservations` (for booking records)

```sql
CREATE TABLE users (
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(50) UNIQUE NOT NULL,
  password VARCHAR(50) NOT NULL
);

CREATE TABLE reservations (
  pnr INT PRIMARY KEY AUTO_INCREMENT,
  passenger_name VARCHAR(100),
  train_no VARCHAR(20),
  seat_no VARCHAR(10),
  travel_date DATE,
  source VARCHAR(50),
  destination VARCHAR(50),
  status VARCHAR(20)
);

HOW TO RUN THIS

Clone the repository
Import into your Java IDE
Add MySQL JDBC driver to your project (lib/)
Configure DBConnection.java with your MySQL credentials
Run Main.java to launch the app

📄 License
This project is open-source and free to use for educational and portfolio purposes.

💬 Contact
Built by Yashika Sorani 📍 Kota, Rajasthan 📧 [Add your email or LinkedIn if you'd like]

project link:
