package main.problems.hackerrank.interviewprepkit.dictandhashmap;

import java.util.*;

public class FrequencyQueries {
    public static void main(String[] args) {
        System.out.println(freqQuery(List.of(
                List.of(1, 1),
                List.of(1, 2),
                List.of(3, 1),
                List.of(2, 1),
                List.of(3, 1),
                List.of(3, 2)
        )));
    }

    private static List<Integer> freqQuery(int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i=0; i<queries.length; i++) {
            int num = queries[i][1];
            int queryType = queries[i][0];

            if (queryType == 1) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            } else if (queryType == 2) {
                Integer currNumFreq = freqMap.getOrDefault(num, 0);
                if (currNumFreq > 1)
                    freqMap.put(num, currNumFreq - 1);
                else
                    freqMap.remove(num);
            } else {
                answer.add(freqMap.values().contains(num) ? 1 : 0);
            }
        }

        return answer;
    }


    private static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> freqMap = new TreeMap<>();

        for (List<Integer> query: queries) {
            Integer num = query.get(1);
            Integer queryType = query.get(0);

            if (queryType == 1) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            } else if (queryType == 2) {
                Integer currNumFreq = freqMap.get(num);
                if (Objects.nonNull(currNumFreq))
                    if (currNumFreq > 1)
                        freqMap.put(num, currNumFreq - 1);
                    else
                        freqMap.remove(num);
            } else {
                answer.add(freqMap.values().contains(num) ? 1 : 0);
            }
        }

        return answer;
    }

}
