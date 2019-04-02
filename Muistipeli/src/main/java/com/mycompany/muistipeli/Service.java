/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.muistipeli;

import java.sql.SQLException;

/**
 *
 * @author hanna
 */
public class Service {

    private UserDao userDao = new UserDao();
    private User loggedIn;

    public boolean createProfile(String username) {
        if (userDao.read(username) == null) {
            userDao.create(username);
            return true;
        }
        
        return false;
    }

    public boolean logIn(String username) {
        User user = userDao.read(username);
        if (user != null) {
            loggedIn = user;
            return true;
        }
            
        return false;
    }
    
    public User getLoggedIn() {
        return loggedIn;
    }
    
}
