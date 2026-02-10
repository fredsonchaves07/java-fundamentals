package javamodern.stream;

import java.util.*;
import java.util.stream.Collectors;

public class Chapter5Solutions {

    static void main() {
        List<Transaction> transactions = inicialize();
//        solution1(transactions);
//        solution2(transactions);
//        solution3(transactions);
//        solution4(transactions);
//        solution5(transactions);
//        solution6(transactions);
//        solution7(transactions);
        solution8(transactions);
    }

    private static void solution1(final List<Transaction> transaction) {
        final List<Transaction> list = transaction
                .stream()
                .filter(transaction1 -> transaction1.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .toList();
        System.out.println(list);
    }

    private static void solution2(final List<Transaction> transaction) {
        final Set<String> list = transaction
                .stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .collect(Collectors.toSet());
        System.out.println(list);
    }

    private static void solution3(final List<Transaction> transaction) {
        final Set<Trader> list = transaction
                .stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .collect(Collectors.toSet());
        System.out.println(list);
    }

    private static void solution4(final List<Transaction> transaction) {
        final LinkedHashSet<String> list = transaction
                .stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(list);
    }

    private static void solution5(final List<Transaction> transaction) {
        final Set<Trader> list = transaction
                .stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Milan"))
                .collect(Collectors.toSet());
        System.out.println(list);
    }

    private static void solution6(final List<Transaction> transaction) {
        final List<Integer> list = transaction
                .stream()
                .filter(transaction1 -> transaction1.getTrader().getCity().equals("Milan"))
                .map(Transaction::getValue)
                .toList();
        System.out.println(list);
    }

    private static void solution7(final List<Transaction> transaction) {
        final Integer maxValue = transaction
                .stream()
                .map(Transaction::getValue)
                .reduce(0, Integer::max);
        System.out.println(maxValue);
    }

    private static void solution8(final List<Transaction> transaction) {
        final Transaction transactionValue = transaction
                .stream()
                .min(Comparator.comparing(Transaction::getValue))
                .orElseThrow();
        System.out.println(transactionValue);
    }

    private static List<Transaction> inicialize() {
        final Trader raoul = new Trader("Raoul", "Cambridge");
        final Trader mario = new Trader("Mario","Milan");
        final Trader alan = new Trader("Alan","Cambridge");
        final Trader brian = new Trader("Brian","Cambridge");
        return Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }
}
