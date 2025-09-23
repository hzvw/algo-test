package com.zhang.hot100;

import java.rmi.Remote;

/**
 * ClassName: _029_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/19 3:48
 * @Version 1.0
 */
public class _029_ {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        ListNode l1 = _027_.generateListNode(arr);
        new _029_().removeNthFromEnd(l1, 3);

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l1 = head;
        ListNode l2 = head;

        for (int i = 0; i < n-1; i++) {
            if(l2 != null){
                l2 = l2.next;
            }
        }

        ListNode pre = null;
        while (l2 != null && l2.next != null){
            pre = l1;

            l2 = l2.next;
            l1 = l1.next;
        }

        if(pre != null){
            pre.next = l1.next;
            return head;
        }else{
            return head.next;
        }
    }
}
