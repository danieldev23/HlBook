package com.dangquochuy.huylinhsocial.utils;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.File;

public class ChooseFile extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button openPopupButton = new Button("Mở Popup");
        openPopupButton.setOnAction(e -> openImagePopup());

        VBox root = new VBox(openPopupButton);
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Image Popup Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openImagePopup() {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            Image selectedImage = new Image(selectedFile.toURI().toString());
            ImageView imageView = new ImageView(selectedImage);

            Popup imagePopup = new Popup();
            imagePopup.getContent().add(imageView);

            // Đặt các thuộc tính popup (vị trí, kích thước, v.v.)
            imagePopup.setAutoHide(true); // Tự động ẩn khi click ngoài popup
            imagePopup.show(imageView.getScene().getWindow());
        }
//        public void delete(ActionEvent event) throws SQLException {
//            int postIdDelete = getPostIdDelete();
//            System.out.println("Post delete " + postIdDelete);
//            boolean result = new Post().deletePostById(postIdDelete);
//            if(result) {
//
//                Platform.runLater(() -> {
//                    showViewPostRandom();
//                });
//            }
//        }
//        public void edit(ActionEvent event) {
//            System.out.println("Edit button clicked!");
//        }
    }



    public static void main(String[] args) {
        launch(args);
    }
}
