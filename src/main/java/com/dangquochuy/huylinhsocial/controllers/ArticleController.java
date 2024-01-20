package com.dangquochuy.huylinhsocial.controllers;

import com.dangquochuy.huylinhsocial.models.Article;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ArticleController {
    @FXML
    private ListView<Article> articleListView;

    private ObservableList<Article> articleList = FXCollections.observableArrayList();

    @FXML
    public void initialize() throws Exception {
        GetApiController apiController = new GetApiController();
        Article article = new Article(apiController.getAuthor(), apiController.getDescription(), apiController.getImages());
        articleList.add(article);
        articleListView.setItems(articleList);
    }
}
