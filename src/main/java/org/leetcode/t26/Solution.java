package org.leetcode.t26;

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int p = 0;
        int q = 0;

        while (q < nums.length) {
            if(nums[p] == nums[q]) {
                q ++;
            } else {
                p ++;
                nums[p] = nums[q];
            }
        }

        return p + 1;
    }
}