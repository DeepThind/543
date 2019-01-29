/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduleme;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import static java.lang.System.in;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;
//import org.apache.derby.shared.common.reference.SQLState;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;  
import java.util.Calendar;
 
class ScheduleMe  
{
	private JLabel statusLabel;
          JMenu menu, submenu, submenu1, submenu2, submenu3;  
          JMenuItem i2, i3, i4, i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,i16; 
           JFrame f; 
          ScheduleMe()
		{  
           f= new JFrame("Schedule");  
          JMenuBar mb=new JMenuBar();  
          menu=new JMenu("ScheduleMe");  
          submenu=new JMenu("Account");  
	  submenu1=new JMenu("Appointment");
	  submenu2=new JMenu("Settings");
          submenu3=new JMenu("Help");

        // i1=new JMenuItem("Account");  
         i2=new JMenuItem("Appointment");  
          //i3=new JMenuItem("Settings");  
          i4=new JMenuItem("Help");  
          i5=new JMenuItem("CreateAccount");
	  i6=new JMenuItem("ChangeUsername");
	  i7=new JMenuItem("ChangePassword");
          i8=new JMenuItem("ModifyAccount");
	  i9=new JMenuItem("MakeAppointment");
	  i10=new JMenuItem("ChangeAppointment");
	  i11=new JMenuItem("CancelAppointment");
	  i12=new JMenuItem("SetCalenderType");
	  i13=new JMenuItem("SetColor");
          i14=new JMenuItem("FAQ");
	  i15=new JMenuItem("Online Chat");
	  i16=new JMenuItem("Contact us");
          

	submenu.add(i5); 
        submenu.add(i6);  	
        submenu.add(i7);
        submenu.add(i8);
	menu.add(submenu);
	
        submenu1.add(i9);
	submenu1.add(i10);
	submenu1.add(i11);
	menu.add(submenu1);
      
         
	submenu2.add(i12);
	submenu2.add(i13);
	menu.add(submenu2);
         
        submenu3.add(i14);
        submenu3.add(i15);  	
        submenu3.add(i16);
        menu.add(submenu3);  

        mb.add(menu);  
          
	MenuItemListener menuItemListener = new MenuItemListener();

      	i5.addActionListener(menuItemListener);
	i6.addActionListener(menuItemListener);
	i7.addActionListener(menuItemListener);
	i8.addActionListener(menuItemListener);
	i12.addActionListener(menuItemListener);
	f.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);}
         }); 
	 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          f.setJMenuBar(mb);  
          f.setSize(400,400);  
          f.setLayout(null);  
          f.setVisible(true);  
	
}  

public static void main(String args[])  throws ClassNotFoundException, SQLException 
{  
                    ScheduleMe scheduleMe = new ScheduleMe();  
}

class MenuItemListener implements ActionListener 
{
 public void actionPerformed(ActionEvent e) 
{           
         
	if(e.getActionCommand().equals("CreateAccount"))
	{
		 JPanel createAccountDialog = new JPanel();
		 createAccountDialog.setSize(400, 400);
                
                JLabel labelEmail = new JLabel("Email: ");
                JTextField textEmail = new JTextField(20);
                
                JLabel labelUsername = new JLabel("User Name: ");
                JTextField textUsername = new JTextField(20);
                
                JLabel labelPassword = new JLabel("Password: ");
                JPasswordField fieldPassword = new JPasswordField(20);
                
                JButton buttonCreateAcc = new JButton("Create Account");
                
                // create a new panel with GridBagLayout manager
                JPanel newPanel = new JPanel(new GridBagLayout());

                GridBagConstraints constraints = new GridBagConstraints();
                constraints.anchor = GridBagConstraints.WEST;
                constraints.insets = new Insets(10, 10, 10, 10);
         
                // add components to the panel
                constraints.gridx = 0;
                constraints.gridy = 0; 
                newPanel.add(labelEmail, constraints);
                
                constraints.gridx = 1;
                constraints.gridy = 0; 
                newPanel.add(textEmail, constraints);
                
                constraints.gridx = 0;
                constraints.gridy = 1;     
                newPanel.add(labelUsername, constraints);

                constraints.gridx = 1;
                constraints.gridy = 1;     
                newPanel.add(textUsername, constraints);

                constraints.gridx = 0;
                constraints.gridy = 2;     
                newPanel.add(labelPassword, constraints);

                constraints.gridx = 1;
                constraints.gridy = 2;     
                newPanel.add(fieldPassword, constraints);

                
                constraints.gridx = 0;
                constraints.gridy = 3;
                constraints.gridwidth = 2;
                constraints.anchor = GridBagConstraints.CENTER;
                
                createAccountDialog.setVisible(true);
                
                buttonCreateAcc.addActionListener(new ActionListener() {
            
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        System.out.println(textEmail.getText());
			  System.out.println(textUsername.getText());
		
       
       try{
       //2. load / register Driver Manager
             JOptionPane.showMessageDialog(f," User Name created.");
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            //3. establish connecction
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/JDBC","Project1","Project1");
             String sql =  "INSERT INTO userAccount( userName, password,email)VALUES(?,?,?) ";
                        PreparedStatement pstmt = null;
                        pstmt = conn.prepareStatement(sql);
                        
                        pstmt.setString(1, textUsername.getText());

                        //userInput3 = "Baby Soup2";
                        //System.out.println("\nEnter the BookTitle\nUser entered: " + userInput3);
                        pstmt.setString(2, fieldPassword.getText()); //B
                        pstmt.setString(3, textEmail.getText());
                        
                        int rowsaffected = pstmt.executeUpdate();
                        System.out.println("\nNumber of Rows Effected : " + (rowsaffected));
                        pstmt.close();
                        conn.close();
                        new ScheduleMe();
//                        //email = textEmail.getText();     
                    }
                   
                    catch(SQLException e)
                    {
                    }   catch (ClassNotFoundException ex) {
                            Logger.getLogger(ScheduleMe.class.getName()).log(Level.SEVERE, null, ex);
                        }
                      }
                    
                });
                newPanel.add(buttonCreateAcc, constraints);


                
                // add the panel to this frame
                createAccountDialog.add(newPanel);

                
                f.getContentPane().add(BorderLayout.CENTER, createAccountDialog);
                f.setVisible(true);
                

            
        

	}//IF STATMENT CREATE ACCOUNT

