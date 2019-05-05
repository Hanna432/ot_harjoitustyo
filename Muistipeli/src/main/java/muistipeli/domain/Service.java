/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.domain;

import muistipeli.dao.UserDao;

/**
 *
 * @author hanna
 */
/**
* Luokka vastaa sovelluslogiikasta ja erityisesti toiminnallisuuksista jotka 
* liittyvät käyttäjiin.
*
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

    /**
    * Metodi tarkistaa ensin että onko käyttäjätunnus olemassa ja onko 
    * annettu salasana oikein. Jos on, niin talletetaan käyttäjä kirjautuneeksi.
    *
    * @param   username   käyttäjätunnus
    * @param   password   salasana
    * 
    * @return true jos käyttäjä kirjauduttiin onnistuneesti, muuten false
    */
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
    
    /**
    * Metodi tarkistaa ensin että onko parametrina annettu tulos parempi kuin
    * tämänhetkisen kirjautuneen käyttäjän paras tulos. Jos on, niin 
    * päivitetään käyttäjän paras tulos.
    *
    * @param   result   pelin tulos
    * 
    */
    public void saveResult(int result) {
        if (result > loggedIn.getHighScore()) {
            userDao.updateHighScore(loggedIn.getUsername(), result);
            loggedIn.setHighScore(result);
        }
    }
    
    /**
    * Metodi hakee tietokannasta kaikkien käyttäjien tuloksien keskiarvo.
    * 
    * @return löydetty keskiarvo
    */
    public int getAvarageHighScore() {
        return userDao.getAvarageHighScore();
    }
    
    /**
    * Metodi asettaa service-olion muuttuja loggedIn null:iksi.
    *
    */
    public void logOut() {
        loggedIn = null;
    }
    
    /**
    * Metodi vaihtaa käyttäjän salasana parametrina annetulle salasanalle.
    *
    * @param   password   uusi salasana
    * 
    */
    public void changePassword(String password) {
        userDao.changePassword(loggedIn.getUsername(), password);
        loggedIn.setPassword(password);
    }
    
    /**
    * Metodi poistaa käyttäjäprofiili jonka käyttäjätunnus on 
    * sama kuin annettu parametri
    *
    * @param   username   käyttäjätunnus
    * 
    */
    public void deleteProfile(String username) {
        userDao.delete(username);
    }
    
}
