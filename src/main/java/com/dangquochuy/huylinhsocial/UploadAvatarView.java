package com.dangquochuy.huylinhsocial;

import com.dangquochuy.huylinhsocial.controllers.UploadAvatarController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UploadAvatarView extends Application {
    private Stage primaryStage;
    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/dangquochuy/huylinhsocial/fxml/upload_avatar.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 420, 449);
        UploadAvatarController controller = fxmlLoader.getController();
        controller.setPrimaryStage(stage);

        stage.setTitle("Cập nhật ảnh đại diện");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
