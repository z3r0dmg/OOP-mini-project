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
 * @author Sandesh Thakar
 */
public class ModifyBookings extends javax.swing.JFrame {

    /**
     * Creates new form ModifyBookings
     */
    int refno;
    int new_refno;
    String selectedHotel;
    boolean avail = false;
    int nor;
    java.sql.Date fDate;
    java.sql.Date tDate;
    String username;
    int price;
    int days;
    
    public ModifyBookings(int refno1,String hotel1,String user, int p) {
        setContentPane(new JLabel(new ImageIcon("D:\\\\JOOPS\\\\HotelBooking\\\\src\\\\hotelbooking\\\\bg1.jpg")));
        initComponents();
        
        bmt.setBorder(null);
        bmt.setBorderPainted(false);
        bmt.setContentAreaFilled(false);
        bmt.setOpaque(false);
        
        
        java.util.Date today = new java.util.Date();
        fromdate.setDate(today);
        todate.setDate(today);
        invalid_dates.setText("");
        maxpeople.setText("");
        unavail.setText("");
        newprice.setText("");
        success.setText("");
        //invalid_dates.setVisible(false);
        //maxpeople.setVisible(false);
        //unavail.setVisible(false);
        confirm.setVisible(false);
        refno=refno1;
        selectedHotel=hotel1;
        username=user;
        
        ref.setVisible(false);
        no.setVisible(false);
        
        Connection myconn = null;
        Statement mystat = null;
        ResultSet myresult = null;
        
        try{
            myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels","root","n!gg3|2f@gg0t");
            mystat =  myconn.createStatement();
            myresult = mystat.executeQuery("select Price from hotels where Name = \'" + selectedHotel + "\'");
            myresult.next();
            price = myresult.getInt(1);
        }
        catch(Exception e){
            System.out.println(e);
        }
        try{
            if(myresult!=null){
                myresult.close();
            }
            if(mystat!=null){
                mystat.close();
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fromdate = new org.jdesktop.swingx.JXDatePicker();
        todate = new org.jdesktop.swingx.JXDatePicker();
        rooms = new javax.swing.JSpinner();
        from = new javax.swing.JLabel();
        to = new javax.swing.JLabel();
        labelpeople = new javax.swing.JLabel();
        invalid_dates = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        unavail = new javax.swing.JLabel();
        people = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        maxpeople = new javax.swing.JLabel();
        bmt = new javax.swing.JButton();
        check = new javax.swing.JButton();
        confirm = new javax.swing.JButton();
        newprice = new javax.swing.JLabel();
        success = new javax.swing.JLabel();
        ref = new javax.swing.JLabel();
        no = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        rooms.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        from.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        from.setText("From");

        to.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        to.setText("To");

        labelpeople.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelpeople.setText("People");

        invalid_dates.setForeground(new java.awt.Color(255, 0, 51));
        invalid_dates.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalid_dates.setText("Enter valid dates");

        jButton2.setText("Go back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        unavail.setForeground(new java.awt.Color(255, 0, 51));
        unavail.setText("The required number of rooms are unavilable. Change selection or go to waiting list.");

        people.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Rooms");

        maxpeople.setForeground(new java.awt.Color(255, 0, 51));
        maxpeople.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maxpeople.setText("Maximum 3 people per room");

        bmt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotelbooking/bmtlogo.png"))); // NOI18N
        bmt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bmt.setBorderPainted(false);
        bmt.setOpaque(false);
        bmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmtActionPerformed(evt);
            }
        });

        check.setText("Check");
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });

        confirm.setText("Go to waiting list");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });

        newprice.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        newprice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        newprice.setText("New Price: ");

        success.setBackground(new java.awt.Color(255, 255, 255));
        success.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        success.setForeground(new java.awt.Color(0, 204, 0));
        success.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        success.setText("Your booking has been modified");

        ref.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ref.setText("New reference number");

        no.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        no.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        no.setText("0000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ref)
                        .addGap(18, 18, 18)
                        .addComponent(no, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(254, 254, 254))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bmt)
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(unavail, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelpeople, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                                .addGap(105, 105, 105)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(confirm)
                                    .addComponent(check, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fromdate, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(todate, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rooms, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(people, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(invalid_dates, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(maxpeople)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newprice, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(success, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(265, 265, 265)))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bmt)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(invalid_dates)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fromdate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(todate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maxpeople)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rooms, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelpeople, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(people))
                .addGap(42, 42, 42)
                .addComponent(check)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirm)
                .addGap(18, 18, 18)
                .addComponent(unavail)
                .addGap(18, 18, 18)
                .addComponent(newprice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(success, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ref, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(no, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private boolean check_date_india(java.util.Date fromdate, java.util.Date todate) {
        java.util.Date today = new java.util.Date();
        boolean flag = true;
        int nop = (Integer)people.getValue();
        int nor = (Integer)rooms.getValue();
        
        if(nop>3*nor){
            maxpeople.setText("Maximum 3 people in 1 room");
            //maxpeople.setVisible(true);
            flag = false;
        }
        else{
            maxpeople.setText("");
            //maxpeople.setVisible(false);
        }
        
        if(fromdate.after(todate) || fromdate.before(today) ) {
            invalid_dates.setText("Enter valid dates");
            //invalid_dates.setVisible(true);
            flag = false;
        }
        else{
            invalid_dates.setText("");
            //invalid_dates.setVisible(false);
        }
        
        return flag;
    }
    
    private void deleteEntry(int refno, String cancelledHotel){
        Connection myconn = null;
        Statement mystat = null;
        ResultSet myresult = null;
        ResultSet waitingList = null, confirmedList = null;
        try{
            myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels", "root", "n!gg3|2f@gg0t"); 
            String sql = "delete from bookings where RefNo = ?";
            PreparedStatement statement = myconn.prepareStatement(sql);
            statement.setInt(1, refno);
            statement.executeUpdate();
        }
        catch(Exception e){
            System.out.println("xxxxxxxxxxxxxx");
            System.out.println(e);
        }
        
        try{
            myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels", "root", "n!gg3|2f@gg0t"); 
            String sql1 = "select * from bookings where HotelName = ? and Status = 0";
            PreparedStatement statement1 = myconn.prepareStatement(sql1);
            statement1.setString(1, cancelledHotel);
            waitingList = statement1.executeQuery();
            
            mystat =  myconn.createStatement();
            myresult = mystat.executeQuery("select AvailableRooms from hotels where Name = \'"+cancelledHotel+"\'");
            myresult.next();
            int totalrooms = myresult.getInt(1);
            
            while(waitingList.next()){
                java.sql.Date fromDate = waitingList.getDate(5);
                java.sql.Date toDate = waitingList.getDate(6);
                int newref = waitingList.getInt(1);
                
                String sql2 = "select * from bookings where HotelName = ? and Status = 1 and (FromDate<=? and ToDate>=? or FromDate<=? and ToDate>=?)";
                PreparedStatement statement2 = myconn.prepareStatement(sql2);
                statement2.setString(1, cancelledHotel);
                statement2.setDate(2, fromDate);
                statement2.setDate(3, fromDate);
                statement2.setDate(4, toDate);
                statement2.setDate(5, toDate);
                confirmedList = statement2.executeQuery();
                
                int requiredrooms = waitingList.getInt(4);
                int occupiedrooms = 0;
                
                while(confirmedList.next()){
                    occupiedrooms += confirmedList.getInt(4);
                }
                
                if(totalrooms - occupiedrooms >= requiredrooms){
                    String query = "update bookings set Status = ? where RefNo = ?";
                    PreparedStatement stat = myconn.prepareStatement(query);
                    stat.setInt(1, 1);
                    stat.setInt(2, newref);
                    stat.executeUpdate();
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    private void modifyEntry(int refno, String selectedHotel){
        Connection myconn = null;
        ResultSet myresult =null;
        Statement mystat = null;
        
        //System.out.println(cancelledHotel);
        
        java.sql.Date sqlFromDate = new java.sql.Date(fromdate.getDate().getTime());
        java.sql.Date sqlToDate = new java.sql.Date(todate.getDate().getTime());
        fDate = sqlFromDate;
        tDate = sqlToDate;
        days = Math.toIntExact((tDate.getTime()-fDate.getTime())/86400000 + 1);
        try {
            myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels", "root", "n!gg3|2f@gg0t");
            String p = "select NoOfRooms from bookings where HotelName = \'" + selectedHotel + "\'" + " and (FromDate<=? and ToDate>=? or FromDate<=? and ToDate>=?) and Status = 1";
            PreparedStatement pstat = myconn.prepareStatement(p);
            pstat.setDate(1, sqlFromDate);
            pstat.setDate(2, sqlFromDate);
            pstat.setDate(3, sqlToDate);
            pstat.setDate(4, sqlToDate);
            System.out.println(pstat);
            myresult = pstat.executeQuery();
            int occupiedRooms=0;
            while(myresult.next()){
                if(myresult.getInt(1)==refno)
                    continue;
                occupiedRooms += myresult.getInt(1);
            }

            System.out.println(occupiedRooms);
            mystat = myconn.createStatement();
            ResultSet resRooms = mystat.executeQuery("select AvailableRooms from hotels where Name = \'" + selectedHotel + "\'" );
            resRooms.next();
            int HotelRooms = resRooms.getInt(1);
            int requiredRooms = (int)rooms.getValue();
            nor = requiredRooms;
            if(HotelRooms - occupiedRooms >= requiredRooms){
                unavail.setVisible(false);
                confirm.setVisible(true);
                confirm.setText("Confirm");
                avail = true;
            }
            else{
                unavail.setVisible(true);
                confirm.setVisible(true);
                confirm.setText("Go to waiting list");
                avail = false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        // TODO add your handling code here:
        java.util.Date FromDate = fromdate.getDate();
        java.util.Date ToDate = todate.getDate();
       
        if(check_date_india(FromDate,ToDate)){
            modifyEntry(refno,selectedHotel);
        }
        else{
           // unavail.setText("The required number of rooms are unavailable. Change selection or go to waiting list.");
            newprice.setText("");
        }
    }//GEN-LAST:event_checkActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ModifyBookings.this.setVisible(false);
        ViewBookings vb = new ViewBookings(username); 
        vb.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        // TODO add your handling code here:
        
        //
        newprice.setText("New price: " + price*days*nor);
        success.setText("Your booking has been modified");
        int x;
        if(avail){
            x = 1;
        }
        else{
            x = 0;
        }
        Connection myconn = null;
        try{
            myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels", "root", "n!gg3|2f@gg0t"); 
            String sql = "insert into bookings(RefNo, Username, HotelName, NoOfRooms,FromDate , ToDate, Status, Price) values (?,?,?,?,?,?,?,?)";
            String maxquery = "select max(RefNo) from bookings";
            PreparedStatement maxstat = myconn.prepareStatement(maxquery);
            PreparedStatement statement = myconn.prepareStatement(sql);
            ResultSet maxref = maxstat.executeQuery();
            maxref.next();
            new_refno = maxref.getInt(1) + 1;
            System.out.println(maxstat);
            statement.setInt(1, new_refno);
            statement.setString(2, username);
            statement.setString(3, selectedHotel);
            statement.setInt(4, nor);             //CONFIRM EVENT HANDLING
            statement.setDate(5, fDate);
            statement.setDate(6, tDate);
            statement.setInt(7, x);
            statement.setInt(8, price*nor*days); 
            System.out.println(statement);
            statement.executeUpdate();
            ref.setVisible(true);
            no.setVisible(true);
            no.setText(Integer.toString(new_refno));
        }
        catch(Exception e){
            System.out.println("xxxxxxxxxxxxxx");
            System.out.println(e);
        }
        deleteEntry(refno, selectedHotel);
    }//GEN-LAST:event_confirmActionPerformed

    private void bmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmtActionPerformed
        // TODO add your handling code here:
        ModifyBookings.this.setVisible(false);

        HomePage hp = new HomePage();
        hp.setVisible(true);
    }//GEN-LAST:event_bmtActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bmt;
    private javax.swing.JButton check;
    private javax.swing.JButton confirm;
    private javax.swing.JLabel from;
    private org.jdesktop.swingx.JXDatePicker fromdate;
    private javax.swing.JLabel invalid_dates;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelpeople;
    private javax.swing.JLabel maxpeople;
    private javax.swing.JLabel newprice;
    private javax.swing.JLabel no;
    private javax.swing.JSpinner people;
    private javax.swing.JLabel ref;
    private javax.swing.JSpinner rooms;
    private javax.swing.JLabel success;
    private javax.swing.JLabel to;
    private org.jdesktop.swingx.JXDatePicker todate;
    private javax.swing.JLabel unavail;
    // End of variables declaration//GEN-END:variables
}
