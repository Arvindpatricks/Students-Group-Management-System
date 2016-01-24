import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.print.*;
import javax.swing.table.*;
import java.io.*;

public class JTableDatabase extends JFrame implements ActionListener
   {
String file = "D:/newfile.xls";
JButton b;
 JPanel p;
JTable table;
ExcelExporter exp;
            JTableDatabase()
              {

              b= new JButton("Print");
              b.addActionListener(this);

        Vector columnNames = new Vector();
        Vector data = new Vector();
       /* JPanel */ p=new JPanel();
        try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection con = DriverManager.getConnection("jdbc:odbc:students1");
                String sql = "Select * from biolist";
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
 table = new JTable(data, columnNames);
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
p.add(b);

f.setSize(600,400);
f.setVisible(true);


   }

    public void toExcel(JTable table, File file){
		try{
			TableModel model = table.getModel();
			FileWriter excel = new FileWriter(file);

			for(int i = 0; i < model.getColumnCount(); i++){
				excel.write(model.getColumnName(i) + "\t");
			}

			excel.write("\n");

			for(int i=0; i< model.getRowCount(); i++) {
				for(int j=0; j < model.getColumnCount(); j++) {
					excel.write(model.getValueAt(i,j).toString()+"\t");
				}
				excel.write("\n");
			}

			excel.close();
		}catch(IOException e){ System.out.println(e); }
	}
public void  actionPerformed(ActionEvent ae)
  {
     if(ae.getSource()==b)
        {
          toExcel(table, new File(file));
 JOptionPane.showMessageDialog(this,"Exported to excel..","Login Status",JOptionPane.PLAIN_MESSAGE); 
try{  
                Runtime.getRuntime().exec("open.bat");
                }catch(Exception e)
                    {System.out.println(e);}
                   }
       }
  

public static void main(String[] args)
    {
         JTableDatabase j = new JTableDatabase();
         
    }
}