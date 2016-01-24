import java.io.*;
import java.sql.*;

   class  runner
      { int i,j;
           runner()
              {
                 try{
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection  conn=DriverManager.getConnection("jdbc:odbc:students1");
System.out.println("Connection  established"); 
Statement  smt = conn.createStatement();
ResultSet  rs = smt.executeQuery("select seatava  from seats where dept = 'total'" );
    if(rs.next())
       j = rs.getInt(1);
       
     rs.close();
                    for( i=1;i<=j;i++)
                     {
                          bio b =  new bio();
                      }
         
                    }catch(ClassNotFoundException  ce)
  {  System.out.println("Driver not loaded");}
  catch(SQLException  se)
   {  System.out.println(se);}

    }
       
  public static void main(String args[])
    {
           runner r = new runner();
   }

}
