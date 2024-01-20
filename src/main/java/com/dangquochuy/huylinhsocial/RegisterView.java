package com.dangquochuy.huylinhsocial;

import com.dangquochuy.huylinhsocial.controllers.RegisterController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterView extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RegisterView.class.getResource("fxml/register.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1020, 570);
        RegisterController controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.setTitle("Register HLBook");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
