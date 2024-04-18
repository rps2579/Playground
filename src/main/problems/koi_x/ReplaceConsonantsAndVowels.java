package main.problems.koi_x;

import java.util.*;

public class ReplaceConsonantsAndVowels {

    private String inputString;
    private String replacedString;

    public static void main(String[] args) {
        ReplaceConsonantsAndVowels obj = new ReplaceConsonantsAndVowels();

        obj.setInputString("This is my 10th board exam.");

        obj.replaceCharacters();

        System.out.println("Input : " + obj.inputString);
        System.out.println("Answer: " + obj.replacedString);
    }

    public void replaceCharacters() {
        char[] replacedCharSequence = inputString.toCharArray();

        for (int i = 0; i < inputString.length(); i++) {
            replaceCharacterAtIndex(replacedCharSequence, i);
        }

        replacedString = new String(replacedCharSequence);
    }

    private void replaceCharacterAtIndex(char[] replacedCharSequence, int index) {
        Character currChar = inputString.charAt(index);

        if (Character.isAlphabetic(currChar)) {
            int replacementCharIndex;

            if (isVowel(currChar)) {
                replacementCharIndex = (index + 1 != inputString.length()) ? index + 1 : 0;
            }
            else {
                replacementCharIndex = (index == 0) ? inputString.length() - 1 : index - 1;
            }

            replacedCharSequence[index] = inputString.charAt(replacementCharIndex);
        }
    }

    private boolean isVowel(Character currChar) {
        String vowels = "AEIOUaeiou";

        return vowels.indexOf(currChar) != -1;
    }

    public String getReplacedString() {
        return replacedString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }
}
