package org.leetcode.t14;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int firstLength = strs[0].length();

        for (int j = 0; j < firstLength; j++) {
            for (int i = 1; i < strs.length; i++) {
                //如果某个子串遍历完了，则退出
                if(j+1 > strs[i].length()) {
                    return result.toString();
                }
                //如果字符不相等立马退出
                if(strs[i].charAt(j) != strs[0].charAt(j)) {
                    return result.toString();
                }
            }
            result.append(strs[0].charAt(j));
        }

        return result.toString();
    }
}