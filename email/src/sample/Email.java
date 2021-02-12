package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Email {
    private SimpleIntegerProperty ID;
    private SimpleStringProperty mittente, destinatario, subject, body;

    /**
     * A new Email, Remeber every object returned from this Enail is a property
     * @param ID id number
     * @param mittente sender
     * @param destinatario receiver
     * @param subject subject
     * @param text body of the enail
     */
    public Email(int ID, String mittente, String destinatario, String subject, String text) {
        this.ID = new SimpleIntegerProperty();
        this.mittente = new SimpleStringProperty();
        this.destinatario = new SimpleStringProperty();
        this.subject  = new SimpleStringProperty();
        this.body  = new SimpleStringProperty();

        this.ID.setValue(ID);
        this.mittente.setValue(mittente);
        this.destinatario.setValue(destinatario);
        this.subject.setValue(subject);
        this.body.setValue(text);
    }

    public int getID() {
        return ID.get();
    }

    public SimpleIntegerProperty IDProperty() {
        return ID;
    }

    public void setID(int ID) {
        this.ID.set(ID);
    }

    public String getMittente() {
        return mittente.get();
    }

    public SimpleStringProperty mittenteProperty() {
        return mittente;
    }

    public void setMittente(String mittente) {
        this.mittente.set(mittente);
    }

    public String getDestinatario() {
        return destinatario.get();
    }

    public SimpleStringProperty destinatarioProperty() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario.set(destinatario);
    }

    public String getSubject() {
        return subject.get();
    }

    public SimpleStringProperty subjectProperty() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject.set(subject);
    }

    public String getBody() {
        return body.get();
    }

    public SimpleStringProperty bodyProperty() {
        return body;
    }

    public void setBody(String body) {
        this.body.set(body);
    }

    /**
     * this override of the toString function permits showing custom section of the email in javaFX
     * @return a "pretty print" of the Email
     */
    @Override
    public String toString() {
        return "new message from: " + mittente.getValue();
    }
}
