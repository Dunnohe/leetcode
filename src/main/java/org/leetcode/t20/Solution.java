package org.leetcode.t20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public static final Map<Character, Integer> SYMBOL_MAP = new HashMap<Character, Integer>(6);

    static {
        SYMBOL_MAP.put('(', 1);
        SYMBOL_MAP.put(')', -1);
        SYMBOL_MAP.put('[', 2);
        SYMBOL_MAP.put(']', -2);
        SYMBOL_MAP.put('{', 3);
        SYMBOL_MAP.put('}', -3);
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            //如果栈空，直接压栈
            if (stack.empty()) {
                stack.push(aChar);
                continue;
            }

            //否则做抵消判断
            Integer oldVal = SYMBOL_MAP.get(stack.peek());
            Integer newVal = SYMBOL_MAP.get(aChar);

            if (oldVal + newVal == 0 && newVal < 0) {
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }

        return stack.empty();
    }
}