import java.util.Collection;

public class Calcolatrice {
    public static void print(Collection<? extends Number> numbers){
        for (Number number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public static Number sum(Collection<? extends Number> numbers){
        if (!numbers.iterator().hasNext())
            return 0;
        switch (numbers.iterator().next().getClass().getName()){
            case "java.lang.Integer":
                return numbers.stream().mapToInt(x->(int)x).reduce(0,Integer::sum);
            case "java.lang.Double":
                return numbers.stream().map(x->(double)x).reduce((double)0,Double::sum);
            case "java.lang.Float":
                return numbers.stream().map(x->(float)x).reduce((float) 0,Float::sum);
            case "java.lang.Long":
                return numbers.stream().mapToLong(x->(int)x).reduce(0,Long::sum);
        }
        return 0;
    }public static Number max(Collection<? extends Number> numbers){
        if (!numbers.iterator().hasNext())
            return 0;
        switch (numbers.iterator().next().getClass().getName()){
            case "java.lang.Integer":
                return numbers.stream().mapToInt(x->(int)x).max().getAsInt();
            case "java.lang.Double":
                return numbers.stream().map(x->(double)x).max(Double::compareTo).get();
            case "java.lang.Float":
                return numbers.stream().map(x->(float)x).max(Float::compareTo).get();
            case "java.lang.Long":
                return numbers.stream().mapToLong(x->(int)x).max().getAsLong();
        }
        return 0;
    }

}
