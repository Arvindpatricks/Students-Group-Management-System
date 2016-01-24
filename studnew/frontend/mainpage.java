import  java.awt.*;
import  java.awt.event.*;
import javax.swing.*;


class  mainpage  extends  Frame  implements ActionListener
{
   MenuBar  mb;
   Menu m1;
   MenuItem  mi1,mi3;
   ImageIcon i;
   JLabel l;
   

   

   mainpage()
   {

        i = new  ImageIcon("img2.jpg");
        l= new JLabel(i);
        add(l);

        mb = new  MenuBar();
        m1 = new  Menu("Main Menu");
        mi1 = new  MenuItem("Add Student Details");
        mi1.addActionListener(this);

        mi3 = new  MenuItem("Exit");
        mi3.addActionListener(this);
        m1.add(mi1);

        m1.addSeparator();
        m1.add(mi3);
        mb.add(m1);
        setMenuBar( mb );
    }
     
  public  void  actionPerformed( ActionEvent  ae )
   {
      if  (ae.getSource() == mi1 )
         {
          //  setVisible(false);
            students1  s = new  students1();
            
            s.pack();
            s.show();
          }

      if  (ae.getSource() == mi3 )
         {
         setVisible(false);
         System.exit(0);
         }
   }
  public  static  void  main(String  args[] )
   {
      mainpage  m = new  mainpage();
    
      m.pack();
    
      m.show();
   }
} 