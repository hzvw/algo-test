package com.zhang.hot100;

/**
 * ClassName: _026_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/19 0:07
 * @Version 1.0
 */
public class _026_ {
    public static void main(String[] args) {


    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                ListNode l1 = head;
                ListNode l2 = slow;
                while (l1 != l2){
                    l1 = l1.next;
                    l2 = l2.next;
                }
                return l1;
            }
        }
        return null;
    }
}
