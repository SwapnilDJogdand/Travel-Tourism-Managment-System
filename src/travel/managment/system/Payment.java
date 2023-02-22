package travel.managment.system;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;


public class Payment extends JFrame implements ActionListener{
    
    JButton b1, b2;
    
    
    public Payment(){
        
        
        
        setLayout(null);
        setBounds(300, 120, 800, 600);
        
        JLabel label=new JLabel("Pay using Paytm");
        label.setFont(new Font("Raleway", Font.BOLD, 40));
        label.setBounds(50, 20, 350, 45);
        add(label);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/managment/system/icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, 800, 600);
        add(l1);
        
        b1 = new JButton("Pay");
        b1.setBounds(420, 20, 80, 40);
        b1.addActionListener(this);
        l1.add(b1);
        
         b2 = new JButton("Back");
        b2.setBounds(520, 20, 80, 40);
        b2.addActionListener(this);
        l1.add(b2);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            this.setVisible(false);
            new Paytm().setVisible(true);
        }else if(ae.getSource() == b2){
           this.setVisible(false); 
        }
    
       
     

    }

    public static void main(String[] args){
        new Payment().setVisible(true);
    }
    
}