package main.problems.heycoach.techniquesaga.bitmanipulation;

public class BitManipulationTechniques {
    public static void main(String[] args) {
        BitManipulationTechniques bmt = new BitManipulationTechniques();

        bmt.powerOf2(7);
        bmt.powerOf2(8);
    }

    private void commonlyUsedBasicManipulations(int n) {
        int leftMostSetBit = n & (n - 1);
        int rightMostSetBit = n ^ (n & (n-1));
        int rightMostSetBit2 = n & -n;
        int negativeN = ~n + 1;
    }

    private void powerOf2(int n) {
        boolean isPowerOfTwo;
        if(n<0) isPowerOfTwo = false;
//        else  n & (~(n & (n - 1)));

        // get left most bit
        int leftMostSetBit = n & (n - 1);

        // AND with left-most bit complement should give 0
//        boolean isPowerOfTwo = (n & ~leftMostSetBit) == 0;

//        System.out.println(n + " isPowerOfTwo - " + isPowerOfTwo);
    }
}
