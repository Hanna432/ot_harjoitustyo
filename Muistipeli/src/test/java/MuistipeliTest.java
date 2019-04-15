/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import muistipeli.domain.Game;
import muistipeli.domain.Service;
import muistipeli.domain.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hanna
 */
public class MuistipeliTest {
    
    User user;
    Service service;
    
    @Before
    public void setUp() {
        user = new User("Liisa", 5);
        service = new Service();
        service.createProfile("testUser");
    }
    
    @After
    public void tearDown() {
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
        assertEquals(false, service.createProfile("testUser"));
    }
    
    @Test
    public void createProfileWhenUsernameDoNotExist() {
        assertEquals(true, service.createProfile("testUser2"));
    }
    
    @Test
    public void logInWhenUsernameExists() {
        assertEquals(true, service.logIn("testUser"));
    }
    
    @Test
    public void logInWhenUsernameDoNotExist() {
        assertEquals(false, service.logIn("testUser3"));
    }
    
    @Test
    public void getLoggedInReturnsLoggedIn() {
        service.logIn("testUser");
        assertEquals("testUser", service.getLoggedIn().getUsername());
    }
    
    @Test
    public void logOutSetsLoggedInToNull() {
        service.logIn("Liisa");
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

    
}
