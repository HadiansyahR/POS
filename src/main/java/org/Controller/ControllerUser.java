package org.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.ConnectionManager.ConnectionManager;
import org.Model.User;

public class ControllerUser {
    static String query = "";
    
    private int Login(int pin){
        int loginStatus = 0;
        User user = new User();
        
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.LogOn();
        
        query = "SELECT * FROM user WHERE pin = "+pin;
        try{
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
            while(rs.next()){
                if(rs.getInt("pin") == pin){
                    loginStatus = 1;
                    
                    user.setPin(rs.getInt("pin"));
                    user.setUsername(rs.getString("username"));
                    user.setRole(rs.getString("role"));
                    
                    
                }
                else{
                    loginStatus = 0;
                }
            }
                        
        }catch (SQLException e){
            e.getMessage();
        }
        conMan.LogOff();
        return loginStatus;
    }
}
