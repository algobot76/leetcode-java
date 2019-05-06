package com.algobot76.leetcode._42;

/**
 * Two Pointers
 */
public class Solution1 {
    public int trap(int[] height) {
        int ans = 0;
        if (height.length == 0) {
            return ans;
        }
        int left = 0;
        int right = height.length - 1;
        int leftHeight = height[left];
        int rightHeight = height[right];

        while (left < right) {
            if (leftHeight < rightHeight) {
                left++;
                if (leftHeight > height[left]) {
                    ans += (leftHeight - height[left]);
                } else {
                    leftHeight = height[left];
                }
            } else {
                right--;
                if (rightHeight > height[right]) {
                    ans += (rightHeight - height[right]);
                } else {
                    rightHeight = height[right];
                }
            }
        }

        return ans;
    }
}
