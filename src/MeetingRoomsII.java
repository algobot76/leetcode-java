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
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> allocator = new PriorityQueue<>(intervals.length, Comparator.comparingInt(a -> a));
        Arrays.sort(intervals, Comparator.comparingInt(l -> l.start));
        allocator.add(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= allocator.peek()) {
                allocator.poll();
            }
            allocator.add(intervals[i].end);
        }

        return allocator.size();
    }
}
