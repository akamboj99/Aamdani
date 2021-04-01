import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;

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
import javax.swing.JOptionPane;
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
import java.awt.Cursor;
import java.awt.Dimension;

public class NewShopkeeperSignUp extends JFrame {

	private JPanel contentPane;
	private JTextField shopkeeper_name;
	private JTextField shopkeeper_phone;
	private JTextField shopkeeper_email;
	private JTextField shopkeeper_shop_name;
	private JTextField shopkeeper_shop_address;
	private JPasswordField shopkeeper_password;
	private JPasswordField shopkeeper_confirm_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewShopkeeperSignUp frame = new NewShopkeeperSignUp();
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
	public NewShopkeeperSignUp() {
		setTitle("Shopkeeper Sign Up");
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
		txtrName.setBounds(95, 183, 59, 22);
		txtrName.setEditable(false);
		txtrName.setFont(new Font("Cambria", Font.BOLD, 21));
		txtrName.setBackground(Color.DARK_GRAY);
		txtrName.setText("Name");
		contentPane.add(txtrName);
		
		JTextArea txtrPhoneNo = new JTextArea();
		txtrPhoneNo.setForeground(Color.WHITE);
		txtrPhoneNo.setBounds(95, 243, 106, 23);
		txtrPhoneNo.setEditable(false);
		txtrPhoneNo.setFont(new Font("Cambria", Font.BOLD, 21));
		txtrPhoneNo.setBackground(Color.DARK_GRAY);
		txtrPhoneNo.setText("Phone No.");
		contentPane.add(txtrPhoneNo);
		
		JTextArea txtrEmail = new JTextArea();
		txtrEmail.setForeground(Color.WHITE);
		txtrEmail.setBounds(95, 303, 59, 22);
		txtrEmail.setEditable(false);
		txtrEmail.setFont(new Font("Cambria", Font.BOLD, 21));
		txtrEmail.setBackground(Color.DARK_GRAY);
		txtrEmail.setText("Email");
		contentPane.add(txtrEmail);
		
		JTextArea txtrSetPassword = new JTextArea();
		txtrSetPassword.setForeground(Color.WHITE);
		txtrSetPassword.setBounds(95, 363, 139, 22);
		txtrSetPassword.setEditable(false);
		txtrSetPassword.setFont(new Font("Cambria", Font.BOLD, 21));
		txtrSetPassword.setBackground(Color.DARK_GRAY);
		txtrSetPassword.setText("Set Password");
		contentPane.add(txtrSetPassword);
		
		JTextArea txtrShopName = new JTextArea();
		txtrShopName.setForeground(Color.WHITE);
		txtrShopName.setBounds(95, 483, 113, 27);
		txtrShopName.setEditable(false);
		txtrShopName.setFont(new Font("Cambria", Font.BOLD, 21));
		txtrShopName.setBackground(Color.DARK_GRAY);
		txtrShopName.setText("Shop name");
		contentPane.add(txtrShopName);
		
		JTextArea txtrAddress = new JTextArea();
		txtrAddress.setForeground(Color.WHITE);
		txtrAddress.setBounds(95, 543, 139, 30);
		txtrAddress.setEditable(false);
		txtrAddress.setFont(new Font("Cambria", Font.BOLD, 21));
		txtrAddress.setBackground(Color.DARK_GRAY);
		txtrAddress.setText("Shop Address");
		contentPane.add(txtrAddress);
		
		JTextArea txtrDistanceFromUpes = new JTextArea();
		txtrDistanceFromUpes.setForeground(Color.WHITE);
		txtrDistanceFromUpes.setBounds(95, 423, 188, 27);
		txtrDistanceFromUpes.setEditable(false);
		txtrDistanceFromUpes.setFont(new Font("Cambria", Font.BOLD, 21));
		txtrDistanceFromUpes.setBackground(Color.DARK_GRAY);
		txtrDistanceFromUpes.setText("Confirm Password");
		contentPane.add(txtrDistanceFromUpes);
		
		shopkeeper_name = new JTextField();
		shopkeeper_name.setForeground(Color.DARK_GRAY);
		shopkeeper_name.setAutoscrolls(false);
		shopkeeper_name.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		shopkeeper_name.setBounds(293, 180, 230, 30);
		shopkeeper_name.setFont(new Font("Cambria", Font.BOLD, 18));
		contentPane.add(shopkeeper_name);
		shopkeeper_name.setColumns(10);
		
		shopkeeper_phone = new JTextField();
		shopkeeper_phone.addKeyListener(new KeyAdapter() 
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
		shopkeeper_phone.setForeground(Color.DARK_GRAY);
		shopkeeper_phone.setFont(new Font("Cambria", Font.BOLD, 18));
		shopkeeper_phone.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		shopkeeper_phone.setBounds(293, 240, 230, 30);
		shopkeeper_phone.setColumns(10);
		contentPane.add(shopkeeper_phone);
		
		shopkeeper_email = new JTextField();
		shopkeeper_email.setForeground(Color.DARK_GRAY);
		shopkeeper_email.setFont(new Font("Cambria", Font.BOLD, 18));
		shopkeeper_email.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		shopkeeper_email.setBounds(293, 300, 230, 30);
		shopkeeper_email.setColumns(10);
		contentPane.add(shopkeeper_email);
		
		shopkeeper_shop_name = new JTextField();
		shopkeeper_shop_name.setForeground(Color.DARK_GRAY);
		shopkeeper_shop_name.setFont(new Font("Cambria", Font.BOLD, 18));
		shopkeeper_shop_name.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		shopkeeper_shop_name.setBounds(293, 480, 230, 30);
		shopkeeper_shop_name.setColumns(10);
		contentPane.add(shopkeeper_shop_name);
		
		shopkeeper_shop_address = new JTextField();
		shopkeeper_shop_address.setForeground(Color.DARK_GRAY);
		shopkeeper_shop_address.setFont(new Font("Cambria", Font.BOLD, 18));
		shopkeeper_shop_address.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		shopkeeper_shop_address.setBounds(293, 540, 230, 30);
		shopkeeper_shop_address.setColumns(10);
		contentPane.add(shopkeeper_shop_address);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBounds(654, 522, 179, 48);
		btnNewButton.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent arg0) 
			{
				String shopkeeperName = shopkeeper_name.getText();
                String shopkeeperPhone = shopkeeper_phone.getText();
                String shopkeeperEmail = shopkeeper_email.getText();
                String shopkeeperPswd = shopkeeper_password.getText();
                String shopkeeperConfirmpswd = shopkeeper_confirm_password.getText();
                String shopkeeperShopName = shopkeeper_shop_name.getText();
                String shopkeeperShopAddress = shopkeeper_shop_address.getText();
                int len = shopkeeperPhone.length();

                String msg = "" + shopkeeperName;
                msg += " \n";
                if (len != 10) 
                {
                    JOptionPane.showMessageDialog(null, new JLabel("Enter a valid phone number !", JLabel.CENTER), "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                else if(shopkeeperName.length()==0||shopkeeperPhone.length()==0||shopkeeperEmail.length()==0||shopkeeperPswd.length()==0||shopkeeperConfirmpswd.length()==0||shopkeeperShopName.length()==0||shopkeeperShopAddress.length()==0) 
                {
                    JOptionPane.showMessageDialog(null, new JLabel("Please fill out all the fields.", JLabel.CENTER), "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                else if (shopkeeperPswd.compareTo(shopkeeperConfirmpswd)!=0) 
                {
                    JOptionPane.showMessageDialog(null, new JLabel("Password did not match with the confirmed password !", JLabel.CENTER), "Error", JOptionPane.ERROR_MESSAGE);
                }

                else
                {
                	try 
                    {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aamdani", "root", "root");
                        
                        String query1 = "SELECT * FROM shopkeeper_sign_up where shopkeeper_email ='" + shopkeeperEmail + "'";
                        String query3 = "SELECT * FROM student_sign_up where student_email ='" + shopkeeperEmail + "'";

                        String query2 = "INSERT INTO shopkeeper_sign_up values('" + shopkeeperName + "','" + shopkeeperPhone + "','" + shopkeeperEmail + "','" +
                        		shopkeeperPswd + "','" + shopkeeperConfirmpswd + "','" + shopkeeperShopName + "','" + shopkeeperShopAddress + "')";

                        Statement sta = connection.createStatement();
                        Statement sta2 = connection.createStatement();
                        
                        ResultSet rs = sta.executeQuery(query1);
                        ResultSet rs1 = sta2.executeQuery(query3);
                        
                        if(rs.next()==false&&rs1.next()==false)
                        {
                        	int x = sta.executeUpdate(query2);
                            if (x != 0) 
                            {
                            	JOptionPane.showMessageDialog(null, new JLabel("Welcome, " + msg + "Your account is sucessfully created", JLabel.CENTER), "Congrats", JOptionPane.PLAIN_MESSAGE);
                                connection.close();
                                
                                dispose();
                				PostJobButtonClicked pjbc = new PostJobButtonClicked();
                				pjbc.setVisible(true);
                                
                            }
                        }
                        else
                        {
                        	JOptionPane.showMessageDialog(null, new JLabel("This email already exists !", JLabel.CENTER), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        
                    }
                    catch (Exception exception) 
                    {
                        exception.printStackTrace();
                    }
    				
    				
                }
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 27));
		contentPane.add(btnNewButton);
		
		JTextArea txtrCreateAccount = new JTextArea();
		txtrCreateAccount.setForeground(Color.WHITE);
		txtrCreateAccount.setBounds(92, 87, 315, 40);
		txtrCreateAccount.setEditable(false);
		txtrCreateAccount.setFont(new Font("Cambria", Font.BOLD, 36));
		txtrCreateAccount.setBackground(Color.DARK_GRAY);
		txtrCreateAccount.setText("CREATE  ACCOUNT");
		contentPane.add(txtrCreateAccount);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(596, 180, 292, 292);
		Image img = new ImageIcon(this.getClass().getResource("/shopicon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel);
		
		shopkeeper_password = new JPasswordField();
		shopkeeper_password.setForeground(Color.DARK_GRAY);
		shopkeeper_password.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		shopkeeper_password.setFont(new Font("Cambria", Font.BOLD, 18));
		shopkeeper_password.setBounds(293, 360, 230, 30);
		contentPane.add(shopkeeper_password);
		
		shopkeeper_confirm_password = new JPasswordField();
		shopkeeper_confirm_password.setForeground(Color.DARK_GRAY);
		shopkeeper_confirm_password.setFont(new Font("Cambria", Font.BOLD, 18));
		shopkeeper_confirm_password.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		shopkeeper_confirm_password.setBounds(293, 420, 230, 30);
		contentPane.add(shopkeeper_confirm_password);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setToolTipText("Back");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
				PostJobButtonClicked pjbc2 = new PostJobButtonClicked();
				pjbc2.setVisible(true);
			}
		});
		Image img1 = new ImageIcon(this.getClass().getResource("/back-arrow.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(15, 15, 50, 48);
		contentPane.add(lblNewLabel_1);
	}
}
