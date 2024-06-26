package main.problems.heycoach.assignments;

public class P2388_BubbleSort {

    public static void main(String[] args) {
        System.out.println(findWinner(new int[]{7, 2, 8, 9, 5}, new int[]{4, 6, 2, 5, 3}));
    }

    public static String findWinner(int[] Anish, int[] Binish) {
        int swapsOfAnish = calculateSwapsInBubbleSort(Anish);
        System.out.println("swapsOfAnish: " + swapsOfAnish);
        int swapsOfBinish = calculateSwapsInBubbleSort(Binish);
        System.out.println("swapsOfBinish: " + swapsOfBinish);

        int difference = swapsOfAnish - swapsOfBinish;
        return difference < 0 ? "Anish" : difference==0 ? "Tie" : "Binish";
    }

    private static int calculateSwapsInBubbleSort(int[] arr) {
        int swaps = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-(i+1); j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    swaps++;
                    System.out.print("i: " + i + ",j: " + j + ", arr: ");
                    printArr(arr);
                }
            }
        }
        return swaps;
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
