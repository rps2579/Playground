package main.problems.hackerrank.interviewprepkit.dictandhashmap;

import java.util.*;

public class SubStringAnagramPairsInString {

    public static void main(String[] args) {
        String s = "mom";
        System.out.println(sherlockAndAnagrams(s));
    }

    private static int anagramPairsInStringCount(String s) {
        int answer = 0;

        Map<String, Integer> hash = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length() + 1; j++) {
                char[] currSubstrCharArray = s.substring(i, j).toCharArray();
                Arrays.sort(currSubstrCharArray);
                String sortedCurrSubString = String.valueOf(currSubstrCharArray);

                hash.put(sortedCurrSubString, hash.getOrDefault(sortedCurrSubString,0)+1);
            }
        }

        for (Map.Entry<String, Integer> currEntry: hash.entrySet()) {
            int n = currEntry.getValue();
            answer += (n*(n-1))/2;
        }

        return answer;
    }

    public static int sherlockAndAnagrams(String s) {
        class CharFreq {
            char c;
            int count;

            public CharFreq(char c, int currCharCount) {
                this.c = c;
                count = currCharCount;
            }
        }

        class charSplit {
        }

        List<CharFreq> charFreqList = new ArrayList<>();

        int currCharCount = 1;
        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i-1) == s.charAt(i))
                currCharCount += 1;
            else {
                charFreqList.add(new CharFreq(s.charAt(i-1), currCharCount));
                currCharCount = 1;
            }
        }
        charFreqList.add(new CharFreq(s.charAt(s.length()-1), currCharCount));

        /**
         * if n substrings of same len -> no of pairs = (n*(n-1))/2
         *
         * no. of substr of len 1 = n1 + n2 +...
         *                  len 2 = n1-1 + n2-1 +...
         *                  len 3 = n1-2 + n2-2 +...
         *                  len n1 = n1-n1+1 +...
         */
        for (int lengthOfSubStr = 1; lengthOfSubStr < s.length(); lengthOfSubStr++) {

        }

        return 0;
    }
}
