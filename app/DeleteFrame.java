package com.app;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class DeleteFrame extends JFrame {

    JTextField txtId;
    JLabel lblMsg;

    String url = "jdbc:mysql://127.0.0.1:3306/barrownz?autoReconnect=true&useSSL=false";
    String user="root";
    String pass="boot";

    public DeleteFrame() {

        txtId = new JTextField(10);
        JButton btnDelete = new JButton("Delete");
        lblMsg = new JLabel(" ", JLabel.CENTER);

        btnDelete.addActionListener(e -> delete());

        JPanel p = new JPanel(new GridLayout(3,2,5,5));
        p.add(new JLabel("Employee ID:")); p.add(txtId);
        p.add(btnDelete); p.add(lblMsg);

        add(p);

        setTitle("Delete Employee");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void delete() {
        try {
            Connection cn = DriverManager.getConnection(url,user,pass);
            PreparedStatement ps =
                    cn.prepareStatement("DELETE FROM employee WHERE id=?");

            ps.setInt(1, Integer.parseInt(txtId.getText()));

            int a = ps.executeUpdate();
            lblMsg.setText(a>0 ? "Deleted Successfully" : "ID Not Found");

            cn.close();

        } catch (Exception e) {
            lblMsg.setText("Error");
        }
    }
}
