package views;


import countries.Countries;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Stage primary;
    private Countries countries;
    {
        countries = Countries.getInstance();
    }
    @Override
    public void start(Stage stage) throws Exception {
        primary = stage;
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primary.setTitle("Práctica 1: Países");
        primary.setScene(new Scene(root, 800,600));
        primary.show();
    }
    public static void main(String[] args) {
        launch(args);
    }


    @FXML
    public void goContinent() throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("Continente.fxml"));
        primary.getScene().setRoot(pane);
    }

    @FXML
    public void goLang() throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("Idiomas.fxml"));
        primary.getScene().setRoot(pane);
    }

    @FXML
    public void goSize() throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("Extension.fxml"));
        primary.getScene().setRoot(pane);
    }

    @FXML
    public void goAdd() throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("Agregar.fxml"));
        primary.getScene().setRoot(pane);
    }
    @FXML
    public void goAll() throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("Todo.fxml"));
        primary.getScene().setRoot(pane);
    }

    public static void returnToMenuFromOtherPlaces() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("Main.fxml"));
        primary.getScene().setRoot(root);
    }
}
