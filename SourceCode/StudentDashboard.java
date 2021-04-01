import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;


import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import java.sql.Timestamp;  

public class StudentDashboard extends JFrame {

	private JPanel contentPane;
	private JTextField MaxDistanceEntered;
	private JTextField txtKms;
	private JTextField txtStart;
	private JTextField txtEnd;
	private JComboBox StartTimeEntered,EndTimeEntered;
	private JTextField txtMin;
	private JTextField txtMax;
	private JTextField txtInr;
	private JTextField textField_1;
	private JTextField MinStipendEntered;
	private JTextField MaxStipendEntered;
	private JButton btnViewDescription;
	private JButton btnApplyForJob;
	private JScrollPane scrollPane;
	private JTable table;
	private JScrollPane scrollPane_1;
	
	static String SelectedRowTitle,SelectedRowLocation,SelectedRowStipend,SelectedRowDistance,SelectedRowStart,SelectedRowEnd,SelectedRowContact;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDashboard frame = new StudentDashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public String getDynamicName()
	{
		String DynamicName = null;
		String getEmail = FindJobButtonClicked.student_email_entered.getText();
		
        try 
        {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aamdani", "root", "root");
               
            String query = "SELECT student_name FROM student_sign_up WHERE student_email='"+getEmail+"'";

            Statement sta = connection.createStatement();
            ResultSet rs = sta.executeQuery(query);
            while (rs.next())
            {
            	DynamicName = rs.getString(1);
            }
            connection.close();
        }
        catch (Exception exception) 
        {
            exception.printStackTrace();
        }
		return DynamicName;
	}
	
	
	public void displayTable()
	{
		
		try 
        {
			int update_md = 0;
			if(MaxDistanceEntered.getText()==null)
			{
				update_md = 99;
			}
			else
			{
				update_md = Integer.valueOf(MaxDistanceEntered.getText());
			}
			
			
			int update_mins = 0;
			if(MinStipendEntered.getText()==null)
			{
				update_mins = 0;
			}
			else
			{
				update_mins = Integer.valueOf(MinStipendEntered.getText());
			}
			
			int update_maxs = 0;
			if(MaxStipendEntered.getText()==null)
			{
				update_maxs = 9999;
			}
			else
			{
				update_maxs = Integer.valueOf(MaxStipendEntered.getText());
			}
			
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aamdani", "root", "root");
               
            String query2 = "SELECT Title,Location,Distance_From_UPES_In_KMs,Hourly_Stipend_INR,Start_Time,End_Time FROM jobs_posted WHERE Distance_From_UPES_In_KMs<='"+update_md+"' and (Hourly_Stipend_INR>='"+update_mins+"') and (Hourly_Stipend_INR<='"+update_maxs+"') and (Start_Time>='"+StartTimeEntered.getSelectedItem()+"') and (End_Time<='"+EndTimeEntered.getSelectedItem()+"')";

            Statement sta = connection.createStatement();
            ResultSet rs2 = sta.executeQuery(query2);
            
            table.setModel(DbUtils.resultSetToTableModel(rs2));
            
            connection.close();
            
            
            
            TableColumn col1 = table.getColumnModel().getColumn(0);
    	    col1.setPreferredWidth(150);
    	    TableColumn col2 = table.getColumnModel().getColumn(1);
    	    col2.setPreferredWidth(210);
    	    TableColumn col3 = table.getColumnModel().getColumn(2);
    	    col3.setPreferredWidth(265);
    	    TableColumn col4 = table.getColumnModel().getColumn(3);
    	    col4.setPreferredWidth(190);
    	    TableColumn col5 = table.getColumnModel().getColumn(4);
    	    col5.setPreferredWidth(110);
    	    TableColumn col6 = table.getColumnModel().getColumn(5);
    	    col6.setPreferredWidth(110);
            
        }
        catch (Exception exception) 
        {
            exception.printStackTrace();
        }
	}
	

