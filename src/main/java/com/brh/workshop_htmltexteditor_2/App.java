package com.brh.workshop_htmltexteditor_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Stage _stage;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        _stage = stage;
        stage.setTitle("HTML Texteditor");
        stage.setScene(scene);
        stage.show();
    }

    public static Stage getStage(){
        return _stage;
    }

    public static void main(String[] args) {
        launch();
    }

























}