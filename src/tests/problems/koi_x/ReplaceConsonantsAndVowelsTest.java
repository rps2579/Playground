package tests.problems.koi_x;

import main.problems.koi_x.ReplaceConsonantsAndVowels;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReplaceConsonantsAndVowelsTest {

    ReplaceConsonantsAndVowels replacer = new ReplaceConsonantsAndVowels();

    @Test
    void replaceCharacters1() {
        replacer.setInputString("abcde");

        replacer.replaceCharacters();

        Assertions.assertEquals("babca", replacer.getReplacedString());
    }

    @Test
    void replaceCharacters3() {
        replacer.setInputString("This is my 10th board exam.");

        replacer.replaceCharacters();

        Assertions.assertEquals(".Tsi si  m 100t  arar xema.", replacer.getReplacedString());
    }
}