package Algo;

/**
 * Given a string s, return true if a permutation of the string could form a palindrome.
 */
public class Solution266 {

    public boolean canPermutePalindrome(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        boolean foundOdd = false;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                if (foundOdd) return false;
                foundOdd = true;
            }
        }
        return true;
    }

}
