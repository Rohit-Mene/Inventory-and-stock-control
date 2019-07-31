import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;

public class add_category extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 * 
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_category frame = new add_category();
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
	public add_category() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 899, 729);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setName("SURGICAL PLATE");
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(12, 63, 424, 249);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(" PLATE NAME");
		lblNewLabel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblNewLabel_1.setFont(new Font("Goudy Old Style", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(new Color(255, 204, 153));
		lblNewLabel_1.setBounds(26, 73, 134, 39);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(189, 73, 209, 39);
		panel.add(textField);
		textField.setColumns(10);
		//String rowadd=textField.getText().toString(); //adding
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setFont(new Font("Goudy Old Style", Font.PLAIN, 15));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		btnNewButton.setBounds(172, 176, 105, 44);
		panel.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				DB_conn db=new DB_conn();
				Connection con=db.getConnection();
				String queradd="insert into platefourmm (p_name) values (?) ";
			
				PreparedStatement ps=con.prepareStatement(queradd);
				ps.setString(1, textField.getText().toString());
				int i= ps.executeUpdate();
	  		      if(i>0) {
	  		    	  JOptionPane.showMessageDialog(null,"Success");
	  		      }
	  		      else
	  		    	  JOptionPane.showMessageDialog(null,"Fail");

			}catch(Exception e1) {
				e1.printStackTrace();
			}
			
			}
		});                                                  // end of add
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(494, 63, 399, 249);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("PLATE NAME");
		lblNewLabel_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblNewLabel_2.setForeground(new Color(255, 204, 153));
		lblNewLabel_2.setFont(new Font("Goudy Old Style", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(25, 69, 122, 36);
		panel_2.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(182, 69, 187, 36);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		String rowdel=textField_1.getText().toString();
		
		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.setFont(new Font("Goudy Old Style", Font.PLAIN, 13));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		btnNewButton_1.setBounds(143, 173, 97, 43);
		panel_2.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				DB_conn db=new DB_conn();
				Connection con=db.getConnection();
				String querdel="DELETE FROM platefourmm WHERE p_name = "+rowdel;
				PreparedStatement ps=con.prepareStatement(querdel);
			}catch(Exception e1) {
				e1.printStackTrace();
			}
				
			}
		});  
		
		JLabel lblNewLabel = new JLabel("SURGICAL PLATE");
		lblNewLabel.setBounds(384, 13, 225, 24);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Poor Richard", Font.PLAIN, 21));
		lblNewLabel.setForeground(new Color(255, 204, 153));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(262, 396, 406, 240);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("CHECK PLATES");
		lblNewLabel_3.setBounds(134, 5, 148, 38);
		lblNewLabel_3.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		lblNewLabel_3.setForeground(new Color(255, 204, 153));
		panel_1.add(lblNewLabel_3);
		
		JLabel lblClickOnDrodown = new JLabel("CLICK ON DROPDOWN");
		lblClickOnDrodown.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblClickOnDrodown.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClickOnDrodown.setForeground(new Color(255, 204, 153));
		lblClickOnDrodown.setBounds(12, 84, 160, 33);
		panel_1.add(lblClickOnDrodown);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(196, 84, 198, 28);
		panel_1.add(comboBox);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(765, 604, 85, 32);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
		Admin_Login.main(new String[] {});
		dispose();
		}
	});
		
		
		 try {
				DB_conn db=new DB_conn();
			Connection con=db.getConnection();
			String query="Select * from platefourmm";
			
			   PreparedStatement ps=con.prepareStatement(query);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next()) {
				  comboBox.addItem(rs.getString("p_name"));
			   }
		 }catch(Exception e2) {
				   e2.printStackTrace();
			   }
	}
}
