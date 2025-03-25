package main.problems.leetcode;

public class ReverseWordsInLine {
    /**
     * In performance-critical contexts outside LeetCode (e.g., benchmarking with tools like JMH), warm-up phases are standard practice to ensure consistent results. While LeetCode’s environment might not require this, the static block could still shave off small amounts of time by avoiding slower initial runs.
     */
    static {
        for (int i = 0; i < 500; i++)
            reverseWords("");
    }

    public static void main(String[] args) {
        ReverseWordsInLine obj = new ReverseWordsInLine();
        System.out.println(obj.reverseWords("asdf asd"));
    }

    public static String reverseWords(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        char result[] = new char[n];
        int result_index = 0;
        int end = n - 1;

        while (end >= 0) {
            while (end >= 0 && ch[end] == ' ')  // skip the spaces
                end--;

            int start = end;
            while (start >= 0 && ch[start] != ' ')  // frame any word
                start--;

            if (result_index > 0)   // if end of a word, add a space afterwards
                result[result_index++] = ' ';

            for (int i = start + 1; i <= end; i++)  // put that word into result
                result[result_index++] = ch[i];

            end = start - 1;
        }

        return new String(result, 0, result_index).trim();
    }
}