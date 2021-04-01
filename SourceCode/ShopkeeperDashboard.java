import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.table.TableColumn;

public class ShopkeeperDashboard extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	static String SelectedRowTitle,SelectedRowLocation,SelectedRowStipend,SelectedRowDistance,SelectedRowStart,SelectedRowEnd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopkeeperDashboard frame = new ShopkeeperDashboard();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public String getDynamicName()
	{
		String DynamicName = null;
		String getEmail = PostJobButtonClicked.shopkeeper_email_entered.getText();
		
        try 
        {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aamdani", "root", "root");
               
            String query = "SELECT shopkeeper_name FROM shopkeeper_sign_up WHERE shopkeeper_email='"+getEmail+"'";

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
		String getEmailId = PostJobButtonClicked.shopkeeper_email_entered.getText();
		
		try 
        {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aamdani", "root", "root");
               
            String query2 = "SELECT Title,Location,Distance_From_UPES_In_KMs,Hourly_Stipend_INR,Start_Time,End_Time FROM jobs_posted WHERE Email_Address='"+getEmailId+"'";

            Statement sta = connection.createStatement();
            ResultSet rs2 = sta.executeQuery(query2);
            
            table_1.setModel(DbUtils.resultSetToTableModel(rs2));
            
            connection.close();
        }
        catch (Exception exception) 
        {
            exception.printStackTrace();
        }
		
		
		TableColumn col1 = table_1.getColumnModel().getColumn(0);
	    col1.setPreferredWidth(150);
	    TableColumn col2 = table_1.getColumnModel().getColumn(1);
	    col2.setPreferredWidth(210);
	    TableColumn col3 = table_1.getColumnModel().getColumn(2);
	    col3.setPreferredWidth(265);
	    TableColumn col4 = table_1.getColumnModel().getColumn(3);
	    col4.setPreferredWidth(190);
	    TableColumn col5 = table_1.getColumnModel().getColumn(4);
	    col5.setPreferredWidth(110);
	    TableColumn col6 = table_1.getColumnModel().getColumn(5);
	    col6.setPreferredWidth(110);
		
	}

	/**
	 * Create the frame.
	 */
	public ShopkeeperDashboard() {
		setTitle("Aamdani Dashboard");
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
		
		JTextArea txtrHelloDeepak = new JTextArea();
		txtrHelloDeepak.setEditable(false);
		txtrHelloDeepak.setForeground(Color.WHITE);
		txtrHelloDeepak.setFont(new Font("Cambria", Font.BOLD, 25));
		txtrHelloDeepak.setBackground(Color.DARK_GRAY);
		txtrHelloDeepak.setText("Hello "+ getDynamicName());
		//PostJobButtonClicked.shopkeeper_email_entered.getText());
		txtrHelloDeepak.setBounds(70, 45, 387, 34);
		contentPane.add(txtrHelloDeepak);
		
		JTextArea txtrThisIsYour = new JTextArea();
		txtrThisIsYour.setEditable(false);
		txtrThisIsYour.setForeground(Color.WHITE);
		txtrThisIsYour.setFont(new Font("Cambria", Font.BOLD, 25));
		txtrThisIsYour.setBackground(Color.DARK_GRAY);
		txtrThisIsYour.setText("Welcome to your Aamdani Dashboard");
		txtrThisIsYour.setBounds(70, 85, 448, 34);
		contentPane.add(txtrThisIsYour);
		
		JTextArea txtrGoAhead = new JTextArea();
		txtrGoAhead.setEditable(false);
		txtrGoAhead.setForeground(Color.WHITE);
		txtrGoAhead.setFont(new Font("Cambria", Font.BOLD, 25));
		txtrGoAhead.setBackground(Color.DARK_GRAY);
		txtrGoAhead.setText("Go ahead!");
		txtrGoAhead.setBounds(70, 125, 118, 34);
		contentPane.add(txtrGoAhead);
		
		table = new JTable();
		table.setBounds(98, 284, 135, -61);
		table.setBackground(Color.DARK_GRAY);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setToolTipText("Logout");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
				PostJobButtonClicked pjbc3 = new PostJobButtonClicked();
				pjbc3.setVisible(true);
			}
		});
		Image img1 = new ImageIcon(this.getClass().getResource("/logout.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		lblNewLabel.setBounds(920, 15, 48, 55);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Post A New Job");
		btnNewButton.setBorder(null);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 20));
		btnNewButton.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
				PostNewJob pnj = new PostNewJob();
				pnj.setVisible(true);
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBounds(70, 200, 176, 38);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				DefaultTableModel model = (DefaultTableModel)table_1.getModel();
				int SelectedRowIndex = table_1.getSelectedRow();
			}
		});
		scrollPane.setBounds(70, 280, 847, 235);
		scrollPane.setBackground(Color.DARK_GRAY);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setBackground(Color.white);
		table_1.setForeground(Color.black);
		table_1.setGridColor(Color.black);
		table_1.setRowHeight(40);
		table_1.setAutoResizeMode(0);
		
		DefaultTableCellRenderer r=new DefaultTableCellRenderer();
	    r.setHorizontalAlignment(JLabel.CENTER);
	    table_1.setDefaultRenderer(Object.class,r);
		
		Font headerFont1 = new Font("Cambria", Font.BOLD, 18);
	    table_1.setFont(headerFont1);
	    table_1.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				DefaultTableModel model = (DefaultTableModel)table_1.getModel();
				int SelectedRowIndex = table_1.getSelectedRow();
				SelectedRowTitle = model.getValueAt(SelectedRowIndex, 0).toString();
				SelectedRowLocation = model.getValueAt(SelectedRowIndex, 1).toString();
				SelectedRowDistance = model.getValueAt(SelectedRowIndex, 2).toString();
				SelectedRowStipend = model.getValueAt(SelectedRowIndex, 3).toString();
				SelectedRowStart = model.getValueAt(SelectedRowIndex, 4).toString();
				SelectedRowEnd = model.getValueAt(SelectedRowIndex, 5).toString();
			}
		});
		displayTable();
		
		JTableHeader tableHeader = table_1.getTableHeader();
	    tableHeader.setBackground(Color.black);
	    tableHeader.setForeground(Color.white);
	    Font headerFont = new Font("Cambria", Font.BOLD, 18);
	    tableHeader.setFont(headerFont);
	    tableHeader.setPreferredSize(new Dimension(50,50));
	    
	    TableColumn col1 = table_1.getColumnModel().getColumn(0);
	    col1.setPreferredWidth(150);
	    TableColumn col2 = table_1.getColumnModel().getColumn(1);
	    col2.setPreferredWidth(210);
	    TableColumn col3 = table_1.getColumnModel().getColumn(2);
	    col3.setPreferredWidth(265);
	    TableColumn col4 = table_1.getColumnModel().getColumn(3);
	    col4.setPreferredWidth(190);
	    TableColumn col5 = table_1.getColumnModel().getColumn(4);
	    col5.setPreferredWidth(110);
	    TableColumn col6 = table_1.getColumnModel().getColumn(5);
	    col6.setPreferredWidth(110);
		
		JButton btnViewDescription = new JButton("View  Description");
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
	                    
	                    String query1 = "SELECT Decription FROM jobs_posted where Email_Address ='" + PostJobButtonClicked.shopkeeper_email_entered.getText() + "' and Title ='"+SelectedRowTitle+"' and Location ='"+SelectedRowLocation+"' and Distance_From_UPES_In_KMs ='"+SelectedRowDistance+"' and Hourly_Stipend_INR ='"+SelectedRowStipend+"' and Start_Time ='"+SelectedRowStart+"' and End_Time ='"+SelectedRowEnd+"'";
	                    
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
		btnViewDescription.setBounds(70, 560, 180, 38);
		contentPane.add(btnViewDescription);
		
		JButton btnEditJob = new JButton("Edit  Job");
		btnEditJob.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(SelectedRowTitle==null)
				{
					JOptionPane.showMessageDialog(null, new JLabel("Please select a job to edit !", JLabel.CENTER), "No job selected", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					dispose();
					EditJob ed = new EditJob();
					ed.setVisible(true);
				}
			}
		});
		btnEditJob.setForeground(Color.WHITE);
		btnEditJob.setFont(new Font("Cambria", Font.BOLD, 20));
		btnEditJob.setBorder(null);
		btnEditJob.setBackground(new Color(65, 105, 225));
		btnEditJob.setBounds(407, 560, 176, 38);
		contentPane.add(btnEditJob);
		
		JButton btnViewJobs_3 = new JButton("Delete  Job");
		btnViewJobs_3.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(SelectedRowTitle==null)
				{
					JOptionPane.showMessageDialog(null, new JLabel("Please select a job to delete !", JLabel.CENTER), "No job selected", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					try 
			        {
			        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aamdani", "root", "root");
			            String query1 = "DELETE FROM jobs_posted WHERE Email_Address='"+PostJobButtonClicked.shopkeeper_email_entered.getText()+"' and Title ='"+SelectedRowTitle+"' and Location ='"+SelectedRowLocation+"' and Distance_From_UPES_In_KMs ='"+SelectedRowDistance+"' and Hourly_Stipend_INR ='"+SelectedRowStipend+"' and Start_Time ='"+SelectedRowStart+"' and End_Time ='"+SelectedRowEnd+"'";
			            Statement sta = connection.createStatement();
			            sta.executeUpdate(query1);
			            connection.close();
			            displayTable();
			        }
			        catch (Exception exception) 
			        {
			            exception.printStackTrace();
			        }
				}
			}
		});
		btnViewJobs_3.setForeground(Color.WHITE);
		btnViewJobs_3.setFont(new Font("Cambria", Font.BOLD, 20));
		btnViewJobs_3.setBorder(null);
		btnViewJobs_3.setBackground(new Color(65, 105, 225));
		btnViewJobs_3.setBounds(741, 560, 176, 38);
		contentPane.add(btnViewJobs_3);
	}
}
