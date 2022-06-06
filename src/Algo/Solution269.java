package Algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * There is a new alien language that uses the English alphabet. However,
 * the order among the letters is unknown to you.
 * <p>
 * You are given a list of strings words from the alien language's
 * dictionary, where the strings in words are sorted lexicographically
 * by the rules of this new language.
 * <p>
 * Return a string of the unique letters in the new alien language sorted
 * in lexicographically increasing order by the new language's rules. If
 * there is no solution, return "". If there are multiple solutions, return
 * any of them.
 * <p>
 * A string s is lexicographically smaller than a string t if at the first
 * letter where they differ, the letter in s comes before the letter in t
 * in the alien language. If the first min(s.length, t.length) letters are
 * the same, then s is smaller if and only if s.length < t.length.
 */
public class Solution269 {

    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Map<Character, Set<Character>> adjMap = new HashMap<>();
        Map<Character, Integer> backCount = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                adjMap.put(c, new HashSet<>());
                backCount.put(c, 0);
            }
        }
        for (int i = 1; i < words.length; i++) {
            if (!checkOrder(words[i - 1], words[i], adjMap, backCount)) {
                return "";
            }
        }
        // start building order
        String order = "";
        Queue<Character> queue = new LinkedList<>();
        for (char c : adjMap.keySet()) {
            if (backCount.get(c) == 0) {
                queue.offer(c);
            }
        }
        while (!queue.isEmpty()) {
            char c = queue.poll();
            order += c;
            for (char adj : adjMap.get(c)) {
                backCount.put(adj, backCount.get(adj) - 1);
                if (backCount.get(adj) == 0) {
                    queue.offer(adj);
                }
            }
        }
        return order.length() == adjMap.size() ? order : "";
    }

    public boolean checkOrder(String a, String b, Map<Character,
        Set<Character>> adjMap, Map<Character, Integer> backCount) {

        int i = 0;
        while (i < a.length() && i < b.length() && a.charAt(i) == b.charAt(i)) {
            i++;
        }
        if (i == a.length()) {
            return true;
        }
        if (i == b.length()) {
            return false;
        }
        char front = a.charAt(i);
        char back = b.charAt(i);
        if (adjMap.get(back).contains(front)) {
            return false;
        }
        if (!adjMap.get(front).contains(back)) {
            adjMap.get(front).add(back);
            backCount.put(back, backCount.get(back) + 1);
        }
        return true;
    }

}
