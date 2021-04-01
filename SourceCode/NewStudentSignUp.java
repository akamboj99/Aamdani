import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Component;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import java.awt.Cursor;
import java.awt.Dimension;

public class NewStudentSignUp extends JFrame {

	private JPanel contentPane;
	private JTextField student_name;
	private JTextField student_phone;
	private JTextField student_email;
	private JTextField student_specialization;
	private JPasswordField student_password;
	private JPasswordField student_confirm_password;
	private JTextField student_year;
	private JTextField student_sapid;
	private JComboBox student_degree;
	private JComboBox student_course;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewStudentSignUp frame = new NewStudentSignUp();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewStudentSignUp() {
		setTitle("Student Sign Up");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2 , size.height/2 - getHeight()/2);
		
		JTextArea txtrName = new JTextArea();
		txtrName.setForeground(Color.WHITE);
		txtrName.setBounds(108, 168, 59, 24);
		txtrName.setEditable(false);
		txtrName.setFont(new Font("Cambria", Font.BOLD, 21));
		txtrName.setBackground(Color.DARK_GRAY);
		txtrName.setText("Name");
		contentPane.add(txtrName);
		
		JTextArea txtrPhoneNo = new JTextArea();
		txtrPhoneNo.setForeground(Color.WHITE);
		txtrPhoneNo.setBounds(108, 218, 107, 24);
		txtrPhoneNo.setEditable(false);
		txtrPhoneNo.setFont(new Font("Cambria", Font.BOLD, 21));
		txtrPhoneNo.setBackground(Color.DARK_GRAY);
		txtrPhoneNo.setText("Phone No.");
		contentPane.add(txtrPhoneNo);
		
		JTextArea txtrEmail = new JTextArea();
		txtrEmail.setForeground(Color.WHITE);
		txtrEmail.setBounds(108, 268, 59, 24);
		txtrEmail.setEditable(false);
		txtrEmail.setFont(new Font("Cambria", Font.BOLD, 21));
		txtrEmail.setBackground(Color.DARK_GRAY);
		txtrEmail.setText("Email");
		contentPane.add(txtrEmail);
		
		JTextArea txtrSetPassword = new JTextArea();
		txtrSetPassword.setForeground(Color.WHITE);
		txtrSetPassword.setBounds(108, 318, 133, 24);
		txtrSetPassword.setEditable(false);
		txtrSetPassword.setFont(new Font("Cambria", Font.BOLD, 21));
		txtrSetPassword.setBackground(Color.DARK_GRAY);
		txtrSetPassword.setText("Set Password");
		contentPane.add(txtrSetPassword);
		
		JTextArea txtrShopName = new JTextArea();
		txtrShopName.setForeground(Color.WHITE);
		txtrShopName.setBounds(108, 568, 86, 24);
		txtrShopName.setEditable(false);
		txtrShopName.setFont(new Font("Cambria", Font.BOLD, 21));
		txtrShopName.setBackground(Color.DARK_GRAY);
		txtrShopName.setText("SAP ID");
		contentPane.add(txtrShopName);
		
		JTextArea txtrAddress = new JTextArea();
		txtrAddress.setForeground(Color.WHITE);
		txtrAddress.setBounds(108, 418, 86, 24);
		txtrAddress.setEditable(false);
		txtrAddress.setFont(new Font("Cambria", Font.BOLD, 21));
		txtrAddress.setBackground(Color.DARK_GRAY);
		txtrAddress.setText("Course");
		contentPane.add(txtrAddress);
		
		JTextArea txtrDistanceFromUpes = new JTextArea();
		txtrDistanceFromUpes.setForeground(Color.WHITE);
		txtrDistanceFromUpes.setBounds(108, 368, 186, 24);
		txtrDistanceFromUpes.setEditable(false);
		txtrDistanceFromUpes.setFont(new Font("Cambria", Font.BOLD, 21));
		txtrDistanceFromUpes.setBackground(Color.DARK_GRAY);
		txtrDistanceFromUpes.setText("Confirm Password");
		contentPane.add(txtrDistanceFromUpes);
		
		student_name = new JTextField();
		student_name.setForeground(Color.DARK_GRAY);
		student_name.setAutoscrolls(false);
		student_name.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		student_name.setBounds(341, 165, 211, 28);
		student_name.setFont(new Font("Calibri", Font.BOLD, 18));
		contentPane.add(student_name);
		student_name.setColumns(10);
		
