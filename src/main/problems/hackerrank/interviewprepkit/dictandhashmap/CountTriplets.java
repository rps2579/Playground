package main.problems.hackerrank.interviewprepkit.dictandhashmap;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CountTriplets {
    public static void main(String[] args) {
        // Answer - 2
//        System.out.println(countTriplets(List.of(1L, 4L, 16L, 64L), 4));
        // Answer - 3
        System.out.println(countTriplets(List.of(1L, 2L, 1L, 2L, 4L), 2));

    }

    private static long countTriplets(List<Long> nums, long r) {
        Map<Long, Long> leftFreq = new TreeMap<>();
        Map<Long, Long> rightFreq = new TreeMap<>();
        for (Long num: nums) {
            rightFreq.put(num, rightFreq.getOrDefault(num, 0L)+1);
        }

        long answer = 0;
        for (Long num: nums) {
            /**
             * CurrNum is always considered as middle number
             *      remove from rightFreq as it is current
             *
             * leftFreq should contain lower i.e, num/r if num%r==0
             * rightFreq should contain higher i.e, num*r
             *
             * After Calculation is done, add curr into leftFreq as it will be used next
             */

            rightFreq.put(num, rightFreq.get(num)-1);

            long smallerNum = 0L;
            if (num % r == 0)
                smallerNum = num/r;

            long largerNum = num*r;

            long currNumTriplets = leftFreq.getOrDefault(smallerNum, 0L) * rightFreq.getOrDefault(largerNum, 0L);
            answer += currNumTriplets;

            leftFreq.put(num, leftFreq.getOrDefault(num, 0L)+1);
        }

        return answer;
    }

    static long countTripletsBruteForceWithHashing(List<Long> arr, long r) {
        long answer = 0;
        /**
         * Stores how many triplets for particular first number
         */
        Map<Long, Long> cacheForNum1 = new TreeMap<>();
        for (int i = 0; i < arr.size() - 2; i++) {
            long num1 = arr.get(i);
            long num1TripletsFromCache = cacheForNum1.getOrDefault(num1, -1L);
            if (num1TripletsFromCache != -1L) {
                answer += num1TripletsFromCache;
                System.out.println("Used num1Cache: " + num1 + ", " + cacheForNum1.get(num1));
                continue;
            }

            long expectedNum2 = num1*r;
            long num1Triplets = 0;
            Map<Long, Long> cacheForNum2 = new TreeMap<>();
            for (int j = i+1; j < arr.size() - 1; j++) {
                long num2 = arr.get(j);
                long num2ValueFromCache = cacheForNum2.getOrDefault(num2, -1L);
                if (num2ValueFromCache != -1L) {
                    num1Triplets += num2ValueFromCache;
                    System.out.println("Used num2Cache: " + num2 + ", " + cacheForNum2.get(num2));
                    continue;
                }

                if (num2 != expectedNum2) {
                    if (num2 > expectedNum2)
                        break;
                    else
                        continue;
                }

                long expectedNum3 = num2*r;
                long num2Value = 0;
                for (int k = j+1; k < arr.size(); k++) {
                    long num3 = arr.get(k);
                    if (num3 != expectedNum3) {
                        if (num3 > expectedNum3)
                            break;
                        else
                            continue;
                    }

                    num2Value += 1;
                }

                num1Triplets += num2Value;
                cacheForNum2.put(num2, num2Value);
                System.out.println("Updated num2Cache: " + num2 + ", " + cacheForNum2.get(num2));
            }

            answer += num1Triplets;
            cacheForNum1.put(num1, num1Triplets);
            System.out.println("Updated num1Cache: " + num1 + ", " + cacheForNum1.get(num1));
        }

        return answer;
    }

}
