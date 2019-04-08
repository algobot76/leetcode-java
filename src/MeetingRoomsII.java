import util.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 253. Meeting Rooms II
 *
 * @author Kaitian Xie
 */
public class MeetingRoomsII {
    // Priority Queue
//    public int minMeetingRooms(Interval[] intervals) {
//        if (intervals.length == 0) {
//            return 0;
//        }
//
//        PriorityQueue<Integer> allocator = new PriorityQueue<>(intervals.length, Comparator.comparingInt(a -> a));
//        Arrays.sort(intervals, Comparator.comparingInt(l -> l.start));
//        allocator.add(intervals[0].end);
//        for (int i = 1; i < intervals.length; i++) {
//            if (intervals[i].start >= allocator.peek()) {
//                allocator.poll();
//            }
//            allocator.add(intervals[i].end);
//        }
//
//        return allocator.size();
//    }

    // Chronological Ordering
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }

        Arrays.sort(start, Comparator.comparingInt(a -> a));
        Arrays.sort(end, Comparator.comparingInt(a -> a));

        int startPtr = 0;
        int endPtr = 0;
        int rooms = 0;

        while (startPtr < intervals.length) {
            if (start[startPtr] >= end[endPtr]) {
                rooms -= 1;
                endPtr += 1;
            }
            rooms += 1;
            startPtr += 1;
        }

        return rooms;
    }
}
