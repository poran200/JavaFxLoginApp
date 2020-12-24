package com.mycompany.mydbgui;

import com.mycompany.mydbgui.config.DbConnection;
import com.mycompany.mydbgui.dao.UserDAO;
import com.mycompany.mydbgui.dao.UserDAOImpl;
import com.mycompany.mydbgui.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable {
    private final UserDAO dao;
    public TextField userNameTextfield;
    public PasswordField passwordTextfield;
    public Label statusLabel;
    public Button registerButton;
    public Button logOutButton;
    public Button logInButton;
    boolean isUserLoggedIn = false;
    public PrimaryController() {
        this.dao = new UserDAOImpl();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        DbConnection.getConnection();
        statusLabel.setText("Create Account Or Login!");
        System.out.println("connection created");
        logOutButton.setVisible(false);
    }


    public void onLoginAction(ActionEvent actionEvent) {
        var login = dao.login(new User(userNameTextfield.getText(), passwordTextfield.getText()));
        if (login){
            isUserLoggedIn = true;
            logOutButton.setVisible(true);
           statusLabel.setText("You are logged in - "+userNameTextfield.getText());
           registerButton.setVisible(false);
           logInButton.setVisible(false);
           clearField();
        }else {
            statusLabel.setText("Bad credential");
            registerButton.setVisible(true);
        }

    }

    public void onRegisterButtonAction(ActionEvent actionEvent) {
        User user = new User();
        if (userNameTextfield.getText().isEmpty() || passwordTextfield.getText().isEmpty()){
            statusLabel.setText("User name or password can not empty");
        }
        user.setUserName(userNameTextfield.getText().trim());
        user.setPassword(passwordTextfield.getText());
        var optionalUser = dao.finById(user.getUserName());
        if (optionalUser.isPresent()){
            statusLabel.setText("user name already exits");
        }else {
            var save = dao.save(user);
            if (save!= null){
                statusLabel.setText("");
                statusLabel.setText("Registration Successfully User : "+user.getUserName());
            }
        }
    }

    public void onlogoutAction(ActionEvent actionEvent) {
        registerButton.setVisible(true);
        logInButton.setVisible(true);
        statusLabel.setText("");
        statusLabel.setText("Log out :)");
    }
    public void clearField(){
        if (isUserLoggedIn){
            userNameTextfield.clear();
            passwordTextfield.clear();
        }
    }
}
