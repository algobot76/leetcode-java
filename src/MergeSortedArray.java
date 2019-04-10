import java.util.Arrays;

/**
 * 88. Merge Sorted Array
 *
 * @author Kaitian Xie
 */
public class MergeSortedArray {
    // Naive Approach
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        System.arraycopy(nums2, 0, nums1, m, n);
//        Arrays.sort(nums1);
//    }

    // Two Pointers
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = new int[m];
        System.arraycopy(nums1, 0, nums1Copy, 0, m);

        int ptr = 0;
        int ptr1 = 0;
        int ptr2 = 0;

        while ((ptr1 < m) && (ptr2 < n)) {
            nums1[ptr++] = (nums1Copy[ptr1] < nums2[ptr2]) ? nums1Copy[ptr1++] : nums2[ptr2++];
        }

        if (ptr1 < m) {
            System.arraycopy(nums1Copy, ptr1, nums1, ptr1 + ptr2, m + n - ptr1 - ptr2);
        }
        if (ptr2 < n) {
            System.arraycopy(nums2, ptr2, nums1, ptr1 + ptr2, m + n - ptr1 - ptr2);
        }
    }
}
