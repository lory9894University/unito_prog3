import java.util.Collection;
import java.util.List;

public class Geometrie <T extends Poligono>{
    List<T> poligonList;

    public Geometrie(List<T> lista) {
        poligonList = lista;
    }

    public int getNumElem(){
        return poligonList.size();
    }

    public boolean add(T element){
        if (poligonList.contains(element))
            return false;
        poligonList.add(element);
        return true;
    }

    public void printAree(){
        int id=0;
        if (!poligonList.iterator().hasNext())
            return;
        System.out.println("lista di " + poligonList.iterator().next().getClass().getName());
        for (T poligon: poligonList) {
            System.out.println("#" + id + ": " + poligon.getArea());
            id ++;
        }
    }
}
abstract class Poligono {
    private final int vertexNum;
    private final double base, height;

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
