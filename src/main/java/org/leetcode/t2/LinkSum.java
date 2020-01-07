package org.leetcode.t2;

import lombok.Data;

public class LinkSum {

    @Data
    public static class ListNode {
         int val;
         public ListNode next;
         ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //结果
        ListNode result = null;
        //结果node的当前指针
        ListNode curr = null;
        //第一个参数的next指针
        ListNode firstNext = l1;
        //第二个参数的next指针
        ListNode secondNext = l2;
        //进位
        int high = 0;
        //中断条件，由于l1和l2可能不一样长，l1和l2的next指针都为空且进位不为0就结束
        for (;firstNext != null || secondNext != null || high != 0;) {
            if(firstNext == null) {
                firstNext = new ListNode(0);
                firstNext.next = null;
            }
            if(secondNext == null) {
                secondNext = new ListNode(0);
                secondNext.next = null;
            }

            //计算
            int sum = firstNext.val + secondNext.val + high;

            //算个位
            int low = sum % 10;
            //算十位
            high = sum / 10;

            //指针调整
            firstNext = firstNext.next;
            secondNext = secondNext.next;

            //结果指针调整
            if(curr == null) {
                result = new ListNode(low);
                curr = result;
            } else {
                curr.next = new ListNode(low);
                curr = curr.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LinkSum test = new LinkSum();
        System.out.println(test.addTwoNumbers(new ListNode(5), new ListNode(5)));

    }
}
