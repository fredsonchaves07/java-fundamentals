package udemy.list;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Maria");
        list.add("Bob");
        list.add("Alex");
        list.add(2, "Anna");

        for(String name : list){
            System.out.println(name);
        }

        System.out.println(list.size());

        /* Predicados lambda */
        list.removeIf(string -> string.charAt(0) == 'M');
    }
}
