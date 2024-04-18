package main.problems.techgig;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MagicWand {

    public static void main(String args[] ) throws Exception {

        Scanner scanner = new Scanner(System.in);
        long noOfNumbers = scanner.nextInt();
        long noOfQueries = scanner.nextInt();

        List<Long> numbers = new ArrayList<>();
        while (noOfNumbers-- > 0) {
            numbers.add(scanner.nextLong());
        }

        List<Long> queries = new ArrayList<>();
        while (noOfQueries-- > 0) {
            queries.add(scanner.nextLong());
        }

        for (Long query : queries) {
            System.out.println(findCost(numbers, query));
        }
    }

    private static long findCost(List<Long> numbers, Long query) {
        final Long[] cost = {0L};
        numbers.stream().forEach(number -> {
            cost[0] += Math.abs(number - query);
        });
        return cost[0];
    }
}
