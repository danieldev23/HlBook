package com.dangquochuy.huylinhsocial.utils;

import com.dangquochuy.huylinhsocial.controllers.GetApiController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadApi {
    public String[] getApi() throws ExecutionException, InterruptedException {

        int numberOfThreads = 2;

        // Tạo một ExecutorService với số lượng luồng cần thiết
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        // Tạo một mảng để lưu trữ các Future cho mỗi nhiệm vụ
        Future<String> descriptionFuture = executor.submit(() -> new GetApiController().getDescription());
        Future<String> imagesFuture = executor.submit(() -> new GetApiController().getImages());

        // Đợi cho tất cả các nhiệm vụ hoàn thành

        // Lấy kết quả từ mỗi Future
        String description = descriptionFuture.get();
        String images = imagesFuture.get();
        String[] data = {description, images};
        return data;
    }
}
