import java.util.Date;

public class Coppia <T , U> {
    private T Comp1;
    private U Comp2;

    public Coppia(T Comp1, U Comp2){
        this.Comp1 = Comp1;
        this.Comp2 = Comp2;
    }

    public T getComp1() {
        return Comp1;
    }

    public U getComp2() {
        return Comp2;
    }

    @Override
    public String toString() {
        return  "{" + Comp1.toString() + "," + Comp2.toString() + "}";
    }

    public static void main (String args[]){
        Coppia<String, Date> coppia1 = new Coppia<String, Date>("Uno",
                new Date());
        Coppia<String, Date> coppia2 = new Coppia<String, Date>("Due",
                new Date());
        System.out.println("Coppia1: " + coppia1);
        System.out.println("Coppia2: " + coppia2);
    }

}

