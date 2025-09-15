#____________________________________________________________________________________________JAVA__INTERNSHIP____________________________________________________________________________________________
CREATE DATABASE reservation_system;
USE reservation_system;

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    role ENUM('admin', 'user') DEFAULT 'user'
);

INSERT INTO users (username, password, role)
VALUES ('admin', '1234', 'admin');

CREATE TABLE reservations (
    pnr INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    passenger_name VARCHAR(100),
    train_no VARCHAR(10),
    seat_no VARCHAR(10),
    travel_date DATE,
    source VARCHAR(50),
    destination VARCHAR(50),
    booking_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE cancellations (
    cancel_id INT AUTO_INCREMENT PRIMARY KEY,
    pnr INT,
    cancel_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    reason VARCHAR(255),
    FOREIGN KEY (pnr) REFERENCES reservations(pnr)
);

SHOW TABLES;
SELECT * FROM users ;
SELECT * FROM reservations ;
SELECT * FROM cancellations ;

ALTER TABLE reservations
ADD COLUMN status ENUM('active', 'cancelled') DEFAULT 'active';


Alter table users drop column role;