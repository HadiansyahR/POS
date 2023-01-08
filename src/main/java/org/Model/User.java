package org.Model;

public class User {
    private int pin;
    private String username;
    private String role;

    public User() {
    }

    public User(int pin, String username, String role) {
        this.pin = pin;
        this.username = username;
        this.role = role;
    }

    /**
     * @return the pin
     */
    public int getPin() {
        return pin;
    }
    
    /**
     * @param pin the pin to set
     */
    public void setPin(int pin) {
        this.pin = pin;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }
}
