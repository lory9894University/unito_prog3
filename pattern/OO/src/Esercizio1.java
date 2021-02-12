import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Esercizio1 {
    public static void main(String[] args) {
        Filtro filter = new Filtro();
        Contatore counter = new Contatore();
        Visualizzatore visualizer = new Visualizzatore();
        counter.addObserver(filter);
        filter.addObserver(visualizer);
        counter.start();

    }
}

class Contatore extends Observable{
    private int c=0;

    public void start(){
        for (int i = 0; i <50 ; i++) {
            if (i%5==0){
                setChanged();
                notifyObservers();
            }
            c++;
        }
    }

    public int getC() {
        return c;
    }
}

class Filtro extends Observable implements Observer{
    private ArrayList<Integer> lista=new ArrayList<>();

    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof Contatore){
            lista.add(((Contatore) observable).getC());
            setChanged();
            notifyObservers();
        }
    }

    ArrayList<Integer> getLista(){
        return lista;
    }
}

class Visualizzatore implements  Observer{

    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof Filtro)
            if (((Filtro) observable).getLista().size()%2==0)
                System.out.println(((Filtro) observable).getLista());
    }
}
