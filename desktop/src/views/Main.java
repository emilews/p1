package views;


import countries.Countries;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Stage primary;
    private Countries countries;
    static ObservableList<String> continents = FXCollections.observableArrayList();
    {
        continents.addAll(countries.getAllContinents());
    }
    @FXML
    public ChoiceBox<String> contChoice;
    public ListView<String> byContinentList;

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
    public void populateListByContinent(){
        ObservableList<String> paises = FXCollections.observableArrayList();
        paises.addAll(countries.getCountriesByContinent(contChoice.getValue()));
        byContinentList.getItems().clear();
        byContinentList.getItems().addAll(paises);
    }
}
