package main.problems.heycoach.mindmap.arrays.prefixsum;

public class FindPivotElement {
    public int pivotIndexConstantSpace(int[] nums) {
        int n = nums.length;

        int rightSum = 0, leftSum = 0;

        // not considering 1st element as we need to find sum from right most to the next ele
        for (int i=1; i<n; i++) {
            rightSum += nums[i];
        }

        if (rightSum == 0) return 0;

        for (int i=1; i<n; i++) {
            leftSum += nums[i-1];
            rightSum -= nums[i];

            if (leftSum == rightSum) return i;
        }

        return -1;
    }

    public int pivotIndexClassic(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];

        leftSum[0] = 0;
        rightSum[n-1] = 0;
        for (int i=1; i<n; i++) {
            leftSum[i] = leftSum[i-1] + nums[i-1];
            rightSum[n-i-1] = rightSum[n-i] + nums[n-i];
        }

        for (int i=0; i<n; i++) {
            if (leftSum[i] == rightSum[i]) return i;
        }

        return -1;
    }
}
