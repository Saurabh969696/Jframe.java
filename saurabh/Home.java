package saurabh;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jagad\\eclipse-workspace\\swing\\src\\attendance.jpg"));
		setTitle("Attendance ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1275, 671);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(200, 231, 251));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Take All Class ");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Allmain h=new Allmain();
        		h.setVisible(true);
        		dispose();
			}
		});
		btnNewButton.setBounds(659, 576, 197, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Batchwise");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Allmain1 h=new Allmain1();
        		h.setVisible(true);
        		dispose();
			}
		});
		btnNewButton_1.setBounds(896, 576, 197, 38);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Attendance Management System ");
		lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 70));
		lblNewLabel_1.setBounds(161, 170, 1057, 67);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jagad\\eclipse-workspace\\swing\\src\\Dayanand\\nblogo.png"));
		lblNewLabel.setBounds(25, 25, 308, 257);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("N. B. Navale Sinhgad College");
		lblNewLabel_1_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 60));
		lblNewLabel_1_1.setBounds(260, 25, 770, 67);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Of Engineering,Solapur ");
		lblNewLabel_1_1_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 60));
		lblNewLabel_1_1_1.setBounds(312, 103, 630, 67);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Computer Science Engineering ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setBounds(367, 240, 474, 58);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sy-cse-1");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setBounds(558, 309, 101, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Team Member's ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(26, 443, 181, 25);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Dayanand Jagadale ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(24, 478, 216, 25);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Saurabh Aglave");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5_1.setBounds(24, 513, 216, 25);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("Sagar hulle");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5_2.setBounds(24, 548, 216, 25);
		contentPane.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("Aditya boddu");
		lblNewLabel_5_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5_3.setBounds(25, 583, 216, 25);
		contentPane.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_6 = new JLabel("Guidance By : Dhanave Sir");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setBounds(464, 350, 277, 30);
		contentPane.add(lblNewLabel_6);
	}
}
