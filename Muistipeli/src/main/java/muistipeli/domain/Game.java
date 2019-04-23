/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.domain;

import java.util.Random;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author hanna
 */

public class Game {
    private int[] numbers = new int[20];
    
    public Game() {
        Random r = new Random();
        
        for (int i = 0; i < 20; i++) {
            numbers[i] = r.nextInt(10);
        }
    }
    
    public int getNumber(int i) {
        return numbers[i];
    }        
    
    public boolean checkNumberSeries(int n, String answer) {
        if (answer.equals("")) {
            return false;
        }
        String[] pieces = answer.split("");
        for (int i = 0; i < n; i++) {
            if (Integer.valueOf(pieces[i]) != numbers[i]) {
                return false;
            }
        }
        
        return true;
    }
    
}
