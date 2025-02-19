package com.zhang.hot100;

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

    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode p = head;
        while (p != null){
            len ++;
            p = p.next;
        }

        int n = len / k;
        ListNode n_head = new ListNode(-1);
        n_head.next = head;
        ListNode pre = n_head;
        ListNode start = head;
        while (n > 0){
            int count = k;
            ListNode tail = start;
            p = start;
            ListNode q = start.next;
            while(--count > 0){
                ListNode next = q.next;
                q.next = p;
                p = q;
                q = next;
            }
            pre.next = p;
            start = q;
            tail.next = start;
            pre = tail;

            n--;
        }
        return n_head.next;
    }

    static ListNode reverse(ListNode head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode p = head;
        while (p != null){
            ListNode next = p.next;
            p.next = pre;
            pre = p;

            p = next;
        }

        return pre;
    }

}
