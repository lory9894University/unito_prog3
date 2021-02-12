public class Esercizio {
    public static void main(String[] args) {
        Quadrato q = new Quadrato(4);
        System.out.println(q.getArea());
        Rettangolo r = new Rettangolo(3, 4);
        System.out.println(r.getArea());
        System.out.println(Poligono.getPoligoni());
        System.out.println(Rettangolo.getPoligoni());
    }


}

abstract class Poligono{
    private int vertici,base,altezza;
    private static int poligoni;

    public Poligono(int vertici, int base, int altezza) {
        this.vertici = vertici;
        this.base = base;
        this.altezza = altezza;
        poligoni++;
    }

    public int getVertici() {
        return vertici;
    }

    public int getBase() {
        return base;
    }

    public int getAltezza() {
        return altezza;
    }

    public static int getPoligoni() {
        return poligoni;
    }

    public abstract double getArea();
}

class Rettangolo extends Poligono{

    public Rettangolo(int base, int altezza) {
        super(4, base, altezza);
    }

    @Override
    public double getArea() {
        return (double)(getBase() * getAltezza());
    }
}

class Quadrato extends Rettangolo{

    public Quadrato(int lato) {
        super(lato,lato);
    }
}
