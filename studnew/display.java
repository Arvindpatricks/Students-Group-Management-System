import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

   class  display extends JFrame implements actionListener
     {

        display()
         {
           try{
  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 COnnection conn= DriverManager.getConnection("jdbc:odbc:students1");
Sytem.out.println("COnnection Established");
Statement smt = conn.createStatement();

ResultSet rs = smt.executeQuery("select seatava from seats where dept='bio'");
if(rs.next())
  j= rs.getInt(1);
for(

rs.close();

 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 COnnection conn1= DriverManager.getConnection("jdbc:odbc:students1");
Sytem.out.println("COnnection1 Established");
Statement smt1 = conn1.createStatement();

ResultSet rs1 = smt.executeQuery("select * from biolist");



while (rs.next())
   {
       JLabel
     