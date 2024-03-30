package saurabh;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.awt.EventQueue;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.FileWriter;  
import java.io.IOException; 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DropMode;
import java.awt.Font;
import javax.swing.JButton;
import java.util.Arrays;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.JTextArea;
public class Allmain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField input;
	private JTextField out1;
	private JTextField out2;
	JComboBox ch;
	JRadioButton py;
	JRadioButton aby;
	private String name="";
	int aa=0;
	 private JTextField fileNameField;
	 private JButton downloadButton;
	

	/**
	 * Launch the application.
	 */
	
	int[] present = new int[100];
    int[] check = new int[100];
    int[] spre = new int[100];
    int[] apre = new int[100];
    int[] abr = new int[100];
    int[] pr = new int[100];
	String subject ="";
    int total = 78;
    int start = 0;
    private JLabel lblNewLabel;
    private JTextField sub;
    private JLabel lblNewLabel_2;
    private JTextField subj;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;
    private JButton re;
    private JLabel lblNewLabel_3;

void display(int[] spre, int[] apre, int total, int start, String subject) {
// printing information about the present and absent
System.out.println("\n" + "Subject : " + subject + "\n");
int presentCount = 0;
int absentCount = 0;
String out="";


System.out.println("Present : ");
for (int k = start + 1; k < total + 1; k++) {
    if (spre[k] == 1) {
        System.out.println(k + ": " );
        out +=" " + k;
        presentCount++;

    }
}
out1.setText(out);
String outab="";
System.out.println("\nTotal Present: " + presentCount);

System.out.println("\n");
System.out.println("Absent : ");
for (int j = start + 1; j < total + 1; j++) {
    if (apre[j] == 1) {
        System.out.println(j + ": ");
        outab += " " +  j;
        absentCount++;
    }
}
System.out.println("\nTotal Absent: " + absentCount);


out2.setText(outab);



}

//Enter the absent Roll no Logic
public void enterab(int[] spre, int[] apre,int[] abr, int total, int start ,String datatext ){

    String data =datatext;
     String numbersString ="0,";
     numbersString += data;
    String[] numbersArray = numbersString.split(",");
    Arrays.sort(numbersArray);
    for (int i = 0; i < numbersArray.length; i++) {
        abr[i] = Integer.parseInt(numbersArray[i]);
    }

     int l = start + 1;
     for (int abb = start + 1; abb < total + 1; abb++) {

         if (abr[l] == abb) {
             apre[abb] = 1;
             l = l + 1;
         } else {
             spre[abb] = 1;
         }
     }


 }
//Enter the present Roll no Logic

public void enterpr(int[] spre, int[] apre,int[] abr, int total, int start ,String datatext ){

    String data =datatext;
     String numbersString ="0,";
     numbersString += data;
    String[] numbersArray = numbersString.split(",");
    Arrays.sort(numbersArray);
    for (int i = 0; i < numbersArray.length; i++) {
        pr[i] = Integer.parseInt(numbersArray[i]);
    }

     int l = start + 1;
     for (int spp = start + 1; spp < total + 1; spp++) {

         if (abr[l] == spp) {
        	 spre[spp] = 1;
             l = l + 1;
         } else {
             apre[spp] = 1;
         }
     }


 }

private void downloadFile(String fileName) {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Save File");
    int userSelection = fileChooser.showSaveDialog(this);

    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        try {
            // Here, you should implement your file download logic
            // For demonstration purposes, let's assume we copy a sample file
            File sourceFile = new File(fileName); // Assuming the file exists in the current directory
            Files.copy(sourceFile.toPath(), selectedFile.toPath());
            JOptionPane.showMessageDialog(this, "File downloaded successfully.");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error downloading file: " + ex.getMessage());
        }
    }
}