		student_phone = new JTextField();
		student_phone.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) 
				{
					e.consume();
				}
			}
		});
		student_phone.setForeground(Color.DARK_GRAY);
		student_phone.setFont(new Font("Calibri", Font.BOLD, 18));
		student_phone.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		student_phone.setBounds(341, 215, 211, 28);
		student_phone.setColumns(10);
		contentPane.add(student_phone);
		
		student_email = new JTextField();
		student_email.setForeground(Color.DARK_GRAY);
		student_email.setFont(new Font("Calibri", Font.BOLD, 18));
		student_email.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		student_email.setBounds(341, 265, 211, 28);
		student_email.setColumns(10);
		contentPane.add(student_email);
		
		student_specialization = new JTextField();
		student_specialization.setForeground(Color.DARK_GRAY);
		student_specialization.setFont(new Font("Calibri", Font.BOLD, 18));
		student_specialization.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		student_specialization.setBounds(341, 465, 211, 28);
		student_specialization.setColumns(10);
		contentPane.add(student_specialization);
	  
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBounds(645, 485, 232, 50);
		btnNewButton.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent arg0) 
			{
				String stuName = student_name.getText();
                String stuPhone = student_phone.getText();
                String stuEmail = student_email.getText();
                String stuPswd = student_password.getText();
                String stuConfirmpswd = student_confirm_password.getText();
                String stuDegree = (String)student_degree.getSelectedItem();
                String stuCourse = (String)student_course.getSelectedItem();
                String stuSpecialization = student_specialization.getText();
                String stuYear = student_year.getText();
                String stuSapid = student_sapid.getText();
                int len = stuPhone.length();

                String msg = "" + stuName;
                msg += " \n";
                if (len != 10) 
                {
                    JOptionPane.showMessageDialog(null, new JLabel("Enter a valid phone number !", JLabel.CENTER), "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                else if (stuName.length()==0||stuPhone.length()==0||stuEmail.length()==0||stuPswd.length()==0||stuConfirmpswd.length()==0||stuDegree.length()==0||stuCourse.length()==0||stuYear.length()==0||stuSapid.length()==0) 
                {
                    JOptionPane.showMessageDialog(null, new JLabel("Please fill out all the fields.", JLabel.CENTER), "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                else if (stuPswd.compareTo(stuConfirmpswd)!=0) 
                {
                    JOptionPane.showMessageDialog(null, new JLabel("Password did not match with the confirmed password !", JLabel.CENTER), "Error", JOptionPane.ERROR_MESSAGE);
                }

                else
                {
                	try {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aamdani", "root", "root");

                        String query1 = "SELECT * FROM student_sign_up where student_email ='" + stuEmail + "'";
                        String query3 = "SELECT * FROM shopkeeper_sign_up where shopkeeper_email ='" + stuEmail + "'";
                        
                        String query2 = "INSERT INTO Student_Sign_Up values('" + stuName + "','" + stuPhone + "','" + stuEmail + "','" +
                        		stuPswd + "','" + stuConfirmpswd + "','" + stuSpecialization + "','" + stuYear + "','" + stuSapid + "','" + stuDegree + "','" + stuCourse + "')";

                        Statement sta = connection.createStatement();
                        Statement sta2 = connection.createStatement();
                        
                        ResultSet rs = sta.executeQuery(query1);
                        ResultSet rs2 = sta2.executeQuery(query3);
                        
                        if(rs.next()==false&&rs2.next()==false)
                        {
                        	int x = sta.executeUpdate(query2);
                            if (x != 0) 
                            {
                            	JOptionPane.showMessageDialog(null, new JLabel("Welcome, " + msg + "Your account is sucessfully created.", JLabel.CENTER), "Success", JOptionPane.PLAIN_MESSAGE);
                                connection.close();
                                
                                dispose();
                				FindJobButtonClicked pjbc = new FindJobButtonClicked();
                				pjbc.setVisible(true);
                            } 
                        }
                        else
                        {
                        	JOptionPane.showMessageDialog(null, new JLabel("This email already exists !", JLabel.CENTER), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        
                    }
                        catch (Exception exception) {
                        exception.printStackTrace();
                    }
             
    				
                }
			}	
		});

		btnNewButton.setBorder(null);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 26));
		contentPane.add(btnNewButton);
		
		JTextArea txtrCreateAccount = new JTextArea();
		txtrCreateAccount.setForeground(Color.WHITE);
		txtrCreateAccount.setBounds(105, 80, 324, 42);
		txtrCreateAccount.setEditable(false);
		txtrCreateAccount.setFont(new Font("Cambria", Font.BOLD, 38));
		txtrCreateAccount.setBackground(Color.DARK_GRAY);
		txtrCreateAccount.setText("CREATE ACCOUNT");
		contentPane.add(txtrCreateAccount);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(631, 185, 256, 249);
		Image img = new ImageIcon(this.getClass().getResource("/New-Student-Large.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel);
		
		student_password = new JPasswordField();
		student_password.setForeground(Color.DARK_GRAY);
		student_password.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		student_password.setFont(new Font("Calibri", Font.BOLD, 18));
		student_password.setBounds(341, 315, 211, 28);
		contentPane.add(student_password);
		
		student_confirm_password = new JPasswordField();
		student_confirm_password.setForeground(Color.DARK_GRAY);
		student_confirm_password.setFont(new Font("Calibri", Font.BOLD, 18));
		student_confirm_password.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		student_confirm_password.setBounds(341, 365, 211, 28);
		contentPane.add(student_confirm_password);
		
		student_degree = new JComboBox();
		student_degree.setForeground(Color.DARK_GRAY);
		student_degree.setName("");
		student_degree.setMaximumRowCount(10);
		student_degree.setFont(new Font("Calibri", Font.BOLD, 16));
		student_degree.setModel(new DefaultComboBoxModel(new String[] {"B.Tech", "M.Tech", "BBA", "MBA", "BCA", "MCA", "B.SC", "M.SC", "B.DES", "M.DES", "LL.B", "LLM", "BA", "MA", "B.COM", "B.Pharma", "BJMC"}));
		student_degree.setBounds(341, 415, 76, 28);
		contentPane.add(student_degree);
		
		JTextArea txtrYearOfStudy = new JTextArea();
		txtrYearOfStudy.setForeground(Color.WHITE);
		txtrYearOfStudy.setText("Year of study");
		txtrYearOfStudy.setFont(new Font("Cambria", Font.BOLD, 21));
		txtrYearOfStudy.setEditable(false);
		txtrYearOfStudy.setBackground(Color.DARK_GRAY);
		txtrYearOfStudy.setBounds(108, 518, 140, 27);
		contentPane.add(txtrYearOfStudy);
		
		student_year = new JTextField();
		student_year.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) 
				{
					e.consume();
				}
			}
		});
		student_year.setForeground(Color.DARK_GRAY);
		student_year.setFont(new Font("Calibri", Font.BOLD, 18));
		student_year.setColumns(10);
		student_year.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		student_year.setBounds(341, 515, 211, 28);
		contentPane.add(student_year);
		
		student_course = new JComboBox();
		student_course.setForeground(Color.DARK_GRAY);
		student_course.setModel(new DefaultComboBoxModel(new String[] {"CSE", "Chemical", "Design", "Upstream"}));
		student_course.setName("");
		student_course.setMaximumRowCount(10);
		student_course.setFont(new Font("Calibri", Font.BOLD, 16));
		student_course.setBounds(427, 415, 125, 28);
		contentPane.add(student_course);
		
		JTextArea txtrSpecialization = new JTextArea();
		txtrSpecialization.setForeground(Color.WHITE);
		txtrSpecialization.setText("Specialization (if any)");
		txtrSpecialization.setFont(new Font("Cambria", Font.BOLD, 21));
		txtrSpecialization.setEditable(false);
		txtrSpecialization.setBackground(Color.DARK_GRAY);
		txtrSpecialization.setBounds(108, 468, 218, 28);
		contentPane.add(txtrSpecialization);
		
		student_sapid = new JTextField();
		student_sapid.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) 
				{
					e.consume();
				}
			}
		});
		student_sapid.setForeground(Color.DARK_GRAY);
		student_sapid.setFont(new Font("Calibri", Font.BOLD, 18));
		student_sapid.setColumns(10);
		student_sapid.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		student_sapid.setBounds(341, 565, 211, 28);
		contentPane.add(student_sapid);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setToolTipText("Back");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
				FindJobButtonClicked fjbc2 = new FindJobButtonClicked();
				fjbc2.setVisible(true);
			}
		});
		Image img1 = new ImageIcon(this.getClass().getResource("/back-arrow.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(15, 15, 59, 50);
		contentPane.add(lblNewLabel_1);
	}
}
