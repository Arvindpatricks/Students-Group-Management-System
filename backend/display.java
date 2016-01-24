import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

    class display extends JFrame implements ActionListener
      {
            
             JLabel l1;
             Choice a;
             JButton submit;    
            
         display()
          {
           
             l1= new JLabel("Select a Group:");
             a= new Choice();
                  a.add("Biology");
                  a.add("Comp. Science");
                  a.add("Commerce");
             
              submit = new JButton("SUBMIT");
              submit.addActionListener(this);
 
            JPanel p1 = new JPanel();
            JPanel p2 = new JPanel();
 
             p1.add(l1);
             p1.add(a);
             p2.add(submit);

               getContentPane().setLayout(new GridLayout(2,1));
               getContentPane().add(p1);
               getContentPane().add(p2);

           }

 public void actionPerformed(ActionEvent ae)
          
      {
           if(ae.getSource()==submit)
              {
                 String sel = a.getSelectedItem();
                
                if(sel.equals("Biology"))
                  {
               try{  
                Runtime.getRuntime().exec("build.bat");
                }catch(Exception e)
                    {System.out.println(e);}
                   }
             
                if(sel.equals("Comp. Science"))
                  {
                 try{  
                Runtime.getRuntime().exec("build1.bat");
                }catch(Exception e)
                    {System.out.println(e);}

                    }

                if(sel.equals("Commerce"))
                   {
                try{  
                Runtime.getRuntime().exec("build2.bat");
                }catch(Exception e)
                    {System.out.println(e);}


                    }

              }

      }


     public static void main(String args[]) 
        {
             display d = new display();
              d.pack();
              d.show();
        }

  }
           
