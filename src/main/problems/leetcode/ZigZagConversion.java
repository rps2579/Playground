package main.problems.leetcode;

import java.util.Objects;

public class ZigZagConversion {

    public static void main(String[] args) {
        ZigZagConversion solution = new ZigZagConversion();
        String s = "";
        int numRows = 0;
        String ans = "";
        switch (2) {
            case 1:
                s = "PAYPALISHIRING";
                numRows = 3;
                ans = "PAHNAPLSIIGYIR";
                break;
            case 2:
                s = "PAYPALISHIRING";
                numRows = 4;
                ans = "PINALSIGYAHRPI";
                break;
        }
        
        System.out.println(
//                solution.convertSimpleSoln(s, numRows)
                Objects.equals(solution.convert(s, numRows), ans)
        );

    }

    public String convert(String s, int numRows) {
        if (s.length() == 1 || numRows == 1 || s.length() == numRows) return s;

        int row = 0, colIndex = 0, colAddCount = 2*numRows -2;
        StringBuilder sb = new StringBuilder();
        while (row < numRows) {
            colIndex = row;

            while (colIndex < s.length()) {
                sb.append(s.charAt(colIndex));
                int increment = (colAddCount-2*row);
                if (increment == 0) {
                    increment = 2*row;
                }
                colIndex += increment;
                if (increment < colAddCount && colIndex < s.length()) {
                    sb.append(s.charAt(colIndex));
                    colIndex += (colAddCount-increment);
                }
            }

            row++;
        }

        return sb.toString();
    }

    public String convertSimpleSoln(String s, int numRows) {
        int n = s.length();
        char[][] zigzag = new char[numRows][n];
        // Arrays.fill('');

        int index=0, row = 0, col = 0;
        while( index<n ) {
            if (row == 0 && (col%(numRows-1)) == 0) {
                while (row < numRows && index<n) {
                    zigzag[row++][col] = s.charAt(index++);
                }
                row = numRows-1;

                while (row > 1 && index<n) {
                    zigzag[--row][++col] = s.charAt(index++);
                }
                row = 0;
                col++;
            }
        }

        String ans = "";
        for (int i=0; i<numRows; i++) {
            for (int j=0; j<n; j++) {
                ans += zigzag[i][j];
            }
        }

        return ans;
    }
}