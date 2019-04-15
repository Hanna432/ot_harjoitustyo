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
public class User {
    private String username;
    private int highScore;
    
    public User(String u, int h) {
        this.username = u;
        this.highScore = h;
    }
    
    public String getUsername() {
        return username;
    }
    
    public int getHighScore() {
        return highScore;
    }
    
    public void setHighScore(int h) {
        highScore = h;
    }
    
}
