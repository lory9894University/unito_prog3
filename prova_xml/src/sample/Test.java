package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.skin.CellSkinBase;

public class Test {
    private int selectedQuestion;
    private Question[] questions;
    private SimpleStringProperty text = null;
    private SimpleStringProperty result = null;
    private SimpleStringProperty correctness = null;

    public String getText() {
        return text.get();
    }

    public SimpleStringProperty textProperty() {
        return text;
    }

    public String getResult() {
        return result.get();
    }

    public SimpleStringProperty resultProperty() {
        return result;
    }

    public String getCorrectness() {
        return correctness.get();
    }

    public SimpleStringProperty correctnessProperty() {
        return correctness;
    }

    public void newExercise(){
        selectedQuestion = (int) (Math.random() * questions.length);
        text.setValue(questions[(selectedQuestion)].question);
    }

    public void checkAnswer(){
        if (result.getValue().equalsIgnoreCase(questions[selectedQuestion].answer))
            correctness.setValue("Corretta!");
        else
            correctness.setValue("Errata!");
    }

    public Test() {
        text = new SimpleStringProperty();
        result = new SimpleStringProperty();
        correctness = new SimpleStringProperty();

        questions = new Question[3];
        questions[0] = new Question("es1", "Calcola la radice quadrata di 9", "3");
        questions[1] = new Question("es2", "Calcola la radice quadrata di 16", "4");
        questions[2] = new Question("es3", "Calcola la radice quadrata di 25", "5");
    }

    private class Question{
        private final String question , id, answer;

        public Question(String id, String question, String answer) {
            this.answer = answer;
            this.question = question;
            this.id = id;
        }
    }
}
