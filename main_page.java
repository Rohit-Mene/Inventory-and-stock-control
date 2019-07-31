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
import java.sql.SQLException;
import java.text.NumberFormat;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.text.NumberFormatter;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class main_page extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public String query;
	 public int data;
	 public int back_newdata;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_page frame = new main_page();
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
	public main_page() {
//		NumberFormat format= NumberFormat.getInstance();
//		NumberFormatter takeint=new NumberFormatter(format);
//		takeint.setValueClass(Integer.class);
//		takeint.setMinimum(0);
//		takeint.setMaximum(Integer.MAX_VALUE);
//		takeint.setAllowsInvalid(false);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1281, 979);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new EtchedBorder(EtchedBorder.RAISED, null, null)), new EtchedBorder(EtchedBorder.RAISED, null, null)));
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(24, 103, 769, 305);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("    4.5mm Plate");
		lblNewLabel.setForeground(new Color(255, 204, 153));
		lblNewLabel.setFont(new Font("Poor Richard", Font.PLAIN, 17));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(39, 83, 171, 36);
		panel.add(lblNewLabel);
		
		JComboBox<String> comboBoxplate = new JComboBox<String>();
		comboBoxplate.setToolTipText("Select Plate");
		comboBoxplate.setBounds(276, 82, 266, 36);
		panel.add(comboBoxplate);
		
		
		
	        try {
			DB_conn db=new DB_conn();
		Connection con=db.getConnection();
		query="Select * from platefourmm";
		
		   PreparedStatement ps=con.prepareStatement(query);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next()) {
			  comboBoxplate.addItem(rs.getString("p_name"));
		   }
		  
	            //	String new_plate=comboBoxplate.getSelectedItem().toString();
	            	
	      
		
	        
	        JComboBox<String> comboBoxhole = new JComboBox<String>();
			comboBoxhole.setToolTipText("Select Hole Number");
			comboBoxhole.setBounds(603, 82, 121, 36);
			comboBoxhole.addItem("five");
			comboBoxhole.addItem("six");
			comboBoxhole.addItem("eight");
			comboBoxhole.addItem("ten");
			comboBoxhole.addItem("tweleve");
			comboBoxhole.addItem("fourteen");
			panel.add(comboBoxhole);
			String size=comboBoxhole.getSelectedItem().toString();
			JButton btnNewButton = new JButton("SHOW");
			btnNewButton.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
			btnNewButton.setBackground(Color.LIGHT_GRAY);
			btnNewButton.setBounds(418, 167, 97, 36);
			panel.add(btnNewButton);
			
			JLabel lblNewLabel_1 = new JLabel("  IN STOCK");
			lblNewLabel_1.setBackground(new Color(0, 0, 0));
			lblNewLabel_1.setOpaque(true);
			lblNewLabel_1.setForeground(new Color(255, 204, 153));
			lblNewLabel_1.setFont(new Font("Poor Richard", Font.PLAIN, 17));
			lblNewLabel_1.setBounds(80, 237, 133, 30);
			panel.add(lblNewLabel_1);
			
			textField = new JTextField();
			textField.setBounds(311, 236, 69, 30);
			panel.add(textField);
			textField.setColumns(10);
			
			JLabel lblL = new JLabel("    STOCK CHECK");
			lblL.setBounds(302, 13, 186, 47);
			panel.add(lblL);
			lblL.setForeground(new Color(255, 204, 153));
			lblL.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
			
			btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	try {
	            	String query1= "SELECT "+size+" FROM platefourmm WHERE p_name=?";
	            	 PreparedStatement ps1=con.prepareStatement(query1);
		   				ps1.setString(1, comboBoxplate.getSelectedItem().toString());
	   			 
	   			 
	   				
	   				 ResultSet rs=ps1.executeQuery();
	         		   while(rs.next()) {
	         			textField.setText(rs.getString(size));
        		   }
	   			} catch (SQLException e1) {
	   				// TODO Auto-generated catch block
	   				e1.printStackTrace();
	   			}
	            }
			});                                                       //completion of1st panel code
			
			//2nd panel code
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new EtchedBorder(EtchedBorder.RAISED, null, null)));
			panel_1.setBackground(Color.DARK_GRAY);
			panel_1.setBounds(24, 541, 769, 364);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel_3 = new JLabel("4.5mm Plate");
			lblNewLabel_3.setOpaque(true);
			lblNewLabel_3.setForeground(new Color(255, 204, 153));
			lblNewLabel_3.setBackground(new Color(0, 0, 0));
			lblNewLabel_3.setFont(new Font("Poor Richard", Font.PLAIN, 17));
			lblNewLabel_3.setBounds(28, 81, 180, 39);
			panel_1.add(lblNewLabel_3);
			
			JComboBox<String> comboBoxplate1 = new JComboBox<String>();
			comboBoxplate1.setBounds(275, 80, 274, 39);
			comboBoxplate1.setToolTipText("Select Plate");
			String query1="Select * from platefourmm";
			
			  PreparedStatement  ps1=con.prepareStatement(query1);
			  ResultSet  rs1=ps.executeQuery();
			   while(rs1.next()) {
				  comboBoxplate1.addItem(rs1.getString("p_name"));
			   }
			panel_1.add(comboBoxplate1);
			
			JComboBox<String> comboBoxhole1 = new JComboBox<String>();
			comboBoxhole1.setBounds(614, 81, 109, 39);
			
			comboBoxhole1.setToolTipText("Select Hole Number");
			comboBoxhole1.addItem("five");
			comboBoxhole1.addItem("six");
			comboBoxhole1.addItem("eight");
			comboBoxhole1.addItem("ten");
			comboBoxhole1.addItem("tweleve");
			comboBoxhole1.addItem("fourteen");
			panel_1.add(comboBoxhole1);
			
			JLabel lblNewLabel_2 = new JLabel("      ADD TO STOCK/DELETE FROM STOCK");
			lblNewLabel_2.setBounds(141, 5, 464, 63);
			panel_1.add(lblNewLabel_2);
			lblNewLabel_2.setForeground(new Color(255, 204, 153));
			lblNewLabel_2.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
			
			JButton btnNewButton_1 = new JButton("ADD ITEM");
			btnNewButton_1.setBackground(Color.LIGHT_GRAY);
			btnNewButton_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
			btnNewButton_1.setBounds(157, 271, 89, 39);
			panel_1.add(btnNewButton_1);
			
			JComboBox comboBoxitem = new JComboBox();
			comboBoxitem.setBounds(40, 275, 74, 30);
			for(int i=1;i<=300;i++) {
				comboBoxitem.addItem(i);
			}
			panel_1.add(comboBoxitem);
			String sizear=comboBoxhole1.getSelectedItem().toString();
			
			String added_s=comboBoxitem.getSelectedItem().toString();
			int added=Integer.parseInt(added_s);
						btnNewButton_1.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent e) {
				            	try {
				            	String query1= "SELECT "+sizear+" FROM platefourmm WHERE p_name=?";
				            	 PreparedStatement ps1=con.prepareStatement(query1);
					   				ps1.setString(1, comboBoxplate1.getSelectedItem().toString());
				   			 
				   			 
				   				
				   				 ResultSet rs=ps1.executeQuery();
				         		   while(rs.next()) {
				         			 data=rs.getInt(sizear);
				         			
			        		   }
				         		    back_newdata=data+added;
				         		  String addquer= "update platefourmm set "+sizear+" = "+back_newdata+" where p_name=?";
				         		 PreparedStatement ps2 = con.prepareStatement(addquer);
				         		 ps2.setString(1, comboBoxplate1.getSelectedItem().toString());
				         		int i= ps2.executeUpdate();
				  		      if(i>0) {
				  		    	  JOptionPane.showMessageDialog(null,"Success");
				  		      }
				  		      else
				  		    	  JOptionPane.showMessageDialog(null,"Fail");
				   			} catch (SQLException e1) {
				   				// TODO Auto-generated catch block
				   				e1.printStackTrace();
				   			}
				            	catch(NumberFormatException nf) {
				            		nf.printStackTrace();
				            	}
				            }
						});                                      //add item completion