//Create the txt File Logic
public static String txt( int start,int total,int []spre, int[]apre ,String subject) {
    Date currentDate = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    String formattedDate = dateFormat.format(currentDate);
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    String formattedTime = timeFormat.format(currentDate);
  
   String  name="Sy-"+formattedDate+" "+subject+".txt";
    
    try {
     
      System.out.println(name);
        FileWriter myWriter = new FileWriter(name);

        int presentCount = 0;
        int absentCount = 0;
        myWriter.write("--------------------"+subject+"---------------------\n");
        myWriter.write(formattedDate+"\n");
        myWriter.write( formattedTime+"\n");

        myWriter.write("present :\n");
        for (int k = start + 1; k < total + 1; k++) {
            if (spre[k] == 1) {
                
                myWriter.write(k + ": " + data(k)+"\n");
                presentCount++;
    
            }
        }
       
        myWriter.write("Absent : \n");
        for (int j = start + 1; j < total + 1; j++) {
            if (apre[j] == 1) {
                
                myWriter.write(j + ": " + data(j)+"\n" );
                absentCount++;
            }
        }
        myWriter.write("\nTotal Present: " + presentCount + "\n");
        myWriter.write("\nTotal Absent: " + absentCount + "\n" );
        myWriter.close();

        myWriter.close();
        System.out.println("Successfully wrote to the file.");
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    return name ;
    
}

//All name of class 
public static String data(int index) {
    String[] name = new String[100];
    name[0] = "";
    name[1] = "Saurabh aglave";
    name[2] = "Devashree agnihotri";
    name[3] = "Rohit bandgar";
    name[4] = "Aditya boddu";
    name[5] = "Atharva chaudhari";
    name[6] = "Samarth chavan";
    name[7] = "Paras dhajal";
    name[8] = "Shruti dhumal";
    name[9] = "Shreedhar doijode";
    name[10] = "anushka dussa";
    name[11] = "Vaishnavi emekar";
    name[12] = "Ritej gaikwad";
    name[13] = "Onkar gawade";
    name[14] = "Shubham ghadage";
    name[15] = "Ambadas gote";
    name[16] = "Nurandayya hiremath";
    name[17] = "Sagar hulle";
    name[18] = "Akshay ingale";
    name[19] = "Prakash jadhav";
    name[20] = "Dayanand jagdale";
    name[21] = "Devidas kakade";
    name[22] = "Aditya kamble";
    name[23] = "Pratik kamble";
    name[24] = "Sakshi kamble";
    name[25] = "Vaishnavi kamble";
    name[26] = "Samarth kanagi";
    name[27] = "Sapana kandalgaonkar";
    name[28] = "Samir karache";
    name[29] = "Kirtan karwa";
    name[30] = "Bhargav katkam";
    name[31] = "Swapnil kengar";
    name[32] = "Neha kore";
    name[33] = "Ashvini lad";
    name[34] = "Dharmavir londhe";
    name[35] = "Sonal mahamuni";
    name[36] = "Ananya menchekaa";
    name[37] = "Uday more";
    name[38] = "Vishal mote";
    name[39] = "Raj naik";
    name[40] = "Anuja narsale";
    name[41] = "Rutuja nilange";
    name[42] = "Viresh paramahetti";
    name[43] = "Vaishnavi patil";
    name[44] = "Vinayak patil";
    name[45] = "Shivani pethe";
    name[46] = "Dhanashri pujari";
    name[47] = "Sakshi raje";
    name[48] = "Mahavir rupnavar";
    name[49] = "Onkar salunke";
    name[50] = "Anjali salunke";
    name[51] = "Sunil sangolkar";
    name[52] = "Faizan shaikh";
    name[53] = "Mohasin shaikh";
    name[54] = "Rohit shalgar";
    name[55] = "Teja shevale";
    name[56] = "Sujay shewale";
    name[57] = "Aparna shinde";
    name[58] = "Srushti shinde";
    name[59] = "Ismail shirgapure";
    name[60] = "Sushil shivasharan";
    name[61] = "Shrinivas solapure";
    name[62] = "Dnyaneshwar suryawanshi";
    name[63] = "Tamanna tamboli";
    name[64] = "Vaishnavi tapase";
    name[65] = "Athrav vijapure";
    name[66] = "Ajay waghmare";
    name[67] = "Yash waghmare";
    name[68] = "Khandu waghmode";
    name[69] = "Kartik yemul";
    name[70] = "Asawari jambhale";
    name[71] = "Pooja rathod";
    name[72] = "Vaibhavi belamkar";
    name[73] = "Laya kokkul";
    name[74] = "Manasi swadde";
    name[75] = "Sanket honkar";
    name[76] = "Rohan tatipamul";
    name[77] = "Harshada bhore";
    name[78] = "Vaishnavi yeladi";
    return name[index];
}
	public static void main(String[] args) {
		
        
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Allmain frame = new Allmain();
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
	public Allmain() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".cartoon-illustration-man-holding-stick-hand-giving-presentation_262129-821.jpg"));
		setTitle("Attendance System");
		

		for (int set = 0; set <100; set++) {
			present[set] = 1;
			check[set] = 1;
			spre[set] = 0;
			apre[set] = 0;
			abr[set] = 0;
			pr[set] = 0;
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1270, 680);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(200, 231, 251));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		input = new JTextField();
		input.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		input.setBounds(208, 241, 1038, 102);
		contentPane.add(input);
		input.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Roll no :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setBounds(0, 259, 224, 45);
		contentPane.add(lblNewLabel_1);
		
		JButton ok = new JButton("Submits ");
		ok.setForeground(new Color(0, 255, 0));
		ok.setBackground(new Color(215, 255, 215));
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
			
				
				if (aa==1) {
					 enterpr(spre, apre, pr, total, start ,input.getText());
	         			display(spre, apre, total, start, subject);
				        subject=sub.getText();}
				
				else if(aa==2) {
					enterab(spre, apre, pr, total, start ,input.getText());
         			display(spre, apre, total, start, subject);
			        subject=sub.getText();}
				
			
				else {
					input.setText("Plase Select The Present & Absent Button ");
				}
	
				
			}
		});
		ok.setFont(new Font("Tahoma", Font.BOLD, 30));
		ok.setBounds(190, 354, 218, 36);
		contentPane.add(ok);
		
		out1 = new JTextField();
		out1.setFont(new Font("Tahoma", Font.BOLD, 13));
		out1.setBounds(180, 401, 1066, 73);
		contentPane.add(out1);
		out1.setColumns(10);
		
		out2 = new JTextField();
		out2.setFont(new Font("Tahoma", Font.BOLD, 13));
		out2.setBounds(180, 485, 1066, 73);
		contentPane.add(out2);
		out2.setColumns(10);
		
		lblNewLabel = new JLabel("Subjects ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(29, 10, 88, 25);
		contentPane.add(lblNewLabel);
		
		sub = new JTextField();
		sub.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sub.setBounds(127, 5, 224, 36);
		contentPane.add(sub);
		sub.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Date & Time");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(3, 50, 123, 25);
		contentPane.add(lblNewLabel_2);
		
		subj = new JTextField();
		subj.setFont(new Font("Tahoma", Font.PLAIN, 20));
		subj.setBounds(127, 45, 224, 36);
		contentPane.add(subj);
		subj.setColumns(10);
		Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = dateFormat.format(currentDate);
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedTime = timeFormat.format(currentDate);
        System.out.println("Date: " + formattedDate);
        System.out.println("Time: " + formattedTime);
        String datenew ="";
        datenew=formattedDate +" & "+formattedTime;
        subj.setText(datenew);
        
        btnNewButton = new JButton("TextFile");
        btnNewButton.setBackground(new Color(134, 134, 255));
        btnNewButton.setForeground(new Color(0, 0, 255));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		txt(start ,total,spre ,apre,subject);

        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setBounds(1110, 580, 123, 31);
        contentPane.add(btnNewButton);
        
        btnNewButton_1 = new JButton("Home");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Home h =new Home();
        		h.setVisible(true);
        		dispose();
        	}
        });
        btnNewButton_1.setBackground(new Color(134, 134, 255));
        btnNewButton_1.setForeground(new Color(0, 0, 255));
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton_1.setBounds(29, 580, 116, 31);
        contentPane.add(btnNewButton_1);
        
        JRadioButton py = new JRadioButton("Enter Present Roll No");
        py.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		aa=1;
        	}
        });
        py.setFont(new Font("Tahoma", Font.PLAIN, 20));
        py.setBounds(250, 209, 218, 25);
        contentPane.add(py);
        
        JRadioButton aby = new JRadioButton("Enter Absent Roll No");
        aby.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		aa=2;
        	}
        });
        aby.setFont(new Font("Tahoma", Font.PLAIN, 20));
        aby.setBounds(591, 209, 218, 25);
        contentPane.add(aby);
        
        lblNewLabel_4 = new JLabel("Present Roll no");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_4.setBounds(26, 419, 144, 31);
        contentPane.add(lblNewLabel_4);
        
        lblNewLabel_5 = new JLabel("Absent Roll No");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_5.setBounds(29, 506, 131, 25);
        contentPane.add(lblNewLabel_5);
        
        lblNewLabel_6 = new JLabel("Select :");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_6.setBounds(85, 209, 95, 25);
        contentPane.add(lblNewLabel_6);
        
        JButton btnNewButton_2 = new JButton("save file");
        btnNewButton_2.setBackground(new Color(183, 255, 255));
        btnNewButton_2.setForeground(new Color(0, 255, 255));
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 String fileName =  txt(start ,total,spre ,apre,subject);
	                if (!fileName.isEmpty()) {
	                    downloadFile(fileName);
	                } else {
	                    JOptionPane.showMessageDialog(Allmain.this, "Please enter a file name.");
	                }
        	}
        });
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_2.setBounds(1134, 611, 95, 21);
        contentPane.add(btnNewButton_2);
        
        re = new JButton("Reset");
        re.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		out1.setText("");
				out2.setText("");
				input.setText("");
				
				py.setSelected(false);
				aby.setSelected(false);
				for (int set = 0; set <100; set++) {
					present[set] = 1;
					check[set] = 1;
					spre[set] = 0;
					apre[set] = 0;
					abr[set] = 0;
					pr[set] = 0;
				}
        	}
        });
        re.setForeground(Color.RED);
        re.setFont(new Font("Tahoma", Font.BOLD, 30));
        re.setBackground(new Color(255, 202, 202));
        re.setBounds(983, 354, 250, 36);
        contentPane.add(re);
        
        lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon(".attendance.jpg"));
        lblNewLabel_3.setBounds(624, 5, 622, 261);
        contentPane.add(lblNewLabel_3);
	}
}
