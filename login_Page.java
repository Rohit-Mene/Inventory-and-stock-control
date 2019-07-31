import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.mysql.cj.Messages;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login_Page extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_Page frame = new login_Page();
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
	public login_Page() {
		setBackground(new Color(0, 0, 102));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 622);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("User Login");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Poor Richard", Font.PLAIN, 14));
		btnNewButton.setBounds(552, 249, 113, 44);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	User_Login.main(new String[]{});
	            dispose();


            }
		});
		
		JButton btnNewButton_1 = new JButton("Admin Login");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Poor Richard", Font.PLAIN, 14));
		btnNewButton_1.setBounds(552, 85, 113, 44);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Admin_perm.main(new String[] {});
            	dispose();
            }
		});
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\lenovo\\Downloads\\7b91b2efc18361b9f3d67e6102382cd4.png"));
		lblNewLabel_1.setBounds(153, 122, 298, 171);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\lenovo\\Desktop\\warehouse-wallpaper-hd-wallpapers-blog-in-1024x768.jpg"));
		lblNewLabel.setBounds(0, 0, 834, 575);
		contentPane.add(lblNewLabel);
		btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Admin_perm.main(new String[] {});
            }
		});
		
		
	}
}