int deleted=added;
			
			
			
			JComboBox comboBoxdel = new JComboBox();
			comboBoxdel.setBounds(404, 271, 80, 30);
			for(int i=1;i<=300;i++) {
				comboBoxdel.addItem(i);
			}
			
			panel_1.add(comboBoxdel);
			
			JButton btnNewButton_2 = new JButton("DELETE ITEM");
			btnNewButton_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
			btnNewButton_2.setBackground(Color.LIGHT_GRAY);
			btnNewButton_2.setBounds(516, 271, 99, 39);
			panel_1.add(btnNewButton_2);
			
			btnNewButton_2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	try {
	            	String query1= "SELECT "+sizear+" FROM platefourmm WHERE p_name=?";
	            	 PreparedStatement ps1=con.prepareStatement(query1);
		   				ps1.setString(1, comboBoxplate1.getSelectedItem().toString());
	   			 
	   			 
	   				
	   				 ResultSet rs=ps1.executeQuery();
	         		   while(rs.next()) {
	         			 data=rs.getInt(sizear);
	         			
        		   }
	         		    back_newdata=data-deleted; //deletion
	         		  String addquer= "update platefourmm set "+sizear+" = "+back_newdata+" where p_name=?";
	         		 PreparedStatement ps2 = con.prepareStatement(addquer);
	         		 ps2.setString(1, comboBoxplate1.getSelectedItem().toString());
	         		int i= ps2.executeUpdate();
	  		      if(i>0) {
	  		    	  JOptionPane.showMessageDialog(null,"Success");
	  		      }
	  		      else
	  		    	  JOptionPane.showMessageDialog(null,"Fail");
	   			} catch (SQLException e1) {
	   				// TODO Auto-generated catch block
	   				e1.printStackTrace();
	   			}
	            	catch(NumberFormatException nf) {
	            		nf.printStackTrace();
	            	}
	            }
			});
			
			JLabel lblNewLabel_4 = new JLabel("ADD OPTION");
			lblNewLabel_4.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
			lblNewLabel_4.setFont(new Font("Goudy Old Style", Font.PLAIN, 13));
			lblNewLabel_4.setForeground(new Color(255, 204, 153));
			lblNewLabel_4.setBounds(90, 212, 118, 30);
			panel_1.add(lblNewLabel_4);
			
			JLabel lblNewLabel_5 = new JLabel("DELETE OPTION");
			lblNewLabel_5.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
			lblNewLabel_5.setFont(new Font("Goudy Old Style", Font.PLAIN, 13));
			lblNewLabel_5.setForeground(new Color(255, 204, 153));
			lblNewLabel_5.setBounds(511, 212, 123, 23);
			panel_1.add(lblNewLabel_5);
			
			JButton btnNewButton_3 = new JButton("Back to main");
			btnNewButton_3.setBounds(895, 746, 112, 36);
			contentPane.add(btnNewButton_3);
			
			btnNewButton_3.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
			login_Page.main(new String[] {});
			dispose();
			}
		});
		
			
	
	            
			
			
			
			
			
			 
	        }catch(Exception e1) {
				System.out.println(e1);
			}	
        
	}
}
