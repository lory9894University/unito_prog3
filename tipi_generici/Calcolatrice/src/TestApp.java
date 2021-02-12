import java.util.ArrayList;

public class TestApp {
    public static void main(String[] args) {
        ArrayList<Integer> numeri = new ArrayList<>();

        numeri.add(1);
        numeri.add(2);
        numeri.add(2);

        Calcolatrice.print(numeri);
        System.out.println(Calcolatrice.sum(numeri));
        System.out.println(Calcolatrice.max(numeri));
    }
}
