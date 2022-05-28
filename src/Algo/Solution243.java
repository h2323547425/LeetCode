package Algo;

/**
 * Given an array of strings wordsDict and two different strings that
 * already exist in the array word1 and word2, return the shortest
 * distance between these two words in the list.
 */
public class Solution243 {

    public int shortestDistance(String[] wordsDict,
                                String word1, String word2) {
        int minDist = Integer.MAX_VALUE;
        int lastWord1 = -1;
        int lastWord2 = -1;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                lastWord1 = i;
                if (lastWord2 != -1) {
                    minDist = Math.min(minDist, lastWord1 - lastWord2);
                }
            } else if (wordsDict[i].equals(word2)) {
                lastWord2 = i;
                if (lastWord1 != -1) {
                    minDist = Math.min(minDist, lastWord2 - lastWord1);
                }
            }
        }
        return minDist;
    }

}
