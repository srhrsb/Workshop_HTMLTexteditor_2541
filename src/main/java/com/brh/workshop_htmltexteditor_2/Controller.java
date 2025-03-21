package com.brh.workshop_htmltexteditor_2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Controller {
    @FXML
    private Label pathLabel;

    @FXML
    private HTMLEditor htmlEditor;

    @FXML
    protected void onClickSave() {

        String path = pathLabel.getText();

        if(path.isEmpty()){
             path = getSavePath();
        }

       if(!path.isEmpty()){
           String html = htmlEditor.getHtmlText();
           save(path, html);
       }

    }

    @FXML
    protected void onClickLoad() {
    String path = getLoadPath();

        if(!path.isEmpty()){
            pathLabel.setText(path);
            String html = load(path);
            htmlEditor.setHtmlText(html);
        }

    }

    @FXML
    protected void onClickSaveAs() {
        String path = getSavePath();
        if(!path.isEmpty()){
            String html = htmlEditor.getHtmlText();
            save(path, html);
        }
    }

    private String getLoadPath(){
        //ToDo: nur Html im dialog auswählbar machen
        //ToDo: Dialog soll sich Pfad merken
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog( App.getStage() );
        return file.getAbsolutePath();
    }

    private String getSavePath(){
        //ToDo: nur Html im dialog auswählbar machen
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog( App.getStage() );
        return file.getAbsolutePath();
    }

    private void save( String path, String html ){
        try {
            Files.writeString(Path.of(path), html );
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    private String load( String path ){
        String html="";

        try {
            html = Files.readString(Path.of(path));
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }

        return html;
    }
}