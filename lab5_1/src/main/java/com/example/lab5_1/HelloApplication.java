package com.example.lab5_1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        TextField textField = new TextField();
        CheckBox checkBox1 = new CheckBox("фамилия");
        CheckBox checkBox2 = new CheckBox("отчество");
        ObservableList<String> fam = FXCollections.observableArrayList();
        ListView<String> langsListView = new ListView<String>(fam);
        ObservableList<String>  name = FXCollections.observableArrayList();
        ListView<String> langsListView2 = new ListView<String>(name);
        ObservableList<String> otch = FXCollections.observableArrayList();
        ListView<String> langsListView3 = new ListView<String>(otch);
        Button add = new Button("add");
        Button print = new Button("print");
        Label label1 = new Label("фамилия");
        Label label2 = new Label("имя");
        Label label3 = new Label("отчество");
        DialogPane dialogPane = new DialogPane();
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                    String text = textField.getText();
                String[] strings = text.split(" ");
                for (int i = 0;i<strings.length;i++){
                    if (i==0){
                        fam.add(strings[0]);
                    }
                    if (i==1){
                        name.add(strings[1]);
                    }
                    if (i==2){
                        otch.add(strings[2]);
                    }
                }
                textField.clear();
            }
        });
        print.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 String []secondName= new String[fam.size()];
                 for (int i = 0;i< fam.size();i++){
                   secondName[i]= fam.get(i);
                 }
                 Arrays.sort(secondName);
                 String str = String.join(",",secondName);
                 alert.setTitle("Print");
                 alert.setContentText(str);
                 alert.showAndWait();
            }
        });
        checkBox1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MultipleSelectionModel<String> langsSelectionModel = langsListView.getSelectionModel();
                langsSelectionModel.setSelectionMode(SelectionMode.MULTIPLE);
            }
        });
        checkBox2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MultipleSelectionModel<String> langsSelectionModel = langsListView3.getSelectionModel();
                langsSelectionModel.setSelectionMode(SelectionMode.MULTIPLE);
            }
        });

        GridPane root = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHgrow(Priority.ALWAYS);
        root.getColumnConstraints().add(column1);


        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHgrow(Priority.ALWAYS);;
        root.getColumnConstraints().add(column2);

        ColumnConstraints column3 = new ColumnConstraints();
        column3.setHgrow(Priority.ALWAYS);;
        root.getColumnConstraints().add(column3);

        RowConstraints row1 = new RowConstraints();
        row1.setMaxHeight(50);
        root.getRowConstraints().add(row1);

        RowConstraints row2 = new RowConstraints();
        row2.setMaxHeight(200);
        root.getRowConstraints().add(row2);

        RowConstraints row3 = new RowConstraints();
        row3.setVgrow(Priority.ALWAYS);
        root.getRowConstraints().add(row3);

        GridPane root2 = new GridPane();
        root2.getColumnConstraints().add(column1);
        root2.getColumnConstraints().add(column2);
        root2.add(add,0,0);
        root2.add(print,1,0);

        GridPane root3 = new GridPane();
        root3.getColumnConstraints().add(column1);
        root3.getColumnConstraints().add(column2);
        root3.add(checkBox1,0,0);
        root3.add(checkBox2,1,0);

        root.add(textField, 0,0);
        root.add(root2,1,0);
        root.add(root3,2,0);
        root.add(label1,0,1);
        root.add(label2,1,1);
        root.add(label3,2,1);
        root.add(langsListView,0,2);
        root.add(langsListView2,1,2);
        root.add(langsListView3,2,2);

        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Lab 5_1");
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}