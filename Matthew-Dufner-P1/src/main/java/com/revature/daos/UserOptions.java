package com.revature.daos;

import com.revature.pojos.User;
import com.revature.services.DatabaseServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserOptions implements DatabaseCRUD<User> {

    Connection connection;

    public UserOptions(Connection connection){
        this.connection = connection;
    }

    public UserOptions() {
        connection = DatabaseServices.getConnection();
    }

    @Override
    public void create(User user){
        try{
            String sql = "INSERT INTO users (first_name, last_name, user_pass, user_admin, email) " +
                    "VALUES (?, ?, ?, false, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getUserPass());
            pstmt.setString(4, user.getEmail());

            pstmt.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public User read(int id) {
        User user = new User();

        try{
            String sql = "SELECT * FROM users WHERE user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet results = pstmt.executeQuery();


            if(results.next()){
                user.setUserID(results.getInt("user_id"));
                user.setFirstName(results.getString("first_name"));
                user.setLastName(results.getString("last_name"));
                user.setUserPass(results.getString("user_pass"));
                user.setUserAdmin(results.getBoolean("user_admin"));
                user.setEmail(results.getString("email"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> readAll() {
        List<User> userList = new LinkedList<>();

        try{
            String sql = "SELECT * FROM users";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet results = pstmt.executeQuery();

            while(results.next()){
                User user = new User();
                user.setUserID(results.getInt("user_id"));
                user.setFirstName(results.getString("first_name"));
                user.setLastName(results.getString("last_name"));
                user.setUserPass(results.getString("user_pass"));
                user.setUserAdmin(results.getBoolean("user_admin"));
                user.setEmail(results.getString("email"));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public void update(User user) {

        try{

            String sql = "UPDATE users SET first_name = ?, last_name = ?, user_pass = ?, user_admin = false, email = ?, WHERE user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getUserPass());
            pstmt.setString(5, user.getEmail());


        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int id) {
        try{
            String sql = "DELETE FROM users WHERE user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    /*public Boolean checkAdmin(User user){



        try{
            String sql = "SELECT * FROM users WHERE user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setObject(1, user);
            ResultSet results = pstmt.executeQuery();

            user.setUserAdmin(results.getBoolean("user_admin"));

        } catch (SQLException e){
            e.printStackTrace();
        }
    }*/


}
