package main.problems.hackerrank.interviewprepkit.dictandhashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * link - [https://www.hackerrank.com/challenges/two-strings/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps]
 */
public class TwoStrings {
    public static void main(String[] args) {
        String s1 = "cat";
        String s2 = "";
        System.out.println(twoStrings(s1, s2));
    }

    public static String twoStrings(String s1, String s2) {
        Set<Character> avblCharsInS1 = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            avblCharsInS1.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            if (avblCharsInS1.contains(s2.charAt(i)))
                return "YES";
        }
        return "NO";
    }
}
