package projects;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class New_Events extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    Choice c1;
    
    New_Events(){
        
        super("New Events");
        
        setSize(600,650);
        setLocation(600,200);
        getContentPane().setBackground(Color.WHITE);
        
        JPanel p1= new JPanel();
        p1.setBackground(Color.WHITE);
      
        p1.setLayout(new GridLayout(8,2,10,40));
       
        
        l1 = new JLabel("Name");
        t1= new JTextField(15);
        p1.add(l1);
        p1.add(t1);
        l2 = new JLabel("Date");
        t2 = new JTextField(15);
        p1.add(l2);
        p1.add(t2);
        l3 = new JLabel("Venue");
        t3 = new JTextField(15);
        p1.add(l3);
        p1.add(t3); 
        l4 = new JLabel("Time");
        t4 = new JTextField(15);
        p1.add(l4);
        p1.add(t4);
        l5 = new JLabel("Variousprograms");
        t5 = new JTextField(15);
        p1.add(l5);
        p1.add(t5);
   
        b1 =new JButton("Submit");
        b2 = new JButton("Cancel");
        p1.add(b1);
        p1.add(b2);
       
        setLayout(new BorderLayout());
        add(new JLabel(new ImageIcon(ClassLoader.getSystemResource("icon/b.jpg"))),"West");
        add(p1,"Center");
       
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
       
    }
    
    public void actionPerformed(ActionEvent ae){
       
        String n= t1.getText();
        String d = t2.getText();
        String v = t3.getText();
        String t = t4.getText();
        String ve = t5.getText();
        String qry = "insert into event values(null,'"+n+"','"+d+"','"+v+"','"+t+"','"+ve+"')";
       
        try{
            conn c = new conn();
            c.s.executeUpdate(qry);
            JOptionPane.showMessageDialog(null,"Event Created");
            this.setVisible(false);  
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    public static void main(String s[]){
        new New_Events().setVisible(true);
    }

}




