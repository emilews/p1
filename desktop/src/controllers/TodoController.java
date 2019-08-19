package controllers;

import countries.Countries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import views.Main;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TodoController implements Initializable {
    private Countries countries;
    {
        countries = Countries.getInstance();
    }

    @FXML
    public ListView<String> allTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> paises = FXCollections.observableArrayList();
        paises.addAll(Countries.getAllCountries());
        allTable.getItems().addAll(paises);
    }

    public void populateList(){


    }
    public void returnToMenu() throws IOException {
        Main.returnToMenuFromOtherPlaces();
    }
}
