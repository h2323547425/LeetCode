package Algo;

import java.util.List;

/**
 * Given two vectors of integers v1 and v2, implement an iterator
 * to return their elements alternately.
 *
 * Implement the ZigzagIterator class:
 *
 * ZigzagIterator(List<int> v1, List<int> v2) initializes the object
 * with the two vectors v1 and v2.
 *
 * boolean hasNext() returns true if the iterator still has elements,
 * and false otherwise.
 *
 * int next() returns the current element of the iterator and moves
 * the iterator to the next element.
 */
public class Solution281 {

    /**
     * Your ZigzagIterator object will be instantiated and called as such:
     * ZigzagIterator i = new ZigzagIterator(v1, v2);
     * while (i.hasNext()) v[f()] = i.next();
     */
    public static class ZigzagIterator {
        List<Integer>[] vectors;
        int[] indices;
        int vec_ptr;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            this.vectors = new List[] { v1, v2 };
            this.indices = new int[] { 0, 0 };
        }

        public int next() {
            if (hasNext()) {
                if (this.indices[this.vec_ptr]
                    >= this.vectors[this.vec_ptr].size()) {
                    this.vec_ptr = 1 - this.vec_ptr;
                }
                int ret = this.vectors[this.vec_ptr]
                    .get(this.indices[this.vec_ptr]);
                this.indices[this.vec_ptr]++;
                this.vec_ptr = 1 - this.vec_ptr;
                return ret;
            }
            return -1;
        }

        public boolean hasNext() {
            return this.indices[0] < this.vectors[0].size()
                || this.indices[1] < this.vectors[1].size();
        }
    }

}