	else if(e.getActionCommand().equals("ChangeUsername") )
	{     
                System.out.println("Usename changed");
                
                JPanel createAccountDialog = new JPanel();
              //createAccountDialog.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                createAccountDialog.setSize(400, 400);
                
                JLabel labelOldUsername = new JLabel("Old Username");
                JTextField textOldUsername = new JTextField(20);
                
                JLabel labelNewUsername = new JLabel("New Username: ");
                JTextField textNewUsername = new JTextField(20);
                
                JButton buttonCreateAcc = new JButton("Save");
                
                // create a new panel with GridBagLayout manager
                JPanel newPanel = new JPanel(new GridBagLayout());

                GridBagConstraints constraints = new GridBagConstraints();
                constraints.anchor = GridBagConstraints.WEST;
                constraints.insets = new Insets(10, 10, 10, 10);
         
                // add components to the panel
                constraints.gridx = 0;
                constraints.gridy = 0; 
                newPanel.add(labelOldUsername, constraints);
                
                constraints.gridx = 1;
                constraints.gridy = 0; 
                newPanel.add(textOldUsername, constraints);
                
                constraints.gridx = 0;
                constraints.gridy = 1;     
                newPanel.add(labelNewUsername, constraints);

                constraints.gridx = 1;
                constraints.gridy = 1;     
                newPanel.add(textNewUsername, constraints);

                
                constraints.gridx = 0;
                constraints.gridy = 3;
                constraints.gridwidth = 2;
                constraints.anchor = GridBagConstraints.CENTER;
                
                createAccountDialog.setVisible(true);
                
                newPanel.add(buttonCreateAcc, constraints);

                
                // add the panel to this frame
                createAccountDialog.add(newPanel);
		
		buttonCreateAcc.addActionListener(new ActionListener() {
            
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        
                        try{
                        JOptionPane.showMessageDialog(f, "User Name Changed.");  
                        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            //3. establish connecction
                        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/JDBC","Project1","Project1");
                        String sql = "UPDATE userAccount SET userName = ? WHERE userName = ?";
                        PreparedStatement pstmt = null;
                        pstmt = conn.prepareStatement(sql); ////////////
                        //pstmt.setString(1, userInput);
                        pstmt.setString(1, textNewUsername.getText());
                        pstmt.setString(2, textOldUsername.getText());
                         int rowsaffected = pstmt.executeUpdate();
                        System.out.println("\nNumber of Rows Effected : " + (rowsaffected));
                        pstmt.close();
                        conn.close();
//                        //email = textEmail.getText();    
                         new ScheduleMe();
                    }
                   
                    catch(SQLException e)
                    {
                    }   catch (ClassNotFoundException ex) {   
                            Logger.getLogger(ScheduleMe.class.getName()).log(Level.SEVERE, null, ex);
                        }   
                      }
                });
                
