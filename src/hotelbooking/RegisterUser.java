/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbooking;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;


public class RegisterUser extends javax.swing.JFrame {

    /**
     * Creates new form RegisterUser
     */
    boolean check_dob(java.util.Date dateOfBirth) {
        int year = 2000;
        int month = 11;
        int day = 19;

        String date = year + "/" + month + "/" + day;
        java.util.Date utilDate = null;

        try {
          SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
          utilDate = formatter.parse(date);
        } catch (ParseException e) {
          e.printStackTrace();
        }
        
        if(dateOfBirth.after(utilDate))
        {
            invalid_dob.setText("You must be over 18 years of age");
            return false;
        }
            
        
        invalid_dob.setText("");
        return true;
    }
    
    
    boolean check_name(String name)
    {
        if(name.length()==0) {
            invalid_name.setText("This field cannot be left empty");
            return false;
        }
        for(int i=0;i<name.length();i++)
        {
            if( !(name.charAt(i)>='a' && name.charAt(i)<='z') && !(name.charAt(i)>='A' && name.charAt(i)<='Z') && name.charAt(i)!=' ' ){
                invalid_name.setText("Name should contain the characters 'a-z' and 'A-Z' only");
                return false;
            }
                
        }
        
        return true;
    }
    
    boolean check_username()
    {
        Connection myCon = null;
        Statement myStmnt = null;
        ResultSet myRs = null;
        if(username.getText().length()==0)
        {
            invalid.setText("This field cannot be left empty");
            return false;
        }
        else {
            invalid.setText("");
        }
        try {
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels", "root", "n!gg3|2f@gg0t");
            myStmnt = myCon.createStatement();
            myRs = myStmnt.executeQuery("SELECT * FROM users WHERE Username = '" + username.getText() + "'");
            if(myRs.next()){
                invalid.setText("Username already in use");
                return false;
            }
            else{
                invalid.setText("");
            }
            
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        try{
            if(myStmnt!=null)
                myStmnt.close();
            if(myRs!=null)
                myRs.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }
    
    boolean check_address(String address)
    {
       if(address.length()==0) {
           invalid_address.setText("This field cannot be left empty");
           return false;
       }
       
       return true;
    }
    
    boolean check_email(String email)
    {
        if(email.length()==0) {
            invalid_email.setText("This field cannot be left empty");
            return false;
        }
        
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        
        if(pat.matcher(email).matches()==false) {
            invalid_email.setText("Invalid email");
            return false;
        } 
        
        invalid_email.setText("");
        return true;
    }
    
    boolean check_password()
    {
        String u = password.getText();
        if(u.length()==0)
        {
            invalid_password.setText("This field cannot be left empty");
            return false;
        }
        
       
        boolean flag=true;
        
        for(int i=0;i<u.length();i++)
        {
            if(u.charAt(i)>='a' && u.charAt(i)<='z');
            
            else if(u.charAt(i)>='0' && u.charAt(i)<='9');
                
            else
                flag=false;
        }
        
        if(!flag){
            invalid_password.setText("Password should contain lowercase and numerical characters only.");
            return false; 
        }
        
        invalid_password.setText("");
        return true;
       
    }
    
    public RegisterUser() {
        setContentPane(new JLabel(new ImageIcon("D:\\\\JOOPS\\\\HotelBooking\\\\src\\\\hotelbooking\\\\bg1.jpg")));
        initComponents();
        
        bmt.setBorder(null);
        bmt.setBorderPainted(false);
        bmt.setContentAreaFilled(false);
        bmt.setOpaque(false);
        
        invalid.setText("");
        invalid_name.setText("");
        invalid_address.setText("");
        invalid_email.setText("");
        invalid_dob.setText("");
        success.setText("");
        
        java.util.Date today = new java.util.Date();
        dob.setDate(today);
        
        
        finRegister.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1) {
                    
                    check_dob(dob.getDate()); 
                    check_name(name.getText());
                    check_username();
                    check_address(address.getText());
                    check_password();
                    check_email(email.getText());
                    
                    Connection myCon = null;
                    Statement myStmnt = null;
                    
                    if(check_dob(dob.getDate()) && check_name(name.getText()) && check_username() && check_address(address.getText()) && check_password() && check_email(email.getText()) )
                        
                        try{
                            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels","root","n!gg3|2f@gg0t");
                            myStmnt = myCon.createStatement();
                            myStmnt.executeUpdate("INSERT INTO users(Username, Password)VALUES('" + username.getText() + "', '" + password.getText() + "')");
                            success.setText("Registration Succesful");
                        }catch(Exception a){
                            a.printStackTrace();
                        }
                        try{
                            if(myStmnt!=null)
                                myStmnt.close();
                        }catch(Exception a){
                            a.printStackTrace();
                        }
                }
            }
        });
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        finRegister = new javax.swing.JButton();
        invalid = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        invalid_name = new javax.swing.JLabel();
        invalid_address = new javax.swing.JLabel();
        invalid_email = new javax.swing.JLabel();
        invalid_password = new javax.swing.JLabel();
        success = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dob = new org.jdesktop.swingx.JXDatePicker();
        invalid_dob = new javax.swing.JLabel();
        bmt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setSize(new java.awt.Dimension(1280, 720));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Name");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Address");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Email");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Choose Username");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Password");

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });

        finRegister.setText("Register");
        finRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finRegisterActionPerformed(evt);
            }
        });

        invalid.setForeground(new java.awt.Color(255, 0, 0));
        invalid.setText("The username already exists");

        invalid_name.setForeground(new java.awt.Color(255, 0, 0));
        invalid_name.setText("Name should contain the characters 'a-z' and 'A-Z' only");

        invalid_address.setForeground(new java.awt.Color(255, 0, 0));
        invalid_address.setText("This field cannot be left empty");

        invalid_email.setForeground(new java.awt.Color(255, 0, 0));
        invalid_email.setText("This field cannot be left empty");

        invalid_password.setForeground(new java.awt.Color(255, 0, 0));
        invalid_password.setText("Password should contain atleast lowercase and numerical characters only.");

        success.setForeground(new java.awt.Color(0, 204, 51));
        success.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        success.setText("Registration successful");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Date of Birth");

        invalid_dob.setForeground(new java.awt.Color(255, 0, 51));
        invalid_dob.setText("You must be over 18 years of age");

        bmt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotelbooking/bmtlogo.png"))); // NOI18N
        bmt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bmt.setBorderPainted(false);
        bmt.setOpaque(false);
        bmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(success, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(316, 316, 316))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invalid_name)
                            .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(invalid_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(invalid_address)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(invalid_email)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(invalid)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(invalid_password)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(197, 197, 197)
                                .addComponent(finRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bmt)))
                .addGap(0, 235, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bmt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invalid_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invalid_dob)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(invalid_address)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invalid_email)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invalid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invalid_password)
                .addGap(30, 30, 30)
                .addComponent(finRegister)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(success)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void finRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finRegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_finRegisterActionPerformed

    private void bmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmtActionPerformed
        RegisterUser.this.setVisible(false);        // TODO add your handling code here:
        HomePage hp = new HomePage();
        hp.setVisible(true);
    }//GEN-LAST:event_bmtActionPerformed
    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JButton bmt;
    private org.jdesktop.swingx.JXDatePicker dob;
    private javax.swing.JTextField email;
    private javax.swing.JButton finRegister;
    private javax.swing.JLabel invalid;
    private javax.swing.JLabel invalid_address;
    private javax.swing.JLabel invalid_dob;
    private javax.swing.JLabel invalid_email;
    private javax.swing.JLabel invalid_name;
    private javax.swing.JLabel invalid_password;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField name;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel success;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
