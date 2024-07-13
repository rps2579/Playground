package main.problems.heycoach.assignments;

public class P2385_MaximumStones {
    public static void main(String[] args) {
        int[] stones = {2,4,9,8,11,2};
        System.out.println(maximumStones(stones));
    }

    private static int maximumStones(int[] stones) {
        int n = stones.length;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n-i; j++) {
                if (stones[j - 1] > stones[j]) {
                    int temp = stones[j];
                    stones[j] = stones[j-1];
                    stones[j-1] = temp;
                }
            }
        }

        int ans = 0;
        for (int i = n/3; i < n; i+=2) {
            ans += stones[i];
        }

        return ans;
    }
}
