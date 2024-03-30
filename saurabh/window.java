package saurabh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class window extends JFrame {

    public window() {
        setTitle("Main Window");
        setBounds(100, 100, 1269, 704);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel present = new JLabel("Attendance Management System");
        present.setFont(new Font("Tahoma", Font.BOLD, 25));
        present.setBounds(312, 45, 493, 44);
        getContentPane().add(present);

        JButton present1 = new JButton("Presenty");
        present1.setFont(new Font("Tahoma", Font.BOLD, 20));
        present1.setBounds(124, 252, 235, 51);
        getContentPane().add(present1);

        
        present1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                Allmain frame = new Allmain();
                frame.setVisible(true); // Show Allmain page
                dispose(); // Close the current window
            }
        });

        JButton batchwise = new JButton("Batchwise Presenty");
        batchwise.setFont(new Font("Tahoma", Font.BOLD, 20));
        batchwise.setBounds(526, 252, 235, 51);
        getContentPane().add(batchwise);

        // ActionListener for the Batchwise button
        batchwise.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 Allmain2 frame = new Allmain2();
                 frame.setVisible(true); // Show Allmain1 page
                 dispose();// Close the current window
            }
        });
    }

    public static void main(String[] args) {
        window frame = new window();
        frame.setVisible(true);
    }
}
