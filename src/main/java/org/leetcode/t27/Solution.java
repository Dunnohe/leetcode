package org.leetcode.t27;

class Solution {

    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int p = 0;
        int q = 0;

        while (q < nums.length) {
            if(nums[q] != val) {
                nums[p] = nums[q];
                p ++;
            }
            q ++;
        }

        return p;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        System.out.println(new Solution().removeElement(nums, 3));
    }
}