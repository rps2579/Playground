package main.problems.heycoach.sessiontests.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        byte a = 9;
        byte b = 7;
        List<Integer> al = new ArrayList<>();
        al.iterator().next();
//        System.out.println(c);

        Stack<Character> stk = new Stack<>();
        stk.peek();
        stk.pop();
        stk.push(' ');
    }

    public void swapToMax(int n, int[] a, int[] b) {
        // check if a[n-1] = max(a) and b[n-1] = max(b) can be achieved by swap(a[i], b[i]) any number of times
        int maxA = findMax(a);
        int maxB = findMax(b);

        if (maxA == a[n-1] && maxB == b[n-1]) {
            System.out.println("YES");
            return;
        }

        if (maxA != a[n-1] && maxB != b[n-1]) {
            System.out.println("NO");
            return;
        }

        if (maxA == maxB)
            swapArrBasedOnLast(a, b, a[n-1]<b[n-1] ? a[n-1] : b[n-1]);
        else {
            if (maxA > maxB) {
                swapArrBasedOnLast(a, b, a[n-1]);
            }
            else {
                swapArrBasedOnLast(b, a, b[n-1]);
            }
        }

        maxA = findMax(a);
        maxB = findMax(b);

        if (maxA == a[n-1] && maxB == b[n-1]) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

    private void swapArrBasedOnLast(int[] a, int[] b, int thresholdForSwap) {
        for (int i = 0; i < a.length; i++) {
            if (b[i] > thresholdForSwap) {
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            }
        }
    }

    private int findMax(int[] ar) {
        int max = ar[0];
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] > max) {
                max = ar[i];
            }
        }
        return max;
    }

    private static int prefixMangoesAndPineapples(String s, int n) {
        int[] prefixMangoes = new int[n];
        int[] prefixPineapples = new int[n];

        if (s.charAt(0) == 'P') {
            prefixMangoes[0] = 0;
            prefixPineapples[0] = 1;
        }
        else {
            prefixMangoes[0] = 1;
            prefixPineapples[0] = 0;
        }
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == 'P') {
                prefixPineapples[i] = prefixPineapples[i-1] + 1;
                prefixMangoes[i] = prefixMangoes[i-1];
            }
            else {
                prefixMangoes[i] = prefixMangoes[i-1] + 1;
                prefixPineapples[i] = prefixPineapples[i-1];
            }
        }

        int totalPineapples = prefixPineapples[n-1];
        int totalMangoes = prefixMangoes[n-1];

        for (int i = 0; i < n; i++) {
            if (prefixMangoes[i] != totalMangoes-prefixMangoes[i] && prefixPineapples[i] != totalPineapples-prefixPineapples[i]) {
                return i+1;
            }
        }
        return -1;
    }

    public static int getMedian(int[] ar1, int[] ar2, int n, int m) {
        if (m == 0 && n == 0)
            return 0;
        else if (m == 0 || n == 0) {
            return singleArrMedian(m == 0 ? ar2 : ar1);
        }

        int median_index = (m+n)/2;
        boolean is_even_length = (m+n)%2 == 0;

//        int curr_overall_index = 0;
        int head = ar1[0] < ar2[0] ? ar1[0] : ar2[0];
        int ar1_index = 0, ar2_index = 0, curr_overall_index = -1;
        while( (ar1_index < m || ar2_index < n)
                && curr_overall_index < median_index) {

            if(ar1_index < m
                    && ar2_index < n) {
                if (ar1[ar1_index] <= ar2[ar2_index]) {
                    head = ar1[ar1_index];
                    curr_overall_index++;

                    ar1_index++;
                } else {
                    head = ar2[ar2_index];
                    curr_overall_index++;

                    ar2_index++;
                }
            }
            else if (ar1_index < m) {
                head = ar1[ar1_index];
                curr_overall_index++;

                ar1_index++;
            } else {
                head = ar2[ar2_index];
                curr_overall_index++;

                ar2_index++;
            }

            System.out.println("Head: " + head + ", curr_overall_index: " + curr_overall_index + ", median_index: " + median_index + ", ar1_index: " + ar1_index + ", ar2_index: " + ar2_index);

        }

        if (is_even_length) {
            int next_median_element;
            if(ar1_index < m
                    && ar2_index < n) {

                if (ar1[ar1_index] <= ar2[ar2_index]) {
                    next_median_element = ar1[ar1_index];
                } else {
                    next_median_element = ar2[ar2_index];
                }

            } else if (ar1_index >= m) {
                next_median_element = ar2[ar2_index];
            } else {
                next_median_element = ar1[ar1_index];
            }

            return (head + next_median_element)/2;
        }

        return head;
    }

    private static int singleArrMedian(int[] ar) {
        int medianIndex = ar.length / 2;
        return ar.length % 2 == 0 ? (ar[medianIndex-1]+ar[medianIndex])/2 : ar[medianIndex-1];
    }
}
