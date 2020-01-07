package org.leetcode.t13;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static final Map<Character, Integer> ROMAN_MAP = new HashMap<Character, Integer>(7);

    static {
        ROMAN_MAP.put('I', 1);
        ROMAN_MAP.put('V', 5);
        ROMAN_MAP.put('X', 10);
        ROMAN_MAP.put('L', 50);
        ROMAN_MAP.put('C', 100);
        ROMAN_MAP.put('D', 500);
        ROMAN_MAP.put('M', 1000);
    }

    public int romanToInt(String s) {

        int result = 0;
        int prev = 0;

        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            Integer curr = ROMAN_MAP.get(chars[i]);
            if(prev <= curr) {
                result = result + curr;
            } else {
                result = result - curr;
            }
            prev = curr;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("LVIII"));
    }
}