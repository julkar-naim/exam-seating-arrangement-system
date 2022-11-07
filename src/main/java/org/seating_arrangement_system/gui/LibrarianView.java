package org.seating_arrangement_system.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LibrarianView extends CenteredLayout {
    public LibrarianView () {
        topLabel.setText("Librarian Section");
        topLabel.setFont(new Font("SF Pro", Font.PLAIN, 25));
        topLabel.setForeground(Color.black);

        topInsets = new Insets(40, 0, 0, 0);

        setSize(400, 500);

        Dimension btnDimension = new Dimension(170, 180);

        JButton addBooks = new JButton("Add Books");
        addBooks.setPreferredSize(btnDimension);
        
        addBooks.addActionListener((ActionEvent e) -> {
        });

        
        compList.add(addBooks);

        JButton viewBooks = new JButton("View Books");
        viewBooks.setPreferredSize(btnDimension);
        
        
        viewBooks.addActionListener((ActionEvent e) -> {
        });
        
        compList.add(viewBooks);

        JButton issueBooks = new JButton("Issue Books");
        issueBooks.setPreferredSize(btnDimension);
        
        issueBooks.addActionListener((ActionEvent e) -> {
        });
        
        
        compList.add(issueBooks);

        JButton viewIssuedBooks = new JButton("View Issued Books");
        viewIssuedBooks.setPreferredSize(btnDimension);
        
        
        viewIssuedBooks.addActionListener((ActionEvent e) -> {
        });
        
        
        compList.add(viewIssuedBooks);

        JButton returnBooks = new JButton("Return Books");
        returnBooks.setPreferredSize(btnDimension);
        
        
        returnBooks.addActionListener((ActionEvent e) -> {
        });
        
        compList.add(returnBooks);

        JButton logout = new JButton("Logout");
        logout.setPreferredSize(btnDimension);
        
        logout.addActionListener((ActionEvent e) -> {
        	dispose();
        });
        
        compList.add(logout);

        render();
        setVisible(true);
    }
}