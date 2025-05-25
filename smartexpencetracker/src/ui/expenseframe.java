package ui;

import dao.expenceDAO;
import model.Expense;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class expenseframe extends JFrame {
    private JComboBox<String> categoryCombo;
    private JTextField amountField;
    private JTextField dateField;
    private int userId;

    public expenseframe(int userId) {
        this.userId = userId;

        setTitle("Add Expense");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel categoryLabel = new JLabel("Category:");
        categoryCombo = new JComboBox<>(new String[]{"Food", "Travel", "Bills", "Entertainment", "Others"});

        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField(15);

        JLabel dateLabel = new JLabel("Date (YYYY-MM-DD):");
        dateField = new JTextField(15);
        dateField.setText(LocalDate.now().toString());  // default today

        JButton addBtn = new JButton("Add Expense");
        addBtn.addActionListener(this::addExpenseAction);

        c.insets = new Insets(10,10,10,10);
        c.anchor = GridBagConstraints.LINE_END;

        c.gridx = 0; c.gridy = 0; panel.add(categoryLabel, c);
        c.gridy = 1; panel.add(amountLabel, c);
        c.gridy = 2; panel.add(dateLabel, c);

        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 1; c.gridy = 0; panel.add(categoryCombo, c);
        c.gridy = 1; panel.add(amountField, c);
        c.gridy = 2; panel.add(dateField, c);

        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 1; c.gridy = 3; panel.add(addBtn, c);

        add(panel);
    }

    private void addExpenseAction(ActionEvent e) {
        String category = (String) categoryCombo.getSelectedItem();
        String amountText = amountField.getText().trim();
        String date = dateField.getText().trim();

        if (category == null || amountText.isEmpty() || date.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double amount = Double.parseDouble(amountText);
            LocalDate.parse(date); // validates date format

            Expense expense = new Expense(userId, category, amount, date);
            boolean success = expenceDAO.addExpense(expense);

            if (success) {
                JOptionPane.showMessageDialog(this, "Expense added successfully!");
                amountField.setText("");
                dateField.setText(LocalDate.now().toString());
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add expense", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount", "Input Error", JOptionPane.WARNING_MESSAGE);
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Invalid date format. Use YYYY-MM-DD", "Input Error", JOptionPane.WARNING_MESSAGE);
        }
    }
}
