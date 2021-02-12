package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private Mailbox mailbox = null;
    clickedEmailController controller = null;

    @FXML private ListView mailList;
    @FXML private AnchorPane mailPanel;

    /**
     * Initialize the controller using as a base a given model, this method takes care of inizialization and binding of property
     * @param model data-model of the application
     */
    public void init(Mailbox model) {
        mailbox = model;

        //binding of listView
        mailList.setItems(model.getEmails());

        //initialization of the child controller
        controller.init(mailbox);

    }

    /**
     * what happens when i select an Email with the mouse
     */
    @FXML public void handleEmailSelected(MouseEvent event){
        mailbox.showMail(mailList.getSelectionModel().getSelectedIndex());
    }

    /**
     * questa parte di codice mi serve ad inizializzare un nuovo controllore aggiungendo al mailPanel (splitPane) un nuovo oggetto XML
     * sarebbe molto piú comodo e modulare svolgere questa operazione nel main, ma non riesco assolutamente ad accedere al fottuto splitPane
     * dato che la Ardissono non ci ha spiegato come navigare l'albero. se qualcuno riesce in qualche modo a spostare il load del nuovo xml nel main é un figo
     *
     * per spiegarla semplicemente, non so come accedere all'oggetto AnchorPane dal main.
     */
    //TODO: create the new controller in main and learn how to navigate xml tree
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EmailRead.fxml"));
        try {
            mailPanel.getChildren().add(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        controller = loader.getController();
    }
}
