package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        //loading of xml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        TitledPane root = loader.load();
        //creation and handling of the new controller created by the FXML loader
        Controller controller = loader.getController();
        controller.init(new Mailbox());
        // some setup of the application windows (qui ci sono tutte le caratteristiche della finestra che spunta)
        primaryStage.setTitle("Email");
        primaryStage.setScene(new Scene(root, 500, 275));
        primaryStage.show();
    }
}
