import   java.awt.*;
import   java.awt.event.*;
import  javax.swing.*;
import  java.sql.*;

class  search  extends  JFrame  implements ActionListener
{
   JLabel  l1,l2,l3,l4,l5,l6,l7,l8;
   JLabel l31,l32,l33;
   JTextField  tf1, tf2, tf3, tf4,tf5,tf6;
   
   JButton close,search,update,delete;
   JComboBox caste,religion;
   Choice first,second,third;

  search()
   {

first = new Choice();
         first.add("Comp. Science");
         first.add("Biology");
         first.add("Commerce");

second = new Choice();
          second.add("Comp. Science");
          second.add("Biology");
          second.add("Commerce");

 third = new Choice();
         third.add("Comp. Science");
         third.add("Biology");
         third.add("Commerce");

     l1 = new  JLabel("Reg no:");
     l2 = new  JLabel("Name:");
     l3 = new  JLabel("Marks Obtained:");
      

    l31 = new JLabel("Choose 1st Choice");
    l32 = new JLabel("Choose 2nd Choice");
    l33 = new JLabel("Choose 3rd Choice");
      
     l4 = new  JLabel("Caste:");
     l5 = new  JLabel("Religion:");
     l6 = new  JLabel("Address:");
     l7 = new  JLabel("Landline no:");
     l8 = new  JLabel("Mobile");

     tf1 = new  JTextField(30);
     tf2 = new  JTextField(30);
     tf3 = new  JTextField(30);
     tf4 = new  JTextField(30);
     tf5 = new  JTextField(30);
     tf6 = new  JTextField(30);

 
    
 String n[] = {"OBC","MBC","SC","OC"};
       caste = new JComboBox(n);
   

String r[] = { "Hindu","Christian","Muslim"};
    religion = new JComboBox(r);


    search = new JButton("Search");
    update = new JButton("Update");
    delete = new JButton("Delete");
    update.setEnabled(false);
    delete.setEnabled(false);

    JPanel  p1 = new  JPanel();
    JPanel  p2 = new  JPanel();
    JPanel  p3 = new  JPanel();
    JPanel  p31 = new JPanel();
    JPanel  p32 = new JPanel();
     JPanel  p33 = new JPanel();
    JPanel  p4 = new  JPanel();
    JPanel  p5 = new  JPanel();
    JPanel  p6 = new  JPanel();
    JPanel  p7 = new  JPanel();
    JPanel  p8 = new  JPanel();
    JPanel  p9 = new  JPanel();


close= new JButton("Close");
close.addActionListener(this);

    search.addActionListener(this);
    update.addActionListener(this);
    delete.addActionListener(this);


    p1.add(l1);
    p1.add(tf1);
    p1.add(search);

    p2.add(l2);
    p2.add(tf2);

    p3.add(l3);
    p3.add(tf3);


   p31.add(l31);
   p31.add(first);

   p32.add(l32);
   p32.add(second);
 
   p33.add(l33);
   p33.add(third);
    p4.add(l4);
    p4.add(caste);

    p5.add(l5);
    p5.add(religion);

    p6.add(l6);
    p6.add(tf4);

    p7.add(l7);
    p7.add(tf5);

    p8.add(l8);
    p8.add(tf6);

    
    p9.add(close);
    p9.add(update);
    p9.add(delete);

    getContentPane().setLayout( new  GridLayout(12,1));
    getContentPane().add(p1);
    getContentPane().add(p2);
    getContentPane().add(p3);
    getContentPane().add(p31);
    getContentPane().add(p32);
    getContentPane().add(p33);  
    getContentPane().add(p4);
    getContentPane().add(p5);
    getContentPane().add(p6);
    getContentPane().add(p7);
    getContentPane().add(p8);
    getContentPane().add(p9);
     }

public  void  actionPerformed(  ActionEvent  ae )
   {
  try {
  
       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection  conn =DriverManager.getConnection("jdbc:odbc:students1");
System.out.println("Connection  established");
Statement  smt = conn.createStatement();

if(ae.getSource() ==close)
  { 
     setVisible(false); 
     mainpage1 k = new mainpage1();
      k.pack();
       k.show();
   }
    if  (  ae.getSource() == search )
     {
ResultSet  rs = smt.executeQuery("select  * from studtable  where  regno=" + tf1.getText());
if  (  rs.next())
  {
         update.setEnabled(true);
         delete.setEnabled(true);
         tf2.setText( rs.getString("sname") );
         tf3.setText( ""+rs.getInt("marks"));
       
String nn = rs.getString("caste");
          String  de[] = {"OBC","MBC","SC","OC"};
          int i=0;
          for(;i<de.length;i++)
            {
                if  (  nn.equals( de[i] ) )
                   break;
            }
                   
          caste.setSelectedIndex(i); 

         String re = rs.getString("religion");
         String e[] ={"Hindu","Christian","Muslim"};
          int j=0;
             for(;j<e.length;j++)
              {
                   if(re.equals(e[j]))
                       break;
               }

          religion.setSelectedIndex(j);


String abcd = rs.getString("first");
String efgh = rs.getString("second");
String ijkl = rs.getString("third");

 if(abcd.equals("Biology"))
      first.select("Biology");
else if(abcd.equals("Comp. Science"))
      first.select("Comp. Science");
else if(abcd.equals("Commerce"))
      first.select("Commerce");


 if(efgh.equals("Biology"))
     second.select("Biology");
else if(efgh.equals("Comp. Science"))
      second.select("Comp. Science");
else if(efgh.equals("Commerce"))
      second.select("Commerce");



 if(ijkl.equals("Biology"))
     third.select("Biology");
else if(ijkl.equals("Comp. Science"))
      third.select("Comp. Science");
else if(ijkl.equals("Commerce"))
      third.select("Commerce");




        tf4.setText( rs.getString("address") );
        tf5.setText( rs.getString("landline") );
        tf6.setText( rs.getString("mobile") );

}
else

  {
 JOptionPane.showMessageDialog(this,"Search Reg not Found..","Update status",JOptionPane.ERROR_MESSAGE);
  }
     
}




  if(ae.getSource()==update)
   {
String  upcmd = "update  studtable set  sname='" + tf2.getText() + "' ,marks=" + tf3.getText() +" , caste ='" +caste.getSelectedItem()+"',religion='"+religion.getSelectedItem()+"',address='"+tf4.getText()+"',landline="+tf5.getText()+",mobile="+tf6.getText()+" where  regno ="+ tf1.getText() ;
     System.out.println("update command ="+upcmd);
     smt.executeUpdate(upcmd);
     conn.close();
  JOptionPane.showMessageDialog(this,"Students details updated..","Update status",JOptionPane.PLAIN_MESSAGE);




   }

else if ( ae.getSource() == delete )
  {
         smt.executeUpdate("delete  from studtable  where  regno = "+tf1.getText());
  JOptionPane.showMessageDialog(this,"Students details deleted..","Delete status",JOptionPane.PLAIN_MESSAGE);
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
        tf4.setText("");
        tf5.setText("");
        tf6.setText("");
  }
}catch(ClassNotFoundException  ce)
  {  System.out.println("Driver not loaded");}
  catch(SQLException  se)
   {  System.out.println(se);}
  
    
}

public  static  void  main(  String  args[] )
 {
   search  s = new  search();
   s.pack();
   s.show();
  }
}