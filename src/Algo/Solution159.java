package Algo;

public class Solution159 {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int currCnt = 0;
        int totalCnt = 0;
        char currChar = ',';
        char altChar = ',';
        int[] maxLen = new int[s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == currChar || currChar == ',') {
                currChar = c;
                currCnt ++;
                totalCnt ++;
            } else if (c == altChar || altChar == ',') {
                char temp = currChar;
                currChar = c;
                altChar = temp;
                currCnt = 1;
                totalCnt ++;
            } else {
                altChar = currChar;
                currChar = c;
                totalCnt = currCnt + 1;
                currCnt = 1;
            }
            maxLen[i] = totalCnt;
        }
        // find maximum in maxLen
        int max = 0;
        for (int num : maxLen) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
