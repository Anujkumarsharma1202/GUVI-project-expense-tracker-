package ui;

import dao.userDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class loginframe extends JFrame {
    private JTextField userField;
    private JPasswordField passField;

    public loginframe() {
        setTitle("Expense Tracker - Login");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Layout - Using GridBag for better alignment
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");

        userField = new JTextField(15);
        passField = new JPasswordField(15);

        JButton loginBtn = new JButton("Login");
        loginBtn.addActionListener(this::loginAction);

        c.insets = new Insets(10,10,10,10);

        c.gridx = 0; c.gridy = 0; c.anchor = GridBagConstraints.LINE_END;
        panel.add(userLabel, c);
        c.gridx = 1; c.anchor = GridBagConstraints.LINE_START;
        panel.add(userField, c);

        c.gridx = 0; c.gridy = 1; c.anchor = GridBagConstraints.LINE_END;
        panel.add(passLabel, c);
        c.gridx = 1; c.anchor = GridBagConstraints.LINE_START;
        panel.add(passField, c);

        c.gridx = 1; c.gridy = 2; c.anchor = GridBagConstraints.CENTER;
        panel.add(loginBtn, c);

        add(panel);
    }

    private void loginAction(ActionEvent e) {
        String username = userField.getText().trim();
        String password = new String(passField.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter username and password", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (userDAO.validateUser(username, password)) {
            int userId = userDAO.getUserId(username);
            JOptionPane.showMessageDialog(this, "Login Successful!");
            new expenseframe(userId).setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new loginframe().setVisible(true));
    }
}
