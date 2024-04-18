package main.problems.techgig;

import java.util.*;
import java.util.stream.Collectors;

public class StopTheShameSemiProb1 {
    private static long p;
    private static Set<Long> inputWeights = new HashSet<>();
    private static List<Long> candidatesToBeSorted = new ArrayList<>();
    private static boolean isFirstPrint = true;

    public static void main(String[] args) {
        takeInput();

        List<Long> sortedWeights = inputWeights.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for (Long candidateWeight : candidatesToBeSorted) {
            print(sortedWeights.indexOf(candidateWeight) + 1L);
        }
    }

    private static void takeInput() {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        p = sc.nextLong();

        for (long i = 0; i < n; i++) {
            inputWeights.add(sc.nextLong());
        }

        long currNum;
        for (long i = 0; i < p; i++) {
            currNum = sc.nextLong();

            candidatesToBeSorted.add(currNum);
            inputWeights.add(currNum);
        }

        sc.close();
    }

    private static void print(Long currNum) {
        if (isFirstPrint) {
            System.out.print(currNum);
            isFirstPrint = false;
            return;
        }

        System.out.print("\n" + currNum);
    }
}
