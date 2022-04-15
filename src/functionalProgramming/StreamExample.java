package functionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);
        Stream<Integer> stream1 = list.stream().map(element -> element * 10);
        System.out.println(stream1.toList());
        Stream<String> stream2 = Stream.of("Maria", "Alex", "Bob");
        System.out.println(stream2.toList());
        Stream<Integer> stream3 = Stream.iterate(0, element -> element + 2);
        System.out.println(stream3.limit(10).toList());
        /* Sequência de fibbonacci utilizando stream */
        Stream<Long> stream4 = Stream.iterate(new Long[] {0L, 1L}, p -> new Long[] {p[1], p[0] + p[1]}).map(p -> p[0]);
        System.out.println(stream4.limit(10).toList());
    }
}
