package controllers;

import countries.Countries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private Countries countries;
    {
        countries = Countries.getInstance();
    }
    //Combobox

    @FXML
    public static ComboBox contCombo;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
