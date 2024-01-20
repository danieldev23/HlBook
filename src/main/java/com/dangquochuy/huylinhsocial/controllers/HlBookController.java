package com.dangquochuy.huylinhsocial.controllers;

import com.dangquochuy.huylinhsocial.LoginView;
import com.dangquochuy.huylinhsocial.models.Post;
import com.dangquochuy.huylinhsocial.models.RandomPost;
import com.dangquochuy.huylinhsocial.models.User;
import com.dangquochuy.huylinhsocial.utils.GetCurrentTime;
import com.dangquochuy.huylinhsocial.utils.MultiThreadApi;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HlBookController implements Initializable {
    private String image;
    @FXML
    private ImageView profileAuthor;
    @FXML
    private ImageView userImg;
    @FXML
    private ImageView imgProfilePost;
    @FXML
    private ImageView imageUser;
    private static String avatar;
    public FileChooser fileChooser = new FileChooser();
    @FXML
    public VBox root;
    @FXML
    private WebView webView = new WebView();
    @FXML
    public Label PostAuthor;
    @FXML
    public Label randomPostDate;
    @FXML
    public Label captionPostRandom;
    @FXML
    public ImageView randomPostImage;
    @FXML
    private Label name;
    @FXML
    private TextArea postCaption;
    @FXML
    private VBox postImg;
    @FXML
    private Button postImgBtn;
    @FXML
    private VBox showPostUser;
    private static int user_id;
    public Stage stage;
    @FXML
    private static Label username;
    @FXML
    private TextField post_content;
    @FXML
    public Label usernameApi;
    @FXML
    public Label dateApi;
    @FXML
    public Label captionApi;
    @FXML
    public ImageView imgPostApi;

    @FXML
    public ImageView imgPostUser;
    @FXML
    private Label usernamePost;
    @FXML
    public ImageView getUserImg() {
        return userImg;
    }

    public void setUserImg(ImageView userImg) {
        this.userImg = userImg;
    }

    public ImageView getImageUser() {
        return imageUser;
    }

    public void setImageUser(ImageView imageUser) {
        this.imageUser = imageUser;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public VBox getShowPostUser() {
        return showPostUser;
    }

    public void setShowPostUser(VBox showPostUser) {
        this.showPostUser = showPostUser;
    }

    public String getName() {
        return name.getText();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setName() {
        System.out.println(new User().getName());
        String name = new User().getName();
        this.name.setText(name);
        usernamePost.setText(name);
    }

    public String getPostCaption() {
        return postCaption.getText();
    }

    public void setPostCaption(String caption) {
        postCaption.setText(caption);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ImageView getImgPostUser() {
        return imgPostUser;
    }

    public void setImgPostUser(ImageView imgPostUser) {
        this.imgPostUser = imgPostUser;
    }

    public Button getPostImgBtn() {
        return postImgBtn;
    }

    public void setPostImgBtn(Button postImgBtn) {
        this.postImgBtn = postImgBtn;
    }

    public VBox getPostImg() {
        return postImg;
    }

    public void setPostImg(VBox postImg) {
        this.postImg = postImg;
    }

    public void showPostImg(double width, double height, boolean show) {

        getPostImg().setPrefWidth(width);
        getPostImg().setPrefHeight(Region.USE_COMPUTED_SIZE);
        getPostImg().setVisible(show);
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public String getPostContent() {
        return post_content.getText();
    }

    private void setPostContent(String postContent) {
        post_content.setText(postContent);
    }

    public void setUsername(String username) {
        this.username.setText(username);
    }

    public void setCaptionApi() throws Exception {
        this.captionApi.setText(new MultiThreadApi().getApi()[0]);
        String img = new MultiThreadApi().getApi()[1];
        ImageView image = new ImageView(img);
        this.imgPostApi.setImage(image.getImage());
    }

    public void setDateApi() {
        this.dateApi.setText(new GetCurrentTime().getFormatTime());
    }

    public void post(ActionEvent event) throws SQLException {
        if (new Post().addPost(getUserId(), getPostContent())) {
            setPostContent("");
            System.out.println("Posted succesfully1");
            showRandomPostUser();
        }
    }
    public void showViewPostRandom() {
        getShowPostUser().setPrefWidth(601.0);
        getShowPostUser().setPrefHeight(Region.USE_COMPUTED_SIZE);
        getShowPostUser().setVisible(true);
    }
    public void showRandomPostUser() throws SQLException{

        if(new RandomPost().getQuantityPostUser() > 0) {
//            new HlBookView().refreshUI();
            String[] postRandom = new RandomPost().getRandomPost();
            String name = new User().getName();
            PostAuthor.setText(name);
            profileAuthor.setImage(new Image(getAvatar()));
            randomPostDate.setText(new GetCurrentTime().getFormatTime());
            captionPostRandom.setText(postRandom[2]);
            if(postRandom[3] == null) {
                randomPostImage.setImage(new Image("https://images.unsplash.com/photo-1515378791036-0648a3ef77b2?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"));
            }
            else {
                Image image = new Image(postRandom[3]);

                randomPostImage.setImage(image);
            }
            System.out.println(new RandomPost().getQuantityPostUser());
            showViewPostRandom();

        }
    }
    public void postImgButton(ActionEvent event) {
        showPostImg(601.0, 527.0, true);
        File file = fileChooser.showOpenDialog(postImgBtn.getScene().getWindow());
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            imgPostUser.setImage(image);
            System.out.println(file.toURI().toString());
            setImage(file.toURI().toString());
        }
//        showPostImg(0.0, 0.0, false);

    }

    public void imgPostBtn(ActionEvent event) throws SQLException {
        new Post().addPostImg(getUserId(), getPostCaption(), getImage());
        getPostImg().setVisible(false);
        getPostImg().setManaged(false);
        Platform.runLater(() -> {
            try {
                showRandomPostUser();
            } catch (SQLException e) {
                e.printStackTrace();

            }
        });
    }

    public void setUsernameApi() throws Exception {
        this.usernameApi.setText("VnExpress");
    }
    @FXML
    public void logout(ActionEvent event) throws IOException {
        try {
            new LoginView().start(new Stage());
            getStage().close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void setImageUser() {
        if (getAvatar() != null) {
            try {
                Image image = new Image(getAvatar());
                userImg.setImage(image);
                imageUser.setImage(image);

            } catch (Exception e) {
                System.err.println("Error loading image: " + e.getMessage());
                // Xử lý lỗi ở đây, ví dụ: hiển thị ảnh mặc định hoặc thông báo lỗi cho người dùng.
            }
        }
//        else {
//            Image image = new Image("/Users/macbook/Documents/Projects/Java/HuyLinhSocial/src/main/resources/images/person.png");
//            userImg.setImage(image);
//            imageUser.setImage(image);
//        }
    }

    public void init() throws Exception {
        imgProfilePost.setImage(new Image(getAvatar()));
        setImageUser();
        showRandomPostUser();
        setName();
//        setUsernameApi();
//        setDateApi();
//        setCaptionApi();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            webView.setPrefWidth(510);
            webView.setPrefHeight(380);
            String videoURL = "https://www.youtube.com/embed/jLTuPyppBPc?si=csArQtoOrHIp5IoL?autoplay=1";
//            String videoURL = "https://www.youtube.com/embed/bP9gMpl1gyQ?autoplay=1";
//            String videoURL = "https://www.dangquochuy.id.vn";
            WebEngine engine = webView.getEngine();
            engine.load(videoURL);
            root.getChildren().add(webView);
            init();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
