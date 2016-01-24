import java.io.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

    class   admin extends JFrame implements ActionListener
       {
                      JLabel l1,l2,l3,l4;
                      JTextField tf1,tf2,tf3,tf4;
                      JButton b1,b2,b3;
              
               admin()
                  {
                      
                     l1 = new JLabel("Enter no of Computer Science Seats");
                     l2 = new JLabel("Enter no of Biology Seats");
                     l3 = new JLabel("Enter no of Commerce Seats");
                     l4 = new JLabel("Enter total no of Seats");

                     tf1 = new JTextField(5);
                     tf2 = new JTextField(5);
                     tf3 = new JTextField(5);
                     tf4 = new JTextField(5);

                     b1 = new JButton("Save");
                     b2 = new JButton("Process");
                     b3 = new JButton("Close");
                     b1.addActionListener(this);
                     b2.addActionListener(this);
                     b3.addActionListener(this);
             
                     JPanel p1 = new JPanel();
                     JPanel p2 = new JPanel();
                     JPanel p3 = new JPanel();
                     JPanel p4 = new JPanel();
                     JPanel p5 = new JPanel();

       p1.add(l1);
       p1.add(tf1);

       p2.add(l2);
       p2.add(tf2);

       p3.add(l3);
       p3.add(tf3);

       p4.add(l4);
       p4.add(tf4);

       p5.add(b1);
       p5.add(b2);
       p5.add(b3);
    
        getContentPane().setLayout( new  GridLayout(5,1));

       getContentPane().add(p1);
       getContentPane().add(p2);
       getContentPane().add(p3);
       getContentPane().add(p4);
       getContentPane().add(p5);            


   }

     public  void  actionPerformed(  ActionEvent  ae )
 {
        if(ae.getSource()==b1)
        { 
if(tf1.getText().equals("") ||tf2.getText().equals("") || tf3.getText().equals("") || tf4.getText().equals("") )
    {  JOptionPane.showMessageDialog(this,"Values Missing..","Update status",JOptionPane.WARNING_MESSAGE);   }
  else
   {
       int comp = Integer.parseInt(tf1.getText());
       int bio = Integer.parseInt(tf2.getText());
       int com = Integer.parseInt(tf3.getText());
       int tot = Integer.parseInt(tf4.getText());

        try{
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection  conn=DriverManager.getConnection("jdbc:odbc:students1");
System.out.println("Connection  established"); 
Statement  smt = conn.createStatement();

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection  conn1=DriverManager.getConnection("jdbc:odbc:students1");
System.out.println("Connection1  established"); 
Statement  smt1 = conn1.createStatement();

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection  conn2=DriverManager.getConnection("jdbc:odbc:students1");
System.out.println("Connection2  established"); 
Statement  smt2 = conn2.createStatement();

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection  conn3=DriverManager.getConnection("jdbc:odbc:students1");
System.out.println("Connection3  established"); 
Statement  smt3= conn3.createStatement();

String  up1 = "update  seats set  seatava="+bio+" where Dept = 'Biology'";
 smt.executeUpdate( up1);

String  up2 = "update  seats set  seatava="+comp+" where Dept = 'Comp. Science'";
 smt1.executeUpdate( up2);

String  up3 = "update  seats set  seatava="+com+" where Dept = 'Commerce'";
 smt2.executeUpdate( up3);

String  up4 = "update  seats set  seatava="+tot+" where Dept = 'total'";
 smt3.executeUpdate( up4);

conn.close();
 conn1.close();
 conn2.close();
 conn3.close();
    }catch(ClassNotFoundException  ce)
  {  System.out.println("Driver not loaded");}
  catch(SQLException  se)
   {  System.out.println(se);}
    
JOptionPane.showMessageDialog(this,"No of Seats Updated..","Update status",JOptionPane.PLAIN_MESSAGE);
}
   }//end of if

   if(ae.getSource()==b2)
     {
          runner r = new runner();
JOptionPane.showMessageDialog(this,"Processing....Wait Patiently..","Processing status",JOptionPane.PLAIN_MESSAGE);  
JOptionPane.showMessageDialog(this,"Processing Finished....","Processing status",JOptionPane.PLAIN_MESSAGE);     
      
     }

    if(ae.getSource()==b3)
     {
         setVisible(false);
         login o = new login();
         o.show();
         o.pack();
       
     }

 }//end of actionperformed

 public static void main(String args[])
     {
             admin ad = new admin();
             ad.show(); 
              ad.pack();
      }

  }