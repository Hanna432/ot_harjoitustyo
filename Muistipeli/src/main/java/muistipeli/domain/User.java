/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.domain;

/**
 *
 * @author hanna
 */
/**
* Luokka vastaa sovelluksen käyttäjistä.
*
*/
public class User {
    private String username;
    private String password;
    private int highScore;
    
    public User(String u, String p, int h) {
        this.username = u;
        this.password = p;
        this.highScore = h;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String p) {
        password = p;
    }
    
    public int getHighScore() {
        return highScore;
    }
    
    public void setHighScore(int h) {
        highScore = h;
    }
    
}
