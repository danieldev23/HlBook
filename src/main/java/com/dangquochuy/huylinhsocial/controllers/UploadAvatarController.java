package com.dangquochuy.huylinhsocial.controllers;

import com.dangquochuy.huylinhsocial.models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class UploadAvatarController {

    @FXML
    private ImageView avatar;
    private String avatarImg;
    @FXML
    private Button selectAvatar;
    private FileChooser fileChooser = new FileChooser();

    private Stage primaryStage;

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public ImageView getAvatar() {
        return avatar;
    }

    public void setAvatar(ImageView avatar) {
        this.avatar = avatar;
    }

    public String getAvatarImg() {
        return avatarImg;
    }

    public void setAvatarImg(String avatarImg) {
        this.avatarImg = avatarImg;
    }

    public FileChooser getFileChooser() {
        return fileChooser;
    }

    public void setFileChooser(FileChooser fileChooser) {
        this.fileChooser = fileChooser;
    }

    @FXML
    public void selectAvatar(ActionEvent event) {
        File file = fileChooser.showOpenDialog(selectAvatar.getScene().getWindow());
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            avatar.setImage(image);
            System.out.println(file.toURI().toString());
            setAvatarImg(file.toURI().toString());
        }
    }

    @FXML
    void updateAvatar(ActionEvent event) {
        int userId = new HlBookController().getUserId();
        String image = getAvatarImg();
        if(new User().uploadAvatar(userId, image)) {
            System.out.println("Upload successfully!");
            primaryStage.close();
                new HlBookController().getStage().close();
        }
        System.out.println("Updating avatar with file path: " + avatarImg);
    }
}
