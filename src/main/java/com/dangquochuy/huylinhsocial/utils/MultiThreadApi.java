package com.dangquochuy.huylinhsocial.utils;

import com.dangquochuy.huylinhsocial.controllers.GetApiController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadApi {
    public String[] getApi() throws ExecutionException, InterruptedException {

        int numberOfThreads = 4;

        // Tạo một ExecutorService với số lượng luồng cần thiết
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        // Tạo một mảng để lưu trữ các Future cho mỗi nhiệm vụ
        Future<String> descriptionFuture = executor.submit(() -> new GetApiController().getDescription());
        Future<String> imagesFuture = executor.submit(() -> new GetApiController().getImages());
        Future<String> titleFuture = executor.submit(() -> new GetApiController().getAuthor());
        Future<String> urlFuture = executor.submit(() -> new GetApiController().getUrl());

        // Đợi cho tất cả các nhiệm vụ hoàn thành

        // Lấy kết quả từ mỗi Future
        String title = titleFuture.get();
        String description = descriptionFuture.get();
        String images = imagesFuture.get();
        String url = urlFuture.get();
        String[] data = {description, images, title, url};
        return data;
    }
}
