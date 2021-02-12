import java.util.ArrayList;

public class Geometrie {
    private ArrayList<Poligono> poligons = new ArrayList<>();
    public static final int PARALLELOGRAMMA=0,RETTANGOLO=1,TRIANGOLO=3;

    public int getNumElementi(){
        return poligons.size();
    }
    public void add(int type, double base, double height){
        Poligono poligon;
        switch (type){
            case PARALLELOGRAMMA:
                poligon=new Parallelogramma(base,height);
                break;
            case RETTANGOLO:
                poligon=new Rettangolo(base,height);
                break;
            case TRIANGOLO:
                poligon=new Triangolo(base,height);
                break;
            default:
                System.out.println("error, not a known type\n");
                return;
        }
        if (poligons.stream().anyMatch(x -> x.equals(poligon))){
            System.out.println("already present in the collection");
        }else
            poligons.add(poligon);
    }

    public void printAree(){
        poligons.forEach(x -> System.out.println(x.getClass().toString().substring(6) + ":" + x.getArea()));
    }

    @Override
    public String toString() {
        return "Geometrie : "+ poligons;
    }
}

abstract class Poligono {
    private int vertexNum;
    private double base, height;

    public Poligono(int vertexNum, double base, double height) {
        this.vertexNum = vertexNum;
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    public int getNumeroVertici() {
        return vertexNum;
    }

    public abstract double getArea();

    @Override
    public String toString() {
        return this.getClass().toString().substring(6) +"{" +
                "base=" + base +
                ", height=" + height +
                '}';
    }
}

class Parallelogramma extends Poligono {
    private int vertexNum;
    private double base, height, area;

    public Parallelogramma(double base, double height) {
        super(4, base, height);
    }


    public int getNumeroVertici() {
        return super.getNumeroVertici();
    }

    public double getArea() {
        return getBase() * getHeight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parallelogramma that = (Parallelogramma) o;
        return vertexNum == that.vertexNum &&
                Double.compare(that.base, base) == 0 &&
                Double.compare(that.height, height) == 0;
    }
}

class Rettangolo extends Poligono {
    private int vertexNum;
    private double base,height;

    public Rettangolo(double base, double height) {
        super(4, base, height);
    }


    public int getNumeroVertici() {
        return super.getNumeroVertici();
    }

    public double getArea() {
        return getBase() * getHeight();
    }

    public double getPerimeter() {
        return getBase() * 2 + getHeight() * 2;
    }
}

class Triangolo extends Poligono {
    private int vertexNum;
    private double base, height;

    public Triangolo(double base, double height) {
        super(3, base, height);
    }


    public int getNumeroVertici() {
        return super.getNumeroVertici();
    }

    public double getArea() {
        return (double) (getBase() * getHeight() /2);
    }

}
