/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.domain;

import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author hanna
 */

public class Game {
    private int[] numbers = new int[20];
    private Label number;
    private TextField answerField;
    
    public Game(Label number, TextField answerField) {
        this.number = number;
        this.answerField = answerField;
        
        Random r = new Random();
        
        for (int i = 0; i < 20; i++) {
            numbers[i] = r.nextInt(10);
        }
        
    }
    
    public int play() {
        
        for (int n = 3; n <= 20; n++) {
            
            showNumbers(n);
            
            String answer = saveAnswer(answerField, n);
            if (!checkNumberSeries(n, answer)) {
                int result = 0;
                if (n > 3) {
                    result = n;
                }
                number.setText("Your result: " + result + " numbers!");
                return result;
            }
        }
        
        return 20;
    }
    
    public int getNumber(int i) {
        return numbers[i];
    }
    
    public void showNumbers(int n) {
        for (int i = 0; i < n; i++) {
            number.setText("" + numbers[i]);
            AnimationTimer timer = new AnimationTimer() {
                int index = 0;
                long lastUpdate = 0;
                @Override
                public void handle(long now) {
                    if (now - lastUpdate >= 800_000_000) {
                        number.setText(numbers[index] + "");
                        index++;
                        lastUpdate = now;
                    }
                }
            };
            timer.start();
        }
    }
    
    public String saveAnswer(TextField answerfield, int n) {
//        boolean ready = false;
//        while (!ready) {
//            AnimationTimer timer = new AnimationTimer() {
//                int index = 0;
//                long lastUpdate = 0;
//                boolean ready = false;
//                @Override
//                public void handle(long now) {
//                    if (now - lastUpdate >= 800_000_000) {
//                        if (answerfield.getText() != null) {
//                            ready = true;
//                        }
//                        lastUpdate = now;
//                    }
//                }
//            };
//        }
        
        String answer = answerField.getText();
        while (true) {
            answer = answerField.getText();
            if (answer.length() == n) {
                break;
            }
        }
        return answer;
    }
    
    public boolean checkNumberSeries(int n, String answer) {
        String[] pieces = answer.split("");
        for (int i = 0; i < n; i++) {
            if (Integer.valueOf(pieces[i]) != numbers[i]) {
                return false;
            }
        }
        
        return true;
    }
    
}
