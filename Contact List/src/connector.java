/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//import contactlist.*;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author nadat
 */
public class connector {
    public static Connection get() throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/contact","root","");
        return con;
    }
}
