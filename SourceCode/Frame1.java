import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Cursor;

public class Frame1 {

	private JFrame frmAamdani;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frmAamdani.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAamdani = new JFrame();
		frmAamdani.setResizable(false);
		frmAamdani.setTitle("Aamdani");
		frmAamdani.getContentPane().setBackground(Color.DARK_GRAY);
		frmAamdani.setBounds(100, 100, 1000, 700);
		frmAamdani.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAamdani.getContentPane().setLayout(null);
		frmAamdani.setLocationRelativeTo(null);
		
		JTextArea txtrWelcome = new JTextArea();
		txtrWelcome.setForeground(Color.WHITE);
		txtrWelcome.setBackground(Color.DARK_GRAY);
		txtrWelcome.setEditable(false);
		txtrWelcome.setFont(new Font("Cambria", Font.BOLD, 60));
		txtrWelcome.setText("Welcome To AAMDANI");
		txtrWelcome.setBounds(185, 60, 630, 69);
		frmAamdani.getContentPane().add(txtrWelcome);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frmAamdani.dispose();
				SecondFrame sf = new SecondFrame();
				sf.setVisible(true);
			}
		});
		lblNewLabel.setBounds(375, 160, 250, 250);
		Image img = new ImageIcon(this.getClass().getResource("/handshake.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		frmAamdani.getContentPane().add(lblNewLabel);
		
		JTextArea txtrBlahBlahBlah = new JTextArea();
		txtrBlahBlahBlah.setForeground(Color.WHITE);
		txtrBlahBlahBlah.setEditable(false);
		txtrBlahBlahBlah.setText("A platform for college students to find non-technical part-time jobs near their colleges in order to earn their basic expenses and also making it easier for employers as well to find candidates willing to work on an hourly stipend basis.");
		txtrBlahBlahBlah.setFont(new Font("Cambria", Font.BOLD, 18));
		txtrBlahBlahBlah.setBackground(Color.DARK_GRAY);
		txtrBlahBlahBlah.setBounds(173, 440, 651, 28);
		frmAamdani.getContentPane().add(txtrBlahBlahBlah);
		
		JTextArea txtrClickOnThe = new JTextArea();
		txtrClickOnThe.setForeground(Color.WHITE);
		txtrClickOnThe.setEditable(false);
		txtrClickOnThe.setText("Click on the logo above to Get Started");
		txtrClickOnThe.setFont(new Font("Cambria", Font.BOLD, 22));
		txtrClickOnThe.setBackground(Color.DARK_GRAY);
		txtrClickOnThe.setBounds(308, 560, 384, 28);
		frmAamdani.getContentPane().add(txtrClickOnThe);
		
		JTextArea txtrCollegesInOrder = new JTextArea();
		txtrCollegesInOrder.setText("colleges in order to earn their basic expenses and also making it easier for employers as well to find candidates willing to work on an hourly stipend basis.");
		txtrCollegesInOrder.setForeground(Color.WHITE);
		txtrCollegesInOrder.setFont(new Font("Cambria", Font.BOLD, 18));
		txtrCollegesInOrder.setEditable(false);
		txtrCollegesInOrder.setBackground(Color.DARK_GRAY);
		txtrCollegesInOrder.setBounds(141, 470, 716, 28);
		frmAamdani.getContentPane().add(txtrCollegesInOrder);
		
		JTextArea txtrBlahBlahBlah_2 = new JTextArea();
		txtrBlahBlahBlah_2.setText("as well to find candidates willing to work on an hourly stipend basis.");
		txtrBlahBlahBlah_2.setForeground(Color.WHITE);
		txtrBlahBlahBlah_2.setFont(new Font("Cambria", Font.BOLD, 20));
		txtrBlahBlahBlah_2.setEditable(false);
		txtrBlahBlahBlah_2.setBackground(Color.DARK_GRAY);
		txtrBlahBlahBlah_2.setBounds(188, 500, 623, 28);
		frmAamdani.getContentPane().add(txtrBlahBlahBlah_2);
	}
}
