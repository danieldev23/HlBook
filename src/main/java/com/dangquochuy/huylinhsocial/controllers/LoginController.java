package com.dangquochuy.huylinhsocial.controllers;

import com.dangquochuy.huylinhsocial.HlBookView;
import com.dangquochuy.huylinhsocial.RegisterView;
import com.dangquochuy.huylinhsocial.models.User;
import com.dangquochuy.huylinhsocial.utils.Encrypt;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    public Button btnLogin;

    private Stage stage;
    @FXML
    public Button btnSignup;

    @FXML
    public TextField email;

    @FXML
    public PasswordField password;

    @FXML
    public Label warning;

    private static String emailText;

    private static String pass;

    public String getEmailText() {
        return emailText;
    }

    public void setEmailText(String emailText) {
        this.emailText = emailText;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public String getEmail() {
        return email.getText();
    }
    public String getPassword() {
        return password.getText();
    }
    @FXML
    public void signup(ActionEvent e) {
        showSignupView();
    }
    @FXML
    public void login(ActionEvent event) throws SQLException, InterruptedException {
        String email = getEmail();
        String password = getPassword();
        String encPassword = new Encrypt().endcodePassword(password);
        System.out.println(encPassword);
        if (new User().validateUser(email, encPassword)) {
            setEmailText(email);
            setPass(password);
            showHlBookView();
            stage.close();
        }
        else {
            warning.setVisible(true);
            Thread.sleep(1000);
            warning.setVisible(false);
        }

    }

    private void showHlBookView() {
        try {
            new HlBookView().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showSignupView() {
        try {
            new RegisterView().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
@Override
    public void initialize(URL location, ResourceBundle resources) {
        email.setText(getEmailText());
        password.setText(getPass());
}
}
