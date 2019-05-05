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
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;

/**
    * Luokka vastaa sovelluksen graafisesta käyttöliittymästä
    *
    */
public class UI extends Application {

    /**
    * Metodi käynnistää sovelluksen graafisen käyttöliittymän parametrina 
    * annettuun ikkunaan.
    *
    * @param   window   sovelluksen käyttämä ikkuna
    */
    @Override
    public void start(Stage window) {
        Service service = new Service();

        Label usernameLabel = new Label("Username");
        Label passwordLabel = new Label("Password");
        TextField username = new TextField();
        PasswordField password = new PasswordField();
        Button logIn = new Button("Log in");
        Button playAsGuest = new Button("Play as a guest");
        Button register = new Button("Register");
        
        VBox componentsUsername = new VBox();
        componentsUsername.getChildren().add(usernameLabel);
        componentsUsername.getChildren().add(username);
        
        VBox componentsPassword = new VBox();
        componentsPassword.getChildren().add(passwordLabel);
        componentsPassword.getChildren().add(password);

        VBox components = new VBox();
        components.setPadding(new Insets(10, 10, 10, 10));
        components.setSpacing(20);
        components.getChildren().add(componentsUsername);
        components.getChildren().add(componentsPassword);
        components.getChildren().add(logIn);
        components.getChildren().add(playAsGuest);
        components.getChildren().add(register);

        Scene home = new Scene(components);
        

        Label usernameRegLabel = new Label("Username");
        Label passwordRegLabel = new Label("Password");
        TextField usernameReg = new TextField();
        PasswordField passwordReg = new PasswordField();
        Button registerReg = new Button("Register");
        
        VBox componentsUsernameReg = new VBox();
        componentsUsernameReg.getChildren().add(usernameRegLabel);
        componentsUsernameReg.getChildren().add(usernameReg);
        
        VBox componentsPasswordReg = new VBox();
        componentsPasswordReg.getChildren().add(passwordRegLabel);
        componentsPasswordReg.getChildren().add(passwordReg);

        VBox componentsReg = new VBox();
        componentsReg.setSpacing(20);
        componentsReg.setPadding(new Insets(10, 10, 10, 10));
        componentsReg.getChildren().add(componentsUsernameReg);
        componentsReg.getChildren().add(componentsPasswordReg);
        componentsReg.getChildren().add(registerReg);

        Scene reg = new Scene(componentsReg);
        

        Label usernameIn = new Label("");
        Button logOut = new Button("Log out");
        Button play = new Button("Play");
        Button settings = new Button("Settings");
        Label result = new Label("");
        Label highScore = new Label("");
        Label avarage = new Label("");

        VBox menu = new VBox();
        menu.setPadding(new Insets(0, 0, 0, 30));
        menu.setSpacing(5);

        menu.getChildren().add(usernameIn);
        menu.getChildren().add(highScore);
        menu.getChildren().add(avarage);
        menu.getChildren().add(settings);
        menu.getChildren().add(logOut);

        BorderPane componentsIn = new BorderPane();
        componentsIn.setPadding(new Insets(0, 0, 10, 10));
        componentsIn.setTop(result);
        componentsIn.setCenter(play);
        componentsIn.setRight(menu);

        Scene in = new Scene(componentsIn);
        
        
        Button changePassword = new Button("Change password");
        Button deleteProfile = new Button("Delete profile");
        Button backFromSettings = new Button("Back");
        
        VBox settingsMenu = new VBox();
        settingsMenu.setSpacing(5);
        settingsMenu.setPadding(new Insets(10, 10, 10, 10));
        
        settingsMenu.getChildren().add(backFromSettings);
        settingsMenu.getChildren().add(changePassword);
        settingsMenu.getChildren().add(deleteProfile);
        
        Scene settingsScene = new Scene(settingsMenu);
        
        
        Label newPasswordLabel = new Label("New password");
        TextField newPassword = new TextField();
        Button changePasswordNow = new Button("Change password");
        Button backToSettings = new Button("Back");
        
        VBox changePasswordMenu = new VBox();
        changePasswordMenu.setSpacing(5);
        changePasswordMenu.setPadding(new Insets(10, 10, 10, 10));
        
        changePasswordMenu.getChildren().add(newPasswordLabel);
        changePasswordMenu.getChildren().add(newPassword);
        changePasswordMenu.getChildren().add(changePasswordNow);
        changePasswordMenu.getChildren().add(backToSettings);
        
        Scene changePasswordScene = new Scene(changePasswordMenu);
        

        register.setOnAction((event) -> {
            username.setText("");
            window.setScene(reg);
        });

        registerReg.setOnAction((event) -> {
            if (service.createProfile(usernameReg.getText(), passwordReg.getText())) {
                window.setScene(home);
            } else {
                usernameReg.setText("Username already exists");
            }
        });

        logIn.setOnAction((event) -> {
            if (service.logIn(username.getText(), password.getText())) {

                settings.setVisible(true);
                usernameIn.setText("Username: " + service.getLoggedIn().getUsername());
                highScore.setText("Highscore: " + service.getLoggedIn().getHighScore());
                avarage.setText("In avarage players' \n  highscore is: " + service.getAvarageHighScore());

                window.setScene(in);
            } else {
                username.setText("wrong username");
            }
        });
        
        playAsGuest.setOnAction((event) -> {
            settings.setVisible(false);
            usernameIn.setText("");
            highScore.setText("");
            avarage.setText("In avarage players' \n  highscore is: " + service.getAvarageHighScore());
            window.setScene(in);
        });

        play.setOnAction((event) -> {
            GameScene gameScene = new GameScene(service, window, in, result, highScore, avarage);
            window.setScene(gameScene.getScene());
            gameScene.play();
        });

        logOut.setOnAction((event) -> {
            service.logOut();
            username.setText("");
            password.setText("");
            result.setText("");
            window.setScene(home);
        });
        
        settings.setOnAction((event) -> {
            window.setScene(settingsScene);
        });
        
        changePassword.setOnAction((event) -> {
            newPassword.setText("");
            window.setScene(changePasswordScene);
        });
        
        changePasswordNow.setOnAction((event) -> {
            service.changePassword(newPassword.getText());
            window.setScene(settingsScene);
            
        });
        
        backToSettings.setOnAction((event) -> {
            window.setScene(settingsScene);
        });
        
        deleteProfile.setOnAction((event) -> {
            service.deleteProfile(service.getLoggedIn().getUsername());
            window.setScene(home);
        });
        
        backFromSettings.setOnAction((event) -> {
            window.setScene(in);
        });

        window.setScene(home);
        window.show();

    }

    /**
    * Sovelluksen main-metodi mistä sovellus käynnistyy
    *
    */
    public static void main(String[] args) {
        makeDatabase();
        launch(UI.class);
    }

    /**
    * Metodi alustaa tietokannan
    *
    */
    public static void makeDatabase() {

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:muistipeli.db")) {
            conn.prepareStatement("CREATE TABLE IF NOT EXISTS User (username VARCHAR(30) PRIMARY KEY, password VARCHAR(20), highScore INTEGER);")
                    .executeUpdate();
        } catch (SQLException e) {
            System.out.println("problem with making the database " + e.getMessage());
        }
    }

}
