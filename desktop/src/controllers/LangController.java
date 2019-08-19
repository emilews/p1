package controllers;

import countries.Countries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import views.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LangController implements Initializable {
    private Countries countries;
    {
        countries = Countries.getInstance();
    }
    @FXML
    public ListView<String> byLangList;
    public ChoiceBox<String> langChoice;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        langChoice.getItems().clear();
        langChoice.getItems().addAll(Countries.getAllLangs());
    }
    public void populateListByLang(){
        ObservableList<String> paises = FXCollections.observableArrayList();
        paises.addAll(countries.getCountriesByLang(langChoice.getValue()));
        byLangList.getItems().clear();
        byLangList.getItems().addAll(paises);
    }
    public void returnToMenu() throws IOException {
        Main.returnToMenuFromOtherPlaces();
    }
}
