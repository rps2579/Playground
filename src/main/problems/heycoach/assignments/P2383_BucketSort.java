package main.problems.heycoach.assignments;

import java.util.LinkedHashMap;
import java.util.Map;

public class P2383_BucketSort {

    public static void main(String[] args) {
        String input = "ssgysyqa";
        System.out.println(freqSort(input));
    }

    private static String freqSort(String input) {
        Map<Character, Integer> freqMap = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); i++) {
            freqMap.put(input.charAt(i), freqMap.getOrDefault(input.charAt(i), 0)+1);
        }

        Map<Integer, String> countCharMap = new LinkedHashMap<>();
        freqMap.forEach((k,v) -> {
            countCharMap.put(
                    v,
                    countCharMap.getOrDefault(v, "")
                            + String.valueOf(k).repeat(v));
        });

        StringBuilder result = new StringBuilder();
        countCharMap.entrySet().stream()
                .sorted((e1, e2) -> e2.getKey() - e1.getKey())
                .forEach(e -> result.append(bucketSortString(e.getValue())));
        return result.toString();
    }

    private static String bucketSortString(String input) {
        int inputLength = input.length();
        char[] inputArr = input.toCharArray();

        for (int i = 0; i < inputLength; i++) {
            for (int j = 1; j < inputLength-i; j++) {
                if (inputArr[j - 1] > inputArr[j]) {
                    char temp = inputArr[j];
                    inputArr[j] = inputArr[j-1];
                    inputArr[j-1] = temp;
                }
            }
        }

        return String.valueOf(inputArr);
    }
}
