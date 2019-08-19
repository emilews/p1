package controllers;

import countries.Countries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import views.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SizeController implements Initializable {
    private Countries countries;

    @FXML
    public ListView<String> bySizeList;
    public TextField sizeTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        countries = Countries.getInstance();
    }

    public void populateListBySize(){
        ObservableList<String> paises = FXCollections.observableArrayList();
        int sizeToLookFor = 0;
        try{
            sizeToLookFor = Integer.valueOf(sizeTextField.getText());
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
        List<String> result = countries.getCountriesBySize(sizeToLookFor);
        if(result.size() != 0){
            paises.addAll(result);
        }else{
            ObservableList<String> temp = FXCollections.observableArrayList("No existen países con una extensión de" + sizeToLookFor + " o mayor.");
        }

        bySizeList.getItems().clear();
        bySizeList.getItems().addAll(paises);
    }
    public void returnToMenu() throws IOException {
        Main.returnToMenuFromOtherPlaces();
    }
}
