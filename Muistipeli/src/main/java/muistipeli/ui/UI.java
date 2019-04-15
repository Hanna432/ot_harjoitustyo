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

public class UI extends Application {

    @Override
    public void start(Stage window) {
        Service service = new Service();

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

        Label usernameIn = new Label("");
        Button logOut = new Button("Log out");
        Button play = new Button("Play");
        Label result = new Label("");
        Label highScore = new Label("");
        Label avarage = new Label("");
        usernameIn.setPadding(new Insets(0, 2, 2, 2));
        logOut.setPadding(new Insets(5, 5, 5, 5));
        highScore.setPadding(new Insets(2, 2, 2, 2));
        avarage.setPadding(new Insets(2, 2, 6, 2));

        VBox menu = new VBox();
        menu.setPadding(new Insets(0, 0, 0, 30));

        menu.getChildren().add(usernameIn);
        menu.getChildren().add(highScore);
        menu.getChildren().add(avarage);
        menu.getChildren().add(logOut);

        BorderPane componentsIn = new BorderPane();
        componentsIn.setPadding(new Insets(0, 0, 10, 10));
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

                usernameIn.setText("Username: " + service.getLoggedIn().getUsername());
                highScore.setText("Highscore: " + service.getLoggedIn().getHighScore());
                avarage.setText("In avarage players' \n  highscore is: " + service.getAvarageHighScore());

                window.setScene(in);
            } else {
                username.setText("wrong username");
            }
        });

        play.setOnAction((event) -> {
            GameScene gameScene = new GameScene(service, window, in, result, highScore, avarage);
            window.setScene(gameScene.getScene());
            gameScene.play();
        });

        logOut.setOnAction((event) -> {
            service.logOut();
            username.setText("");
            window.setScene(home);
        });

        window.setScene(home);
        window.show();

    }

    public static void main(String[] args) {
        makeDatabase();
        launch(UI.class);
    }

    public static void makeDatabase() {

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:muistipeli.db")) {
//            conn.prepareStatement("DROP TABLE IF EXISTS User;").executeUpdate();
            conn.prepareStatement("CREATE TABLE IF NOT EXISTS User (username VARCHAR(30) PRIMARY KEY, highScore INTEGER);")
                    .executeUpdate();
        } catch (SQLException e) {
            System.out.println("problem with making the database " + e.getMessage());
        }
    }

}
