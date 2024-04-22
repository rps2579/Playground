package main.problems.leetcode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-good-pairs/description/
 */
public class NumberOfGoodPairs {
    public static void main(String[] args) {
        int[][] testarr = new int[2][];
        System.out.println(testarr.length);
        System.out.println(testarr[0]);
        testarr[0][0] = 2;
        System.out.println(testarr[0].length);
    }

    public int mostOptiomized(int[] nums) {
        int[] freq = new int[101];
        int ans = 0;

        for (int num: nums) {
            ans += freq[num]++;
        }

        return ans;
    }

    public int numIdenticalPairsUsingMap(int[] nums) {
        int count = 0;
        Map<Integer, List<Integer>> numIndexMap = new LinkedHashMap<>();

        for (int i=0; i<nums.length; i++) {
            if (numIndexMap.keySet().contains(nums[i]))
                numIndexMap.put(nums[i], new ArrayList<Integer>());
            numIndexMap.get(nums[i]).add(i);
        }
        for (Map.Entry entry: numIndexMap.entrySet()) {
            int n = ((List) entry.getValue()).size();
            count += (n *(n-1)/2);
        }
        return count;
    }

    public int numIdenticalPairsUsingArray(int[] nums) {
        int count = 0;
        int[][] indexCache = new int[nums.length][];
        for (int i=0; i<nums.length; i++) {
            int[] currNumCache = indexCache[nums[i]];
            indexCache[nums[i]][currNumCache.length] = i;
        }
        for (int i=0; i<indexCache.length; i++) {
            int[] currNumCache = indexCache[nums[i]];
            int n = currNumCache.length;
            count += (n *(n-1)/2);
        }

        return count;
    }

}
