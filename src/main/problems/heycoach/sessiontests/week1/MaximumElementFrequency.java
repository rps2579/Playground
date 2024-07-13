package main.problems.heycoach.sessiontests.week1;

import java.util.ArrayList;

public class MaximumElementFrequency {

    public int maxElementFrequency(int n, ArrayList<Integer> a) {
        Integer currMax = Integer.MIN_VALUE;
        Integer freqOfCurrMax = 0;

        for (Integer num : a) {
            if (num > currMax) {
                currMax = num;
                freqOfCurrMax = 1;
            }
            else if (num == currMax)
                freqOfCurrMax++;
        }

        return freqOfCurrMax;
    }
}
