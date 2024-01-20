package com.dangquochuy.huylinhsocial.utils;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class YoutubeVideoPlayer extends Application {

    @Override
    public void start(Stage stage) {
        try {
            // Tạo WebView
            WebView webView = new WebView();
            webView.setPrefSize(560, 315);

            // Enable JS
            WebEngine engine = webView.getEngine();
            engine.setJavaScriptEnabled(true);

            // Nhúng video YouTube
            String videoID = "videoID";
            engine.loadContent("<iframe style=\"border:0\" width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/" + videoID + "\" frameborder=\"0\" allowfullscreen></iframe>");

            // Tạo scene
            Scene scene = new Scene(webView);

            // Thiết lập stage
            stage.setScene(scene);
            stage.setTitle("YouTube Player");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}