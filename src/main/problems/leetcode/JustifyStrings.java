package main.problems.leetcode;

import java.util.ArrayList;
import java.util.List;

public class JustifyStrings {

    public static void main(String[] args) {
        JustifyStrings instance = new JustifyStrings();

        String[] words;
        int maxWidth;

        switch (3) {
            case 1:
                words = new String[]{"the", "is", "a", "love", "to", "be", "the", "love"};
                maxWidth = 10;
                break;
            case 2:
                words = new String[]{"What","must","be","acknowledgment","shall","be"};
                maxWidth = 16;
                break;
            case 3:
                words = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
                maxWidth = 20;
                break;
            default:
                words = new String[]{"the", "is", "a", "love"};
                maxWidth = 10;
        }

        List<String> ans = instance.fullJustify(words, maxWidth);
        for (String s : ans) { System.out.println(s); }
    }

    public List<String> fullJustify(String[] words, int maxWidth) {

        if (words.length == 1) return List.of(words[1]);

        List<String> ans = new ArrayList<>();


        int index = 0;
        while (index < words.length) {
            int lineStartIndex = index;
            String currLine = "";
            int currLineLength = 0;

            while (index < words.length &&
                    currLineLength + words[index].length() <= maxWidth) {

                currLineLength = currLineLength + words[index].length();
                index++;

                if (currLineLength == maxWidth) break;
                if (index == words.length) break;
                if (currLineLength+1+words[index].length() > maxWidth) break;
                // increase for space
                currLineLength++;
            }

            int extraSpaces = maxWidth - currLineLength;
            if (index == words.length) {
                for (int i=lineStartIndex; i<index; i++) {
                    currLine += words[i];
                    if (i == index-1) break;
                    currLine += " ";
                }
                for (int i=0; i< extraSpaces; i++)
                    currLine += " ";
                ans.add(currLine);
                break;
            }

            if (index-lineStartIndex == 1) {
                currLine += words[lineStartIndex];

                for (int i=0; i< extraSpaces; i++)
                    currLine += " ";

                ans.add(currLine);
                continue;
            }

            int evenSpaces = 1 + (extraSpaces/(index-lineStartIndex-1));
            extraSpaces %= (index-lineStartIndex-1);
            String spaceChars = "";
            for (int i=0; i< evenSpaces; i++)
                spaceChars += " ";

            for (int i=lineStartIndex; i<index; i++) {
                currLine += words[i];

                if (i == index-1) break;

                currLine += spaceChars;
                if (extraSpaces > 0) {
                    currLine += " ";
                    extraSpaces--;
                }
            }

            ans.add(currLine);
        }

        return ans;
    }
}