	/**
	 * Create the frame.
	 */
	public StudentDashboard() 
	{
		setResizable(false);
		setTitle("Student Dashboard");
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
		
		JTextArea txtrHelloDeepak = new JTextArea();
		txtrHelloDeepak.setEditable(false);
		txtrHelloDeepak.setForeground(Color.WHITE);
		txtrHelloDeepak.setFont(new Font("Cambria", Font.BOLD, 25));
		txtrHelloDeepak.setBackground(Color.DARK_GRAY);
		txtrHelloDeepak.setText("Hello "+getDynamicName());
		txtrHelloDeepak.setBounds(70, 45, 387, 34);
		contentPane.add(txtrHelloDeepak);
		
		JTextArea txtrThisIsYour = new JTextArea();
		txtrThisIsYour.setEditable(false);
		txtrThisIsYour.setForeground(Color.WHITE);
		txtrThisIsYour.setFont(new Font("Cambria", Font.BOLD, 25));
		txtrThisIsYour.setBackground(Color.DARK_GRAY);
		txtrThisIsYour.setText("Welcome to your Aamdani Dashboard.");
		txtrThisIsYour.setBounds(70, 85, 448, 34);
		contentPane.add(txtrThisIsYour);
		
		JTextArea txtrGoAhead = new JTextArea();
		txtrGoAhead.setEditable(false);
		txtrGoAhead.setForeground(Color.WHITE);
		txtrGoAhead.setFont(new Font("Cambria", Font.BOLD, 25));
		txtrGoAhead.setBackground(Color.DARK_GRAY);
		txtrGoAhead.setText("Go ahead and find jobs suitable for you.");
		txtrGoAhead.setBounds(70, 125, 457, 34);
		contentPane.add(txtrGoAhead);
		
		JTextArea txtrMaxDistanceFrom = new JTextArea();
		txtrMaxDistanceFrom.setText("Max. distance from UPES");
		txtrMaxDistanceFrom.setForeground(Color.WHITE);
		txtrMaxDistanceFrom.setFont(new Font("Cambria", Font.BOLD, 18));
		txtrMaxDistanceFrom.setEditable(false);
		txtrMaxDistanceFrom.setBackground(Color.DARK_GRAY);
		txtrMaxDistanceFrom.setBounds(70, 210, 208, 30);
		contentPane.add(txtrMaxDistanceFrom);
		
		JTextArea txtrJobTimings = new JTextArea();
		txtrJobTimings.setText("Job Timings");
		txtrJobTimings.setForeground(Color.WHITE);
		txtrJobTimings.setFont(new Font("Cambria", Font.BOLD, 18));
		txtrJobTimings.setEditable(false);
		txtrJobTimings.setBackground(Color.DARK_GRAY);
		txtrJobTimings.setBounds(350, 210, 104, 30);
		contentPane.add(txtrJobTimings);
		
		JTextArea txtrHorlyStipend = new JTextArea();
		txtrHorlyStipend.setText("Hourly Stipend");
		txtrHorlyStipend.setForeground(Color.WHITE);
		txtrHorlyStipend.setFont(new Font("Cambria", Font.BOLD, 18));
		txtrHorlyStipend.setEditable(false);
		txtrHorlyStipend.setBackground(Color.DARK_GRAY);
		txtrHorlyStipend.setBounds(550, 210, 132, 30);
		contentPane.add(txtrHorlyStipend);
		
		JButton btnNewButton = new JButton("Apply Filters");
		btnNewButton.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				displayTable();
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 20));
		btnNewButton.setBounds(755, 235, 163, 41);
		contentPane.add(btnNewButton);
		
		MaxDistanceEntered = new JTextField();
		MaxDistanceEntered.addKeyListener(new KeyAdapter() 
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
		MaxDistanceEntered.setFont(new Font("Cambria", Font.BOLD, 17));
		MaxDistanceEntered.setText("99");
		MaxDistanceEntered.setHorizontalAlignment(SwingConstants.CENTER);
		MaxDistanceEntered.setBounds(75, 250, 63, 24);
		contentPane.add(MaxDistanceEntered);
		MaxDistanceEntered.setColumns(10);
		
		txtKms = new JTextField();
		txtKms.setBorder(null);
		txtKms.setFont(new Font("Cambria", Font.BOLD, 17));
		txtKms.setForeground(Color.WHITE);
		txtKms.setBackground(Color.DARK_GRAY);
		txtKms.setText("km");
		txtKms.setColumns(10);
		txtKms.setBounds(150, 251, 28, 20);
		contentPane.add(txtKms);
		
		txtStart = new JTextField();
		txtStart.setText("Start");
		txtStart.setForeground(Color.WHITE);
		txtStart.setFont(new Font("Cambria", Font.BOLD, 17));
		txtStart.setColumns(10);
		txtStart.setBorder(null);
		txtStart.setBackground(Color.DARK_GRAY);
		txtStart.setBounds(348, 248, 43, 20);
		contentPane.add(txtStart);
		
		txtEnd = new JTextField();
		txtEnd.setText("End");
		txtEnd.setForeground(Color.WHITE);
		txtEnd.setFont(new Font("Cambria", Font.BOLD, 17));
		txtEnd.setColumns(10);
		txtEnd.setBorder(null);
		txtEnd.setBackground(Color.DARK_GRAY);
		txtEnd.setBounds(348, 280, 43, 20);
		contentPane.add(txtEnd);
		
		StartTimeEntered = new JComboBox();
		StartTimeEntered.setModel(new DefaultComboBoxModel(new String[] {"00 : 00", "02 : 00", "03 : 00", "04 : 00", "05 : 00", "06 : 00", "07 : 00", "08 : 00", "09 : 00", "10 : 00", "11 : 00", "12 : 00", "13 : 00", "14 : 00", "15 : 00", "16 : 00", "17 : 00", "18 : 00", "19 : 00", "20 : 00", "21 : 00", "22 : 00", "23 : 00", "24 : 00"}));
		StartTimeEntered.setMaximumRowCount(24);
		StartTimeEntered.setFont(new Font("Cambria", Font.PLAIN, 13));
		StartTimeEntered.setBounds(395, 249, 63, 20);
		contentPane.add(StartTimeEntered);
		
		EndTimeEntered = new JComboBox();
		EndTimeEntered.setModel(new DefaultComboBoxModel(new String[] {"00 : 00", "02 : 00", "03 : 00", "04 : 00", "05 : 00", "06 : 00", "07 : 00", "08 : 00", "09 : 00", "10 : 00", "11 : 00", "12 : 00", "13 : 00", "14 : 00", "15 : 00", "16 : 00", "17 : 00", "18 : 00", "19 : 00", "20 : 00", "21 : 00", "22 : 00", "23 : 00", "24 : 00"}));
		EndTimeEntered.setSelectedIndex(23);
		EndTimeEntered.setMaximumRowCount(24);
		EndTimeEntered.setFont(new Font("Cambria", Font.PLAIN, 13));
		EndTimeEntered.setBounds(395, 280, 63, 20);
		contentPane.add(EndTimeEntered);
		
		txtMin = new JTextField();
		txtMin.setText("Min");
		txtMin.setForeground(Color.WHITE);
		txtMin.setFont(new Font("Cambria", Font.BOLD, 17));
		txtMin.setColumns(10);
		txtMin.setBorder(null);
		txtMin.setBackground(Color.DARK_GRAY);
		txtMin.setBounds(550, 248, 36, 20);
		contentPane.add(txtMin);
		
		txtMax = new JTextField();
		txtMax.setText("Max");
		txtMax.setForeground(Color.WHITE);
		txtMax.setFont(new Font("Cambria", Font.BOLD, 17));
		txtMax.setColumns(10);
		txtMax.setBorder(null);
		txtMax.setBackground(Color.DARK_GRAY);
		txtMax.setBounds(550, 280, 36, 20);
		contentPane.add(txtMax);
		
		txtInr = new JTextField();
		txtInr.setText("INR");
		txtInr.setForeground(Color.WHITE);
		txtInr.setFont(new Font("Cambria", Font.BOLD, 17));
		txtInr.setColumns(10);
		txtInr.setBorder(null);
		txtInr.setBackground(Color.DARK_GRAY);
		txtInr.setBounds(654, 248, 36, 20);
		contentPane.add(txtInr);
		
		textField_1 = new JTextField();
		textField_1.setText("INR");
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Cambria", Font.BOLD, 17));
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(Color.DARK_GRAY);
		textField_1.setBounds(654, 280, 36, 20);
		contentPane.add(textField_1);
		
		MinStipendEntered = new JTextField();
		MinStipendEntered.setText("0");
		MinStipendEntered.addKeyListener(new KeyAdapter() 
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
		MinStipendEntered.setHorizontalAlignment(SwingConstants.CENTER);
		MinStipendEntered.setFont(new Font("Cambria", Font.BOLD, 13));
		MinStipendEntered.setBounds(587, 248, 58, 20);
		contentPane.add(MinStipendEntered);
		MinStipendEntered.setColumns(10);
		
		MaxStipendEntered = new JTextField();
		MaxStipendEntered.setText("9999");
		MaxStipendEntered.addKeyListener(new KeyAdapter() 
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
		MaxStipendEntered.setHorizontalAlignment(SwingConstants.CENTER);
		MaxStipendEntered.setFont(new Font("Cambria", Font.BOLD, 13));
		MaxStipendEntered.setColumns(10);
		MaxStipendEntered.setBounds(587, 280, 58, 20);
		contentPane.add(MaxStipendEntered);
		
		btnViewDescription = new JButton("View Description");
		btnViewDescription.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(SelectedRowTitle==null)
				{
					JOptionPane.showMessageDialog(null, new JLabel("Please select a job to view it's description !", JLabel.CENTER), "No job selected", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					try 
	            	{
	                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aamdani", "root", "root");
	                    
	                    Statement sta = connection.createStatement();
	                    
	                    String query1 = "SELECT Decription FROM jobs_posted where Title ='"+SelectedRowTitle+"' and Location ='"+SelectedRowLocation+"' and Distance_From_UPES_In_KMs ='"+SelectedRowDistance+"' and Hourly_Stipend_INR ='"+SelectedRowStipend+"' and Start_Time ='"+SelectedRowStart+"' and End_Time ='"+SelectedRowEnd+"'";
	                    
	                    ResultSet rs = sta.executeQuery(query1);
	                    
	                    rs.next();
	                    
	                    JOptionPane.showMessageDialog(null, new JLabel(rs.getString(1), JLabel.CENTER), "Job Description", JOptionPane.PLAIN_MESSAGE);
	                    
	                    connection.close();
	                    
	                }
	                    catch (Exception exception) 
	            	{
	                    exception.printStackTrace();
	                }
				}
			}
		});
		btnViewDescription.setForeground(Color.WHITE);
		btnViewDescription.setFont(new Font("Cambria", Font.BOLD, 20));
		btnViewDescription.setBorder(null);
		btnViewDescription.setBackground(new Color(65, 105, 225));
		btnViewDescription.setBounds(75, 574, 176, 41);
		contentPane.add(btnViewDescription);
		
		btnApplyForJob = new JButton("Apply for Job");
		btnApplyForJob.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(SelectedRowTitle==null)
				{
					JOptionPane.showMessageDialog(null, new JLabel("Please select a job you want to apply for !", JLabel.CENTER), "No job selected", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					try
					{
	                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aamdani", "root", "root");
	                    
	                    Statement sta = connection.createStatement();
	                    
	                    String showContact = null;
	                    String foundShopEmail = null;
	                    
	           
	                    	String query2 = "SELECT Email_Address FROM jobs_posted where Title ='"+SelectedRowTitle+"' and Location ='"+SelectedRowLocation+"' and Distance_From_UPES_In_KMs ='"+SelectedRowDistance+"' and Hourly_Stipend_INR ='"+SelectedRowStipend+"' and Start_Time ='"+SelectedRowStart+"' and End_Time ='"+SelectedRowEnd+"'";
	                    
	                    	Statement sta2 = connection.createStatement();
	                    	ResultSet rs2 = sta2.executeQuery(query2);
	                        
	                        rs2.next();
	                        
	                        foundShopEmail = rs2.getString(1);
	                        
	                        String query3 = "SELECT shopkeeper_phone FROM shopkeeper_sign_up where shopkeeper_email ='"+foundShopEmail+"'";
	                        
	                    	Statement sta3 = connection.createStatement();
	                    	ResultSet rs3 = sta3.executeQuery(query3);
	                        
	                        rs3.next();
	                        
	                        showContact = rs3.getString(1);
	                    
	                    JOptionPane.showMessageDialog(null, new JLabel("Contact employer at : "+showContact, JLabel.CENTER), "Apply for job", JOptionPane.PLAIN_MESSAGE);
	                    
	                    connection.close();
	                    
	                }
	                    catch (Exception exception) 
	            	{
	                    exception.printStackTrace();
	                }
				}
			}
		});
		btnApplyForJob.setForeground(Color.WHITE);
		btnApplyForJob.setFont(new Font("Cambria", Font.BOLD, 20));
		btnApplyForJob.setBorder(null);
		btnApplyForJob.setBackground(new Color(65, 105, 225));
		btnApplyForJob.setBounds(755, 574, 163, 41);
		contentPane.add(btnApplyForJob);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setToolTipText("Logout");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
				FindJobButtonClicked fjbc3 = new FindJobButtonClicked();
				fjbc3.setVisible(true);
			}
		});
		Image img1 = new ImageIcon(this.getClass().getResource("/logout.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		lblNewLabel.setBounds(920, 15, 48, 55);
		contentPane.add(lblNewLabel);
		
		scrollPane_1 = new JScrollPane();
		
		scrollPane_1.setBackground(Color.DARK_GRAY);
		scrollPane_1.setBounds(70, 325, 848, 220);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setBackground(Color.white);
		
		DefaultTableCellRenderer r=new DefaultTableCellRenderer();
	    r.setHorizontalAlignment(JLabel.CENTER);
	    table.setDefaultRenderer(Object.class,r);
	    
		table.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int SelectedRowIndex = table.getSelectedRow();
				SelectedRowTitle = model.getValueAt(SelectedRowIndex, 0).toString();
				SelectedRowLocation = model.getValueAt(SelectedRowIndex, 1).toString();
				SelectedRowDistance = model.getValueAt(SelectedRowIndex, 2).toString();
				SelectedRowStipend = model.getValueAt(SelectedRowIndex, 3).toString();
				SelectedRowStart = model.getValueAt(SelectedRowIndex, 4).toString();
				SelectedRowEnd = model.getValueAt(SelectedRowIndex, 5).toString();
				
			}
		});
		table.setForeground(Color.black);
		table.setGridColor(Color.black);
		table.setRowHeight(40);
		Font headerFont1 = new Font("Cambria", Font.BOLD, 18);
	    table.setFont(headerFont1);
		table.setAutoResizeMode(0);
		
		displayTable();
		
		
		JTableHeader tableHeader = table.getTableHeader();
	    tableHeader.setBackground(Color.black);
	    tableHeader.setForeground(Color.white);
	    Font headerFont = new Font("Cambria", Font.BOLD, 18);
	    tableHeader.setFont(headerFont);
	    tableHeader.setPreferredSize(new Dimension(50,50));
	    
	    TableColumn col1 = table.getColumnModel().getColumn(0);
	    col1.setPreferredWidth(150);
	    TableColumn col2 = table.getColumnModel().getColumn(1);
	    col2.setPreferredWidth(210);
	    TableColumn col3 = table.getColumnModel().getColumn(2);
	    col3.setPreferredWidth(265);
	    TableColumn col4 = table.getColumnModel().getColumn(3);
	    col4.setPreferredWidth(190);
	    TableColumn col5 = table.getColumnModel().getColumn(4);
	    col5.setPreferredWidth(110);
	    TableColumn col6 = table.getColumnModel().getColumn(5);
	    col6.setPreferredWidth(110);
	}
}
