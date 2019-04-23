package muistipeli.ui;


import muistipeli.domain.Game;
import muistipeli.domain.Service;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hanna
 */
public class GameScene {
    private final Game game;
    private Label number = new Label("");
    private TextField answerField = new TextField("");
    private Button done = new Button("Done");
    private int n = 3;
    private Service service;
    private Stage window;
    private Scene in;
    private Label result;
    private Label highScore;
    private Label avarage;
    
    public GameScene(Service service, Stage window, Scene in, Label result, Label highScore, Label avarage) {
        this.game = new Game();
        this.service = service;
        this.window = window;
        this.in = in;
        this.result = result;
        this.highScore = highScore;
        this.avarage = avarage;
    }

    public Scene getScene() {
        
        BorderPane componentsGame = new BorderPane();
        componentsGame.setPadding(new Insets(30, 30, 30, 30));
        componentsGame.setCenter(number);
        componentsGame.setBottom(answerField);
        componentsGame.setRight(done);
        Scene sceneGame = new Scene(componentsGame);
        return sceneGame;
    }

    public void play() {
        answerField.setText("");
        for (int i = 0; i < n; i++) {
            number.setText(game.getNumber(i) + "");

            AnimationTimer timer = new AnimationTimer() {
                int index = 0;
                int updateIndex = 0;
                long lastUpdate = 0;
                int m = n;

                @Override
                public void handle(long now) {
                    if (now - lastUpdate >= 50_000_000) {
                        if (index < m) {
                            if (updateIndex % 16 == 0) {
                                number.setText(game.getNumber(index) + "");
                                answerField.setText("");
                            }
                            if (updateIndex % 16 == 15) {
                                number.setText("");
                                index++;
                            }
                            updateIndex++;
                            lastUpdate = now;
                        } else if (index == m) {
                            number.setText("");
                            index++;
                        }
                    }
                }
            };
            timer.start();
            number.setText("");
        }

        done.setOnAction((event) -> {
            String answer = answerField.getText();
            if (!game.checkNumberSeries(n, answer)) {
                int r = 0;
                if (n > 3) {
                    r = n - 1;
                }
                
                if (service.getLoggedIn() != null) {
                    service.saveResult(r);
                    highScore.setText("Highscore: " + service.getLoggedIn().getHighScore());
                    avarage.setText("In avarage players' \n  highscore is: " + service.getAvarageHighScore());
                }
                result.setText("Score: " + r);
                window.setScene(in);
            } else {
                n++;
                play();
            }
        });
    }
    
    
    
}
