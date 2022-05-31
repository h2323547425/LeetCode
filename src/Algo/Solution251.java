package Algo;

/**
 * Design an iterator to flatten a 2D vector. It should support the
 * next and hasNext operations.
 *
 * Implement the Vector2D class:
 *
 * Vector2D(int[][] vec) initializes the object with the 2D vector vec.
 *
 * next() returns the next element from the 2D vector and moves the pointer
 * one step forward. You may assume that all the calls to next are valid.
 *
 * hasNext() returns true if there are still some elements in the vector,
 * and false otherwise.
 */
public class Solution251 {

    public class Vector2D {
        int col_ptr;
        int row_ptr;
        int[][] vec;

        public Vector2D(int[][] vec) {
            this.vec = vec;
            this.col_ptr = 0;
            this.row_ptr = 0;
        }

        public int next() {
            int ret = -1;
            if (this.hasNext()) {
                ret = this.vec[this.row_ptr][this.col_ptr];
            }
            this.col_ptr++;
            return ret;
        }

        public boolean hasNext() {
            if (this.row_ptr >= this.vec.length) {
                return false;
            }
            while (this.col_ptr >= this.vec[this.row_ptr].length) {
                if (this.row_ptr == this.vec.length - 1) {
                    return false;
                }
                this.col_ptr = 0;
                this.row_ptr++;
            }
            return true;
        }
    }
}
