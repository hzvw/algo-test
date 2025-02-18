package com.zhang.hot100;

/**
 * ClassName: _030_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/19 4:09
 * @Version 1.0
 */
public class _030_ {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        ListNode l1 = _027_.generateListNode(arr);
        new _030_().swapPairs(l1);
    }

    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(-1);
        ListNode n_head = pre;
        ListNode left = head;
        ListNode right = null;
        if(left != null){
            right = left.next;
        }
        ListNode next = null;
        if(right != null){
            next = right.next;
        }

        while (next != null){
            pre.next = right;
            right.next = left;
            left.next = next;

            pre = left;
            left = next;
            right = next.next;
            next = next.next.next;
        }
        return n_head.next;
    }

}
