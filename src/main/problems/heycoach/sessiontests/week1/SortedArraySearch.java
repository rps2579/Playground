package main.problems.heycoach.sessiontests.week1;

import java.util.ArrayList;
import java.util.List;

public class SortedArraySearch {
    public static void main(String[] args) {

    }

    private static int searchPosition(ArrayList<Integer> arr, int target) {
        int len = arr.size();
        int currIndex = len/2;

        while (isIndexOutOfBound(currIndex, len)) {
            Integer currNum = arr.get(currIndex);
            if (target == currNum)
                return currIndex;
            else if (target < currNum) {
                if (arr.get(currIndex-1) < target)
                    break;
                currIndex /= 2;
            }
            else {
                if (arr.get(currIndex+1) > target)
                    break;
                currIndex = (len-currIndex)/2;
            }
        }
        return currIndex;
    }

    private static boolean isIndexOutOfBound(int currIndex, int len) {
        return currIndex > -1 && currIndex < len;
    }

    private Integer binarySearch(Integer start, Integer end, List<Integer> arr, Integer target) {
        Integer mid = (Integer) (start+end)/2;
        Integer midNum = arr.get(mid);

        if (target == midNum) {
            return mid;
        } else if (target < midNum) {
            end = mid-1;
            if (arr.get(end) < target)
                return mid;
        } else {
            start = mid+1;
            if (target < arr.get(start))
                return mid+1;
        }

        if (start > end)
            return mid;
        return binarySearch(start, end, arr, target);
    }
}