                f.getContentPane().add(BorderLayout.CENTER, createAccountDialog);
                f.setVisible(true);
            }
	else if(e.getActionCommand().equals("ChangePassword") )
		{
			JPanel changePasswordDialog = new JPanel();
//                createAccountDialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                changePasswordDialog.setSize(400, 400);
                
                
                JLabel labeloldPassword = new JLabel("Old Password");
                JTextField textoldPassword = new JTextField(20);

               
                JLabel labelNewPassword = new JLabel("New Password");
                JTextField textNewPassword = new JTextField(20);
                
                JLabel labelConfirmNewPassword = new JLabel("Confirm New Password: ");
                JTextField textConfirmNewPassword = new JTextField(20);
                
                JButton buttonChangePassword = new JButton("Save");
                
                // create a new panel with GridBagLayout manager
                JPanel newPanel = new JPanel(new GridBagLayout());

                GridBagConstraints constraints = new GridBagConstraints();
                constraints.anchor = GridBagConstraints.WEST;
                constraints.insets = new Insets(10, 10, 10, 10);
         
                // add components to the panel
                constraints.gridx = 0;
                constraints.gridy = 0; 
                newPanel.add(labeloldPassword, constraints);
                
                constraints.gridx = 1;
                constraints.gridy = 0; 
                newPanel.add(textoldPassword, constraints);
              
                constraints.gridx = 0;
                constraints.gridy = 1; 
                newPanel.add(labelNewPassword, constraints);
                
                constraints.gridx = 1;
                constraints.gridy = 1; 
                newPanel.add(textNewPassword, constraints);
                
                constraints.gridx = 0;
                constraints.gridy = 2;     
                newPanel.add(labelConfirmNewPassword, constraints);

                constraints.gridx = 1;
                constraints.gridy = 2;     
                newPanel.add(textConfirmNewPassword, constraints);

                
                constraints.gridx = 0;
                constraints.gridy = 3;
                constraints.gridwidth = 2;
                constraints.anchor = GridBagConstraints.CENTER;
                
                changePasswordDialog.setVisible(true);
                
                buttonChangePassword.addActionListener(new ActionListener() {
          
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        try{
                        JOptionPane.showMessageDialog(f,"User Password changed.");  
                        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            //3. establish connecction
                        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/JDBC","Project1","Project1");
                        String sql = "UPDATE userAccount SET password = ? WHERE password = ?";
                        PreparedStatement pstmt = null;
                        pstmt = conn.prepareStatement(sql); ////////////
                        //pstmt.setString(1, userInput);
                        pstmt.setString(1, textNewPassword.getText());
                        pstmt.setString(2, textoldPassword.getText());
                         int rowsaffected = pstmt.executeUpdate();
                        System.out.println("\nNumber of Rows Effected : " + (rowsaffected));
                      //  JOptionPane.showMessageDialog(f,"Password got changed.");    
                        pstmt.close();
                        conn.close();
                      new ScheduleMe();    
                    }
                   
                    catch(SQLException e)
                    {
                    }   catch (ClassNotFoundException ex) {   
                            Logger.getLogger(ScheduleMe.class.getName()).log(Level.SEVERE, null, ex);
                        }   
                      }
                           
                    
                });
                newPanel.add(buttonChangePassword, constraints);

                
                // add the panel to this frame
                changePasswordDialog.add(newPanel);

                
               f.getContentPane().add(BorderLayout.CENTER, changePasswordDialog);
                f.setVisible(true);
                

            }
   
	else if(e.getActionCommand().equals("ModifyAccount") )
		{
			JPanel changeMailidDialog = new JPanel();
//                createAccountDialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                changeMailidDialog.setSize(400, 400);
                
                
                JLabel labelOldMailId = new JLabel("Old email id");
                JTextField textoldMailId = new JTextField(20);
                
                JLabel labelNewMailId = new JLabel("New email id: ");
                JTextField textNewMailId = new JTextField(20);
                
                JButton buttonChangeMailid = new JButton("Save");
                
                // create a new panel with GridBagLayout manager
                JPanel newPanel = new JPanel(new GridBagLayout());

                GridBagConstraints constraints = new GridBagConstraints();
                constraints.anchor = GridBagConstraints.WEST;
                constraints.insets = new Insets(10, 10, 10, 10);
         
                // add components to the panel
                constraints.gridx = 0;
                constraints.gridy = 0; 
                newPanel.add(labelOldMailId, constraints);
                
                constraints.gridx = 1;
                constraints.gridy = 0; 
                newPanel.add(textoldMailId, constraints);
              
                constraints.gridx = 0;
                constraints.gridy = 1; 
                newPanel.add(labelNewMailId, constraints);
                
                constraints.gridx = 1;
                constraints.gridy = 1; 
                newPanel.add(textNewMailId, constraints);
                
                /*constraints.gridx = 0;
                constraints.gridy = 2;     
                newPanel.add(labelConfirmNewPassword, constraints);

                constraints.gridx = 1;
                constraints.gridy = 2;     
                newPanel.add(textConfirmNewPassword, constraints);*/

                
                constraints.gridx = 0;
                constraints.gridy = 3;
                constraints.gridwidth = 2;
                constraints.anchor = GridBagConstraints.CENTER;
                
                changeMailidDialog.setVisible(true);
                
                buttonChangeMailid.addActionListener(new ActionListener() {
          
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                             JOptionPane.showMessageDialog(f,"mail updated.");
                             try{
                        //JOptionPane.showMessageDialog(f,"UserName "+textNewUsername.getText()+" changed.");  
                        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            //3. establish connecction
                        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/JDBC","Project1","Project1");
                        String sql = "UPDATE userAccount SET email = ? WHERE email = ?";
                        PreparedStatement pstmt = null;
                        pstmt = conn.prepareStatement(sql); ////////////
                        //pstmt.setString(1, userInput);
                        pstmt.setString(1, textNewMailId.getText());
                        pstmt.setString(2, textoldMailId.getText());
                         int rowsaffected = pstmt.executeUpdate();
                        System.out.println("\nNumber of Rows Effected : " + (rowsaffected));
                        JOptionPane.showMessageDialog(f,"Email Updated");    
                        pstmt.close();
                        conn.close();
                        new ScheduleMe();
//                        //email = textEmail.getText();     
                    }
                   
                    catch(SQLException e)
                    {
                    }   catch (ClassNotFoundException ex) {   
                            Logger.getLogger(ScheduleMe.class.getName()).log(Level.SEVERE, null, ex);
                        }   
                      }
                           
                    
                });
                newPanel.add(buttonChangeMailid, constraints);

                
                // add the panel to this frame
                changeMailidDialog.add(newPanel);

                
               f.getContentPane().add(BorderLayout.CENTER, changeMailidDialog);
                f.setVisible(true);
                

            }
   
        else if(e.getActionCommand().equals("SetCalenderType") )
		{
			Label ml;
			Label wl;
			Label dl;
			Choice w;
			Choice d;
			Choice m;
			System.out.println("SetCalendaranged");			
                final Label label = new Label(); 
	Button b = new Button("ShowDateSelected");    
	 ml = new Label("Month"); 
	 wl = new Label("Week"); 
	 dl = new Label("Day"); 
        
         w=new Choice(); 
	 m=new Choice(); 
	 d=new Choice();  
	wl.setBounds(100,50,50,50);
        w.setBounds(100,100, 50,75);  
        w.add("1");  
        w.add("2");  
        w.add("3");  
        w.add("4"); 
	f.add(wl); 
	f.add(w);
	dl.setBounds(150,50,50,50);
        d.setBounds(150,100, 50,75);
	d.add("Sunday");  
        d.add("Monday");  
        d.add("Tuesday");  
        d.add("Wednesday");
	d.add("Thursday");  
        d.add("Friday");  
        d.add("Saturday");  
	f.add(dl);
        f.add(d);
	ml.setBounds(200,50,50,50);
	m.setBounds(200,100,50,75);
	m.add("January");  
        m.add("February");  
        m.add("March");  
        m.add("April");
	m.add("May");  
        m.add("June");  
        m.add("July");  
        m.add("August");
	m.add("September");  
        m.add("OCtober");  
        m.add("November");  
        m.add("December");
	b.setBounds(250,125,125,75);
	f.add(ml);
	f.add(m);
	f.add(b);
	f.add(label);
	 //f.setSize(400,400);  
        //f.setLayout(null);  
        f.setVisible(true);  
	 b.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {       
         
 	
	String d1 =  d.getItem(d.getSelectedIndex());  
	String w1 =  w.getItem(w.getSelectedIndex());
	 String m1 =  m.getItem(m.getSelectedIndex());
	System.out.print("Day: "+d1+"Week: "+w1+"Month: "+m1);
		label.setBounds(75,125,125,75);
          label.setText("Day: "+d1+"Week: "+w1+"Month: "+m1);
		new ScheduleMe(); 
        }  
        });       
	
     		}

	  else
 		statusLabel.setText(e.getActionCommand() + " JMenuItem clicked."); 


}//ACTION EVENT E
}//MENU ITEM LISTENER
}//MAIN CLASS