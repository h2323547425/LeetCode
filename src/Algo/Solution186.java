package Algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a character array s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s
 * will be separated by a single space.
 *
 * Your code must solve the problem in-place, i.e. without allocating extra space
 */
public class Solution186 {

    public void reverseWords(char[] s) {
        // first reverse the whole string
        reverseRange(s, 0, s.length - 1);

        // then reverse each word
        int start = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverseRange(s, start, i - 1);
                start = i + 1;
            }
        }
        reverseRange(s, start, s.length - 1);
    }

    public void reverseRange(char[] s, int start, int end) {
        while(start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

}
