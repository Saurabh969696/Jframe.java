//jfram.java
package saurabh;

import java.awt.EventQueue;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class jfram extends JFrame {
    private JTextArea output;
    private JTextField dateTextField;
    private JTextField timeTextField;
    private JTextField subjectTextField;
    private JTextField absentCountTextField;
    private JTextField presentCountTextField; // New text field for total present count
    private String[] absentRollNumbers;

    public jfram(String absentRollNumbersText, int presentCount) { // Updated constructor
        setTitle("WINDOW8");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        getContentPane().setLayout(null);

        JLabel absentLabel = new JLabel("Absent Roll No");
        absentLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        absentLabel.setBounds(32, 171, 202, 25);
        getContentPane().add(absentLabel);

        output = new JTextArea();
        output.setFont(new Font("Courier New", Font.PLAIN, 18));
        output.setBounds(244, 169, 300, 176);
        getContentPane().add(output);

        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        dateLabel.setBounds(32, 23, 46, 14);
        getContentPane().add(dateLabel);

        dateTextField = new JTextField();
        dateTextField.setEditable(false);
        dateTextField.setBounds(88, 20, 150, 20);
        getContentPane().add(dateTextField);
        dateTextField.setColumns(10);

        JLabel timeLabel = new JLabel("Time:");
        timeLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        timeLabel.setBounds(248, 23, 46, 14);
        getContentPane().add(timeLabel);

        timeTextField = new JTextField();
        timeTextField.setEditable(false);
        timeTextField.setBounds(304, 20, 150, 20);
        getContentPane().add(timeTextField);
        timeTextField.setColumns(10);

        JLabel subjectLabel = new JLabel("Subject:");
        subjectLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        subjectLabel.setBounds(464, 23, 66, 14);
        getContentPane().add(subjectLabel);

        subjectTextField = new JTextField();
        subjectTextField.setEditable(false);
        subjectTextField.setBounds(540, 20, 150, 20);
        getContentPane().add(subjectTextField);
        subjectTextField.setColumns(10);

        JLabel absentCountLabel = new JLabel("Total Absent:");
        absentCountLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        absentCountLabel.setBounds(32, 60, 120, 20);
        getContentPane().add(absentCountLabel);

        absentCountTextField = new JTextField();
        absentCountTextField.setEditable(false);
        absentCountTextField.setBounds(160, 60, 100, 20);
        getContentPane().add(absentCountTextField);
        absentCountTextField.setColumns(10);
        
        JLabel presentCountLabel = new JLabel("Total Present:"); // New label for total present count
        presentCountLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        presentCountLabel.setBounds(320, 60, 120, 20);
        getContentPane().add(presentCountLabel);

        presentCountTextField = new JTextField(); // New text field for total present count
        presentCountTextField.setEditable(false);
        presentCountTextField.setBounds(460, 60, 100, 20);
        getContentPane().add(presentCountTextField);
        presentCountTextField.setColumns(10);

        // Set current date and time
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        dateTextField.setText(java.time.LocalDate.now().format(dateFormatter));

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        timeTextField.setText(LocalTime.now().format(timeFormatter));

        // Set subject name
        subjectTextField.setText("Mathematics");

        // Set the absent roll numbers
        absentRollNumbers = absentRollNumbersText.split(",");
        output.setText(absentRollNumbersText);
        
        // Calculate and display absent count
        int absentCount = absentRollNumbers.length;
        absentCountTextField.setText(String.valueOf(absentCount));
        
        // Set total present count
        presentCountTextField.setText(String.valueOf(presentCount)); // Set total present count
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    jfram frame = new jfram("", 0); // Pass absent roll numbers and present count
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
