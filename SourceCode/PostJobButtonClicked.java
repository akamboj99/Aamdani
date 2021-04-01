import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JEditorPane;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;

public class PostJobButtonClicked extends JFrame {

	private JPanel contentPane;
	public static JTextField shopkeeper_email_entered;
	private JPasswordField shopkeeper_password_entered;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostJobButtonClicked frame = new PostJobButtonClicked();
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
	public PostJobButtonClicked() {
		setResizable(false);
		setTitle("Shopkeeper Sign In");
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
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				
				String emailEntered = shopkeeper_email_entered.getText();
				String pswdEntered = shopkeeper_password_entered.getText();
				
				try 
				{
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aamdani", "root", "root");

                    Statement stmt = connection.createStatement();
                    String query = "SELECT * FROM shopkeeper_sign_up where shopkeeper_email ='" + emailEntered + "' and shopkeeper_password ='" + pswdEntered + "'";
                    ResultSet rs = stmt.executeQuery(query);
                    if(rs.next()==false)
                    {
                    	JOptionPane.showMessageDialog(null, new JLabel("Incorrect email or password !", JLabel.CENTER), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                    	dispose();
        				ShopkeeperDashboard sdx = new ShopkeeperDashboard();
        				sdx.setVisible(true);
                    }
                }
				catch (Exception exception) 
				{
                    exception.printStackTrace();
                }
			}
		});
		
		
		btnNewButton.setBorder(null);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 27));
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(213, 340, 293, 45);
		contentPane.add(btnNewButton);
		
		shopkeeper_email_entered = new JTextField();
		shopkeeper_email_entered.setForeground(Color.DARK_GRAY);
		shopkeeper_email_entered.setFont(new Font("Cambria", Font.BOLD, 24));
		shopkeeper_email_entered.setBounds(213, 174, 293, 45);
		contentPane.add(shopkeeper_email_entered);
		shopkeeper_email_entered.setColumns(10);
		
		JTextArea txtrEmail = new JTextArea();
		txtrEmail.setForeground(Color.WHITE);
		txtrEmail.setEditable(false);
		txtrEmail.setFont(new Font("Cambria", Font.BOLD, 24));
		txtrEmail.setBackground(Color.DARK_GRAY);
		txtrEmail.setText("Email");
		txtrEmail.setBounds(106, 185, 64, 28);
		contentPane.add(txtrEmail);
		
		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setForeground(Color.WHITE);
		txtrPassword.setEditable(false);
		txtrPassword.setFont(new Font("Cambria", Font.BOLD, 24));
		txtrPassword.setBackground(Color.DARK_GRAY);
		txtrPassword.setText("Password");
		txtrPassword.setBounds(64, 267, 108, 28);
		contentPane.add(txtrPassword);
		
		JTextArea txtrNewUser = new JTextArea();
		txtrNewUser.setForeground(Color.WHITE);
		txtrNewUser.setEditable(false);
		txtrNewUser.setFont(new Font("Cambria", Font.BOLD, 24));
		txtrNewUser.setBackground(Color.DARK_GRAY);
		txtrNewUser.setText("New User ?");
		txtrNewUser.setBounds(213, 435, 127, 28);
		contentPane.add(txtrNewUser);
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.setFont(new Font("Cambria", Font.BOLD, 27));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				NewShopkeeperSignUp nssu = new NewShopkeeperSignUp();
				nssu.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(361, 425, 145, 45);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/login-large-1.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(570, 157, 340, 333);
		contentPane.add(lblNewLabel);
		
		shopkeeper_password_entered = new JPasswordField();
		shopkeeper_password_entered.setForeground(Color.DARK_GRAY);
		shopkeeper_password_entered.setFont(new Font("Cambria", Font.BOLD, 24));
		shopkeeper_password_entered.setBounds(213, 257, 293, 45);
		contentPane.add(shopkeeper_password_entered);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setToolTipText("Back");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
				SecondFrame sf = new SecondFrame();
				sf.setVisible(true);
			}
		});
		Image img1 = new ImageIcon(this.getClass().getResource("/back-arrow.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(15, 15, 50, 48);
		contentPane.add(lblNewLabel_1);
	}
}
