package projects;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class project extends JFrame implements ActionListener {
       
    project(){
        setSize(2000,1100);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/download.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        add(l1);
    
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        JMenu m1 = new JMenu("Event");
        m1.setForeground(Color.blue);
    
        JMenuItem t1 = new JMenuItem("New Events");
    
        t1.setForeground(Color.blue);
        t1.setFont(new Font("monospaced",Font.PLAIN,12));
        t1.setMnemonic('N');
        t1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        t1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/download.jpg")));
        

    
       
    
    
        JMenuItem t4 = new JMenuItem("List Events");
      
        t4.setForeground(Color.blue);
        t4.setFont(new Font("monospaced",Font.PLAIN,12));
        t4.setMnemonic('L');
        t4.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/download.jpg")));
        t4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
    
    
    
    
        m1.add(t1);
       
        m1.add(t4);
        mb.add(m1); 
        t1.addActionListener(this);
        
        t4.addActionListener(this);
        
        JMenu edit =new JMenu("Update Events");
        edit.setForeground(Color.RED);
   

        JMenuItem s1 = new JMenuItem("Update Events");
        s1.setForeground(Color.blue);   
        s1.setFont(new Font("monospaced",Font.PLAIN,12));
        s1.setMnemonic('U');
        s1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/download.jpg")));
        s1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
    
        edit.add(s1);
        mb.add(edit);
       
        s1.addActionListener(this);
    
       
    
    
        JMenu m8=new JMenu("Exit");
        m8.setForeground(Color.red);
        mb.add(m8);
        JMenuItem m8i1=new JMenuItem("Exit");
        m8.add(m8i1);
        m8i1.setForeground((Color.blue));
        m8i1.setFont(new Font("monospaced", Font.PLAIN, 14));
        m8i1.setMnemonic('X');
        m8i1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/download.jpg")));
        m8i1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        m8i1.addActionListener(this);

    }
    
    public void actionPerformed(ActionEvent ae){
        
        String msg= ae.getActionCommand();
      
        if(msg.equals("New Events"))
            new New_Events().setVisible(true);
        else if(msg.equals("List Events"))
            new List_Events().setVisible(true);
       else if(msg.equals("Update Events"))
            new Update_Events().setVisible(true);
     
        else if(msg.equals("Exit"))
            System.exit(0);
        
    }
    
    public static void main(String[] args){
        new project().setVisible(true);
    }
    

}


