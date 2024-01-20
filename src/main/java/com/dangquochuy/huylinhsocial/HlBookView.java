package com.dangquochuy.huylinhsocial;

import com.dangquochuy.huylinhsocial.controllers.HlBookController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration; // Make sure to import javafx.util.Duration

import java.io.IOException;

public class HlBookView extends Application{
    private Stage primaryStage;
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/dangquochuy/huylinhsocial/fxml/home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1286, 890);
        HlBookController hl = fxmlLoader.getController();
        hl.setStage(stage);
        stage.setTitle("HLBook");
        stage.setScene(scene);
        stage.show();
//        if(new HlBookController().getAvatar() == null) {
            Duration delay;
            delay = Duration.seconds(10);
            Timeline timeline = new Timeline(new KeyFrame(delay, event -> openUploadAvatarView()));
            timeline.play();
        }
//    }

    private void openUploadAvatarView() {
        // Code to open UploadAvatarView
        try {
            UploadAvatarView uploadAvatarView = new UploadAvatarView();
            uploadAvatarView.start(new Stage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}