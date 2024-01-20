package com.dangquochuy.huylinhsocial.utils;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StyledMessageUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label showMessageBtn = new Label("Xin lỗi vì sự bất tiện này :(");
        VBox root = new VBox(10);
        root.getChildren().addAll(showMessageBtn);

        Scene scene = new Scene(root, 300, 200);
        scene.getStylesheets().add(String.valueOf(getClass().getResource("/style.css"))); // Thêm file CSS

        primaryStage.setTitle("Vui lòng đăng nhập lại!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showStyledMessage(String title, String content) {
        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle(title);
        dialog.setHeaderText(null);

        // Tạo label để hiển thị nội dung thông báo
        Label label = new Label(content);
        label.getStyleClass().add("message-label");

        // Tạo nút OK để đóng cửa sổ thông báo
        Button okButton = new Button("OK");
        okButton.setOnAction(e -> dialog.close());

        // Đặt nội dung của dialog
        dialog.getDialogPane().setContent(new VBox(label, okButton));

        // Thêm CSS cho dialog
        dialog.getDialogPane().getStylesheets().add(String.valueOf(getClass().getResource("/style.css")));

        dialog.showAndWait();
    }
}

