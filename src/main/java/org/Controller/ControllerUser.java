package org.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.ConnectionManager.ConnectionManager;
import org.Model.User;

public class ControllerUser {
    static String query = "";
    static User user;
    
    public int login(String pin){
        int loginStatus = 0;
        user = new User();
        
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.LogOn();
        
        query = "SELECT * FROM user WHERE pin = "+pin;
        try{
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
            while(rs.next()){
                if(String.valueOf(rs.getInt("pin")).equals(pin)){
                    if(rs.getString("role").equals("Admin")){
                        loginStatus = 1;
                    }else if(rs.getString("role").equals("Waiter")){
                        loginStatus = 2;
                    }else{
                        loginStatus = 3;
                    }
                                       
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

    public boolean insertUser(int pin, String username, String role){
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.LogOn();
        
        query = "INSERT INTO user VALUES ("
                + ""+ pin +", "
                + "'"+ username +"', "
                + "'"+ role +"')";
        
        try{
            Statement stm = con.createStatement();
            stm.executeUpdate(query);
            
            conMan.LogOff();
            return true;
        } catch (Exception ex){
            System.out.println(ex.toString());
            
            conMan.LogOff();
            return false;
        }
    }
    
    public boolean updateUser(int pin, String username, String role){
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.LogOn();
        
        query = "UPDATE user SET "
                + "username = '"+username+"', "
                + "role = '"+role+"' "
                + "WHERE pin = "+pin;
        
        try{
            Statement stm = con.createStatement();
            stm.executeUpdate(query);
            
            conMan.LogOff();
            return true;
        } catch (Exception ex){
            System.out.println(ex.toString());
            
            conMan.LogOff();
            return false;
        }
    }
    
    
    public boolean deleteUser(int pin){
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.LogOn();
        
        query = "DELETE FROM user WHERE pin = "+pin;
        
        try{
            Statement stm = con.createStatement();
            stm.executeUpdate(query);
            
            conMan.LogOff();
            return true;
        } catch (Exception ex){
            System.out.println(ex.toString());
            
            conMan.LogOff();
            return false;
        }
    }
    
    public static User getUser() {
        return user;
    }
    
}
