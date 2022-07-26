package com.emmmua;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("./fxml/login.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("登录");
        primaryStage.setResizable(false);   // 设置为不能放大，固定了
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("com/emmmua/images/logo.png"));
        primaryStage.show();
    }
}
