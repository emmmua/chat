package com.emmmua.controller;

import com.emmmua.pojo.User;
import com.emmmua.service.UserService;
import com.emmmua.service.impl.UserServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileInputStream;

public class UserController {

    UserService userService = new UserServiceImpl();
    public User user = new User();

    @FXML
    public TextField username;

    @FXML
    public PasswordField password;

    @FXML
    public TextField regNumber;

    @FXML
    public TextField regPassword;

    @FXML
    public Button button1;

    @FXML
    public Button button2;

    @FXML
    public Button button3;

    @FXML
    public void login(ActionEvent actionEvent) throws Exception {
        User user = new User();
        user.setUsername(username.getText());
        user.setPassword(password.getText());
        User res = userService.login(user);

        if (res == null) {
            // 账号或密码错误弹窗
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("警告");
            alert.setHeaderText(null);  // 将默认顶部消息给去掉
            alert.setContentText("账号或密码错误");
            alert.showAndWait();
        } else {
            // 登录成功跳转到主页面
            DataAll.user = res;
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/Main.fxml"));

            Scene scene = new Scene(root);
            Stage mainStage = new Stage();
            mainStage.setTitle("Chat");
            mainStage.setResizable(false);   // 设置为不能放大，固定了
            mainStage.setScene(scene);
            Stage stage2 = (Stage) button2.getScene().getWindow();
            stage2.close();
            mainStage.getIcons().add(new Image("com/emmmua/images/logo.png"));
            DataAll.MainStage = mainStage;
            mainStage.show();
        }
    }

    // 调用注册页面
    @FXML
    public void register(ActionEvent actionEvent) throws Exception {
        Parent reg = FXMLLoader.load(getClass().getResource("../fxml/register.fxml"));
        Scene scene = new Scene(reg);
        Stage stage = new Stage();
        stage.setTitle("注册");
        stage.setScene(scene);
        stage.getIcons().add(new Image("com/emmmua/images/logo.png"));
        stage.show();
    }


    // 提交注册数据
    @FXML
    public void Submit(ActionEvent actionEvent) {
        User user = new User();
        user.setUsername(regNumber.getText());
        user.setPassword(regPassword.getText());
        user.setUrl("https://data.fivk.cn/view.php/9c20358416fdbd060d622eb4c34da198.png");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("提示");
        alert.setHeaderText(null);  // 将默认顶部消息给去掉

        if (user.getUsername().length() < 6 || user.getPassword().length() < 6) {
            alert.setContentText("用户名或者密码小于6");
            alert.showAndWait();
            return;
        }


        boolean flag = userService.register(user);


        if (flag) {
            Stage stage3 = (Stage) button3.getScene().getWindow();
            stage3.close();

            alert.setContentText("注册成功");

        } else {
            alert.setContentText("注册失败，可能是用户名已存在");
        }

        alert.showAndWait();
    }
}
