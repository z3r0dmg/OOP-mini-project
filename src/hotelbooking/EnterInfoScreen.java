/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbooking;

import java.util.*;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kushagra Srivastava
 */
public class EnterInfoScreen extends javax.swing.JFrame {

    /**
     * Creates new form EnterInfoScreen
     */
    
    int refno = 1000;
    String username;
    boolean confirmed = false;
    long days;
    int totalprice;
    String HotelName;
 
    DefaultTableModel model;

    public EnterInfoScreen(String user) {
        setContentPane(new JLabel(new ImageIcon("D:\\\\JOOPS\\\\HotelBooking\\\\src\\\\hotelbooking\\\\bg1.jpg")));
        initComponents();
        
        bmt.setBorder(null);
        bmt.setBorderPainted(false);
        bmt.setContentAreaFilled(false);
        bmt.setOpaque(false);
        

        hello.setText("Hello " + user + "! ");
        price.setVisible(false);
        maxpeople.setVisible(false);
        username = user;
        model = (DefaultTableModel) table.getModel();
        
        message.setVisible(false);
        confirm.setVisible(false);
        invalid_dates.setVisible(false);
        invalid_select.setVisible(false);
        
        java.util.Date today = new java.util.Date();
        
        datePickerFrom.setDate(today);
        datePickerTo.setDate(today);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelLocation = new javax.swing.JLabel();
        labelNoOfPeople = new javax.swing.JLabel();
        spinner = new javax.swing.JSpinner();
        datePickerFrom = new org.jdesktop.swingx.JXDatePicker();
        datePickerTo = new org.jdesktop.swingx.JXDatePicker();
        labelLocation1 = new javax.swing.JLabel();
        labelLocation2 = new javax.swing.JLabel();
        comboBoxLocation = new javax.swing.JComboBox<>();
        buttonOK = new javax.swing.JButton();
        buttonClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        buttonProceed = new javax.swing.JButton();
        confirm = new javax.swing.JButton();
        message = new javax.swing.JLabel();
        hello = new javax.swing.JLabel();
        invalid_dates = new javax.swing.JLabel();
        invalid_select = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        price = new javax.swing.JLabel();
        people = new javax.swing.JSpinner();
        labelNoOfPeople1 = new javax.swing.JLabel();
        maxpeople = new javax.swing.JLabel();
        bmt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setSize(new java.awt.Dimension(1280, 720));

        labelLocation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelLocation.setText("Location");

        labelNoOfPeople.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelNoOfPeople.setText("No of Rooms");

        spinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));

        labelLocation1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelLocation1.setText("From");

        labelLocation2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelLocation2.setText("To");

        comboBoxLocation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gangtok", "Goa", "Jaipur", "Ladakh", "Manali", "Mumbai", "Mysore", "Ooty", "Shimla" }));

        buttonOK.setText("OK");
        buttonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOKActionPerformed(evt);
            }
        });

        buttonClear.setText("Clear");
        buttonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Rating", "Price", "Complementary Breakfast", "WiFi", "Mini Bar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        buttonProceed.setText("Check");
        buttonProceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProceedActionPerformed(evt);
            }
        });

        confirm.setText("Go to waiting list");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });

        message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        message.setText("The required number of rooms are unavailable. Change selection or go to the waiting list.");
        message.setToolTipText("");

        hello.setFont(new java.awt.Font("Georgia", 2, 20)); // NOI18N
        hello.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hello.setText("Hello User!");

        invalid_dates.setForeground(new java.awt.Color(255, 0, 0));
        invalid_dates.setText("Enter valid dates");

        invalid_select.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        invalid_select.setForeground(new java.awt.Color(255, 0, 0));
        invalid_select.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalid_select.setText("Please select a hotel");

        jButton1.setText("Go back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Logout");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        price.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        price.setText("jLabel1");

        people.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));

        labelNoOfPeople1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelNoOfPeople1.setText("No of People");

        maxpeople.setForeground(new java.awt.Color(255, 0, 0));
        maxpeople.setText("Maximum 3 people in 1 room ");

        bmt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotelbooking/bmtlogo.png"))); // NOI18N
        bmt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bmt.setBorderPainted(false);
        bmt.setContentAreaFilled(false);
        bmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bmt)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(752, 752, 752)
                        .addComponent(hello, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(326, 326, 326)
                                .addComponent(invalid_select, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buttonProceed, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(171, 171, 171)
                                        .addComponent(confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(labelNoOfPeople)
                                                            .addComponent(labelLocation)
                                                            .addComponent(labelNoOfPeople1))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(comboBoxLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(people, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(76, 76, 76)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(labelLocation2)
                                                            .addComponent(labelLocation1)))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(buttonClear)
                                                        .addGap(62, 62, 62)
                                                        .addComponent(buttonOK)))
                                                .addGap(26, 26, 26))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(maxpeople)
                                                .addGap(179, 179, 179)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(invalid_dates)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(datePickerFrom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(datePickerTo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(price)
                                .addGap(443, 443, 443)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(bmt)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(datePickerFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelLocation1))
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(datePickerTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelLocation2))
                                .addGap(18, 18, 18)
                                .addComponent(invalid_dates))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(comboBoxLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)
                                        .addComponent(people, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelLocation)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(labelNoOfPeople)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(labelNoOfPeople1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(maxpeople)))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonOK)
                            .addComponent(buttonClear))
                        .addGap(67, 67, 67)
                        .addComponent(invalid_select))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(hello, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonProceed, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(confirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(price)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        price.getAccessibleContext().setAccessibleName("Price: ");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearActionPerformed

        java.util.Date today = new java.util.Date();
        datePickerFrom.setDate(today);
        datePickerTo.setDate(today);

        comboBoxLocation.setSelectedItem(comboBoxLocation.getItemAt(0));
        spinner.setValue(0);
    }//GEN-LAST:event_buttonClearActionPerformed

    private void buttonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOKActionPerformed
        // TODO add your handling code here:
        confirm.setVisible(false);
        
        model.setRowCount(0);
        Connection myconn = null;
        Statement mystat = null;
        ResultSet myresult = null;

        String location = comboBoxLocation.getSelectedItem().toString();

        System.out.println(location);
        java.util.Date FromDate = datePickerFrom.getDate();
        java.sql.Date sqlFromDate = new java.sql.Date(FromDate.getTime());
        java.util.Date ToDate = datePickerTo.getDate();
        java.sql.Date sqlToDate = new java.sql.Date(ToDate.getTime());
        
  
        
        if(check_date_india(FromDate,ToDate)) {
            invalid_dates.setVisible(false);
            days = (sqlToDate.getTime()-sqlFromDate.getTime())/86400000 + 1;
            //System.out.println(days);
            try {
                myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels", "root", "n!gg3|2f@gg0t");
                mystat = myconn.createStatement();
                myresult = mystat.executeQuery("select * from hotels where Location = \'" + location + "\'" );
                while (myresult.next()) {
                    model.insertRow(model.getRowCount(), new Object[]{myresult.getString("Name"), myresult.getInt("Rating"), myresult.getInt("Price"), myresult.getBoolean("CompBreak") ? "yes" : "no", myresult.getBoolean("WiFi") ? "yes" : "no", myresult.getBoolean("MiniBar") ? "yes" : "no"});
                }
            } catch (Exception e) {
                System.out.println(e);
            }

            try {
                if (myresult != null) {
                    myresult.close();
                }
                if (mystat != null) {
                    mystat.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }//GEN-LAST:event_buttonOKActionPerformed

    private boolean check_date_india(java.util.Date fromdate, java.util.Date todate) {
        java.util.Date today = new java.util.Date();
        boolean flag = true;
        int nop = (Integer)people.getValue();
        int nor = (Integer)spinner.getValue();
        
        if(nop>3*nor){
            maxpeople.setVisible(true);
            flag = false;
        }
        else{
            maxpeople.setVisible(false);
        }
        
        if(fromdate.after(todate) || fromdate.before(today) ) {
            invalid_dates.setVisible(true);
            flag = false;
        }
        else{
            invalid_dates.setVisible(false);
        }
        
        return flag;
    }
    
    private void buttonProceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProceedActionPerformed
        // TODO add your handling code here:
        
        
        
        message.setVisible(false);
        confirm.setVisible(false);
        
        Connection myconn = null;
        Statement mystat = null;
        ResultSet myresult = null;
        
        try {
            myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels", "root", "n!gg3|2f@gg0t");
            mystat = myconn.createStatement();
            myresult = mystat.executeQuery("select max(RefNo) from bookings");
            if(myresult.next()){
                if(myresult.getInt(1)==0){
                    refno++;
                }
                else{
                    refno = myresult.getInt(1)+1;
                }
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
        try {
            if (myresult != null) {
                myresult.close();
            }
            if (mystat != null) {
                mystat.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        int column = 0;
        int columnprice = 2;
        int row = table.getSelectedRow();
        
        if(table.getSelectedRow()==-1)
        {
            invalid_select.setVisible(true);
        }

        else {
            invalid_select.setVisible(false);
            
            HotelName = table.getModel().getValueAt(row, column).toString();
            
            int nor = (Integer)spinner.getValue();
            int rate  = Integer.parseInt(table.getModel().getValueAt(row, columnprice).toString());
            
            totalprice = Math.toIntExact(days*nor*rate);
            java.util.Date FromDate = datePickerFrom.getDate();
            java.sql.Date sqlFromDate = new java.sql.Date(FromDate.getTime());
            java.util.Date ToDate = datePickerTo.getDate();
            java.sql.Date sqlToDate = new java.sql.Date(ToDate.getTime());



            try {
                myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels", "root", "n!gg3|2f@gg0t");
                String p = "select NoOfRooms from bookings where HotelName = \'" + HotelName + "\'" + " and (FromDate<=? and ToDate>=? or FromDate<=? and ToDate>=?) and Status = 1";
                PreparedStatement pstat = myconn.prepareStatement(p);
                pstat.setDate(1, sqlFromDate);
                pstat.setDate(2, sqlFromDate);
                pstat.setDate(3, sqlToDate);
                pstat.setDate(4, sqlToDate);
                System.out.println(pstat);
                myresult = pstat.executeQuery();
                int occupiedRooms=0;
                while(myresult.next()){
                    occupiedRooms += myresult.getInt(1);
                }
                System.out.println(occupiedRooms);
                mystat = myconn.createStatement();
                ResultSet resRooms = mystat.executeQuery("select AvailableRooms from hotels where Name = \'" + HotelName + "\'" );
                resRooms.next();
                int HotelRooms = resRooms.getInt(1);
                if(HotelRooms - occupiedRooms >= nor){
                    price.setText("Price: " + totalprice);
                    price.setVisible(true);
                    confirm.setVisible(true);
                    confirm.setText("Confirm");
                    confirmed = true;

                }
                else{
                    price.setVisible(false);
                    message.setVisible(true);
                    confirm.setVisible(true);
                    confirm.setText("Go to waiting list");
                    confirmed = false;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }


    }//GEN-LAST:event_buttonProceedActionPerformed

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        // TODO add your handling code here:
        
        Connection myconn = null;
        int column = 0;
        int row = table.getSelectedRow();

        
        int nor = (Integer)spinner.getValue();

        java.util.Date FromDate = datePickerFrom.getDate();
        java.sql.Date sqlFromDate = new java.sql.Date(FromDate.getTime());
        java.util.Date ToDate = datePickerTo.getDate();
        java.sql.Date sqlToDate = new java.sql.Date(ToDate.getTime());
        
        int status;
        if(confirmed){
            status = 1;
        }
        else{
            status = 0;
        }
        
        EnterInfoScreen.this.setVisible(false);
        BookingConfirmation bc = new BookingConfirmation(refno, username, HotelName, nor, sqlFromDate , sqlToDate, status, totalprice);
        bc.setVisible(true);
     
    }//GEN-LAST:event_confirmActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        EnterInfoScreen.this.setVisible(false);
        OptionSelection os = new OptionSelection(username);
        os.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        EnterInfoScreen.this.setVisible(false);
        HomePage hp = new HomePage();
        hp.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmtActionPerformed
        // TODO add your handling code here:
        EnterInfoScreen.this.setVisible(false);

        HomePage hp = new HomePage();
        hp.setVisible(true);
    }//GEN-LAST:event_bmtActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bmt;
    private javax.swing.JButton buttonClear;
    private javax.swing.JButton buttonOK;
    private javax.swing.JButton buttonProceed;
    private javax.swing.JComboBox<String> comboBoxLocation;
    private javax.swing.JButton confirm;
    private org.jdesktop.swingx.JXDatePicker datePickerFrom;
    private org.jdesktop.swingx.JXDatePicker datePickerTo;
    private javax.swing.JLabel hello;
    private javax.swing.JLabel invalid_dates;
    private javax.swing.JLabel invalid_select;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelLocation;
    private javax.swing.JLabel labelLocation1;
    private javax.swing.JLabel labelLocation2;
    private javax.swing.JLabel labelNoOfPeople;
    private javax.swing.JLabel labelNoOfPeople1;
    private javax.swing.JLabel maxpeople;
    private javax.swing.JLabel message;
    private javax.swing.JSpinner people;
    private javax.swing.JLabel price;
    private javax.swing.JSpinner spinner;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
