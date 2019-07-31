import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class add_newuser extends JFrame {
	private JPanel content;
	//static Admin_Login f;
	private JTextField name;
	private JPasswordField passcode;
	private final JLabel Header = new JLabel("Add new user");
	private JTextField textField;
	private JPasswordField textFieldpss;
	private JButton btnNewButton;

	private JPanel contentPane;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_newuser frame = new add_newuser();
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
	public add_newuser() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
//		
		
		
		getContentPane().setFont(new Font("Monotype Corsiva", Font.PLAIN, 13));
		getContentPane().setBackground(new Color(0, 0, 51));
			
			setBounds(50, 50, 500,400);
			getContentPane().setLayout(null);
			Header.setForeground(new Color(255, 204, 153));
			Header.setSize(482, 50);
			Header.setHorizontalTextPosition(SwingConstants.CENTER);
			
			Header.setMaximumSize(new Dimension(500, 500));
			Header.setLocation(new Point(0, 0));
			Header.setHorizontalAlignment(SwingConstants.CENTER);
			
			Header.setVerticalAlignment(SwingConstants.CENTER);
			getContentPane().add(Header);
			Header.setFont(new Font("Poor Richard", Header.getFont().getStyle(), 22));
			
			JLabel lblNewLabel = new JLabel("Set user's name");
			lblNewLabel.setForeground(new Color(255, 204, 153));
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(12, 97, 182, 62);
			getContentPane().add(lblNewLabel);
			
			textField = new JTextField();
			textField.setBounds(206, 120, 253, 22);
			getContentPane().add(textField);
			textField.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Set user's passcode");
			lblNewLabel_1.setForeground(new Color(255, 204, 153));
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_1.setBounds(12, 187, 182, 25);
			getContentPane().add(lblNewLabel_1);
			
			textFieldpss = new JPasswordField();
			textFieldpss.setBounds(206, 191, 253, 22);
			getContentPane().add(textFieldpss);
			textFieldpss.setColumns(10);
// char[]  take_pss=new char[100];
//take_pss=textFieldpss.getPassword();
//String pss= String.valueOf(take_pss);
			btnNewButton = new JButton("OK");
			btnNewButton.setForeground(new Color(0, 0, 0));
			btnNewButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnNewButton.setBackground(Color.LIGHT_GRAY);
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButton.setBounds(174, 273, 97, 25);
			getContentPane().add(btnNewButton);
			
			btnNewButton_1 = new JButton("Back");
			btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
			btnNewButton_1.setBounds(334, 315, 75, 25);
			getContentPane().add(btnNewButton_1);
			
			btnNewButton_1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
			Admin_Login.main(new String[] {});
			dispose();
			}
		});
			
			
			
			btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            
			try {
				DB_conn db=new DB_conn();
			    Connection con=db.getConnection();
			
			  String queryString ="insert into user_entry(user_name,user_pass) values(?,?)";
		      PreparedStatement ps1 = con.prepareStatement(queryString);
		      ps1.setString(1,textField.getText());
		      ps1.setNString(2,String.valueOf((textFieldpss.getPassword())));
		     
		     // ResultSet results = ps1.executeQuery(); 
		      int i= ps1.executeUpdate();
		      if(i>0) {
		    	  JOptionPane.showMessageDialog(null,"Success");
		      }
		      else
		    	  JOptionPane.showMessageDialog(null,"Fail");
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			
		}
			});
			
	}
}


