package main.problems.hackerrank.interviewprepkit.stackandqueue;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        String invalidInput1 = "{[(])}";
        String invalidInput2 = "{[])}";
        String invalidInput3 = "{[(]}";
        String validInput = "{[]}";

        List<String> inputs = List.of(validInput, invalidInput1, invalidInput2, invalidInput3);
        for (String input: inputs)
            System.out.println(isBalancedUsingStackClass(input));
    }

    private static String isBalancedUsingStackClass(String input) {
        Map<Character, Character> properBracketPairs = new LinkedHashMap<>();
        properBracketPairs.put('{', '}');
        properBracketPairs.put('(', ')');
        properBracketPairs.put('[', ']');

        Stack<Character> stk = new Stack<>();
        stk.push(input.charAt(0));

        for (int i = 1; i < input.length(); i++) {
            if (properBracketPairs.containsKey(input.charAt(i))) {
                stk.push(input.charAt(i));
            } else if (properBracketPairs.get(stk.peek()) == input.charAt(i)) {
                stk.pop();
            }
            else {
                return "NO";
            }
        }

        return stk.empty() ? "YES" : "NO";
    }

    private static String isBalancedUsingBasicArray(String s) {
        int lengthOfString = s.length();
        char[] stackOfChars = new char[(lengthOfString+1)/2];
        Map<Character, Character> properBracketPairs = new LinkedHashMap<>();
        properBracketPairs.put('{', '}');
        properBracketPairs.put('(', ')');
        properBracketPairs.put('[', ']');

        if (properBracketPairs.containsValue(s.charAt(0)))
            return "NO";

        int currStackIndex = 0;
        stackOfChars[0] = s.charAt(0);
        try {
            for (int i = 1; i < lengthOfString; i++) {
                char currChar = s.charAt(i);

                // Opening Bracket => Add to stack
                if (properBracketPairs.containsKey(currChar)) {
                    currStackIndex += 1;
                    stackOfChars[currStackIndex] = currChar;
                }
                // Closing Bracket => MUST be matching closing
                else if (properBracketPairs.getOrDefault(stackOfChars[currStackIndex], ' ') == currChar) {
                    currStackIndex -= 1;
                }
                else {
                    return "NO";
                }
            }
        }
        catch (Exception e) {
            return "NO";
        }

        if (currStackIndex == -1)
            return "YES";

        return "NO";
    }
}
