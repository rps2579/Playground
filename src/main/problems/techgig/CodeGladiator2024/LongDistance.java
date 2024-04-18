package main.problems.techgig.CodeGladiator2024;

import java.util.Scanner;

public class LongDistance {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int noOfTestCases = sc.nextInt();

        for (int i = 0; i < noOfTestCases; i++) {
            int distToBeCoveredByPaul = sc.nextInt();
            int speedOfPaul = sc.nextInt();
            int puncturesOfPaul = sc.nextInt();

            int distToBeCoveredByNina = sc.nextInt();
            int speedOfNina = sc.nextInt();
            int puncturesOfNina = sc.nextInt();

            long timeTakenByPaul = distToBeCoveredByPaul/speedOfPaul + puncturesOfPaul;
            long timeTakenByNina = distToBeCoveredByNina/speedOfNina + puncturesOfNina;

            if (timeTakenByPaul < timeTakenByNina)
                System.out.println("PAUL\n" + timeTakenByPaul);
            else if (timeTakenByPaul == timeTakenByNina)
                System.out.println("BOTH\n" + timeTakenByPaul);
            else
                System.out.println("NINA\n" + timeTakenByNina);
        }

        sc.close();
    }
}
