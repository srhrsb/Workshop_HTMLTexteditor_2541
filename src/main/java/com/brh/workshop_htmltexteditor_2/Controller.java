package com.brh.workshop_htmltexteditor_2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Controller {
    @FXML
    private Label pathLabel;

    @FXML
    private HTMLEditor htmlEditor;

    /**
     * Speichert Html auf Knopfdruck
     */
    @FXML
    protected void onClickSave() {
        //text von path-label holen
        String path = pathLabel.getText();

        //wenn der Pfad leer ist...
        if(path.isEmpty()){
             //... dann Pfad von getSavePath holen
             path = getSavePathFromDialog();
        }

        //jetz muss der Pfad da sein(ausser bei Abrruch durch Nutzer)
       if(!path.isEmpty()){
           //label text mit pfad setzen
           pathLabel.setText(path);
           //html text holen
           String html = htmlEditor.getHtmlText();
           //html an save übergeben und speichern
           save(path, html);
       }

    }

    /**
     * Laden eines HTML Files auf Knopfdruck
     */
    @FXML
    protected void onClickLoad() {
        //pfad holen von Methode getLoadPath
        String path = getLoadPathFromDialog();

        //checken, ob Pfad nicht leer ist
        if(!path.isEmpty()){
            pathLabel.setText(path);
            //Html holen von der Methode load
            String html = load(path);
            //html an Htmleditor übergeben
            htmlEditor.setHtmlText(html);
        }
    }

    @FXML
    protected void onClickSaveAs() {
        //pfad holen über Dialog mit Hilfe von getSavePath
        String path = getSavePathFromDialog();

        //wenn der Pfad nicht leer ist...
        if(!path.isEmpty()){
            //... dann html text holen
            String html = htmlEditor.getHtmlText();
            //html speichern
            save(path, html);
        }
    }

    private String getLoadPathFromDialog(){
        //ToDo: nur Html im dialog auswählbar machen
        //ToDo: Dialog soll sich Pfad merken
        FileChooser fileChooser = new FileChooser();
        //auswählbare Dateien einschränken auf html
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("html", "*.html");
        fileChooser.getExtensionFilters().add(filter);
        File file = fileChooser.showOpenDialog( App.getStage() );
        return file.getAbsolutePath();
    }

    private String getSavePathFromDialog(){
        //ToDo: nur Html im dialog auswählbar machen
        //Objekt Filechooser von JavaFX erzeugen
        FileChooser fileChooser = new FileChooser();
        //auswählbare Dateien einschränken auf html
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("html",  "*.html");
        fileChooser.getExtensionFilters().add(filter);
        //File Object von ausgewähltem Pfad
        File file = fileChooser.showSaveDialog( App.getStage() );
        //Rückgabe des Files als String
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