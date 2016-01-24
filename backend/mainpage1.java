import  java.awt.*;
import  java.awt.event.*;
import javax.swing.*;


class  mainpage1  extends  Frame  implements ActionListener
{
   MenuBar  mb;
   Menu m1,m2,m3;
   MenuItem  mi1,mi2,mi3,mi4;
   ImageIcon i;
   JLabel l;
   

   

   mainpage1()
   {

        i = new  ImageIcon("img2.jpg");
        l= new JLabel(i);
        add(l);

        mb = new  MenuBar();
        m1 = new  Menu("Main Menu");
        m2 = new Menu("Search");
        m3 = new Menu("Report");
        mi1 = new  MenuItem("Search Student Details");
        mi1.addActionListener(this);
         mi2 = new MenuItem("Process");
           mi2.addActionListener(this);

        mi3 = new  MenuItem("Exit");
        mi3.addActionListener(this);
        mi4 = new MenuItem("View Alloted Group");
             mi4.addActionListener(this);
        m2.add(mi1);
        m1.add(mi2);
        m1.addSeparator();
        m1.add(mi3);
        m3.add(mi4);
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        setMenuBar( mb );
    }
     
  public  void  actionPerformed( ActionEvent  ae )
   {
      if  (ae.getSource() == mi1 )
         {
          //  setVisible(false);
            search  s = new  search();
            
            s.pack();
            s.show();
          }

      if  (ae.getSource() == mi3 )
         {
         setVisible(false);
         System.exit(0);
         } 

      if(ae.getSource()== mi4)
          {
             display d = new display();
             d.show();
             d.pack();
          }

      if  (ae.getSource() == mi2 )
         {
         //setVisible(false);
         login g= new login();
         g.show();
         g.pack();
         }
   }
  public  static  void  main(String  args[] )
   {
      mainpage1  m = new  mainpage1();
    
      m.pack();
    
      m.show();
   }
} 