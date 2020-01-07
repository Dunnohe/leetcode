package org.leetcode.t7;

public class IntReverse {

    public int reverse(int x) {
        boolean isNegativeNumber = x < 0;
        char[] chars = String.valueOf(x == Integer.MIN_VALUE ? 0 : Math.abs(x)).toCharArray();

        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }

        long result = Long.parseLong(new String(chars));
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return isNegativeNumber ? (int) result * -1 : (int) result;
    }

    public static void main(String[] args) {
        //System.out.println(new IntReverse().reverse(1534236469));
        System.out.println(new IntReverse().reverse(-2147483648));
        System.out.println(new IntReverse().reverse(-123));
        System.out.println(new IntReverse().reverse(1234));
        System.out.println(new IntReverse().reverse(120));
    }
}
