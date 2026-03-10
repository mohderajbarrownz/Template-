package com.app;

import javax.swing.*;
import java.awt.*;

public class FourthActivity extends JFrame {

    public FourthActivity() {

        JButton btnSearch = new JButton("Search Employee");
        JButton btnUpdate = new JButton("Update Employee");
        JButton btnDelete = new JButton("Delete Employee");

        btnSearch.addActionListener(e -> new SearchFrame());
        btnUpdate.addActionListener(e -> new UpdateFrame());
        btnDelete.addActionListener(e -> new DeleteFrame());

        JPanel p = new JPanel(new GridLayout(3,1,10,10));
        p.setBorder(BorderFactory.createTitledBorder("Employee Dashboard"));
        p.add(btnSearch);
        p.add(btnUpdate);
        p.add(btnDelete);

        add(p);

        setTitle("Dashboard");
        setSize(300,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
