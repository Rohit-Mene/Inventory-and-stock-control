import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class Admin_perm extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterAdminName;
	private JPasswordField pwdEnterPasscode;
	private JLabel lblNewLabel;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_perm frame = new Admin_perm();
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
	public Admin_perm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 533);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEnterAdminName = new JTextField();
		txtEnterAdminName.setText("Enter admin name");
		txtEnterAdminName.setBounds(174, 192, 116, 22);
		contentPane.add(txtEnterAdminName);
		txtEnterAdminName.setColumns(10);
		
		pwdEnterPasscode = new JPasswordField();
		pwdEnterPasscode.setText("Enter passcode");
		pwdEnterPasscode.setToolTipText("Enter passcode");
		pwdEnterPasscode.setBounds(174, 258, 116, 22);
		contentPane.add(pwdEnterPasscode);
		
		JButton btnVerify = new JButton("   Verify");
		btnVerify.setBounds(384, 213, 97, 25);
		contentPane.add(btnVerify);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\lenovo\\Downloads\\ADMIN-APPROVED-USER-REGISTRATION (1).png"));
		lblNewLabel.setBounds(0, 0, 638, 486);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(138, 384, 81, 25);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
		login_Page.main(new String[] {});
		dispose();
		}
	});
		
		btnVerify.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	DB_conn db=new DB_conn();
            	try {
            	Connection con=db.getConnection();
        	
        		
        		
        		String username=null;
        		
        		
        		
         username=txtEnterAdminName.getText();
       
        	  String queryString =" select count(*) as \"exists\" from user_entry where user_name=? and user_pass=?";
              //set this values using PreparedStatement
           PreparedStatement   ps1 = con.prepareStatement(queryString);
              ps1.setString(1,username);
              ps1.setString(2,String.valueOf((pwdEnterPasscode.getPassword())));
             ResultSet results = ps1.executeQuery(); 

              if (results.next()) {
                     int i = results.getInt("exists");
                if(i==1)

             {
                	Admin_Login.main(new String[] {});
             }
                else
                	JOptionPane.showMessageDialog(null,"Fail");
        	
        	
              }

            }catch(Exception e1) {
            	System.out.println(e1);
            }
            }
       
		 });
	}

}
