package com.brh.workshop_htmltexteditor_2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.nio.file.Path;

public class Controller {
    @FXML
    private Label pathLabel;

    @FXML
    private HTMLEditor htmlEditor;

    @FXML
    protected void onClickSave() {
       String path = getSavePath();


    }

    @FXML
    protected void onClickLoad() {
    String path = getLoadPath();

        if(!path.isEmpty()){
            pathLabel.setText(path);
            load(path);
        }

    }

    @FXML
    protected void onClickSaveAs() {

    }

    private String getLoadPath(){
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog( App.getStage() );
        return file.getAbsolutePath();
    }

    private String getSavePath(){
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog( App.getStage() );
        return file.getAbsolutePath();
    }

    private void save( String path, String html ){

    }

    private String load( String path ){
        String html="";



        return html;
    }
}