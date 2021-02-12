package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class clickedEmailController {

    @FXML private TextField from;
    @FXML private TextField subject;
    @FXML private TextArea body;

    /**
     * binding of the properties regarding the selected email
     * @param model data-model of the application
     */
    public void init(Mailbox model){
        from.textProperty().bind(model.getEmailShown()[1]);
        subject.textProperty().bind(model.getEmailShown()[3]);
        body.textProperty().bind(model.getEmailShown()[4]);
    }
}
