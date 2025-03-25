package main.problems.leetcode;

import java.util.HashMap;
import java.util.Map;

public class JumpGame2 {

    private int[] nums;
    private Map<Integer, Integer> minStepsToEnd = new HashMap<>();

    public static void main(String[] args) {
        JumpGame2 jumpGame2 = new JumpGame2();

        switch (2) {
            case 1:
                System.out.println(jumpGame2.jump(new int[]{2, 3, 1, 1, 4}));
                break;
            case 2:
                System.out.println(jumpGame2.jump(new int[]{2, 3, 0, 1, 4}));
                break;
        }
    }

    public int jumpGreedyApproach(int[] nums) {
        int farthest = 0, currEnd = 0, jumps = 0;

        for (int i=0; i<nums.length; i++) {
            if (currEnd >= nums.length-1) {
                return jumps;
            }

            farthest = Math.max(farthest, i+nums[i]);

            if (i == currEnd) {
                jumps++;
                currEnd = farthest;
            }
        }

        return jumps;
    }

    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums[0] >= nums.length-1) return 1;

        this.nums = nums;
        minStepsToEnd.put(nums.length - 1, 0);

        minStepsToReachEnd(0);
        return minStepsToEnd.get(0);
    }

    private int minStepsToReachEnd(int currIndex) {
        if (minStepsToEnd.containsKey(currIndex)) return minStepsToEnd.get(currIndex);

        int indexToRecurse;
        int currMin, min=Integer.MAX_VALUE;

        if (nums[currIndex] + currIndex >= nums.length - 1) {
            minStepsToEnd.put(currIndex, 1);
            return 1;
        }

        for (int i=nums[currIndex]; i>0; i--) {
            indexToRecurse = currIndex+i;
            if (indexToRecurse >= nums.length) continue;

            currMin = minStepsToReachEnd(indexToRecurse);
            if (currMin > -1) {
                min = Math.min(currMin+1, min);
            }
        }

        min = (min == Integer.MAX_VALUE) ? -1 : min;
        minStepsToEnd.put(currIndex, min);
        return min;
    }

    private void printMap() {
        for (Map.Entry entry: minStepsToEnd.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}