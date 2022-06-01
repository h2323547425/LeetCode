package Algo;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals intervals where intervals[i] =
 * [starti, endi], return the minimum number of conference rooms required.
 */
public class Solution253 {

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 0;
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (!rooms.isEmpty() && rooms.peek() <= interval[0]) {
                rooms.poll();
            }
            rooms.offer(interval[1]);
            count = Math.max(count, rooms.size());
        }
        return count;
    }

}
