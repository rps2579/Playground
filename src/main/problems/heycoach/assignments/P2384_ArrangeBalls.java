package main.problems.heycoach.assignments;

public class P2384_ArrangeBalls {

    public static void main(String[] args) {
        char[] input = {'s','g','w'};
        System.out.println(arrange(input.length, input));
    }

    private static String arrange(int n, char[] inputArr) {
        String order = "swg";


        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n-i; j++) {
                if (order.indexOf(inputArr[j - 1]) > order.indexOf(inputArr[j])) {
                    char temp = inputArr[j];
                    inputArr[j] = inputArr[j-1];
                    inputArr[j-1] = temp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(inputArr[i]);
        }
        return String.valueOf(inputArr);
    }
}
