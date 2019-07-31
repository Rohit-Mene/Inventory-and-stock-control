import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;

public class Admin_Login extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Login frame = new Admin_Login();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	public Admin_Login() {
		setBackground(new Color(0, 0, 51));
		setResizable(false);
		
		setBounds(100, 100, 761, 612);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN OPTIONS");
		lblNewLabel.setBounds(510, 49, 233, 63);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Poor Richard", Font.BOLD, 25));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButtonadduser = new JButton("Add new user");
		btnNewButtonadduser.setBounds(496, 147, 139, 50);
		btnNewButtonadduser.setBackground(Color.LIGHT_GRAY);
		btnNewButtonadduser.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		btnNewButtonadduser.setForeground(new Color(0, 0, 0));
		btnNewButtonadduser.setFont(new Font("Goudy Old Style", Font.PLAIN, 15));
		contentPane.add(btnNewButtonadduser);
		btnNewButtonadduser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			add_newuser.main(new String[] {});
			dispose();
		}

				
	});
		
		JButton btnNewButton_1 = new JButton("Add new items");
		btnNewButton_1.setBounds(516, 335, 124, 63);
		btnNewButton_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("Goudy Old Style", Font.PLAIN, 15));
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\lenovo\\Downloads\\maxresdefault.jpg"));
		lblNewLabel_1.setBounds(0, 13, 755, 564);
		contentPane.add(lblNewLabel_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				add_category.main(new String[] {});
				
			}
		});
	}

}
