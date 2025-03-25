package main.problems.heycoach.mindmap.arrays.simple;

public class ShuffleInPlace {
    public int[] shuffle(int[] nums, int n) {
        shuffleInplace(nums, n, 0, 0);
        return nums;
    }

    private void shuffleInplace(int[] nums, int n, int currXIndex, int replaceXIndex) {
        if (currXIndex < n) {
            int tempX = nums[currXIndex];
            int tempY = nums[n+currXIndex];

            shuffleInplace(nums, n, currXIndex+1, replaceXIndex+2);

            nums[replaceXIndex] = tempX;
            nums[replaceXIndex+1] = tempY;
        }
    }
}
