package Algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Design an algorithm to encode a list of strings to a string. The
 * encoded string is then sent over the network and is decoded back
 * to the original list of strings.
 */
public class Solution271 {

    public static void main(String[] args) {
        Codec codec = new Codec();
        String encoding = codec.encode(Arrays.asList("apple", "banana", "caonima"));
        System.out.println(encoding);
        System.out.println(codec.decode(encoding));
    }

    public static class Codec {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            for (String str : strs) {
                sb.append(intToString(str.length())).append(str);
            }
            return sb.toString();
        }

        public String intToString(int num) {
            StringBuilder sb = new StringBuilder();
            for (int i = 3; i >= 0; i--) {
                sb.append((char) ((num >> (i * 8)) % 256));
            }
            return sb.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> res = new ArrayList<>();
            int idx = 0;
            while (idx < s.length()) {
                int len = stringToInt(s.substring(idx, idx + 4));
                res.add(s.substring(idx + 4, idx + 4 + len));
                idx += 4 + len;
            }
            return res;
        }

        public int stringToInt(String s) {
            int len = 0;
            for (int i = 0; i < 4; i++) {
                len += (s.charAt(i) << ((3-i) * 8));
            }
            return len;
        }
    }
}
