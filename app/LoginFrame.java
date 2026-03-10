package com.app;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class LoginFrame extends JFrame {

    private JTextField txtUser;
    private JPasswordField txtPass;
    private JLabel lblMsg;

    private final String url =
            "jdbc:mysql://localhost:3306/employee?useSSL=false&serverTimezone=UTC";
    private final String dbUser = "root";
    private final String dbPass = "boot";

    public LoginFrame() {

        JLabel title = new JLabel("Employee Login", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel l1 = new JLabel("Username:");
        JLabel l2 = new JLabel("Password:");

        txtUser = new JTextField(15);
        txtPass = new JPasswordField(15);

        JButton btnLogin = new JButton("Login");

        lblMsg = new JLabel(" ", JLabel.CENTER);
        lblMsg.setForeground(Color.RED);

        JPanel form = new JPanel(new GridLayout(3, 2, 10, 10));
        form.add(l1);
        form.add(txtUser);
        form.add(l2);
        form.add(txtPass);
        form.add(btnLogin);
        form.add(lblMsg);

        JPanel main = new JPanel(new BorderLayout(10, 10));
        main.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        main.add(title, BorderLayout.NORTH);
        main.add(form, BorderLayout.CENTER);

        add(main);

        btnLogin.addActionListener(e -> login());

        setTitle("Login");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void login() {

        String username = txtUser.getText().trim();
        String password = String.valueOf(txtPass.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            lblMsg.setText("Please enter username and password");
            return;
        }

        String sql = "SELECT id FROM users WHERE username=? AND password=?";

        try (
                Connection cn = DriverManager.getConnection(url, dbUser, dbPass);
                PreparedStatement ps = cn.prepareStatement(sql)
        ) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                dispose();          // close login window
                new FourthActivity(); // open dashboard
            } else {
                lblMsg.setText("Invalid Username or Password");
            }

        } catch (SQLException e) {
            lblMsg.setText("Database connection error");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
