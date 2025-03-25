package main.problems.leetcode;

public class SubSequenceCheck {
    public static void main(String[] args) {
        SubSequenceCheck s = new SubSequenceCheck();
        System.out.println(s.isSubsequence("abc", "aasdfbsdcf"));
    }
    public boolean isSubsequence(String s, String t) {
        int sIndex = 0, tIndex = 0;
        int sl = s.length(), tl = t.length();
        for (int i=0; i<=tl-sl; i++) {
            if (s.charAt(0)==t.charAt(i)) {
                tIndex = i;
                sIndex = 0;

                while (sl-sIndex > 0 && tl-tIndex > 0
                        && sl-sIndex <= tl-tIndex) {

                    if (s.charAt(sIndex) == t.charAt(tIndex)) {
                        sIndex++;
                    }
                    tIndex++;

                }

                if (sl == sIndex) return true;
            }
        }
        return false;
    }
}