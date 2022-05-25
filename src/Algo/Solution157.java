package Algo;

/**
 * Given a file and assume that you can only read the file using a given method
 * read4, implement a method to read n characters.
 */
public class Solution157 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int count = 0;
        char[] buf4 = new char[4];
        while (true) {
            int len = read4(buf4);
            int i = 0;
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
}
