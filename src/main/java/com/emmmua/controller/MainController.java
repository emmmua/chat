package com.emmmua.controller;


import com.emmmua.pojo.User;
import com.emmmua.service.MainService;
import com.emmmua.service.impl.MainServiceImpl;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class MainController {


    MainService mainService = new MainServiceImpl();

    ObservableList<Pane> items;

    @FXML
    void initialize() {

        if (username != null) {
            username.setText("用户名: " + DataAll.user.getUsername());
        }


        if (imgCard != null) {
            Image image1 = new Image(DataAll.user.getUrl());
            imgCard.setImage(new Image(DataAll.user.getUrl()));
        }


        if (avatar != null) {
            avatar.setImage(new Image(DataAll.user.getUrl()));
        }

        if (InformationList != null) {
            items = InformationList.getItems();

            DataAll.users = mainService.SelectAll();
            for (User user : DataAll.users) {

                if (DataAll.user.getId() == user.getId()) {
                    continue;
                }

                GridPane gridPane = new GridPane();
                gridPane.setMaxWidth(340);
                ImageView image = new ImageView(user.getUrl());
                Label username = new Label("    " + user.getUsername());

                // 控件设置
                image.setFitHeight(50);
                image.setFitWidth(50);
                gridPane.add(image, 0, 0);
                gridPane.add(username, 1, 0);


                items.add(gridPane);
            }
        }

    }

    // Main

    @FXML
    public TextField searchBox;


    @FXML
    public ListView<Pane> InformationList;

    @FXML
    private Button Moments;

    @FXML
    void inMoments(MouseEvent event) throws Exception {
        Parent business = FXMLLoader.load(getClass().getResource("../fxml/Moments.fxml"));
        Scene businessScene = new Scene(business);
        Stage Moments = new Stage();
        Moments.setTitle("朋友圈");
        Moments.setResizable(false);   // 设置为不能放大，固定了
        Moments.setScene(businessScene);
        Moments.getIcons().add(new Image("com/emmmua/images/Moments.png"));
        Moments.show();
    }



    // 名片信息

    @FXML
    public Label username;

    @FXML
    private ImageView imgCard;

    @FXML
    private ImageView avatar;

    @FXML
    private Button logoutBtn;

    @FXML
    public Button reBtn;

    @FXML
    private Button reAvatarBtn;


    @FXML
    private TextField avatarUrl;

    @FXML
    void reAvatarUrl(MouseEvent event) {
        DataAll.user.setUrl(avatarUrl.getText());
        mainService.reUser(DataAll.user);

        // 提示更改信息
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("提示");
        alert.setHeaderText(null);  // 将默认顶部消息给去掉
        alert.setContentText("信息已提交至数据库，信息重新登录可见。");
        alert.showAndWait();

        Stage stageReBtn = (Stage) reBtn.getScene().getWindow();
        stageReBtn.close();
    }

    @FXML
    void logout(MouseEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/Main.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("登录");
        stage.setResizable(false);   // 设置为不能放大，固定了
        stage.setScene(scene);
        stage.getIcons().add(new Image("com/emmmua/images/logo.png"));

        if (logoutBtn != null) {
            Stage logoutBtn_stage = (Stage) logoutBtn.getScene().getWindow();
            logoutBtn_stage.close();
        }


        if (DataAll.MainStage != null) {
            DataAll.MainStage.close();
        }

        stage.show();
    }

    @FXML
    void reAvatar(MouseEvent event) throws Exception {
        Parent business = FXMLLoader.load(getClass().getResource("../fxml/reAvatar.fxml"));
        Scene businessScene = new Scene(business);
        Stage Card = new Stage();
        Card.setTitle("更改头像");
        Card.setResizable(false);   // 设置为不能放大，固定了
        Card.setScene(businessScene);
        Card.getIcons().add(new Image("com/emmmua/images/avatar.png"));
        Card.show();
    }


    @FXML
    public void entered(MouseEvent mouseEvent) throws Exception {
        Parent business = FXMLLoader.load(getClass().getResource("../fxml/businessCard.fxml"));
        Scene businessScene = new Scene(business);
        Stage Card = new Stage();
        Card.setTitle("名片");
        Card.setResizable(false);   // 设置为不能放大，固定了
        Card.setScene(businessScene);
        Card.getIcons().add(new Image("com/emmmua/images/avatar.png"));
        Card.show();
    }

    @FXML
    public void searchBtn(MouseEvent mouseEvent) {
        items.clear();

        for (User user : DataAll.users) {

            if (DataAll.user.getId() == user.getId() || !user.getUsername().startsWith(searchBox.getText())) {
                continue;
            }

            GridPane gridPane = new GridPane();
            gridPane.setMaxWidth(340);
            ImageView image = new ImageView(user.getUrl());
            Label username = new Label("    " + user.getUsername());

            // 控件设置
            image.setFitHeight(50);
            image.setFitWidth(50);
            gridPane.add(image, 0, 0);
            gridPane.add(username, 1, 0);


            items.add(gridPane);
        }

    }
}
