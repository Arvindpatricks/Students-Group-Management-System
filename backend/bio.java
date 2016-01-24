import java.sql.*;
import java.io.*;

class  bio
    {
          int bcount,compcount,ccount;

          bio()
           {
                 try {

       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection  conn=DriverManager.getConnection("jdbc:odbc:students1");
System.out.println("Connection  established");
Connection  conn1=DriverManager.getConnection("jdbc:odbc:students1");
System.out.println("Connection1  established");
Connection  conn2 =DriverManager.getConnection("jdbc:odbc:students1");
System.out.println("Connection2  established");
Connection  conn3 =DriverManager.getConnection("jdbc:odbc:students1");
System.out.println("Connection3  established");
Connection  conn4 =DriverManager.getConnection("jdbc:odbc:students1");
System.out.println("Connection4  established");
Connection  conn5 =DriverManager.getConnection("jdbc:odbc:students1");
System.out.println("Connection5  established");
Connection  conn6 =DriverManager.getConnection("jdbc:odbc:students1");
System.out.println("Connection6  established");
Connection  conn7=DriverManager.getConnection("jdbc:odbc:students1");
System.out.println("Connection7  established");

Statement  smt = conn.createStatement();
Statement  smt1 = conn1.createStatement();
Statement  smt2 = conn2.createStatement();
Statement  smt3 = conn3.createStatement();
Statement  smt4 = conn4.createStatement();
Statement  smt5 = conn5.createStatement();
Statement  smt6 = conn6.createStatement();
Statement  smt7 = conn7.createStatement();

ResultSet  rs = smt.executeQuery("select  *  from studtable  where alloted is null " );
ResultSet  rs1 = smt2.executeQuery("select seatava  from seats where dept = 'Biology'" );
ResultSet  rs2 = smt4.executeQuery("select seatava  from seats where dept = 'Comp. Science'" );
ResultSet  rs3 = smt5.executeQuery("select seatava  from seats where dept = 'Commerce'" );

if  (rs1.next())
    bcount = rs1.getInt(1);
System.out.println(" BIO count:"+bcount);

rs1.close();



if  (rs2.next())
    compcount = rs2.getInt(1);
System.out.println(" Comp count:"+compcount);

rs2.close();



if  (rs3.next())
    ccount = rs3.getInt(1);
System.out.println(" Commerce count:"+ccount);

rs3.close();



while(rs.next())
  {


   {
String a = rs.getString("first");
String b = rs.getString ("second");
String c = rs.getString("third");



 if(a.equals("Biology")&& bcount>0 )
    {
 bcount--;
String  avabio = "update  seats set  seatava ="+bcount+" where dept = 'Biology'";
     System.out.println("update command ="+ avabio);
     smt3.executeUpdate( avabio);


String  allotbio= "update  studtable set  alloted ='"+a+"' where marks="+rs.getString("marks") ;
     System.out.println("update command ="+allotbio);
     smt1.executeUpdate(allotbio);
      break;
  }



 else if(a.equals("Comp. Science")&& compcount>0 )
    {
 compcount--;
String  avacomp = "update  seats set  seatava ="+compcount+" where dept = 'Comp. Science'";
     System.out.println("update command ="+avacomp);
     smt6.executeUpdate(avacomp);


String  allotcomp = "update  studtable set  alloted ='"+a+"' where marks="+rs.getString("marks") ;
     System.out.println("update command ="+allotcomp);
     smt4.executeUpdate(allotcomp);
    break;

  }



 else if(a.equals("Commerce")&& ccount>0 )
    {
 ccount--;
String  avacom = "update  seats set  seatava ="+ccount+" where dept = 'Commerce'";
     System.out.println("update command ="+avacom);
     smt7.executeUpdate(avacom);


String  allotcom = "update  studtable set  alloted ='"+a+"' where marks="+rs.getString("marks") ;
     System.out.println("update command ="+allotcom);
     smt5.executeUpdate(allotcom);
 break;
 }



 else if(b.equals("Biology")&& bcount>0 )
  {
bcount--;
String  avabio = "update  seats set  seatava ="+bcount+" where dept = 'Biology'";
     System.out.println("update command ="+ avabio);
     smt3.executeUpdate( avabio);


String  allotbio= "update  studtable set  alloted ='"+b+"' where marks="+rs.getString("marks") ;
     System.out.println("update command ="+allotbio);
     smt1.executeUpdate(allotbio);
break;

   }



 else if(b.equals("Comp. Science")&& compcount>0 )
  {
compcount--;
String  avacomp = "update  seats set  seatava ="+compcount+" where dept = 'Comp. Science'";
     System.out.println("update command ="+avacomp);
     smt6.executeUpdate(avacomp);


String  allotcomp = "update  studtable set  alloted ='"+b+"' where marks="+rs.getString("marks") ;
     System.out.println("update command ="+allotcomp);
     smt4.executeUpdate(allotcomp);
break;

   }



else if(b.equals("Commerce") && ccount>0 )
   {
      ccount--;
String  avacom = "update  seats set  seatava ="+ccount+" where dept = 'Commerce'";
     System.out.println("update command ="+avacom);
     smt7.executeUpdate(avacom);


String  allotcom = "update  studtable set  alloted ='"+b+"' where marks="+rs.getString("marks") ;
     System.out.println("update command ="+allotcom);
     smt5.executeUpdate(allotcom);
break;

    }



//put statement here... else if..

  else  if(c.equals("Biology")&& bcount>0 )
    {
 bcount--;
String  avabio = "update  seats set  seatava ="+bcount+" where dept = 'Biology'";
     System.out.println("update command ="+ avabio);
     smt3.executeUpdate( avabio);


String  allotbio= "update  studtable set  alloted ='"+c+"' where marks="+rs.getString("marks") ;
     System.out.println("update command ="+allotbio);
     smt1.executeUpdate(allotbio);
break;

  }




 else if(c.equals("Comp. Science")&& compcount>0)
    {
 compcount--;
String  avacomp = "update  seats set  seatava ="+compcount+" where dept = 'Comp. Science'";
     System.out.println("update command ="+avacomp);
     smt6.executeUpdate(avacomp);


String  allotcomp = "update  studtable set  alloted ='"+c+"' where marks="+rs.getString("marks") ;
     System.out.println("update command ="+allotcomp);
     smt4.executeUpdate(allotcomp);
break;


  }




 else if(c.equals("Commerce")&& ccount>0 )
    {
 ccount--;
String  avacom = "update  seats set  seatava ="+ccount+" where dept = 'Commerce'";
     System.out.println("update command ="+avacom);
     smt7.executeUpdate(avacom);


String  allotcom = "update  studtable set  alloted ='"+c+"' where marks="+rs.getString("marks") ;
     System.out.println("update command ="+allotcom);
     smt5.executeUpdate(allotcom);
break;

  }
}

}
rs.close();
 conn.close();
 conn1.close();
 conn2.close();
 conn3.close();
 conn4.close();
 conn5.close();
 conn6.close();
 conn7.close();



    }catch(ClassNotFoundException  ce)
  {  System.out.println("Driver not loaded");}
  catch(SQLException  se)
   {  System.out.println(se);}


  }

public static void main(String args[])
  {

        bio b = new bio();
       try{ Runtime.getRuntime().exec("cmd /c start separate.bat");
       }catch(IOException io)
          {
              System.out.println(io);
          }
}

}
