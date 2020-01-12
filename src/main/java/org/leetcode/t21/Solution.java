package org.leetcode.t21;

class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode listNode) {
            val = x;
            next = listNode;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ///弄一个空节点
        ListNode result = new ListNode(-1);

        //当前节点指针
        ListNode prev = result;

        while (l1 != null && l2 != null) {
            int val1 = l1.val;
            int val2 = l2.val;
            //节点比较
            if (val1 <= val2) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        //最后把l1或者l2剩余的节点补上
        prev.next = (l1 == null) ? l2 : l1;

        //再把开头的空节点去掉
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));

        System.out.println(new Solution().mergeTwoLists(l1, l2));
    }
}