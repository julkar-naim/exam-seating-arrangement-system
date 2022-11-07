package org.seating_arrangement_system.gui;

import javax.swing.*;

public class Welcome extends CenteredLayout{

    public Welcome() {
        this.setTitle("Welcome");

        JButton adminButton = new JButton("Admin");

        adminButton.addActionListener(action -> {
            this.dispose();
            new AdminLoginForm();
        });

        JButton studentButton = new JButton("Student");

        studentButton.addActionListener(action -> {
            this.dispose();
            new StudentView();
        });


        compList.add(adminButton);
        compList.add(studentButton);
        this.render();
        this.setVisible(true);
    }
}
