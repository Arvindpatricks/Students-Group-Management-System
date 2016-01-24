import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

   class separator

 {
      
     String name1,alloted1,no1;

      separator()
         {

    try{


            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection  conn=DriverManager.getConnection("jdbc:odbc:students1");
System.out.println("Connection  established");



            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection  conn1=DriverManager.getConnection("jdbc:odbc:students1");
System.out.println("Connection1  established");


Statement smt = conn.createStatement();
Statement smt1 = conn1.createStatement();


ResultSet rs = smt.executeQuery("select * from studtable where alloted='Biology' ");

while(rs.next())
  {
     String name1=rs.getString("sname");
     String alloted1 =rs.getString("alloted");
     String no1 = rs.getString("regno");

String bio = "insert into biolist(sname,regno) values('"+name1+"',"+no1+")";
System.out.println(bio);
smt1.executeUpdate(bio);
  
  }


Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection  conn2=DriverManager.getConnection("jdbc:odbc:students1");
System.out.println("Connection2  established");



            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection  conn3=DriverManager.getConnection("jdbc:odbc:students1");
System.out.println("Connection3  established");


Statement smt2 = conn2.createStatement();
Statement smt3 = conn3.createStatement();


ResultSet rs1 = smt2.executeQuery("select * from studtable where alloted='Comp. Science' ");

while(rs1.next())
  {
     String name1=rs1.getString("sname");
     String alloted1 =rs1.getString("alloted");
     String no1 = rs1.getString("regno");

String comp = "insert into complist(sname,regno) values('"+name1+"',"+no1+")";
System.out.println(comp);
smt3.executeUpdate(comp);
  
  }


Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection  conn4=DriverManager.getConnection("jdbc:odbc:students1");
System.out.println("Connection4  established");



            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection  conn5=DriverManager.getConnection("jdbc:odbc:students1");
System.out.println("Connection5  established");


Statement smt4 = conn4.createStatement();
Statement smt5 = conn5.createStatement();


ResultSet rs2 = smt4.executeQuery("select * from studtable where alloted='Commerce' ");

while(rs2.next())
  {
     String name1=rs2.getString("sname");
     String alloted1 =rs2.getString("alloted");
     String no1 = rs2.getString("regno");

String com = "insert into comlist(sname,regno) values('"+name1+"',"+no1+")";
System.out.println(com);
smt5.executeUpdate(com);
  
  }

rs.close();
conn.close();
conn1.close();
rs1.close();
conn2.close();
conn3.close();
rs2.close();
conn4.close();
conn5.close();

}catch(ClassNotFoundException  ce)
  {  System.out.println("Driver not loaded");}
  catch(SQLException  se)
   {  System.out.println(se);}

         }

 


public static void main(String args[])
  {
      separator s =new separator();

  }

}

