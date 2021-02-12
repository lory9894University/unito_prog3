public class Util {

    public static <T extends Comparable<T>> T max (T elem1, T elem2){
        if (elem1 == null)
            return elem2;
        if (elem2 == null)
            return elem1;
        return elem1.compareTo(elem2) >= 0 ? elem1 : elem2;
    }

    public static void main(String[] args) {
        System.out.println(max("mondo", "ciao"));
        System.out.println(max(1, 2));
    }
}
