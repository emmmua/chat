package com.emmmua.controller;


import com.emmmua.pojo.Moments;
import com.emmmua.pojo.User;
import com.emmmua.service.MomentsService;
import com.emmmua.service.impl.MomentsServiceImpl;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


public class MomentsController {
    MomentsService momentsService = new MomentsServiceImpl();


    void getAll() {
        if (listView != null) {
            ObservableList<Pane> items = listView.getItems();
            items.clear();
            List<Moments> moments = momentsService.selectAll();
            for (Moments moment : moments) {
                // 数据设置
                User user = momentsService.selectById(moment.getDepId());
                ImageView image = new ImageView(user.getUrl());
                Label username = new Label(user.getUsername());
                TextArea text = new TextArea(moment.getText());
                Label time = new Label("     " + moment.getTime() + "  ");
                Button delete = new Button("删除");
                delete.setOnAction((ActionEvent event) -> {

                    Alert res = new Alert(Alert.AlertType.INFORMATION);
                    res.setTitle("操作结果");
                    res.setHeaderText(null);

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("提示");
                    alert.setHeaderText(null);
                    alert.setContentText("将删除这条朋友圈，是否继续？");
                    Optional<ButtonType> result = alert.showAndWait();

                    if (result.get() == ButtonType.OK) {

                        if (DataAll.user.getId() == user.getId()) {
                            System.out.println("删除的文章number = " + moment.getNumber());
                            int line = momentsService.DeleteById(moment.getNumber());
                            if (line != 0) {
                                res.setContentText("删除成功，请刷新数据");
                            } else {
                                res.setContentText("删除失败");
                            }

                        } else {
                            res.setContentText("只能删除自己的朋友圈");
                        }
                    } else {
                        res.setContentText("取消删除");
                    }
                    res.showAndWait();
                });
                text.setWrapText(true);
                text.setEditable(false);

                // 控件设置
                image.setFitHeight(50);
                image.setFitWidth(50);
                GridPane gridPane = new GridPane();
                gridPane.setHgap(2);
                gridPane.setVgap(2);
                gridPane.add(image, 0, 0);
                gridPane.add(username, 1, 0);

                gridPane.add(time, 2, 0);

                if (DataAll.user.getId() == user.getId()) {
                    gridPane.add(delete, 3, 0);
                }


                gridPane.add(text, 0, 1, 4, 3);
                text.setMaxHeight(100);
                text.setMaxWidth(360);
                gridPane.setMaxWidth(400);
                items.add(gridPane);
            }
        }
    }

    @FXML
    void initialize() {

        if (MomentsUsername != null) {
            MomentsUsername.setText(DataAll.user.getUsername());
        }

        if (MomentsBackground != null) {
            MomentsBackground.setImage(new Image("/com/emmmua/images/MomentsBackground.jpg"));
        }

        if (MomentsImage != null) {
            MomentsImage.setImage(new Image(DataAll.user.getUrl()));
        }

        // 查询所有
        this.getAll();


    }


    @FXML
    private ImageView MomentsBackground;

    @FXML
    private ListView<Pane> listView;

    @FXML
    private Label MomentsUsername;

    @FXML
    private ImageView MomentsImage;

    public void verb(MouseEvent mouseEvent) throws Exception {
        Parent editPare = FXMLLoader.load(getClass().getResource("../fxml/MomentsEdit.fxml"));
        Scene scene = new Scene(editPare);
        Stage edit = new Stage();
        edit.setTitle("发布朋友圈");
        edit.setResizable(false);   // 设置为不能放大，固定了
        edit.setScene(scene);
        edit.getIcons().add(new Image("com/emmmua/images/Moments.png"));
        edit.show();
    }

    // 发布朋友圈
    @FXML
    private TextArea verbText;

    @FXML
    private Button confirm;

    @FXML
    void cancelVerb(ActionEvent event) {
        if (confirm != null) {
            Stage confirm_stage = (Stage) confirm.getScene().getWindow();
            confirm_stage.close();
        }
    }

    @FXML
    void confirmVerb(ActionEvent event) {
        Moments moments = new Moments();
        moments.setText(verbText.getText());
        moments.setDepId(DataAll.user.getId());

        // 获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        moments.setTime(sdf.format(date)); // 已经格式化的现在时间（24小时制）

        int line = momentsService.InsertMoments(moments);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("提示");
        alert.setHeaderText(null);

        if (line != 0) {
            alert.setContentText("发布成功，请刷新数据");
        } else {
            alert.setContentText("发布失败");
        }

        if (confirm != null) {
            Stage confirm_stage = (Stage) confirm.getScene().getWindow();
            confirm_stage.close();
        }


        alert.showAndWait();
    }

}
