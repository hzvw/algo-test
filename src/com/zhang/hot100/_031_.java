package com.zhang.hot100;

import java.util.List;

/**
 * ClassName: _031_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/19 15:15
 * @Version 1.0
 */
public class _031_ {
    public static void main(String[] args) {



    }

    public ListNode reverseKGroup(ListNode head, int k){
        ListNode n_head = new ListNode(-1);
        n_head.next = head;
        int len = 0;
        ListNode p = head;
        while (p != null){
            len++;
            p = p.next;
        }

        int n = len / k;
        ListNode pre = n_head;
        ListNode start = head;
        while (n-- > 0){
            ListNode tail = start;
            p = start;
            ListNode q = p.next;

            int count = k;
            while (--count > 0){
                ListNode next = q.next;
                q.next = p;
                p = q;
                q = next;
            }

            pre.next = p;
            tail.next = q;

            start = q;
            pre = tail;
        }
        return n_head.next;
    }




}
