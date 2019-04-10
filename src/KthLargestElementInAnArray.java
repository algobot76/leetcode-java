import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {
    // Sort
//    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length-k];
//    }

    // Heap
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.poll();
    }
}
