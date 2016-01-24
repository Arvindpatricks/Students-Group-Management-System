import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

     class login  extends JFrame implements ActionListener
          {                    
                  JLabel l1,l2;
                  JTextField tf1;
                  JPasswordField tf2;
                  JButton jb;
                   JButton logout,close;

               login()
                  {
                     l1 = new JLabel("Login Id:");
                     l2  = new JLabel("Password:");
                      tf1 = new JTextField(21);
                      tf2 = new JPasswordField(21);
                      jb = new JButton("Login");

                      jb.addActionListener(this);
                     
                        logout = new JButton("Log Out");
                           logout.addActionListener(this);
               
 close = new JButton("Close");
                           close.addActionListener(this);
                      
                   logout.setEnabled(false);
                   JPanel p1 = new JPanel();
                   JPanel p2  = new JPanel();
                   JPanel p3 = new JPanel();
                p1.add(l1);
                p1.add(tf1);
   
                p2.add(l2);
                p2.add(tf2);
          
               p3.add(jb);
               p3.add(logout);
                p3.add(close);


        getContentPane().setLayout(new GridLayout(3,1));
        getContentPane().add(p1);
           getContentPane().add(p2);
          getContentPane().add(p3);
                   }

              public  void actionPerformed( ActionEvent ae)
               {
  
    if  (  ae.getSource() == jb )
     {
                   if(tf1.getText().equals("admin") && tf2.getText().equals("admin"))
              {

JOptionPane.showMessageDialog(this,"Login Successful..","Login Status",JOptionPane.PLAIN_MESSAGE);                  
                                     logout.setEnabled(true);
                                      setVisible(false);
           
                  admin a = new admin();
                      a.show();
                       a.pack();

                    
              }
  else if(tf2.getText().equals(""))
        {
JOptionPane.showMessageDialog(this,"Password Not Entered..","Login Status",JOptionPane.WARNING_MESSAGE);
       }
       else
       {     
              tf2.setText("");
           logout.setEnabled(false);
            JOptionPane.showMessageDialog(this,"Password and User Name does not Match..","Update status",JOptionPane.WARNING_MESSAGE);
        }


}

    
  
 if(ae.getSource()==logout)
       {
JOptionPane.showMessageDialog(this,"Logged Out...","Logout Status",JOptionPane.PLAIN_MESSAGE);
            tf1.setText("");
             tf2.setText("");

        }
  if(ae.getSource()==close)
     { setVisible(false);}
              
        
   }

 public static void main(String args[])
      {
               login l = new login();
               l.show();
                l.pack();
     }
 }
 
                         
               
     
