import java.util.ArrayList;
import java.util.LinkedList;

public class TestApp {
    public static void main(String[] args) {
        Coda <Integer> interi = new Coda<>(new ArrayList<>());
        Coda <Double> virgola = new Coda<>(new LinkedList<>());

        System.out.println("interi vuota: " + interi.empty() + "\tvirgola vuota: " + virgola.empty());
        interi.put(4);
        interi.put(2);
        System.out.println("interi vuota?\nget di interi: " + interi.get());
        System.out.println("get di interi: "+ interi.get());

    }


}
