


import  java.sql.*;
import  javax.swing.*;
import  java.awt.event.*;
import  java.awt.*;

class  students1  extends  JFrame  implements ActionListener,ItemListener
{
   JLabel  l1,l2,l3,l4,l5,l6,l7,l8,l9;
   JLabel l31,l32,l33;
    JLabel l311,l322,l333;
   JTextField  tf1, tf2, tf3, tf4,tf5,tf6;
   JTextField f1,f2,f3;
   Choice  caste,religion;
   JButton  jb,close;
   Choice first,second,third;
   int alloted=0;


  students1()
  {

     first = new Choice();
         first.add("Comp. Science");
         first.add("Biology");
         first.add("Commerce");
    first.addItemListener(this);

    second = new Choice();
          second.add("Comp. Science");
          second.add("Biology");
          second.add("Commerce");
     second.addItemListener(this);

   third = new Choice();
         third.add("Comp. Science");
         third.add("Biology");
         third.add("Commerce");
    third.addItemListener(this);


     l1 = new  JLabel("Reg no:");
     l2 = new  JLabel("Name:");
     l3 = new  JLabel("Marks Obtained:");
        l311 = new JLabel("Mathematics Marks");
        l322 = new JLabel("Science Marks");
        l333 = new JLabel("Social Marks");


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

      f1 = new JTextField(10);
      f2 = new JTextField(10);
      f3 = new JTextField(10);


caste =  new Choice();

       caste.add("OBC");
       caste.add("MBC");
       caste.add("SC");
       caste.add("OC");



    religion = new  Choice();
    religion.add("Hindu");
    religion.add("Christian");
    religion.add("Muslim");


    ImageIcon  im = new  ImageIcon("mmc.gif");
    jb = new  JButton("Save");
    jb.addActionListener(this);

close= new JButton("Close");
close.addActionListener(this);

    JPanel  p1 = new  JPanel();
    JPanel  p2 = new  JPanel();
    JPanel  p3 = new  JPanel();
    JPanel p3a = new JPanel();
    JPanel p3b = new JPanel();
    JPanel p3c = new JPanel();
    JPanel  p31 = new JPanel();
    JPanel  p32 = new JPanel();
     JPanel  p33 = new JPanel();
    JPanel  p4 = new  JPanel();
    JPanel  p5 = new  JPanel();
    JPanel  p6 = new  JPanel();
    JPanel  p7 = new  JPanel();
    JPanel  p8 = new  JPanel();
    JPanel  p9 = new  JPanel();

    p1.add(l1);
    p1.add(tf1);

    p2.add(l2);
    p2.add(tf2);

    p3.add(l3);
    p3.add(tf3);

     p3a.add(l311);
     p3a.add(f1);

    p3b.add(l322);
    p3b.add(f2);

   p3c.add(l333);
   p3c.add(f3);


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

    p9.add(jb);
    p9.add(close);

    getContentPane().setLayout( new  GridLayout(15,1));
    getContentPane().add(p1);
    getContentPane().add(p2);
    getContentPane().add(p3);
    getContentPane().add(p3a);
    getContentPane().add(p3b);
    getContentPane().add(p3c);
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

public  void  actionPerformed(ActionEvent  ae)
{



    if(ae.getSource()==jb)

  {


     int  reg =    Integer.parseInt(tf1.getText());
     String  name =  tf2.getText();
     double marks =   Integer.parseInt(tf3.getText());
     String  caste1 = caste.getSelectedItem();
     String  religion1 = religion.getSelectedItem();
     String  add = tf4.getText();
     int  ll =  Integer.parseInt(tf5.getText());
     int mobile = Integer.parseInt( tf6.getText());
     String first1 = first.getSelectedItem();
     String second2 = second.getSelectedItem();
     String third3 = third.getSelectedItem();
     int maths = Integer.parseInt(f1.getText());
     int sci = Integer.parseInt(f2.getText());
     int soc = Integer.parseInt(f3.getText());
     try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection  conn =DriverManager.getConnection("jdbc:odbc:students1");
System.out.println("Connection  established");
Statement  smt = conn.createStatement();

ResultSet  rs = smt.executeQuery("select  * from studtable  where  regno=" + reg);

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection  conn1 =DriverManager.getConnection("jdbc:odbc:students1");
System.out.println("Connection1  established");
Statement  smt1 = conn1.createStatement();

ResultSet  rs1 = smt1.executeQuery("select  * from studtable  where  marks=" + marks);



if  (rs.next())
JOptionPane.showMessageDialog(this,"Student Reg no  already exist..","Insert status",JOptionPane.PLAIN_MESSAGE);
else  if(rs1.next())
  {
int smaths = rs1.getInt("mathematics");
  int sscience = rs1.getInt("science");
  int ssocial = rs1.getInt("social");



         if(maths > smaths)
               marks = marks + 0.1;
         else
               marks = marks -0.1;

         if(sci  >sscience)
               marks = marks +0.1;
        else
                marks = marks -0.1;

        if(soc >ssocial)
              marks = marks +0.1;
        else
              marks = marks -0.1;

       rs.close();
String  query = "insert  into  studtable(regno,marks,sname,first,second,third,caste,religion,address,landline,mobile,mathematics,science,social)  values("+reg+","+marks+",'"+name+"','"+first1+"','"+second2+"','"+third3+"','"+caste1+"','"+religion1+"','"+add+"',"+ll+","+mobile+","+maths+","+sci+","+soc+")";
System.out.println(query);
smt.executeUpdate(query);
conn.close();
rs1.close();
conn1.close();
JOptionPane.showMessageDialog(this,"Record saved","Insert status",JOptionPane.PLAIN_MESSAGE);
JOptionPane.showMessageDialog(this,"Your total is "+marks,"Insert status",JOptionPane.PLAIN_MESSAGE);
  }
else
{
   rs.close();
String  query = "insert  into  studtable(regno,marks,sname,first,second,third,caste,religion,address,landline,mobile,mathematics,science,social)  values("+reg+","+marks+",'"+name+"','"+first1+"','"+second2+"','"+third3+"','"+caste1+"','"+religion1+"','"+add+"',"+ll+","+mobile+","+maths+","+sci+","+soc+")";
System.out.println(query);
smt.executeUpdate(query);
conn.close();
rs1.close();
conn1.close();
JOptionPane.showMessageDialog(this,"Record saved","Insert status",JOptionPane.PLAIN_MESSAGE);
}
}catch(ClassNotFoundException  ce)
  {  System.out.println("Driver not loaded");}
  catch(SQLException  se)
   {  System.out.println(se);}


}

  else if(ae.getSource()==close)
   {


setVisible(false);

   }

}

 public void itemStateChanged(ItemEvent ie)
  {

}


public  static  void  main(  String  args[] )
 {
    students1  i =  new  students1();
    i.pack();
    i.show();
 }
}

