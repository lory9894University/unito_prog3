import java.util.List;

public class Coda <T>{
    List<T> coda;

    public Coda(List<T> coda) {
        this.coda = coda;
    }

    public boolean empty(){
        return coda.isEmpty();
    }

    public T get(){
        return coda.remove(0);
    }

    public void put(T t){
        coda.add(t);
    }

}
