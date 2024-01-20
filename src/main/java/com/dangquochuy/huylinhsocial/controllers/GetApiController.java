package com.dangquochuy.huylinhsocial.controllers;

import com.dangquochuy.huylinhsocial.models.Article;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetApiController {
    private ListView<Article> articleListView;

    private ObservableList<Article> articleList = FXCollections.observableArrayList();
    private String author;
    private String description;
    private String images;

    private static int res = (int) (Math.random() * 50 + 1);
    public String[] returnData(int res)throws Exception{
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://newsapi.org/v2/everything?domains=vnexpress.net&apiKey=809e7980a9c746f6b3e94a19c5b2f051"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        // --------- GET DATA FROM API -------------------
        JSONObject data = new JSONObject(response.body());


        String authorApi = data.getJSONArray("articles")
                .getJSONObject(res)
                .get("author")
                .toString();

        String description = data.getJSONArray("articles")
                .getJSONObject(res)
                .get("description")
                .toString();

        String images = data.getJSONArray("articles")
                .getJSONObject(res)
                .get("urlToImage")
                .toString();
//
//        String url = data.getJSONArray("articles")
//                .getJSONObject(res)
//                .get("url")
//                .toString();
        String[] article = {authorApi, description, images};
        return article;
    }
    public String getAuthor() throws Exception {

        String[] data = returnData(this.res);
        this.author = data[0];
        return author;
    }

    public String getDescription() throws Exception {
        String[] data = returnData(this.res);
        this.description = data[1];
        return description;
    }

    public String getImages() throws Exception{
        String[] data = returnData(this.res);
        this.images = data[2];
        return images;
    }

    public static void main(String[] args) throws Exception{

        System.out.println(new GetApiController().getAuthor());
        System.out.println(new GetApiController().getDescription());
        System.out.println(new GetApiController().getImages());

    }
}
