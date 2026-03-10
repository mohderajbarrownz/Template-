package com.app;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class SearchFrame extends JFrame {

    JTextField txtId;
    JLabel lblResult;

    String url = "jdbc:mysql://127.0.0.1:3306/barrownz?autoReconnect=true&useSSL=false";
    String user="root";
    String pass="boot";

    public SearchFrame() {

        JLabel l1 = new JLabel("Enter Employee ID:");
        txtId = new JTextField(10);
        JButton btnSearch = new JButton("Search");

        lblResult = new JLabel(" ", JLabel.CENTER);

        btnSearch.addActionListener(e -> search());

        JPanel p = new JPanel(new GridLayout(3,2,5,5));
        p.add(l1); p.add(txtId);
        p.add(btnSearch); p.add(lblResult);

        add(p);

        setTitle("Search Employee");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void search() {
        try {
            Connection cn = DriverManager.getConnection(url,user,pass);
            PreparedStatement ps =
                    cn.prepareStatement("SELECT * FROM employee WHERE id=?");

            ps.setInt(1, Integer.parseInt(txtId.getText()));
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                lblResult.setText(
                        rs.getString("name") + " | " + rs.getDouble("salary")
                );
            } else {
                lblResult.setText("Record Not Found");
            }

            cn.close();

        } catch (Exception e) {
            lblResult.setText("Error");
        }
    }
}
