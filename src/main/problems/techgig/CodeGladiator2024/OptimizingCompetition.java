package main.problems.techgig.CodeGladiator2024;

import java.util.*;

/**
 * https://leetcode.com/discuss/interview-question/1638629/Google-or-Snapshot-(OA)-or-Maximum-unique-pairs-that-form-a-sum/1187005
 */
public class OptimizingCompetition {

    public static void main(String[] args) {
        selfSolution();
    }

    private static void on2Soln() {

        Scanner sc = new Scanner(System.in);

        int noOfParticipants = sc.nextInt();

        int[] arr = new int[noOfParticipants];
        for (int i = 0; i < noOfParticipants; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<arr.length; i++){
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
        }
        int []freq = new int[max + 1];
        // Count the frequency
        for(int i = 0; i < arr.length; ++i)
            freq[arr[i]]++;

        int result = 0;

        // Every possible sum of pairs
        for(int sum = 2*min; sum <= 2 * max; sum++){
            // Count of pairs with given sum
            int pair = 0;
            for(int num = 1; num < (sum + 1) / 2; num++){
                // Check for a possible pair
                if (sum - num <= max){
                    // Update count of pair
                    pair += Math.min(freq[num], freq[sum - num]);
                }
            }
            if (sum % 2 == 0){
                pair += freq[sum / 2] / 2;
            }
            // Update the result
            result = Math.max(result, pair);
        }

        System.out.println(result);
    }

    private static void selfSolution() {
        Scanner sc = new Scanner(System.in);

        int noOfParticipants = sc.nextInt();

        Map<Integer, Integer> wtFreqMap = new LinkedHashMap<>();
        for (int i = 0; i < noOfParticipants; i++) {
            int currWt = sc.nextInt();
            wtFreqMap.put(currWt, wtFreqMap.getOrDefault(currWt, 0)+1);
        }

        Map<Integer, Integer> commomWtCountMap = new LinkedHashMap<>();
        Integer[] differentAvailableWts = wtFreqMap.keySet().toArray(new Integer[0]);

        for (int i = 0; i < differentAvailableWts.length; i++) {
            int firstNumInPair = differentAvailableWts[i];

            for (int j = i; j < differentAvailableWts.length; j++) {
                int secondNumInPair = differentAvailableWts[j];
                int pairWt = firstNumInPair + secondNumInPair;

                if (commomWtCountMap.getOrDefault(pairWt, -1) > -1) {
                    continue;
                }

                commomWtCountMap.put(pairWt,
                        calculatePairs(pairWt, differentAvailableWts, wtFreqMap));
            }
        }

        System.out.println(Collections.max(commomWtCountMap.values()));
    }

    private static int calculatePairs(int pairWt, Integer[] differentAvailableWts, Map<Integer, Integer> avblWtFreqMap) {
        List<Integer> usedWts = new ArrayList<>();

        int noOfPairsWithGivenWt = 0;
        for (int firstNumInPair : differentAvailableWts) {
            int remainingWtForPair = pairWt - firstNumInPair;

            if (remainingWtForPair < 1
                    || usedWts.contains(firstNumInPair)
                    || usedWts.contains(remainingWtForPair)
                    || !avblWtFreqMap.containsKey(remainingWtForPair))
                continue;

            if (firstNumInPair == remainingWtForPair) {
                int n = avblWtFreqMap.get(firstNumInPair);

                int noOfPairsOfCurrPair = n / 2;

                noOfPairsWithGivenWt += noOfPairsOfCurrPair;

                usedWts.add(firstNumInPair);
            } else {
                int nOfFirstNum = avblWtFreqMap.get(firstNumInPair);
                int nOfSecondNum = avblWtFreqMap.get(remainingWtForPair);

                int noOfPairsOfCurrPair = Math.min(nOfFirstNum, nOfSecondNum);

                noOfPairsWithGivenWt += noOfPairsOfCurrPair;

                usedWts.add(firstNumInPair);
                usedWts.add(remainingWtForPair);
            }
        }

        return noOfPairsWithGivenWt;
    }
}
