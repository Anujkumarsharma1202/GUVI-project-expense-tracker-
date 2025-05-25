# GUVI-project-expense-tracker-
by ANUJ KUMAR SHARMA 
# 💸 Smart Expense Tracker

A **Java-based GUI application** for tracking personal expenses with category analysis, built using **Java Swing**, **JDBC**, and **MySQL**. This project is designed according to the **GUVI Project Evaluation Rubric**.

---

## 📌 Features

- 👤 User Registration and Login
- ➕ Add Daily Expenses (Category, Amount, Date)
- 📂 Stores data securely in MySQL
- 🎨 Creative and responsive UI using Java Swing
- 🔐 Secure JDBC operations with error handling

---

## 🛠️ Technologies Used

- Java SE 17
- MySQL 8.0+
- JDBC
- Java Swing (GUI)
- MySQL Workbench
- IDE: Visual Studio Code

---

## 🗂️ Project Structure

SmartExpenseTracker/
├── DBConnection.java
├── Main.java
├── model/
│ ├── User.java
│ └── Expense.java
├── dao/
│ ├── UserDAO.java
│ └── ExpenseDAO.java
├── view/
│ ├── LoginFrame.java
│ ├── RegisterFrame.java
│ └── ExpenseFrame.java
└── README.md





---

## 🧱 Database Schema

Database: `expense_tracker`

### Table: `users`

| Field     | Type          |
|-----------|---------------|
| id        | INT (PK)      |
| username  | VARCHAR(50)   |
| password  | VARCHAR(50)   |

### Table: `expenses`

| Field     | Type           |
|-----------|----------------|
| id        | INT (PK)       |
| user_id   | INT (FK)       |
| category  | VARCHAR(50)    |
| amount    | DOUBLE         |
| date      | DATE           |

---

## 🚀 How to Run

1. ✅ Install Java JDK and VS Code
2. ✅ Set up MySQL and create the database:
   ```sql
   CREATE DATABASE IF NOT EXISTS expense_tracker;

   CREATE TABLE IF NOT EXISTS users (
       id INT AUTO_INCREMENT PRIMARY KEY,
       username VARCHAR(50) UNIQUE NOT NULL,
       password VARCHAR(50) NOT NULL
   );

   CREATE TABLE IF NOT EXISTS expenses (
       id INT AUTO_INCREMENT PRIMARY KEY,
       user_id INT NOT NULL,
       category VARCHAR(50),
       amount DOUBLE,
       date DATE,
       FOREIGN KEY (user_id) REFERENCES users(id)
   );


private static final String URL = "jdbc:mysql://localhost:3306/expense_tracker";
private static final String USER = "root";
private static final String PASSWORD = "Anuj@5649"; // your password


 Evaluation Rubric (Mapped)
Criteria	Marks
JDK & IDE Setup	2
Project Structure	1
Database Schema Design	1
MySQL Table Creation	1
JDBC Implementation	3
Model & DAO Classes	3
UI Aesthetics (Creative Design)	4
Component Placement and Alignment	2
Responsiveness and Accessibility	2


