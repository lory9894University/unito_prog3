import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class MVC {
    public static void main(String[] args) {
        Model model =new Model();
        Controller controller = new Controller(model);
        View view = new View(controller, "Proverbi:");
        model.addObserver(view);
    }
}

class View extends JFrame implements Observer {
    JButton button;
    JLabel proverbio;

    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof Model)
            proverbio.setText(((Model) observable).getActual());
    }

    public View(Controller controller, String name) {
        super(name);
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40));

        button = new JButton("Chiedi proverbio");
        proverbio = new JLabel("proverbio");
        add(button);
        add(proverbio);
        setSize(1000, 300);
        button.addActionListener(controller);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}

class Model extends Observable{
    private ArrayList<String> proverbi = new ArrayList<>();
    private int actual = 0;

    public Model() {
        proverbi.add("rosso di sera, due e-seghe");
        proverbi.add("'a mutua");
        proverbi.add("i cani blu");
    }
    void refresh(){
        actual= (int) (Math.random() * proverbi.size());
        setChanged();
        notifyObservers();
    }
    public String getActual() {
        return proverbi.get(actual);
    }
}

class Controller implements ActionListener {
    Model model;

    public Controller(Model model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        model.refresh();
    }
}