package com.dangquochuy.huylinhsocial.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GetCurrentTime {

    private String formatTime;

    public String getFormatTime() {
        LocalDateTime now = LocalDateTime.now();

        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();

        String time = Integer.toString(day) + " tháng " + Integer.toString(month) + ", " + Integer.toString(year);

        // Định dạng ngày giờ
        String formatDateTime = now.format(DateTimeFormatter.ISO_DATE_TIME);

        return time;
    }

    public static void main(String[] args) {
        System.out.println(new GetCurrentTime().getFormatTime());
    }
}
