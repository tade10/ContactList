/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//import contactlist.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author tade
 */
public class ContactList {
    
    public void addContact(String Fname, String Mname, String Lname, String Date[][], String Address[][],String Phone[][]){
        Contact con = new Contact(Fname, Mname, Lname, Date, Address,Phone);
        con.insert();
        
    }
    
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    
    public void updateName(int contactId, String fname, String mname, String lname){
        
        try
        {
            Connection con = connector.get();
            
            //Insert Contact
            String sqlContact = "UPDATE contact SET Fname = ?, Mname = ?, Lname = ? where Contact_id = ?";
            PreparedStatement psContact = con.prepareStatement(sqlContact);
            
            psContact.setString(1, fname);
            psContact.setString(2, mname);
            psContact.setString(3, lname);
            psContact.setInt(4, contactId);
            psContact.execute();
            
            JOptionPane.showMessageDialog(null, "Name updated successfully");
            
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
        
    }
    public void deleteContact(int contactId){
        try
        {
            Connection con = connector.get();
            
            //Delete Date
            String sqlDate = "delete from date where Contact_id = '"+contactId+"'";
            PreparedStatement psDate = con.prepareStatement(sqlDate);
            psDate.execute();
            
            //Delete Address
            String sqlAddress = "delete from address where Contact_id = '"+contactId+"'";
            PreparedStatement psAddress = con.prepareStatement(sqlAddress);
            psAddress.execute();
            
            //Delete Phone
            String sqlPhone = "delete from phone where Contact_id = '"+contactId+"'";
            PreparedStatement psPhone = con.prepareStatement(sqlPhone);
            psPhone.execute();
            
            //remove check on foreign key
            String sqlCheck = "SET FOREIGN_KEY_CHECKS = 0;";
            PreparedStatement psCheck = con.prepareStatement(sqlCheck);
            psCheck.execute();
            
            //Delete Contact
            String sqlContact = "delete from contact where Contact_id = '"+contactId+"'";
            PreparedStatement psContact = con.prepareStatement(sqlContact);
            psContact.execute();
            
            //Add back check on foreign key
            sqlCheck = "SET FOREIGN_KEY_CHECKS = 1;";
            psCheck = con.prepareStatement(sqlCheck);
            psCheck.execute();
            
            
            JOptionPane.showMessageDialog(null, "Contact deleted successfully");
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public void deleteRow(int rowId, String table){
        try
        {
            
            Connection con = connector.get();
            
            String sql = "";
            if(table == "phone"){
                sql = "delete from phone where Phone_id = '"+rowId+"'";
             }
            else if(table == "address"){
                sql = "delete from address where Address_id = '"+rowId+"'";
             }
            else if(table == "date"){
                sql = "delete from date where Date_id = '"+rowId+"'";
             }
            PreparedStatement psAddress = con.prepareStatement(sql);
            psAddress.execute();
            
            JOptionPane.showMessageDialog(null, "Deletion successful");
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public HashMap search(String key){
        
        HashMap<String, String> searchList = new HashMap<String, String>();
        
        try{
            // step 1: storing all the data from database in separate arrayList
            
            Connection con = connector.get();
            
            String sqlContact = "select * from contact";
            PreparedStatement psContact =  con.prepareStatement(sqlContact);
            ResultSet rsContact = psContact.executeQuery();
            
            ArrayList<String[]> contactArrayList = new ArrayList<String[]>();
            while(rsContact.next())
            {
                String[] row = new String[4];
                row[0] = String.valueOf(rsContact.getInt("contact_id"));
                row[1] = rsContact.getString("Fname");
                row[2] = rsContact.getString("Mname");
                row[3] = rsContact.getString("Lname");
                contactArrayList.add(row);
            }
            
            String sqlDate = "select * from date";
            PreparedStatement psDate =  con.prepareStatement(sqlDate);
            ResultSet rsDate = psDate.executeQuery();
            
            ArrayList<String[]> dateArrayList = new ArrayList<String[]>();
            while(rsDate.next())
            {
                String[] row = new String[4];
                row[0] = String.valueOf(rsDate.getInt("Date_id"));
                row[1] = String.valueOf(rsDate.getInt("Contact_id"));
                row[2] = rsDate.getString("Date_type");
                row[3] = rsDate.getString("Date");
                dateArrayList.add(row);
            }
            
            String sqlAddress = "select * from address";
            PreparedStatement psAddress =  con.prepareStatement(sqlAddress);
            ResultSet rsAddress = psAddress.executeQuery();
            
            ArrayList<String[]> addressArrayList = new ArrayList<String[]>();
            while(rsAddress.next())
            {
                String[] row = new String[7];
                row[0] = String.valueOf(rsAddress.getInt("Address_id"));
                row[1] = String.valueOf(rsAddress.getInt("Contact_id"));
                row[2] = rsAddress.getString("Address_type");
                row[3] = rsAddress.getString("Address");
                row[4] = rsAddress.getString("City");
                row[5] = rsAddress.getString("State");
                row[6] = rsAddress.getString("Zip");
                addressArrayList.add(row);
            }
            
            String sqlPhone = "select * from phone";
            PreparedStatement psPhone =  con.prepareStatement(sqlPhone);
            ResultSet rsPhone = psPhone.executeQuery();
            
            ArrayList<String[]>phoneArrayList = new ArrayList<String[]>();
            while(rsPhone.next())
            {
                String[] row = new String[5];
                row[0] = String.valueOf(rsPhone.getInt("Phone_id"));
                row[1] = String.valueOf(rsPhone.getInt("Contact_id"));
                row[2] = rsPhone.getString("Phone_type");
                row[3] = rsPhone.getString("Area_code");
                row[4] = rsPhone.getString("Number");
                phoneArrayList.add(row);
            }
            
           //step 2: (a)checking all the arraylist with the 'key'
           //        (b)storing the matched contact_id in hashMap
           
           
            //looping through all the contacts
           for(int i=0; i<contactArrayList.size(); i++){
               
               String[] row = new String[4];
               row = contactArrayList.get(i);
               
               //looping within a contact
               for(int j=0; j<row.length; j++){
                   //if contacts contains the search key
                   if(row[j].contains(key)){
                       //add contact_id into hashMap
                       searchList.put(row[0], row[j]);
                   }
               }
           }
           
           //looping through all the dates
           for(int i=0; i<dateArrayList.size(); i++){
               
               String[] row = new String[4];
               row = dateArrayList.get(i);
               
               //looping within a contact
               for(int j=0; j<row.length; j++){
                   //if date contains the search key
                   if(row[j].contains(key)){
                       //add contact_id into hashMap
                       searchList.put(row[1], row[j]);
                   }
               }
           }
           
           //looping through all the address
           for(int i=0; i<addressArrayList.size(); i++){
               
               String[] row = new String[7];
               row = addressArrayList.get(i);
               
               //looping within a contact
               for(int j=0; j<row.length; j++){
                   //if address contains the search key
                   if(row[j].contains(key)){
                       //add contact_id into hashMap
                       searchList.put(row[1], row[j]);
                   }
               }
           }
           
           //looping through all the phones
           for(int i=0; i<phoneArrayList.size(); i++){
               
               String[] row = new String[7];
               row = phoneArrayList.get(i);
               
               //looping within a contact
               for(int j=0; j<row.length; j++){
                   //if phone contains the search key
                   if(row[j].contains(key)){
                       //add contact_id into hashMap
                       searchList.put(row[1], row[j]);
                   }
               }
           }
           
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return searchList;
    }
    
    // finds if a number is between given range
    public static boolean inRange(int begin, int end, int number){
        
        if(number < begin||number>end){
            return false;
        }
        return true;
    }
    
}
