/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.muistipeli.User;
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
    
    @Before
    public void setUp() {
        user = new User("Liisa");
    }
    
    @Test
    public void testi() {
        assertEquals("Liisa", user.getUsername());
    }

    
}
