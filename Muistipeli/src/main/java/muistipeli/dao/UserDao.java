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
    
    
    public void create(String u) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:muistipeli.db", "sa", "");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO User (username) VALUES (?)");
            statement.setString(1, u);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Database failure " + e.getMessage());
        }
    }
    
    public User read(String u) {
        ArrayList<User> list = new ArrayList<>();
        
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:muistipeli.db", "sa", "");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM User WHERE username = ?");
            statement.setString(1, u);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                list.add(new User(rs.getString("username")));
            }

            if (list.isEmpty()) {
                return null;
            }

            return list.get(0);
        } catch (SQLException e) {
            System.out.println("Database failure " + e.getMessage());
        }
        return null;
    }
    
    public void delete(String u) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:muistipeli.db", "sa", "");
            PreparedStatement statement = connection.prepareStatement("DELETE FROM User WHERE username = ?");
            statement.setString(1, u);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Database failure " + e.getMessage());
        }
    }
}
