package Algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * We can shift a string by shifting each of its letters to its successive letter.
 *
 * For example, "abc" can be shifted to be "bcd".
 * We can keep shifting the string to form a sequence.
 *
 * For example, we can keep shifting "abc" to form the sequence:
 * "abc" -> "bcd" -> ... -> "xyz".
 *
 * Given an array of strings strings, group all strings[i] that belong to the
 * same shifting sequence. You may return the answer in any order.
 */
public class Solution249 {
    public Map<String, Integer> pattern2Index;

    public List<List<String>> groupStrings(String[] strings) {
        this.pattern2Index = new HashMap<>();
        List<List<String>> groups = new ArrayList<>();
        for (String s : strings) {
            String pattern = getPattern(s);
            if (!this.pattern2Index.containsKey(pattern)) {
                this.pattern2Index.put(pattern, groups.size());
                List<String> group = new ArrayList<>();
                group.add(s);
                groups.add(group);
            } else {
                groups.get(this.pattern2Index.get(pattern)).add(s);
            }
        }
        return groups;
    }

    public String getPattern(String s) {
        if (s.length() == 0) {
            return "";
        }
        char base = s.charAt(0);
        String pattern = "a";
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            int diff = c - base;
            if (diff < 0) {
                diff += 26;
            }
            pattern += (char) (diff + 'a');
        }
        return pattern;
    }
}
