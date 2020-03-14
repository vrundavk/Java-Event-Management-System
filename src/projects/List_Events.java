package projects;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class List_Events extends JFrame implements ActionListener{
  
    JTable j1;
    JButton b1;
    String h[]={"id","Name","Date","Venue","Time","VariousPrograms"};
    String d[][]=new String[20][8];  
    int i=0,j=0;
    
    List_Events(){
        super("View Events");
        
        setSize(1000,400);
        setLocation(250,200);

        try{
            String q="select * from event";
            conn c=new conn();
            ResultSet rs=c.s.executeQuery(q);
            while(rs.next()){
                
                d[i][j++]=rs.getString("id");
                d[i][j++]=rs.getString("name");
              
                d[i][j++]=rs.getString("date");
                d[i][j++]=rs.getString("venue");
                d[i][j++]=rs.getString("time");
                d[i][j++]=rs.getString("variousprograms");
              
                i++;
                j=0;
            }
            j1=new JTable(d,h); 

        }
        catch(Exception e){}
        
        b1=new JButton("Print");
        add(b1,"South");
        JScrollPane s1=new JScrollPane(j1);
        add(s1);
        
        b1.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
           j1.print();
        }catch(Exception e){}
    }
     
    public static void main(String s[]){
        new List_Events().setVisible(true);
    }
}


