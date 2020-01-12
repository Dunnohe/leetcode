package org.leetcode.t28;

import com.google.common.collect.Maps;

import java.util.TreeMap;

class Solution {

    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) {
            return 0;
        }

        if(needle.length() > haystack.length()) {
            return -1;
        }

        TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();

        char[] chars = haystack.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], i);
        }

        char[] result = needle.toCharArray();

        int startIndex = 0;
        int prevIndex = startIndex;

        for (char c : result) {
            Integer index = map.get(c);
            if (index == null) {
                return -1;
            }

            if (prevIndex != 0 && index - prevIndex != 1) {
                return -1;
            }

            prevIndex = index;
        }

        return startIndex;
    }

    /**
     * 解法1：双重移动指针
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr2(String haystack, String needle) {
        if(needle == null || needle.length() == 0) {
            return 0;
        }

        if(needle.length() > haystack.length()) {
            return -1;
        }

        char[] source = needle.toCharArray();
        int length = source.length;
        char[] aim = haystack.toCharArray();

        int p = 0;
        while (p < aim.length) {
            if(aim[p] == source[0]) {

                //如果找到初始指针，但是遍历的长度不够
                if(p + length > aim.length) {
                    return -1;
                }

                //如果发现相等，则挨个往后对比
                boolean same = true;
                for (int i = 1; i < length; i++) {
                    if(aim[p + i] != source[i]) {
                        same = false;
                        break;
                    }
                }
                if(same) {
                    return p;
                }
            }

            p ++;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("hello", "ll"));
    }
}