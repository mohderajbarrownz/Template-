package com.app;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class UpdateFrame extends JFrame {

    JTextField txtId, txtName, txtSalary;
    JLabel lblMsg;

    String url = "jdbc:mysql://127.0.0.1:3306/barrownz?autoReconnect=true&useSSL=false";
    String user="root";
    String pass="boot";

    public UpdateFrame() {

        txtId = new JTextField(10);
        txtName = new JTextField(10);
        txtSalary = new JTextField(10);

        JButton btnLoad = new JButton("Load");
        JButton btnUpdate = new JButton("Update");

        lblMsg = new JLabel(" ", JLabel.CENTER);

        btnLoad.addActionListener(e -> loadData());
        btnUpdate.addActionListener(e -> updateData());

        JPanel p = new JPanel(new GridLayout(5,2,5,5));
        p.setBorder(BorderFactory.createTitledBorder("Update Employee"));

        p.add(new JLabel("Employee ID:")); p.add(txtId);
        p.add(btnLoad); p.add(new JLabel());
        p.add(new JLabel("Name:")); p.add(txtName);
        p.add(new JLabel("Salary:")); p.add(txtSalary);
        p.add(btnUpdate); p.add(lblMsg);

        add(p);

        setTitle("Update Employee");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void loadData() {
        try {
            Connection cn = DriverManager.getConnection(url,user,pass);
            PreparedStatement ps =
                    cn.prepareStatement("SELECT * FROM employee WHERE id=?");

            ps.setInt(1, Integer.parseInt(txtId.getText()));
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                txtName.setText(rs.getString("name"));
                txtSalary.setText(String.valueOf(rs.getDouble("salary")));
                lblMsg.setText("Record Loaded");
            } else {
                lblMsg.setText("ID Not Found");
            }
            cn.close();

        } catch (Exception e) {
            lblMsg.setText("Error");
        }
    }

    void updateData() {
        try {
            Connection cn = DriverManager.getConnection(url,user,pass);
            PreparedStatement ps =
                    cn.prepareStatement(
                            "UPDATE employee SET name=?, salary=? WHERE id=?");

            ps.setString(1, txtName.getText());
            ps.setDouble(2, Double.parseDouble(txtSalary.getText()));
            ps.setInt(3, Integer.parseInt(txtId.getText()));

            int a = ps.executeUpdate();
            lblMsg.setText(a>0 ? "Updated Successfully" : "Update Failed");

            cn.close();

        } catch (Exception e) {
            lblMsg.setText("Error");
        }
    }
}
