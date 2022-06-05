package Algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string s, return all the palindromic permutations (without
 * duplicates) of it.
 *
 * You may return the answer in any order. If s has no palindromic
 * permutation, return an empty list.
 */
public class Solution267 {

    public List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() == 0) return result;
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        String word = "";
        boolean foundOdd = false;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                if (foundOdd) return result;
                foundOdd = true;
                word += (char) ('a' + i);
                count[i]--;
            }
        }
        generatePalindromesHelper(word, count, result);
        return result;
    }

    public void generatePalindromesHelper(String s,
                                          int[] count, List<String> result) {
        if (Arrays.stream(count).sum() == 0) {
            result.add(s);
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                count[i]-=2;
                generatePalindromesHelper((char) ('a' + i) + s + (char) ('a' + i),
                    count, result);
                count[i]+=2;
            }
        }
    }

}
