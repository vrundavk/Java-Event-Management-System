package projects;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Update_Events extends JFrame implements ActionListener,ItemListener{
    JLabel l1,l2,l3,l4,l5,eve;
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2;
    Choice c1,c2;
    
    Update_Events(){
       super("Update Events");
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        c2 = new Choice();
        c2.setBounds(160,40,200,20);
       
        try{
           conn c = new conn();
           ResultSet rs = c.s.executeQuery("select * from event");
      
            while(rs.next()){
                c2.add(rs.getString("id"));    
            }
       }catch(Exception e) {}
       
        eve = new JLabel("Select id");
        eve.setBounds(40,40,100,20);
        add(eve);
        add(c2);
        
        l1 = new JLabel("Name : ");
        t1 = new JTextField(15);
        
        l1.setBounds(40,80,100,20);
        t1.setBounds(160,80,200,20);
        add(l1);
        add(t1);
       
        
       
        l2 = new JLabel("Date : ");
        t2 = new JTextField(15);
        l2.setBounds(40,120,100,20);
        t2.setBounds(160,120,200,20);
        add(l2);
        add(t2);
         
        l3 = new JLabel("Venue : ");
        t3 = new JTextField(15);
        
        l3.setBounds(40,160,100,20);
        t3.setBounds(160,160,200,20);
        add(l3);
        add(t3);
        
        l4 = new JLabel("Time : ");
        t4 = new JTextField(15);
        
        l4.setBounds(40,200,100,20);
        t4.setBounds(160,200,200,20);
        add(l4);
        add(t4); 
        
        l5 = new JLabel("VariousPrograms: ");
        t5= new JTextField(15);
        
        l5.setBounds(40,240,100,20);
        t5.setBounds(160,240,200,20);
        add(l5);
        add(t5);
       
        
        b1 =new JButton("Update");
        b2 = new JButton("Delete");
        
        b1.setBounds(40,400,150,30);
        b2.setBounds(200,400,150,30);
        add(b1);
        add(b2);
        
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
            
        c2.addItemListener(this);
        
        setVisible(true);
        setSize(400,550);
        setLocation(600,200);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b1){
            
            String n = t1.getText();
            String d = t2.getText();
            String v = t3.getText();
            String t = t4.getText();
            String ve = t5.getText();
            
            String qry ="update event set name='"+n+"',date='"+d+"',venue='"+v+"',time='"+t+"',variousprograms='"+ve+"' where id="+c2.getSelectedItem();
       
            try{
                conn c1 = new conn();
                c1.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null,"Event Updated");
                this.setVisible(true);
                
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
        
        if(ae.getSource()==b2){
            try{
                conn c1 = new conn();
                c1.s.executeUpdate("delete from event where id="+c2.getSelectedItem());
                JOptionPane.showMessageDialog(null,"Event Deleted");
                this.setVisible(false);
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
    }
    
    public void itemStateChanged(ItemEvent ie){
        try{
            conn c1 = new conn();
            ResultSet rs = c1.s.executeQuery("select * from event where id="+c2.getSelectedItem());
            
            if(rs.next()){
                t1.setText(rs.getString("name"));
                t2.setText(rs.getString("date"));
                t3.setText(rs.getString("venue"));
                t4.setText(rs.getString("time"));
                t5.setText(rs.getString("variousprograms"));
               
            }
        }catch(Exception ee){
           ee.printStackTrace();
        }
    
    }
    
    public static void main(String s[]){
        new Update_Events().setVisible(true);
    }
    

}

