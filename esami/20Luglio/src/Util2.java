public class Util2 {

    public static <T> boolean uguali(T uno, T due){
        return uno==due;
    }

    public static void main(String[] args) {
        System.out.println(uguali("mondo", "ciao"));
        System.out.println(uguali("mondo", "mondo"));
        System.out.println(uguali(null, "null"));
    }
}
