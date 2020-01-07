package org.leetcode.t4;

public class MidNumber {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        for (int firstNum : nums1) {

            RestCount firstRestCount = binaryInsert(nums1, firstNum, 0, nums1.length);
            RestCount secondRestCount = binaryInsert(nums2, firstNum, 0, nums2.length);

            int leftCount = firstRestCount.getLeftCount() + secondRestCount.getLeftCount();
            int rightCount = firstRestCount.getRightCount() + secondRestCount.getRightCount();

            if(leftCount == rightCount) {
                return firstNum;
            } else if(leftCount - rightCount == 1) {
                int leftNum = Math.max(nums1[firstRestCount.getLeftIndex()], nums2[secondRestCount.getLeftIndex()]);
                //如果左边的数多一个，就要往前推一位
                return (double) (leftNum + firstNum) / 2;
            } else if(leftCount - rightCount == -1) {
                //如果右边多一个，就要往后推一下
                int rightNum = Math.min(nums1[firstRestCount.getRightIndex()], nums2[secondRestCount.getRightIndex()]);
                return (double) (rightNum + firstNum) / 2;
            }
        }

        for (int secondNum : nums2) {
            RestCount firstRestCount = binaryInsert(nums1, secondNum, 0, nums1.length);
            RestCount secondRestCount = binaryInsert(nums2, secondNum, 0, nums2.length);

            int leftCount = firstRestCount.getLeftCount() + secondRestCount.getLeftCount();
            int rightCount = firstRestCount.getRightCount() + secondRestCount.getRightCount();

            if(leftCount == rightCount) {
                return secondNum;
            } else if(leftCount - rightCount == 1) {
                int leftNum = Math.max(nums1[firstRestCount.getLeftIndex()], nums2[secondRestCount.getLeftIndex()]);
                //如果左边的数多一个，就要往前推一位
                return (double) (leftNum + secondNum) / 2;
            } else if(leftCount - rightCount == -1) {
                //如果右边多一个，就要往后推一下
                int rightNum = Math.min(nums1[firstRestCount.getRightIndex()], nums2[secondRestCount.getRightIndex()]);
                return (double) (rightNum + secondNum) / 2;
            }
        }
        return -1;
    }


    /**
     * 找到num在nums数组中的位置。
     * @param nums 数组
     * @param num 数字
     * @param high 高位
     * @param low 低位
     * @return 返回左边和右边剩余的, 不包含相等的数字。
     */
    public RestCount binaryInsert(int[] nums, int num, int low, int high) {
        double mid = (double) (high + low) / 2;
        int midRight = (int) Math.ceil(mid);
        int midLeft = (int) Math.floor(mid);

        if(num <= nums[0]) {
            return new RestCount(0, num == nums[0] ? nums.length - 1 : nums.length, 0, 0);
        }
        if(num >= nums[nums.length - 1]) {
            return new RestCount(num == nums[nums.length - 1] ? nums.length - 1 : nums.length, 0, nums.length - 1, nums.length - 1);
        }
        //程序出口
        if(nums[midLeft] <= num && nums[midRight] >= num) {
            return new RestCount(
                    num == nums[midLeft] ? midLeft : midLeft + 1,
                    num == nums[midRight] ? nums.length - 1 - midRight : nums.length - midRight,
                    midRight, midLeft);
        } else if(num < nums[midLeft]) {
            return binaryInsert(nums, num, 0, midRight);
        } else {
            return binaryInsert(nums, num, midRight, nums.length - 1);
        }
    }


    private static class RestCount {
        //左边剩余的个数
        private int leftCount;

        //右边剩余的个数
        private int rightCount;

        //左边的index
        private int leftIndex;

        //右边的index
        private int rightIndex;

        public RestCount(int leftCount, int rightCount, int leftIndex, int rightIndex) {
            this.leftCount = leftCount;
            this.rightCount = rightCount;
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
        }

        public int getLeftCount() {
            return leftCount;
        }

        public void setLeftCount(int leftCount) {
            this.leftCount = leftCount;
        }

        public int getRightCount() {
            return rightCount;
        }

        public void setRightCount(int rightCount) {
            this.rightCount = rightCount;
        }

        public int getLeftIndex() {
            return leftIndex;
        }

        public void setLeftIndex(int leftIndex) {
            this.leftIndex = leftIndex;
        }

        public int getRightIndex() {
            return rightIndex;
        }

        public void setRightIndex(int rightIndex) {
            this.rightIndex = rightIndex;
        }

        @Override
        public String toString() {
            return "RestCount{" +
                    "leftCount=" + leftCount +
                    ", rightCount=" + rightCount +
                    ", leftIndex=" + leftIndex +
                    ", rightIndex=" + rightIndex +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 9, 15, 17, 18};
        int[] nums2 = {1, 9};
        int num2 = 9;
        int num3 = 6;

        int num4 = 5;

        //System.out.println(new MidNumber().binaryInsert(nums, num2, 0, nums.length - 1));
        //System.out.println(new MidNumber().binaryInsert(nums, num3, 0, nums.length - 1));
        //System.out.println(new MidNumber().binaryInsert(nums2, num4, 0, nums2.length - 1));
        //System.out.println(new MidNumber().binaryInsert(nums, 0, 0, nums.length - 1));
        //System.out.println(new MidNumber().binaryInsert(nums, 1, 0, nums.length - 1));
        //System.out.println(new MidNumber().binaryInsert(nums, num4, 0, nums.length - 1));

        int[] testNums1 = {1, 2};
        int[] testNums2 = {3, 4};
        System.out.println(new MidNumber().findMedianSortedArrays(testNums1, testNums2));

    }
}
