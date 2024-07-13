package main.problems.hackerrank.deliveroo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchSuggestionSystem {
    public static void main(String[] args) {
        List<String> products = List.of("abcd", "abdc", "abaa", "acbd");
        String search = "abad";
        List<List<String>> searches = getProductSuggestions(products, search);
        for (List<String> list: searches) {
            System.out.print("[");
            for (String suggestion: list) {
                System.out.print(suggestion + ", ");
            }
            System.out.println("]");
        }
    }

    private static List<List<String>> getProductSuggestions(List<String> products, String search) {
        List<List<String>> answer = new ArrayList<>();
        for (int i = 1; i <= search.length(); i++) {
            Stream<String> sortedProductStream = products.stream().sorted();
            int finalI = i;
            List<String> matchedProducts = sortedProductStream
                    .filter(word -> word.startsWith(search.substring(0, finalI)))
                    .collect(Collectors.toList());

            answer.add(matchedProducts.size() < 4 ? matchedProducts : matchedProducts.subList(0, 3));
        }

        return answer;
    }
}
