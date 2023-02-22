package travel.managment.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java .sql.*;

public  class Login extends JFrame implements ActionListener{
    JButton b1,b2,b3;
    JTextField t1;
    JPasswordField t2;
    Login(){
//        setSize(400, 400);
//        setLocation(400, 200);

        setLayout(null); //BorderLayout, FlowLayout, GridLayout, Grid//
        getContentPane().setBackground(Color.WHITE);
        setBounds(380, 200, 800, 400);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 300, 350);
      
       
        add(p1);
        
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/managment/system/icons/login.png"));
      // Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
       //ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i1);
        l1.setBounds(100, 120, 200, 200);
        p1.add(l1);
        
       JPanel p2 = new JPanel();
        p2.setLayout(null);
	p2.setBounds(300, 30, 450, 300);
        add(p2);
        
        JLabel l2 = new JLabel("Username");
        l2.setBounds(60, 20, 100, 25);
       // l2.setFont(new Font("Calabri",Font.BOLD,24));
        p2.add(l2);
 
         t1 = new JTextField();
        t1.setBounds(60, 60, 300, 30);
        t1.setBorder(BorderFactory.createEmptyBorder());
        p2.add(t1);
        
        
          JLabel l3 = new JLabel("Password");
         l3.setBounds(60, 110, 100, 25);
         //l2.setFont(new Font("SAN_SERIF", FONT.PLAIN, 20)); 
        p2.add(l3);
 
        t2 = new JPasswordField();
        t2.setBounds(60, 150, 300, 30);
        t2.setBorder(BorderFactory.createEmptyBorder());
        p2.add(t2);
        
         b1 = new JButton("Login");
        b1.setBounds(60, 200, 130, 30);
        b1.setBackground(new Color(133, 193, 233));
        b1.setForeground(Color.WHITE);
        b1.setBorder(BorderFactory.createEmptyBorder());
        b1.addActionListener(this);
        p2.add(b1);
        
         b2 = new JButton("Signup");
        b2.setBounds(230, 200, 130, 30);
        b2.setBackground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBorder(new LineBorder(new Color(133, 193,233)));
        p2.add(b2);
        
        
         b3 = new JButton("Forget Password");
        b3.setBounds(130, 250, 160, 30);
        b3.setBackground(Color.WHITE);
        b3.addActionListener(this);
        b3.setBorder(new LineBorder(new Color(133, 193,233)));
        p2.add(b3);
        
        JLabel l4 = new JLabel("Trouble in Login...");
        l4.setForeground(Color.red);
        l4.setBounds(300, 250, 100, 20);
        p2.add(l4);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            try{
                String username = t1.getText();
                String password = t2.getText();
                String sql = "select * from account where username = '"+username+"' AND password = '"+password+"'";
                Conn c = new Conn(); 
                 ResultSet rs = c.s.executeQuery(sql);
                 if(rs.next()){
                    this.setVisible(false);
                    new Loading(username).setVisible(true);
                    
                 }else{
                     JOptionPane.showMessageDialog(null, "Invalid Login");
                 }
            }catch (Exception e){}
            
            
        }else if(ae.getSource() == b2){
          this.setVisible(false);
            new Signup().setVisible(true);
          
          
        }else if(ae.getSource() == b3){
          this.setVisible(false);
          new ForgotPassword().setVisible(true);
        }
        
    }
    
    public static void main(String[] args){
        new Login();
    }
}