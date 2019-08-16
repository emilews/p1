package views;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        pane.getChildren().add(new Text("sada"));
        stage.setTitle("Práctica 1: Países");
        stage.setScene(new Scene(pane, 800,600));
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
