package com.zhang.hot100;

import java.time.chrono.IsoChronology;

/**
 * ClassName: _024_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/18 23:36
 * @Version 1.0
 */
public class _024_ {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        new _024_().isPalindrome(head);

    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        ListNode pre = head;
        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        ListNode n_head = reverse(slow);
        ListNode cur1 = n_head;
        ListNode cur2 = head;
        while (cur1 != null && cur2 != null){
            if(cur1.val != cur2.val){
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return true;
    }


    static ListNode reverse(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
