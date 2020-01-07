package org.leetcode.t1;

public class Sum {

    public int[] twoSum(int[] nums, int target) {

        for (int firstIndex = 0; firstIndex < nums.length; firstIndex++) {
            int curr = nums[firstIndex];
            int other = target - curr;
            for (int secondIndex = 0; secondIndex < nums.length; secondIndex++) {
                if (firstIndex == secondIndex) {
                    continue;
                }
                if(nums[secondIndex] == other) {
                    return new int[]{firstIndex, secondIndex};
                }
            }
        }

        throw new RuntimeException("can't found");
    }
}
