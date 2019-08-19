package controllers;

import countries.Countries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import views.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ContinentController implements Initializable {
    private Countries countries;
    static ObservableList<String> continents = FXCollections.observableArrayList();

    @FXML
    public ChoiceBox<String> contChoice;
    public ListView<String> byContinentList;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        countries = Countries.getInstance();
        if(continents.isEmpty()){
            continents.addAll(countries.getAllContinents());
            contChoice.getItems().clear();
            contChoice.getItems().addAll(continents);
        }

    }
    public void populateListByContinent(){
        ObservableList<String> paises = FXCollections.observableArrayList();
        paises.addAll(countries.getCountriesByContinent(contChoice.getValue()));
        byContinentList.getItems().clear();
        byContinentList.getItems().addAll(paises);
    }
    public void returnToMenu() throws IOException {
        Main.returnToMenuFromOtherPlaces();
    }
}
