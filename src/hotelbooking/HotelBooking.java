/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbooking;
import java.util.*;
import java.sql.*;
/**
 *
 * @author Kushagra Srivastava
 */
public class HotelBooking {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        HomePage HP = new HomePage();
        HP.setVisible(true);
        
        /*Connection myconn = null;
        Statement mystat = null;
        ResultSet myresult = null;
        
        try{
            myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels","root","n!gg3|2f@gg0t");
            mystat =  myconn.createStatement();
            myresult = mystat.executeQuery("select * from hotels");
            while(myresult.next()){
                System.out.println(myresult.getString("Name" )+" "+myresult.getString("Rating")+" "+myresult.getString("Location"));
            }
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
        }*/
    }
    
}
