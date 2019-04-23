/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.domain;

import muistipeli.dao.UserDao;
import java.sql.SQLException;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author hanna
 */
public class Service {

    private UserDao userDao = new UserDao();
    private User loggedIn;

    /**
    * Metodi tarkistaa ensin että onko käyttäjätunnus jo olemassa.
    * Jos ei, niin luodaan uusi käyttäjäprofiili.
    *
    * @param   username   käyttäjätunnus
    * @param   password   salasana
    * 
    * @return true jos käyttäjä luotiin onnistuneesti, muuten false
    */
    public boolean createProfile(String username, String password) {
        if (userDao.read(username) == null) {
            userDao.create(username, password);
            return true;
        }
        
        return false;
    }
    
    public void deleteProfile(String username) {
        userDao.delete(username);
    }

    public boolean logIn(String username, String password) {
        User user = userDao.read(username);
        if (user != null && password.equals(user.getPassword())) {
            loggedIn = user;
            return true;
        }
            
        return false;
    }
    
    public User getLoggedIn() {
        return loggedIn;
    }
    
    public void saveResult(int result) {
        if (result > loggedIn.getHighScore()) {
            userDao.updateHighScore(loggedIn.getUsername(), result);
            loggedIn.setHighScore(result);
        }
    }
    
    public int getAvarageHighScore() {
        return userDao.getAvarageHighScore();
    }
    
    public void logOut() {
        loggedIn = null;
    }
    
}
