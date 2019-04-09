/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        user = new User("Liisa");
        service = new Service();
        service.createProfile("testUser");
    }
    
    @After
    public void tearDown() {
        service.deleteProfile("testUser2");
    }
    
    @Test
    public void userClassTest() {
        assertEquals("Liisa", user.getUsername());
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

    
}
