import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;

public class JTableDatabase1 extends JFrame 
   {
          JTableDatabase1()
            {

            }




public static void main(String[] args)
    {


        Vector columnNames = new Vector();
        Vector data = new Vector();
        JPanel p=new JPanel();
        try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection con = DriverManager.getConnection("jdbc:odbc:students1");
                String sql = "Select * from complist";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery( sql );
                ResultSetMetaData md = rs.getMetaData();
                int columns = md.getColumnCount();
                for (int i = 1; i <= columns; i++) {
                columnNames.addElement( md.getColumnName(i) );
              }
          while (rs.next()) 
              {
                    Vector row = new Vector(columns);
                    for (int i = 1; i <= columns; i++)
                        {   row.addElement( rs.getObject(i) ); }
                    data.addElement( row );
             }
            rs.close();
           stmt.close();
         }
              catch(Exception e)
                   {System.out.println(e);}
JTable table = new JTable(data, columnNames);
TableColumn col;
        for (int i = 0; i < table.getColumnCount(); i++) 
           {
               col = table.getColumnModel().getColumn(i);
               col.setMaxWidth(250);
            }
JScrollPane scrollPane = new JScrollPane( table );
p.add( scrollPane );
JFrame f=new JFrame();
f.getContentPane().add(p);

f.setSize(600,400);
f.setVisible(true);
}

}