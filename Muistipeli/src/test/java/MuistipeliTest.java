/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import muistipeli.dao.UserDao;
import muistipeli.domain.Game;
import muistipeli.domain.Service;
import muistipeli.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hanna
 */
public class MuistipeliTest {
    
    User user;
    Service service;
    UserDao userDao;
    
    @Before
    public void setUp() {
        user = new User("Liisa", "l", 5);
        service = new Service();
        service.createProfile("testUser", "p");
        userDao = new UserDao();
    }
    
    @After
    public void tearDown() {
        service.deleteProfile("testUser");
        service.deleteProfile("testUser2");
    }
    
    @Test
    public void getUsernameTest() {
        assertEquals("Liisa", user.getUsername());
    }
    
    @Test
    public void getHighScoreTest() {
        assertEquals(5, user.getHighScore());
    }
    
    @Test
    public void createProfileWhenUsernameAlreadyExists() {
        assertEquals(false, service.createProfile("testUser", "p"));
    }
    
    @Test
    public void createProfileWhenUsernameDoesNotExist() {
        assertEquals(true, service.createProfile("testUser2", "p2"));
    }
    
    @Test
    public void logInWhenUsernameExistsAndPasswordRight() {
        assertEquals(true, service.logIn("testUser", "p"));
    }
    
    @Test
    public void logInWhenUsernameExistsAndPasswordWrong() {
        assertEquals(false, service.logIn("testUser", "p2"));
    }
    
    @Test
    public void logInWhenUsernameDoesNotExist() {
        assertEquals(false, service.logIn("testUser3", "p"));
    }
    
    @Test
    public void getLoggedInReturnsLoggedIn() {
        service.logIn("testUser", "p");
        assertEquals("testUser", service.getLoggedIn().getUsername());
    }
    
    @Test
    public void logOutSetsLoggedInToNull() {
        service.logIn("testUser", "p");
        service.logOut();
        assertEquals(null, service.getLoggedIn());
    }
    
    @Test
    public void gameTestWhenAnswerIsCorrect() {
        Game game = new Game();
        String answer = "" + game.getNumber(0) + game.getNumber(1) + game.getNumber(2);
        assertEquals(true, game.checkNumberSeries(3, answer));
    }
    
    @Test
    public void gameTestWhenAnswerIsNotCorrect() {
        Game game = new Game();
        String answer = "" + 0;
        assertEquals(false, game.checkNumberSeries(3, answer));
    }
    
    @Test
    public void saveResultUpdatesHighscoreWhenNewHighscore() {
        service.logIn("testUser", "p");
        service.saveResult(3);
        assertEquals(3, userDao.read("testUser").getHighScore());
    }
    
    @Test
    public void saveResultDoesNotUpdateHighscoreWhenNotNewHighscore() {
        service.logIn("testUser", "p");
        service.saveResult(5);
        service.saveResult(3);
        assertEquals(5, userDao.read("testUser").getHighScore());
    }
    
    @Test
    public void changePassword() {
        service.logIn("testUser", "p");
        service.changePassword("p3");
        assertEquals("p3", service.getLoggedIn().getPassword());
    }

    
}
