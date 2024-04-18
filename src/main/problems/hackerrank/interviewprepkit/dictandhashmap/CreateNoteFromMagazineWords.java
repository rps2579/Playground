package main.problems.hackerrank.interviewprepkit.dictandhashmap;

import java.util.*;
import java.util.stream.Collectors;

public class CreateNoteFromMagazineWords {
    public static void main(String[] args) {
        String easy1 = "give me one give grand today night";
        String easy2 = "give one grand today";
        List<String> magazine = Arrays.stream(easy1.split(" ")).collect(Collectors.toList());
        List<String> note = Arrays.stream(easy2.split(" ")).collect(Collectors.toList());

        System.out.println(checkMagazine(magazine, note));
    }

    public static String checkMagazine(List<String> magazine, List<String> note) {
        Map<String, Integer> magazineWordAvailability = new HashMap<>();
        for (String currWord: magazine) {
            magazineWordAvailability.put(currWord, magazineWordAvailability.getOrDefault(currWord, 0)+1);
        }

        for (String currWord: note) {
            System.out.println(magazineWordAvailability.get(currWord));
            Integer currWordCount = magazineWordAvailability.getOrDefault(currWord, -1);
            if (currWordCount == -1 || currWordCount == 0)
                return "No";
            else
                magazineWordAvailability.put(currWord, currWordCount-1);
            System.out.println(magazineWordAvailability.get(currWord));
        }

        return "Yes";
    }
}
