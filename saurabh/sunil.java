package saurabh;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class sunil extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField age;
	JLabel output;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sunil frame = new sunil();
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
	public sunil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter name:");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNewLabel.setBounds(33, 115, 178, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Age :");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNewLabel_1.setBounds(33, 220, 178, 29);
		contentPane.add(lblNewLabel_1);
		
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n=name.getText();
				int a=Integer.parseInt(age.getText());
				if (a>=18) {
					output.setText(n+" You are eligibal for voting ");
				}
				else {
					output.setText(n+" You are not eligibal for voting");
				}
			}
		});
		ok.setFont(new Font("Tahoma", Font.PLAIN, 23));
		ok.setBounds(90, 297, 164, 45);
		contentPane.add(ok);
		
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setText("");
				age.setText("");
				output.setText("");
			}
		});
		reset.setFont(new Font("Tahoma", Font.PLAIN, 23));
		reset.setBounds(456, 297, 164, 45);
		contentPane.add(reset);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 20));
		name.setToolTipText("your name");
		name.setBounds(246, 111, 309, 37);
		contentPane.add(name);
		name.setColumns(20);
		
		age = new JTextField();
		age.setFont(new Font("Tahoma", Font.PLAIN, 19));
		age.setBounds(246, 204, 309, 37);
		contentPane.add(age);
		age.setColumns(20);
		
		 output = new JLabel("");
		 output.setFont(new Font("Tahoma", Font.PLAIN, 20));
		output.setBounds(145, 379, 374, 57);
		contentPane.add(output);
	}
}