package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Mailbox {
        private ObservableList<Email> emails = null;
        private SimpleStringProperty[] emailShown = null;

        /**
         * Mailbox is our data model for the emails, it contains an array of property (emailShown)
         * for the "clicked" Email and an ObservableList for every email saved in memory
         *
         * right now the costructur only creates and stores 2 mockup emails
         */
        public Mailbox() {
                emails = FXCollections.observableArrayList();
                emailShown = new SimpleStringProperty[5];
                emails.setAll(new Email(0,"lorenzo","fedra","hey","culo"),
                        new Email(1,"fedra","lorenzo","culo","hey"),
                        new Email(3,"Rick","lorenzo","guarda questo video!","https://www.youtube.com/watch?v=dQw4w9WgXcQ"));

                for (int i = 0; i <emailShown.length ; i++) {
                        emailShown[i] = new SimpleStringProperty();
                }
        }

        public ObservableList<Email> getEmails() {
                return emails;
        }

        /**
         * from an id received as a parameter modifies the corresponding email updating its properties
         * @param index Email ID, the same as the ID property in the Email object
         */
        public void showMail(int index){
                Email email = emails.get(index);
                emailShown[0].set(String.valueOf(email.getID()));
                emailShown[1].set(email.getMittente());
                emailShown[2].set(email.getDestinatario());
                emailShown[3].set(email.getSubject());
                emailShown[4].set(email.getBody());
        }

        /**
         * those are the field on the array emailShown:\n
         *      0 id
         *      1 sender
         *      2 receiver
         *      3 subjject
         *      4 body
         * @return a property that defines all the attributes of the email selected.
         */
        public StringProperty[] getEmailShown() {
                return emailShown;
        }

}
