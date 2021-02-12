package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Controller controller;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();

        Test model = new Test();
        controller = loader.getController();
        controller.init(model);

        primaryStage.setTitle("Exercises");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();




    }


    public static void main(String[] args) {
        launch(args);
    }
}
