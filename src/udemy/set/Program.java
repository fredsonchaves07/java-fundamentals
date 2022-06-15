package udemy.set;

import java.util.HashSet;
import java.util.Set;

public class Program {

    public static void main(String[] args) {

        Set<String> eletronics = new HashSet<>();
        eletronics.add("TV");
        eletronics.add("Notebook");
        eletronics.add("Tablet");
        System.out.println(eletronics.contains("Notebook"));
        eletronics.remove("Tablet");
        eletronics.removeIf(eletronic -> eletronic.length() >= 3);
        for (String eletronic: eletronics) System.out.println(eletronic);
    }
}
