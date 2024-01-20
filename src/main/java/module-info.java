module com.dangquochuy.huylinhsocial {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.net.http;
    requires android.json;
    requires java.sql;
    requires mysql.connector.j;
    requires javafx.web;

    opens com.dangquochuy.huylinhsocial to javafx.fxml;

    opens com.dangquochuy.huylinhsocial.controllers to javafx.fxml;
    exports com.dangquochuy.huylinhsocial;
    exports com.dangquochuy.huylinhsocial.utils;
    exports com.dangquochuy.huylinhsocial.controllers;

}