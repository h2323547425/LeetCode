package Algo;

/**
 * Given two strings s and t, return true if they are both one edit distance apart,
 * otherwise return false.
 *
 * A string s is said to be one distance apart from a string t if you can:
 *  Insert exactly one character into s to get t.
 *  Delete exactly one character from s to get t.
 *  Replace exactly one character of s with a different character to get t.
 */
public class Solution161 {
    public boolean isOneEditDistance(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen == tLen) {
            int i = 0;
            while (i < sLen) {
                if (s.charAt(i) != t.charAt(i)) {
                    return s.substring(i+1).equals(t.substring(i+1));
                }
                i++;
            }
            return false;
        } else if (sLen == tLen - 1) {
            int i = 0;
            while (i < sLen) {
                if (s.charAt(i) != t.charAt(i)) {
                    return s.substring(i).equals(t.substring(i+1));
                }
                i++;
            }
            return true;
        } else if (tLen == sLen - 1) {
            int i = 0;
            while (i < tLen) {
                if (s.charAt(i) != t.charAt(i)) {
                    return s.substring(i+1).equals(t.substring(i));
                }
                i++;
            }
            return true;
        }
        return false;
    }
}
