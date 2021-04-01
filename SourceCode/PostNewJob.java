import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class PostNewJob extends JFrame {

	private JPanel contentPane;
	private JTextField txtJobTitle;
	private JTextField txtJobDescription_1;
	private JTextField txtHourlyStipend;
	private JTextField txtJobLocation_1;
	private JTextField txtApproxDistanceFrom;
	private JTextField txtJobTimings_1;
	private JTextField txtFrom_1;
	private JTextField txtTo_1;
	private JTextField Job_Stipend_Entered;
	private JTextField Job_Location_Entered;
	private JTextField Job_Description_Entered;
	private JTextField Job_Title_Entered;
	private JTextField Job_Distance_Entered;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JComboBox Job_Timing_From_Entered;
	private JComboBox Job_Timing_To_Entered;
	
	String contact_entered;
	
	//private ButtonGroup checkBoxGroup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostNewJob frame = new PostNewJob();
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
	public PostNewJob() {
		setResizable(false);
		setTitle("Post New Job");
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
		
		txtJobTitle = new JTextField();
		txtJobTitle.setBorder(null);
		txtJobTitle.setBackground(Color.DARK_GRAY);
		txtJobTitle.setForeground(Color.WHITE);
		txtJobTitle.setFont(new Font("Cambria", Font.BOLD, 20));
		txtJobTitle.setEditable(false);
		txtJobTitle.setText("Job Title");
		txtJobTitle.setBounds(406, 105, 83, 28);
		contentPane.add(txtJobTitle);
		txtJobTitle.setColumns(10);
		
		txtJobDescription_1 = new JTextField();
		txtJobDescription_1.setText("Job Description");
		txtJobDescription_1.setForeground(Color.WHITE);
		txtJobDescription_1.setFont(new Font("Cambria", Font.BOLD, 20));
		txtJobDescription_1.setEditable(false);
		txtJobDescription_1.setColumns(10);
		txtJobDescription_1.setBorder(null);
		txtJobDescription_1.setBackground(Color.DARK_GRAY);
		txtJobDescription_1.setBounds(406, 165, 152, 28);
		contentPane.add(txtJobDescription_1);
		
		txtHourlyStipend = new JTextField();
		txtHourlyStipend.setText("Hourly Stipend (INR)");
		txtHourlyStipend.setForeground(Color.WHITE);
		txtHourlyStipend.setFont(new Font("Cambria", Font.BOLD, 20));
		txtHourlyStipend.setEditable(false);
		txtHourlyStipend.setColumns(10);
		txtHourlyStipend.setBorder(null);
		txtHourlyStipend.setBackground(Color.DARK_GRAY);
		txtHourlyStipend.setBounds(406, 285, 196, 28);
		contentPane.add(txtHourlyStipend);
		
		txtJobLocation_1 = new JTextField();
		txtJobLocation_1.setText("Job Location");
		txtJobLocation_1.setForeground(Color.WHITE);
		txtJobLocation_1.setFont(new Font("Cambria", Font.BOLD, 20));
		txtJobLocation_1.setEditable(false);
		txtJobLocation_1.setColumns(10);
		txtJobLocation_1.setBorder(null);
		txtJobLocation_1.setBackground(Color.DARK_GRAY);
		txtJobLocation_1.setBounds(406, 225, 119, 28);
		contentPane.add(txtJobLocation_1);
		
		txtApproxDistanceFrom = new JTextField();
		txtApproxDistanceFrom.setText("Approx. distance from UPES (KM)");
		txtApproxDistanceFrom.setForeground(Color.WHITE);
		txtApproxDistanceFrom.setFont(new Font("Cambria", Font.BOLD, 20));
		txtApproxDistanceFrom.setEditable(false);
		txtApproxDistanceFrom.setColumns(10);
		txtApproxDistanceFrom.setBorder(null);
		txtApproxDistanceFrom.setBackground(Color.DARK_GRAY);
		txtApproxDistanceFrom.setBounds(406, 345, 309, 28);
		contentPane.add(txtApproxDistanceFrom);
		
		txtJobTimings_1 = new JTextField();
		txtJobTimings_1.setText("Job Timings :");
		txtJobTimings_1.setForeground(Color.WHITE);
		txtJobTimings_1.setFont(new Font("Cambria", Font.BOLD, 20));
		txtJobTimings_1.setEditable(false);
		txtJobTimings_1.setColumns(10);
		txtJobTimings_1.setBorder(null);
		txtJobTimings_1.setBackground(Color.DARK_GRAY);
		txtJobTimings_1.setBounds(406, 405, 129, 28);
		contentPane.add(txtJobTimings_1);
		
		txtFrom_1 = new JTextField();
		txtFrom_1.setText("From :");
		txtFrom_1.setForeground(Color.WHITE);
		txtFrom_1.setFont(new Font("Cambria", Font.BOLD, 20));
		txtFrom_1.setEditable(false);
		txtFrom_1.setColumns(10);
		txtFrom_1.setBorder(null);
		txtFrom_1.setBackground(Color.DARK_GRAY);
		txtFrom_1.setBounds(576, 405, 65, 28);
		contentPane.add(txtFrom_1);
		
		txtTo_1 = new JTextField();
		txtTo_1.setText("To :");
		txtTo_1.setForeground(Color.WHITE);
		txtTo_1.setFont(new Font("Cambria", Font.BOLD, 20));
		txtTo_1.setEditable(false);
		txtTo_1.setColumns(10);
		txtTo_1.setBorder(null);
		txtTo_1.setBackground(Color.DARK_GRAY);
		txtTo_1.setBounds(777, 405, 39, 28);
		contentPane.add(txtTo_1);
		
		final ButtonGroup bg = new ButtonGroup();
		
		JButton btnNewButton = new JButton("Post  Job");
		btnNewButton.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				String ShopkeeperEmail = PostJobButtonClicked.shopkeeper_email_entered.getText();
				String JobTitle = Job_Title_Entered.getText();
                String JobDescription = Job_Description_Entered.getText();
                String JobLocation = Job_Location_Entered.getText();
                String JobStipend = Job_Stipend_Entered.getText();
                String JobDistance = Job_Distance_Entered.getText();
                String JobTimingsFrom = (String)Job_Timing_From_Entered.getSelectedItem();
                String JobTimingsTo = (String)Job_Timing_To_Entered.getSelectedItem();
                
                
                if (JobTitle.length()==0||JobDescription.length()==0||JobLocation.length()==0||JobStipend.length()==0||JobDistance.length()==0) 
                {
                    JOptionPane.showMessageDialog(null, "Please fill out all the fields.");
                }

                else
                {
                	try 
                	{
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aamdani", "root", "root");
                        
                        Statement sta = connection.createStatement();
                        
                        String query1 = "SELECT * FROM jobs_posted where Email_Address ='" + ShopkeeperEmail +"'";
                        ResultSet rs = sta.executeQuery(query1);
                        int count1 = 1;
                        if(rs.next()==false)
                        {
                        	count1 = 1;
                        }
                        else
                        {
                        	//count1 = rs.getInt(1) + 1;
                        	do
                        	{
                        		count1++;
                        	}while(rs.next()!=false);
                        }
                        
                        String query2 = "INSERT INTO jobs_posted values('" + count1 + "','" + ShopkeeperEmail + "','" + JobTitle + "','" + JobDescription + "','" +
                        		JobLocation + "','" + JobDistance + "','" + JobStipend + "','" + JobTimingsFrom + "','" + JobTimingsTo + "')";
                        
                        sta.executeUpdate(query2);
                        
                        connection.close();
                        
                    }
                        catch (Exception exception) 
                	{
                        exception.printStackTrace();
                    }
             
    				dispose();
    				ShopkeeperDashboard sd4 = new ShopkeeperDashboard();
    				sd4.setVisible(true);
                }
				
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 28));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBounds(576, 525, 190, 53);
		contentPane.add(btnNewButton);
		
		Job_Stipend_Entered = new JTextField();
		Job_Stipend_Entered.setCaretColor(Color.DARK_GRAY);
		Job_Stipend_Entered.addKeyListener(new KeyAdapter() 
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
		Job_Stipend_Entered.setFont(new Font("Cambria", Font.BOLD, 16));
		Job_Stipend_Entered.setColumns(10);
		Job_Stipend_Entered.setBounds(624, 285, 283, 28);
		contentPane.add(Job_Stipend_Entered);
		
		Job_Location_Entered = new JTextField();
		Job_Location_Entered.setCaretColor(Color.DARK_GRAY);
		Job_Location_Entered.setFont(new Font("Cambria", Font.BOLD, 16));
		Job_Location_Entered.setColumns(10);
		Job_Location_Entered.setBounds(624, 225, 283, 28);
		contentPane.add(Job_Location_Entered);
		
		Job_Description_Entered = new JTextField();
		Job_Description_Entered.setCaretColor(Color.DARK_GRAY);
		Job_Description_Entered.setFont(new Font("Cambria", Font.BOLD, 16));
		Job_Description_Entered.setColumns(10);
		Job_Description_Entered.setBounds(624, 165, 283, 28);
		contentPane.add(Job_Description_Entered);
		
		Job_Title_Entered = new JTextField();
		Job_Title_Entered.setCaretColor(Color.DARK_GRAY);
		Job_Title_Entered.setFont(new Font("Cambria", Font.BOLD, 16));
		Job_Title_Entered.setColumns(10);
		Job_Title_Entered.setBounds(624, 105, 283, 28);
		contentPane.add(Job_Title_Entered);
		
		Job_Distance_Entered = new JTextField();
		Job_Distance_Entered.setCaretColor(Color.DARK_GRAY);
		Job_Distance_Entered.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent evt) 
			{
				char c = evt.getKeyChar();
				if(!Character.isDigit(c)) 
				{
					evt.consume();
				}
			}
		});
		Job_Distance_Entered.setFont(new Font("Cambria", Font.BOLD, 16));
		Job_Distance_Entered.setColumns(10);
		Job_Distance_Entered.setBounds(736, 345, 171, 28);
		contentPane.add(Job_Distance_Entered);
		
		Job_Timing_From_Entered = new JComboBox();
		Job_Timing_From_Entered.setModel(new DefaultComboBoxModel(new String[] {"00 : 00", "01 : 00", "02 : 00", "03 : 00", "04 : 00", "05 : 00", "06 : 00", "07 : 00", "08 : 00", "09 : 00", "10 : 00", "11 : 00", "12 : 00", "13 : 00", "14 : 00", "15 : 00", "16 : 00", "17 : 00", "18 : 00", "19 : 00", "20 : 00", "21 : 00", "22 : 00", "23 : 00", "24 : 00"}));
		Job_Timing_From_Entered.setMaximumRowCount(24);
		Job_Timing_From_Entered.setFont(new Font("Cambria", Font.PLAIN, 15));
		Job_Timing_From_Entered.setBounds(655, 406, 73, 28);
		contentPane.add(Job_Timing_From_Entered);
		
		Job_Timing_To_Entered = new JComboBox();
		Job_Timing_To_Entered.setModel(new DefaultComboBoxModel(new String[] {"00 : 00", "01 : 00", "02 : 00", "03 : 00", "04 : 00", "05 : 00", "06 : 00", "07 : 00", "08 : 00", "09 : 00", "10 : 00", "11 : 00", "12 : 00", "13 : 00", "14 : 00", "15 : 00", "16 : 00", "17 : 00", "18 : 00", "19 : 00", "20 : 00", "21 : 00", "22 : 00", "23 : 00", "24 : 00"}));
		Job_Timing_To_Entered.setSelectedIndex(24);
		Job_Timing_To_Entered.setMaximumRowCount(24);
		Job_Timing_To_Entered.setFont(new Font("Cambria", Font.PLAIN, 15));
		Job_Timing_To_Entered.setBounds(834, 406, 73, 28);
		contentPane.add(Job_Timing_To_Entered);
		
		lblNewLabel = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/postjob2.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		lblNewLabel.setBounds(58, 345, 286, 201);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/postjobfirst.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img2));
		lblNewLabel_1.setBounds(58, 118, 286, 201);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setToolTipText("Logout");
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
				PostJobButtonClicked pjbc3 = new PostJobButtonClicked();
				pjbc3.setVisible(true);
			}
		});
		Image img3 = new ImageIcon(this.getClass().getResource("/logout.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img3));
		lblNewLabel_2.setBounds(925, 15, 48, 55);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setToolTipText("Back");
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
				ShopkeeperDashboard sd2 = new ShopkeeperDashboard();
				sd2.setVisible(true);
			}
		});
		Image img4 = new ImageIcon(this.getClass().getResource("/back-arrow.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img4));
		lblNewLabel_3.setBounds(15, 15, 48, 55);
		contentPane.add(lblNewLabel_3);
		
	}
}
