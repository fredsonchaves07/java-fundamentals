package udemy.functionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Pipeline {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);
        Stream<Integer> stream1 = list.stream().map(x -> x * 10);
        System.out.println(stream1.toList());
        int sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        List<Integer> newList = list.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * 10)
                .toList();
        System.out.println(newList);
    }
}
