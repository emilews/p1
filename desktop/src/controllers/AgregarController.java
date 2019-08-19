package controllers;

import countries.Countries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import views.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AgregarController implements Initializable {
    private Countries countries;
    {
        countries = Countries.getInstance();
    }
    static ObservableList<String> continents = FXCollections.observableArrayList();
    {
        continents.addAll(countries.getAllContinents());
    }
    @FXML
    public TextField contName;
    public TextField countName;
    public TextField countSize;
    public TextField countLang;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void addCountry() throws IOException {
        int size = 0;
        try{
            size = Integer.valueOf(countSize.getText());
        }catch (Exception e){
            Stage stage = new Stage();
            stage.setTitle("Error!");
            stage.initModality(Modality.APPLICATION_MODAL);
            BorderPane b = new BorderPane();
            b.setCenter(new Text("That's not a number!"));
            Scene scene = new Scene(b, 100,100);
            stage.setScene(scene);
            stage.show();
        }
        Countries.addNewCountry(contName.getText(),countName.getText(),Integer.valueOf(countSize.getText()),countLang.getText());
    }
    public void returnToMenu() throws IOException {
        Main.returnToMenuFromOtherPlaces();
    }
}
