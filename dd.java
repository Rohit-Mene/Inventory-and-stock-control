import java.awt.*;  
import java.awt.event.*;  
  
import javax.swing.*;  
  
public class dd extends Frame implements ActionListener{  
CardLayout card;  
Button b1,b2,b3;  
Panel p; 
    dd(){  
          
        p=new Panel();
        card=new CardLayout();
      //  card=new dd();  
//create CardLayout object with 40 hor space and 30 ver space  
        p.setLayout(card);  
          
        b1=new Button("Apple");  
        b2=new Button("Boy");  
        b3=new Button("Cat");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        b3.addActionListener(this);  
              
        p.add(b1);p.add(b2);p.add(b3);  
                          
    }  
    public void actionPerformed(ActionEvent e) {  
    card.next(p);
    }  
  
    public static void main(String[] args) {  
        dd cl=new dd();  
        cl.setSize(400,400);  
        cl.setVisible(true);  
        
    }  
}  