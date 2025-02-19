package com.zhang.hot100;

import java.security.DrbgParameters;

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
        ListNode n_head = new ListNode(-1);
        n_head.next = head;
        ListNode p = n_head;
        while (p.next != null && p.next.next != null){
            ListNode n1 = p.next;
            ListNode n2 = p.next.next;
            ListNode next = n2.next;

            p.next = n2;
            n2.next = n1;
            n1.next = next;

            p = n1;
        }
        return n_head.next;
    }

}
