package main.problems.heycoach.assignments;

public class P2386_WaveSort {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        waveSort(arr.length, arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static int[] waveSort(int n, int[] arr) {

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n-i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }

        for (int i = 1; i < n; i+=2) {
            int temp = arr[i];
            arr[i] = arr[i-1];
            arr[i-1] = temp;
        }

        return arr;
    }
}
