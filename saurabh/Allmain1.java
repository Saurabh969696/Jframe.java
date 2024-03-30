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
public class Allmain1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField input;
	private JTextField out1;
	private JTextField out2;
	JComboBox ch;
	JRadioButton py;
	JRadioButton aby;
	int aa=0;
	private String name="";
	JRadioButton s1;
	JRadioButton s2;
	JRadioButton s3;
	JRadioButton s4;
	String batch ="";
	int[] present = new int[100];
    int[] check = new int[100];
    int[] spre = new int[100];
    int[] apre = new int[100];
    int[] abr = new int[100];
    int[] pr = new int[100];
	String subject ="";
    int total = 0;
    int start = 0;
   public  int st=0;
    private JLabel lblNewLabel;
    private JTextField sub;
    private JLabel lblNewLabel_2;
    private JTextField subj;
    private JButton btnNewButton_1;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;
    private JButton save;

void display(int[] spre, int[] apre, int total, int start, String subject) {
// printing information about the present and absent
System.out.println("\n" + "Subject : " + subject + "\n");
int presentCount = 0;
int absentCount = 0;
String out="";

System.out.println("Present : ");
for (int k = st + 1; k < total + 1; k++) {
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
for (int j = st + 1; j < total + 1; j++) {
    if (apre[j] == 1) {
        System.out.println(j + ": ");
        outab += " " +  j;
        absentCount++;
    }
}
System.out.println("\nTotal Absent: " + absentCount);
out2.setText(outab);

}


public void enterab(int[] spre, int[] apre,int[] abr, int total, int start ,String datatext ){

    String data =datatext;
     String numbersString ="0,";
     numbersString += data;
    String[] numbersArray = numbersString.split(",");
    Arrays.sort(numbersArray);
    for (int i = 0; i < numbersArray.length; i++) {
        abr[i] = Integer.parseInt(numbersArray[i]);
    }

     int l = start+1;
     for (int abb = start + 1; abb < total + 1; abb++) {

         if (abr[l] == abb) {
             apre[abb] = 1;
             l = l + 1;
         } else {
             spre[abb] = 1;
         }
     }


 }

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



public String txt( int start,int total,int []spre, int[]apre ,String subject, String batch) {
    Date currentDate = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    String formattedDate = dateFormat.format(currentDate);
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    String formattedTime = timeFormat.format(currentDate);
  
  
 
    String name="Sy-"+formattedDate+" "+subject+".txt";
    
    try {
     
      System.out.println(name);
        FileWriter myWriter = new FileWriter(name);

        int presentCount = 0;
        int absentCount = 0;
        myWriter.write("--------------------"+subject+"---------------------\n");
        myWriter.write("--------------------"+batch+"---------------------\n");
        myWriter.write(formattedDate+"\n");
        myWriter.write( formattedTime+"\n");

        myWriter.write("present :\n");
        for (int k = st + 1; k < total + 1; k++) {
            if (spre[k] == 1) {
                
                myWriter.write(k + ": " + data(k)+"\n");
                presentCount++;
    
            }
        }
       
        myWriter.write("Absent : \n");
        for (int j = st + 1; j < total + 1; j++) {
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
					Allmain1 frame = new Allmain1();
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
	public Allmain1() {
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
		setBounds(100, 100, 1273, 680);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(200, 231, 251));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		input = new JTextField();
		input.setBounds(237, 236, 998, 102);
		input.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		contentPane.add(input);
		input.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Roll no :");
		lblNewLabel_1.setBounds(3, 272, 224, 45);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		contentPane.add(lblNewLabel_1);
		
		JButton ok = new JButton("Submits ");
		ok.setBounds(242, 349, 218, 36);
		ok.setBackground(new Color(255, 255, 255));
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
					input.setText("Plase Select The Present & Absent Button");
				}
	
				
			}
		});
		ok.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(ok);
		
		out1 = new JTextField();
		out1.setBounds(180, 396, 1069, 73);
		out1.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(out1);
		out1.setColumns(10);
		
		out2 = new JTextField();
		out2.setBounds(180, 480, 1069, 73);
		out2.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(out2);
		out2.setColumns(10);
		
		lblNewLabel = new JLabel("Subjects ");
		lblNewLabel.setBounds(29, 10, 88, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
		sub = new JTextField();
		sub.setBounds(127, 5, 224, 36);
		sub.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(sub);
		sub.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Date & Time");
		lblNewLabel_2.setBounds(3, 50, 123, 25);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_2);
		
		subj = new JTextField();
		subj.setBounds(127, 45, 224, 36);
		subj.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
        
        btnNewButton_1 = new JButton("Home");
        btnNewButton_1.setBounds(167, 585, 116, 31);
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Home h=new Home();
        		h.setVisible(true);
        		dispose();
        	}
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPane.add(btnNewButton_1);
        
        JRadioButton py = new JRadioButton("Enter Present Roll No");
        py.setBounds(252, 204, 218, 25);
        py.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		aa=1;
        	}
        });
        py.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPane.add(py);
        
        JRadioButton aby = new JRadioButton("Enter Absent Roll No");
        aby.setBounds(695, 204, 218, 25);
        aby.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		aa=2;
        	}
        });
        aby.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPane.add(aby);
        
        lblNewLabel_4 = new JLabel("Present Roll no");
        lblNewLabel_4.setBounds(26, 414, 144, 31);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPane.add(lblNewLabel_4);
        
        lblNewLabel_5 = new JLabel("Absent Roll No");
        lblNewLabel_5.setBounds(23, 501, 131, 25);
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPane.add(lblNewLabel_5);
        
        lblNewLabel_6 = new JLabel("Select :");
        lblNewLabel_6.setBounds(93, 207, 95, 25);
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblNewLabel_6);
        
        JLabel lblNewLabel_8 = new JLabel("Select Batch :");
        lblNewLabel_8.setBounds(26, 153, 156, 25);
        lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblNewLabel_8);
        
        JRadioButton s1 = new JRadioButton("SY-CSE-1");
        s1.setBounds(257, 155, 131, 21);
        s1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		total=20;
        	}
        });
        s1.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(s1);
        
        JRadioButton s2 = new JRadioButton("SY-CSE-2");
        s2.setBounds(516, 155, 131, 21);
        s2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	total=40;
        	st=20;
        	
        	}
        });
        s2.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(s2);
        
        JRadioButton s3 = new JRadioButton("SY-CSE-3");
        s3.setBounds(695, 155, 131, 21);
        s3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		total=60;
        		st=40;
        		
        	}
        });
        s3.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(s3);
        
        JRadioButton s4 = new JRadioButton("SY-CSE-4");
        s4.setBounds(929, 155, 144, 21);
        s4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		total=78;
        		st=60;
        		
        	}
        });
        s4.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(s4);
        
        JButton off = new JButton("Reset");
        off.setFont(new Font("Tahoma", Font.BOLD, 30));
        off.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		out1.setText("");
				out2.setText("");
				input.setText("");
				py.setSelected(false);
				aby.setSelected(false);
				s1.setSelected(false);
				s2.setSelected(false);
				s3.setSelected(false);
				s4.setSelected(false);
				total=0;
				st=0;
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
        off.setBounds(1091, 349, 144, 36);
        contentPane.add(off);
        
        save = new JButton("Save file");
        save.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (s1.isSelected()) {
        			batch+="--------SY-CSE-1--------\n";
        		}
        		else if (s2.isSelected()) {
        			batch+="----------SY-CSE-2--------\n";
        		}
        		else if (s3.isSelected()) {
        			batch+="---------SY-CSE-3--------\n";
        		}
        		else if (s4.isSelected()) {
        			batch+="---------SY-CSE-4---------\n";
        		}
        		String fileName =txt(start ,total,spre ,apre,subject,batch);
                if (!fileName.isEmpty()) {
                    downloadFile(fileName);
                } else {
                    JOptionPane.showMessageDialog(Allmain1.this, "Please enter a file name.");
                }
        	}
        });
        save.setBounds(1149, 606, 85, 21);
        contentPane.add(save);
        
        JButton txtbut = new JButton("TextFile");
        txtbut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        		if (s1.isSelected()) {
        			batch+="--------SY-CSE-1---------\n";
        		}
        		else if (s2.isSelected()) {
        			batch+="-----------SY-CSE-2--------\n";
        		}
        		else if (s3.isSelected()) {
        			batch+="--------SY-CSE-3-----------\n";
        		}
        		else if (s4.isSelected()) {
        			batch+="--------SY-CSE-4---------\n";
        		}
        		txt(start ,total,spre ,apre,subject,batch);
        	}
        });
        txtbut.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtbut.setBounds(1126, 564, 123, 31);
        contentPane.add(txtbut);
	}
}
