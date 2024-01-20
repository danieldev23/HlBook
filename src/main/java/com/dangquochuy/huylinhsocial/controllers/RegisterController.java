package com.dangquochuy.huylinhsocial.controllers;

import com.dangquochuy.huylinhsocial.LoginView;
import com.dangquochuy.huylinhsocial.models.User;
import com.dangquochuy.huylinhsocial.utils.Encrypt;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.dangquochuy.huylinhsocial.utils.Encrypt.endcodePassword;

public class RegisterController {
    private Stage stage;
    @FXML
    private TextField birthday;

    @FXML
    private TextField email;

    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private Label warning;

    private String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

    private String passRegex = "^[A-Z][a-z0-9!@$%]{7,}";

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public String getBirthday() {
        return birthday.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    public String getName() {
        return name.getText();
    }

    public String getPassword() {
        return password.getText();
    }

    public Label getWarning() {
        return warning;
    }

    @FXML
    void login(ActionEvent event) {
        showLoginView();
    }

    @FXML
    public void register(ActionEvent event) throws SQLException, InterruptedException {
        String name = getName();
        String birthday = getBirthday();
        String email = getEmail();
        String password = getPassword();
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcherEmail = pattern.matcher(email);
        Pattern patternPassword = Pattern.compile(passRegex);
        Matcher matcherPassword = pattern.matcher(password);
        System.out.println("Email: " + email + " " + matcherEmail.matches());
        System.out.println("Password: " + password + " " + matcherPassword.matches());

        if(matcherEmail.matches()) {
            if (new User().addUser(name, birthday, email, new Encrypt().endcodePassword(password))) {
                warning.setText("Đăng ký thành công!");
                getStage().close();
                showLoginView();

            }
        }
        else {
            warning.setText("Email không đúng định dạng!");

        }
    }


    public void showLoginView() {
        try {
            new LoginView().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(endcodePassword("huy123"));
    }
}
