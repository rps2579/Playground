package main.problems.heycoach.mindmap.arrays.simple;

public class BuildArrayFromPermutation {
    public int[] buildArray(int[] nums) {
        // int[] ans = new int[nums.length];

        // for (int i=0; i<nums.length; i++) {
        //     ans[i] = nums[nums[i]];
        // }

        inplaceCreationOfNewArray(nums, 0);

        return nums;
    }

    /**
     * Surprisingly, this is faster than creating a new array and returning it in O(n) time.
     * @param nums
     * @param start
     */
    private void inplaceCreationOfNewArray(int[] nums, int start) {
        if (start < nums.length) {
            int temp = nums[nums[start]];

            inplaceCreationOfNewArray(nums, start+1);
            nums[start] = temp;
        }
    }
}
