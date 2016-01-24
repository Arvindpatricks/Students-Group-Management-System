# Students Group Management System

#Description
 Students group Management System is a JAVA based desktop application that is developed to automate the processing of examination data and allocate the groups for their higher studies according to their preferences and cut-off marks.



#Install Notes


Right Click on the downloaded folder named “Project”
And select Extract here.
All the folders will be extracted to the current location.
Now copy the folders as mentioned below.

Installing java

Copy the “ j2sdk1.4.2_04 “  folder to   C:\Program Files\
Enter sysdm.cpl  in the  run command.
Select the Advanced tab and select Environment Variables.
Select NEW button
Variable Name : path	
Variable Value:  C:\Program Files\j2sdk1.4.2_04\bin;
Click ok.
Again click NEW button.
Variable Name : lib
Variable Value : C:\Program Files\j2sdk1.4.2_04\lib;,;
Click ok.
Click Apply.
Enter cmd in the run command .
Enter javac in the command prompt.
Java is successfully installed.



Automatic Admission Software
Copy Backend and Frontend folders to any local drive.
Eg : C:\\Program Files\backend
  C:\\Program Files\frontend
Creating a DSN(Data Source Name)
      Go to control Panel 
      Double click Administrative tools


Select ODBC ( Data Source Name)

        
       Click the Add button

        Select the Microsoft Access Database Driver (accdb)

       Enter the Data Source name as “students1”

     

  Click the Select button

        Select the backend folder (Eg: C:\\Program Files\Backend\)
        Select the “students.accdb” file.
        Click OK button to save.
      Now the DSN is successfully created.
Next is creating shortcuts to run the Software
       Right click on the desktop, New ->Shortcut and select the C:\studnew\frontend\frontend.bat and save it as Students.
      Right click on the desktop, New ->Shortcut and select the C:\studnew\backend\backend.bat. and save it as Administrator.
      Right click on the shortcuts created and select Properties and select Minimized in the Run of the Shortcut tab.
Now the Software is successfully installed.




