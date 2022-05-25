package Algo;

/**
 * Given a file and assume that you can only read the file using a given method
 * read4, implement a method read to read n characters. Your method read may be
 * called multiple times.
 */

public class Solution158 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    int len = 0;
    int i = 0;
    char[] buf4;

    public int read(char[] buf, int n) {
        int count = 0;
        // System.out.println("len :"+len);
        // System.out.println("i: "+i);
        // System.out.println("arr: "+charArr2String(buf4));
        // System.out.println();

        while (i < len) {
            if (count == n) {
                return count;
            }
            buf[count] = buf4[i];
            i++;
            count++;
        }

        while (true) {
            buf4 = new char[4];
            len = read4(buf4);
            i = 0;
            while (i < len) {
                if (count == n) {
                    break;
                }
                buf[count] = buf4[i];
                i++;
                count++;
            }
            if (len < 4 || count == n) {
                break;
            }
        }
        return count;
    }

    public String charArr2String(char[] arr) {
        if (arr == null) {
            return "";
        }
        String s = "";
        for (char c : arr) {
            s+=c;
        }
        return s;
    }
}