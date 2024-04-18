package main.problems.hackerrank.interviewprepkit.stackandqueue;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LargestRectangle {
    public static void main(String[] args) {
        System.out.println(largestRectangle(List.of(1,2,3,4,5)));
        System.out.println(largestRectangle(List.of(5,2,3,4,5)));
        System.out.println(largestRectangle(List.of(5,4,3,4,5)));
        System.out.println(largestRectangle(List.of(5,4,1,4,5)));
        System.out.println(largestRectangle(List.of(5,4,3,1,4,5)));
    }

    private static Integer largestRectangleOptimize(List<Integer> heights) {
        Map<Integer, Integer> cache = new LinkedHashMap<>();
        List<Integer> completedHeights = new ArrayList<>();

        int maxArea = 0;
        int size = heights.size();
        for (int i = 0; i < size; i++) {
            int currIterMinHeight = heights.get(i);

//            if (cache.getOrDefault(currIterMinHeight, -1) != -1)
            if (completedHeights.contains(currIterMinHeight))
                continue;

            int currIterMaxArea = 0;
            for (Integer currHeight: heights) {
                if (currIterMinHeight > currHeight) {
                    maxArea = Math.max(currIterMaxArea, maxArea);
                    currIterMaxArea = 0;
                }
                else {
                    currIterMaxArea += currIterMinHeight;
                }
            }
            maxArea = Math.max(currIterMaxArea, maxArea);

//            cache.put(currIterMinHeight, currIterMaxArea)
            completedHeights.add(currIterMinHeight);
        }

        return maxArea;
    }

    private static Integer largestRectangle(List<Integer> heights) {
        Map<Integer, Integer> cache = new LinkedHashMap<>();

        int maxArea = 0;
        for (int i = 0; i < heights.size(); i++) {
            int currIterMinHeight = heights.get(i);

            if (cache.getOrDefault(currIterMinHeight, -1) != -1)
                continue;

            int currIterMaxArea = 0;
            for (Integer currHeight: heights) {
                if (currIterMinHeight > currHeight) {
                    currIterMaxArea = 0;
                }
                else {
                    currIterMaxArea += currIterMinHeight;
                    maxArea = Math.max(currIterMaxArea, maxArea);
                }
            }

            cache.put(currIterMinHeight, currIterMaxArea);
        }

        return maxArea;
    }
}
