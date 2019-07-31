//import java.awt.BorderLayout.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
//import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
//import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class User_Login extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldname;
	private  JPasswordField  textFieldpss ;
	
	private JButton btnok;
	private JLabel lblNewLabel_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Login frame = new User_Login();
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
	public User_Login() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 541);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		setContentPane(contentPane);
		
		textFieldname = new JTextField();
		textFieldname.setBounds(299, 41, 186, 22);
		textFieldname.setColumns(10);
		
		textFieldpss = new JPasswordField();
		textFieldpss.setBounds(299, 112, 186, 22);
		textFieldpss.setColumns(10);
		
		btnok = new JButton("Verify");
		btnok.setBounds(354, 172, 82, 33);
		btnok.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new EtchedBorder(EtchedBorder.LOWERED, null, null)));
		btnok.setBackground(Color.WHITE);
		btnok.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	DB_conn db=new DB_conn();
            	try {
            	Connection con=db.getConnection();
        	
        		
        		
        		String username=null;
        		
        		
        		
         username=textFieldname.getText();
       
        	  String queryString =" select count(*) as \"exists\" from user_entry where user_name=? and user_pass=?";
              //set this values using PreparedStatement
           PreparedStatement   ps1 = con.prepareStatement(queryString);
              ps1.setString(1,username);
              ps1.setString(2,String.valueOf((textFieldpss.getPassword())));
             ResultSet results = ps1.executeQuery(); 

              if (results.next()) {
                     int i = results.getInt("exists");
                if(i==1)

             {
                	main_page.main(new String[] {});
             }
                else
                	JOptionPane.showMessageDialog(null,"Fail");
        	
        	
              }

            }catch(Exception e1) {
            	System.out.println(e1);
            }
            }
       
		 });
		contentPane.setLayout(null);
		contentPane.add(textFieldname);
		contentPane.add(textFieldpss);
		contentPane.add(btnok);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\lenovo\\Downloads\\login.png"));
		lblNewLabel_1.setBounds(35, 76, 469, 269);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(339, 390, 82, 33);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
		login_Page.main(new String[] {});
		dispose();
		}
	});
	

	}
}
