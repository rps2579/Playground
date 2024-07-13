package main.problems.heycoach.sessiontests.week1;

import java.util.ArrayList;

public class SortBallsInPlace {

    void sortBalls(ArrayList<Integer> nums) {
        int size = nums.size();
        int numOfOs = 0, numOf1s = 0, numOf2s = 0;

        for (int i = 0; i < size; i++) {
            if (nums.get(i) == 0) {
                numOfOs += 1;
            } else if (nums.get(i) == 1) {
                numOf1s += 1;
            } else {
                numOf2s += 1;
            }
        }

        nums.clear();
        for (int i = 0; i < numOfOs; i++) {
            nums.add(0);
        }
        for (int i = 0; i < numOf1s; i++) {
            nums.add(1);
        }
        for (int i = 0; i < numOf2s; i++) {
            nums.add(2);
        }
    }

    int findNum(ArrayList<Integer> nums, int target, int startIndex) {
        for (int i = startIndex; i < nums.size(); i++) {
            if (nums.get(i) == target)
                return i;
        }
        return -1;
    }
}
