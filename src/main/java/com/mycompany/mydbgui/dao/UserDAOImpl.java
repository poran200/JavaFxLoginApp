package com.mycompany.mydbgui.dao;



import com.mycompany.mydbgui.config.DbConnection;
import com.mycompany.mydbgui.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class UserDAOImpl implements UserDAO {
   private final Connection dbConnection;
   private PreparedStatement preStat;

    public UserDAOImpl() {
        dbConnection = DbConnection.getConnection();
    }

    @Override
    public User register(User user) {
        return null;
    }

    @Override
    public boolean login(User user) {
        try{
            preStat =dbConnection.prepareStatement("select * from user where  userName= ? and password = md5(?) ");
            preStat.setString(1,user.getUserName());
            preStat.setString(2,user.getPassword());
            var resultSet = preStat.executeQuery();
            var isPresent = resultSet.next();
            System.out.println("UserName = " + resultSet.getString(1));
           return isPresent;
        } catch (SQLException e) {
            Logger.getLogger(UserDAOImpl.class.getName()).info(e.getMessage());
        }
        return false;
    }

    @Override
    public User save(User user) {
        try {
            preStat = dbConnection.prepareStatement("insert into user VALUES(?,MD5(?))");
            preStat.setString(1,user.getUserName());
            preStat.setString(2,user.getPassword());
            var i = preStat.executeUpdate();
            if (i!=-1){
             return  new User(user.getUserName(),"");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<User> findByModel(User user) {
        return null;
    }

    @Override
    public User update(User user) {
//        try {
//            preStatSaveUser = dbConnection.prepareStatement("insert into user VALUES (?,'.md5'(?))");
//            preStatSaveUser.setString(1,user.getUserName());
//            preStatSaveUser.setString(1,user.getPassword());
//            var resultSet = preStatSaveUser.executeQuery();
//            return new User(resultSet.getString(1),resultSet.getString(2));
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        return null;
    }

    @Override
    public Optional<User> finById(String s) {
        try{

          preStat =dbConnection.prepareStatement("select *from user where userName=?");
          preStat.setString(1,s);
            var resultSet = preStat.executeQuery();
            resultSet.next();
            return Optional.of(new User(resultSet.getString(1),resultSet.getString(2)));
        } catch (SQLException e) {
            Logger.getLogger(UserDAOImpl.class.getName()).info(e.getMessage());
        }

        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public boolean removeBYId(String s) {
        return false;
    }

}
