package main.problems.techgig;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReconstructingArraysSemiProb2 {
    public static void main(String args[] ) throws Exception {
        // take string input without using Scanner
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String line = br.readLine();
         int N = Integer.parseInt(line);
         System.out.println(N);
         // Scanner
         Scanner s = new Scanner(System.in);
         int i = s.nextInt();
         System.out.println(i);
         System.out.println("Hello World!");

    }
}
