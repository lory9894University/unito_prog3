package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.AccessibleRole;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller{
    @FXML private Label Exercise;
    @FXML private TextField UserInput;
    @FXML private Label Correctness;

    private Test model = null;

    @FXML
    private void handleConfirm(ActionEvent e){
        model.checkAnswer();
        if (Correctness.textProperty().get().equalsIgnoreCase("Corretta!"))
            Correctness.setStyle("-fx-text-fill: #468b00");
        else
            Correctness.setStyle("-fx-text-fill: #f52c2c");
        Correctness.setVisible(true);

    }

    @FXML
    private void handleAnother(ActionEvent e){
        model.newExercise();
        Correctness.setVisible(false);
    }

    public void init(Test test){
        model = test;
        Exercise.textProperty().bind(model.textProperty());
        model.resultProperty().bind(UserInput.textProperty());
        Correctness.textProperty().bind(model.correctnessProperty());

        model.newExercise();

    }
}
