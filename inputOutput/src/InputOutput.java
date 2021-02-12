import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class InputOutput {
    public static void main(String[] args) {
        Indirizziario indirizziario = new Indirizziario("prova.txt");
        indirizziario.print();
        indirizziario.remove()

    }
}

class Indirizziario{
    HashMap<String,Indirizzo> indirizziario =  new HashMap<>();

    public Indirizziario(String filename) {
        List<String> lines = null;

        try(BufferedReader bf = new BufferedReader(new FileReader(filename))){
            lines = bf.lines().collect(Collectors.toList());
        }catch (IOException e){
            e.printStackTrace();
            return;
        }
        lines.forEach(
                (line) -> {
                    String []sub = Arrays.stream(line.split(";")).map(x -> x.stripLeading().stripTrailing()).toArray(String[]::new);
                    add(sub[0],sub[1],sub[2],Integer.parseInt(sub[3]),sub[4]);
                }
        );
    }

    public Indirizziario() {
    }

    public void add (String nome, String cognome, String via, int civico, String citta){
        indirizziario.put(nome + cognome,new Indirizzo(nome, cognome, via, civico, citta));
    }

    /**
     * la funzione rimuove una persona
     * @param nome il nome della persona
     * @param cognome
     * @return se puo essere rimossa
     */
    public boolean remove(String nome, String cognome){
        return indirizziario.remove(nome + cognome) != null;
    }
    public void print(){
        indirizziario.values().forEach(System.out::println);
    }

}

class Indirizzo{
    String Nome,Cognome,Via,Citta;
    int Civico;

    /**
     * sdflihfgoils
     * @param nome
     * @param cognome
     * @param via
     * @param civico
     * @param citta
     */
    public Indirizzo(String nome, String cognome, String via,int civico, String citta) {
        Nome = nome;
        Cognome = cognome;
        Via = via;
        Citta = citta;
        Civico=civico;
    }

    @Override
    public String toString() {
        return "Indirizzo{" +
                "Nome='" + Nome + '\'' +
                ", Cognome='" + Cognome + '\'' +
                ", Via='" + Via + '\'' +
                ", Citta='" + Citta + '\'' +
                ", Civico=" + Civico +
                '}';
    }
}