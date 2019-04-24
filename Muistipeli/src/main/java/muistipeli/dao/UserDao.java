/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.dao;

/**
 *
 * @author hanna
 */
import muistipeli.domain.User;
import java.sql.*;
import java.util.ArrayList;

public class UserDao {
    
    /**
    * Metodi muodostaa yhteyden tietokantaan ja lisää sinne uuden rivin
    * , eli uuden käyttäjän, parametrina annetuilla tiedoilla.
    *
    * @param   u   käyttäjätunnus
    * @param   p   salasana
    * 
    */
    public void create(String u, String p) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:muistipeli.db", "sa", "");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO User (username, password, highScore) VALUES (?, ?, ?)");
            statement.setString(1, u);
            statement.setString(2, p);
            statement.setInt(3, 0);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Database failure " + e.getMessage());
        }
    }
    
    /**
    * Metodi muodostaa yhteyden tietokantaan ja hakee sieltä rivin
    * jossa käyttäjätunnus on sama kuin parametrina annettu tunnus.
    *
    * @param   u   käyttäjätunnus
    * 
    * @return löydetystä rivistä muodostettu käyttäjä
    */
    public User read(String u) {
        ArrayList<User> list = new ArrayList<>();
        
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:muistipeli.db", "sa", "");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM User WHERE username = ?");
            statement.setString(1, u);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                list.add(new User(rs.getString("username"), rs.getString("password"), rs.getInt("highScore")));
            }

            if (list.isEmpty()) {
                return null;
            }
            
            connection.close();
            
            return list.get(0);
        } catch (SQLException e) {
            System.out.println("Database failure " + e.getMessage());
        }
        return null;
    }
    
    /**
    * Metodi muodostaa yhteyden tietokantaan ja poistaa rivin
    * jossa käyttäjätunnus on sama kuin parametrina annettu tunnus.
    *
    * @param   u   käyttäjätunnus
    * 
    */
    public void delete(String u) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:muistipeli.db", "sa", "");
            PreparedStatement statement = connection.prepareStatement("DELETE FROM User WHERE username = ?");
            statement.setString(1, u);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Database failure " + e.getMessage());
        }
    }
    
    /**
    * Metodi muodostaa yhteyden tietokantaan ja päivittää rivin
    * jossa käyttäjätunnus on sama kuin parametrina annettu tunnus 
    * parametrina annetulla tiedolla
    *
    * @param   u   käyttäjätunnus
    * @param   h   highscore
    * 
    */
    public void updateHighScore(String u, int h) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:muistipeli.db", "sa", "");
            PreparedStatement statement = connection.prepareStatement("UPDATE User SET highScore = ? WHERE username = ?");
            statement.setInt(1, h);
            statement.setString(2, u);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Database failure " + e.getMessage());
        }
    }
    
    /**
    * Metodi muodostaa yhteyden tietokantaan ja hakee sieltä kaikkien käyttäjien 
    * tuloksien keskiarvo.
    * 
    * @return löydetty keskiarvo
    */
    public int getAvarageHighScore() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:muistipeli.db", "sa", "");
            PreparedStatement statement = connection.prepareStatement("SELECT AVG(highScore) FROM User");
            ResultSet rs = statement.executeQuery();
            int a = rs.getInt("AVG(highScore)");
            connection.close();
            return a;
        } catch (SQLException e) {
            System.out.println("Database failure " + e.getMessage());
        }
        return 100;
    }
}
