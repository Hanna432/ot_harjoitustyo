/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.ui;

/**
 *
 * @author hanna
 */
import muistipeli.domain.Game;
import muistipeli.domain.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import java.lang.Object;
import java.util.Random;
import java.util.Timer;
import javafx.animation.AnimationTimer;

public class UI extends Application {
    
    @Override
    public void start(Stage window) {
        Service service = new Service();
        Game game;
        
        TextField username = new TextField();
        Button logIn = new Button("Log in");
        Button register = new Button("Register");
        
        VBox components = new VBox();
        components.setSpacing(20);
        components.getChildren().add(username);
        components.getChildren().add(logIn);
        components.getChildren().add(register);
        
        Scene home = new Scene(components);
        
        
        TextField usernameReg = new TextField();
        Button registerReg = new Button("Register");
        
        VBox componentsReg = new VBox();
        componentsReg.setSpacing(20);
        componentsReg.getChildren().add(usernameReg);
        componentsReg.getChildren().add(registerReg);
        
        Scene reg = new Scene(componentsReg);
//        AnimationTimer timer = new AnimationTimer() {
//            int index=0;
//            @Override
//            public void handle(long now) {
//                test.setText(index+"");
//                index++;
//            }
//        };
//        timer.start();
        Button logOut = new Button("Log out");
        Button play = new Button("Play");
        Label result = new Label("");
        
        VBox menu = new VBox();
        menu.setPadding(new Insets(10, 10, 10, 10));
        
        BorderPane componentsIn = new BorderPane();
        componentsIn.setPadding(new Insets(10, 10, 10, 10));
        componentsIn.setTop(result);
        componentsIn.setCenter(play);
        componentsIn.setRight(menu);

        Scene in = new Scene(componentsIn);
        
        
        
        
        register.setOnAction((event) -> {
            username.setText("");
            window.setScene(reg);
        });
        
        registerReg.setOnAction((event) -> {
            if (service.createProfile(usernameReg.getText())) {
                 window.setScene(home);
            } else {
                usernameReg.setText("Username already exists");
            }
        });
        
        logIn.setOnAction((event) -> {
            if (service.logIn(username.getText())) {
                
                Label usernameIn = new Label(service.getLoggedIn().getUsername());

                menu.getChildren().add(usernameIn);
                menu.getChildren().add(logOut);
                
                window.setScene(in);
            } else {
                username.setText("wrong username");
            }
        });
        
        play.setOnAction((event) -> {
            GameScene gameScene = new GameScene(service, window, in, result);
            window.setScene(gameScene.getScene());
            gameScene.play();
        });
        
        
        
        window.setScene(home);
        window.show();
        
    }
    
    public static void main(String[] args) {
        //makeDatabase();
        launch(UI.class);
    }
    
    public static void makeDatabase() {
        
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:muistipeli.db", "sa", "")) {
            conn.prepareStatement("DROP TABLE IF EXISTS User;").executeUpdate();
            conn.prepareStatement("CREATE TABLE User (username VARCHAR(30) PRIMARY KEY);")
                    .executeUpdate();
        } catch (SQLException e) {
            System.out.println("problem with making the database " + e.getMessage());
        }
    }
    
}
