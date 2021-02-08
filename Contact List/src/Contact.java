/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//import contactlist.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author nadat
 */
public class Contact {
    
    private String Fname, Mname, Lname;
    private int ContactId;
    private String[][] Address,Date,Phone;
    
    Contact(String Fname, String Mname, String Lname, String Date[][],String Address[][], String Phone[][]){
        this.Fname = Fname;
        this.Mname = Mname;
        this.Lname = Lname;
        this.Date = Date;
        this.Address = Address;
        this.Phone = Phone;
        
    }
    
    public void insert(){
        try
        {
            Connection con = connector.get();
            
            //Insert Contact
            String sqlContact = "insert into contact (Fname, Mname, Lname) values (?,?,?)";
            PreparedStatement psContact = con.prepareStatement(sqlContact);
            psContact.setString(1, this.Fname);
            psContact.setString(2, this.Mname);
            psContact.setString(3, this.Lname);
            psContact.execute();
            
            String sqlContact2 = "select * from contact where Fname = '"+this.Fname+"' AND Mname = '"+this.Mname+"' AND Lname = '"+this.Lname+"'";
            PreparedStatement psContact2 = con.prepareStatement(sqlContact2);
            ResultSet rs = psContact2.executeQuery();
            
            while(rs.next())
                {
                  this.ContactId = rs.getInt("contact_id");
                       
                }
            
            //Insert Address
            for(int i=0; i<Address.length; i++)
            {
                String sqlAddress = "insert into address (contact_id,address_type, address, city, state, zip) values (?,?,?,?,?,?)";
                PreparedStatement psAddress = con.prepareStatement(sqlAddress);
                
                psAddress.setInt(1, this.ContactId);
                psAddress.setString(2, this.Address[i][0]);//addressType
                psAddress.setString(3, this.Address[i][1]);//street address
                psAddress.setString(4, this.Address[i][2]);//city
                psAddress.setString(5, this.Address[i][3]);//state
                psAddress.setString(6, this.Address[i][4]);//zip
                psAddress.execute();
            }
            
            //Insert Phone
            for(int i=0; i<Phone.length; i++)
            {   
                String sqlPhone = "insert into phone (contact_id, phone_type, area_code, number) values (?,?,?,?)";
                PreparedStatement psPhone = con.prepareStatement(sqlPhone);
                
                psPhone.setInt(1, this.ContactId);
                psPhone.setString(2, this.Phone[i][0]);//PhoneTYpe
                psPhone.setString(3, this.Phone[i][1]);//AreaCode
                psPhone.setString(4, this.Phone[i][2]);//Number
                psPhone.execute();
            }
            
            
            //insert date
            for(int i=0; i<Date.length; i++)
            {   
                String sqlDate = "insert into date (contact_id, date_type, date) values (?,?,?)";
                PreparedStatement psDate = con.prepareStatement(sqlDate);
                
                psDate.setInt(1, this.ContactId);
                psDate.setString(2, this.Date[i][0]);//DateType
                psDate.setString(3, this.Date[i][1]);//Date
                psDate.execute();
            }
            
            JOptionPane.showMessageDialog(null, "Contact added successfully");
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
    }
            
}
