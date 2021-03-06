import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.io.*;
import javax.swing.table.*;


class ExcelExporter {
     public ExcelExporter() {}

 public void exportTable(JTable table, File file) throws IOException 
{
  TableModel model = table.getModel();
  FileWriter out = new FileWriter(file);

  for(int i=0; i < model.getColumnCount();i++) {
   out.write(model.getColumnName(i)+"\t");
 }
 out.write("\n");

 for(int i=0; i < model.getRowCount();i++){
  for(int j=0;j < model.getColumnCount();j++){
//   I added this check for the ISBN conversion
   if(j==0) {
//    the book Title
    out.write(model.getValueAt(i,j).toString() + "\t");
   } else {
/*
the ISBN Number
Note that I added a \" to the front of the string
and a \t followed by a closing \" to let Excel know
that this field is to be converted as text
     */
    out.write("\""+model.getValueAt(i, j).toString()+"\t"+"\"");
   }
  }
  out.write("\n");
 }
 out.close();
 System.out.println("write to " + file);
}
}
class ExcelOpener {
 public ExcelOpener() {}
 public void openTable(File file) throws IOException {
  Runtime run = Runtime.getRuntime();
//  I make the assumption that the client has Excel and
//  the file type .XLS is associated with Excel

//  This is a simple check to find out the operating system
  String lcOSName = System.getProperty("os.name").toLowerCase();
  boolean MAC_OS_X = lcOSName.startsWith("mac os x");
  if(MAC_OS_X){
   run.exec("open "+ file);
  } else {
   run.exec("cmd.exe /c start " + file);
  }
  System.out.println(file + " opened");
 }
}