import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class sortableList {
    public static void main(String args[]) {
        ArrayOrdinabile<String> kernel = new ArrayOrdinabile<>();
        kernel.addModulo(new SortableListImpl<String>((o, t1) -> ((String)o).compareTo((String)t1) ));
        kernel.add("farfalla");
        kernel.add("ragno");
        kernel.add("zanzara");
        kernel.add("mosca");
        kernel.sort();
        kernel.print();
        kernel.remove("ragno");
        System.out.println();
        kernel.print();

        System.out.println();
        ArrayOrdinabile<Integer> kernel1 = new ArrayOrdinabile<Integer>();
        kernel1.addModulo(new SortableListImpl<Integer>((o, t1) ->  (int)o - (int) t1));
        kernel1.add(new Integer(20));
        kernel1.add(new Integer(30));
        kernel1.add(new Integer(10));
        kernel1.add(new Integer(5));
        //kernel1.add("ciao"); // error: incompatible types...
        kernel1.sort();
        kernel1.print();
    }
}

class ArrayOrdinabile<T extends Comparable>{
    SortableList<T> list;
    public void addModulo(SortableList<T> list){
        this.list = list;
    }
    public void add(T newItem) {
        list.add(newItem);
    }

    public boolean remove(T item) {
        return list.remove(item);
    }

    public void sort() {
        list.sort();
    }


    public void print() {
        list.print();
    }

}
class SortableListImpl <T extends Comparable> implements SortableList<T>{
    List<T> list;
    Comparator comparator;

    public SortableListImpl(Comparator comparator){
        this.comparator=comparator;
        list = new ArrayList();
    }

    @Override
    public void add(T newItem) {
        list.add(newItem);
    }

    @Override
    public boolean remove(T item) {
        return list.remove(item);
    }

    @Override
    public void sort() {
        list.sort(comparator);
    }

    @Override
    public void print() {
        System.out.println(list);
    }
}
interface SortableList <T extends Comparable>{
    void add(T t);
    boolean remove(T t);
    void sort();
    void print();
}
