package org.leetcode.t3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RepeatString {

    /**
     * 算法描述：滑动窗口
     * 开始指针start指向s的第一位，当前指针curr从start然后不断往下一位移，当start到curr有重复子串时，记录这个长度。
     * 然后start后移，重置curr，重复这个过程。
     * @param s 字符串
     * @return 最大子串
     */
    public int lengthOfLongestSubstring(String s) {

        Set<Character> temp = new HashSet<Character>(s.length());
        //开始指针
        int start = 0;
        //结束指针
        int curr = 0;
        //最大子串长度
        int maxSubStringLength = 0;
        int tempLength = 0;
        while (start < s.length() && curr < s.length()) {
            char currChar = s.charAt(curr);
            if(temp.contains(s.charAt(curr))) {
                //start后移
                start ++;
                //重置当前指针
                curr = start;
                //保存当前最大指针
                temp.clear();

                tempLength = 0;
            } else {
                temp.add(currChar);
                //end指针后移
                curr ++;
                //子串长度加1
                tempLength ++;
            }

            //每次都来对比子串长度
            maxSubStringLength = Math.max(maxSubStringLength, tempLength);
        }

        return maxSubStringLength;
    }

    public static void main(String[] args) {
        System.out.println(new RepeatString().lengthOfLongestSubstring("abcde"));
        System.out.println(new RepeatString().lengthOfLongestSubstring(""));
        System.out.println(new RepeatString().lengthOfLongestSubstring("dvdf"));
        System.out.println(new RepeatString().lengthOfLongestSubstring("bbbb"));
        System.out.println(new RepeatString().lengthOfLongestSubstring("abcaabcabb"));
    }
}
