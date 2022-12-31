package Java.Practical.JAppletDemo;

import java.applet.*;  
import javax.swing.*;  
import java.awt.event.*;  

/* 
    <applet code="JAppletDemo1.class" width="300" height="300">  
    </applet>  
*/

public class JAppletDemo1 extends JApplet implements ActionListener{
    JButton b;
    JTextField tf;  
    public void init(){  
        
        tf=new JTextField();  
        tf.setBounds(30,40,150,20);  
        
        b=new JButton("Click");  
        b.setBounds(80,150,70,40);  
        
        add(b);add(tf);  
        b.addActionListener(this);
        
        setLayout(null); 
    }  
    
    public void actionPerformed(ActionEvent e){  
    tf.setText("Welcome");  
    }
}
