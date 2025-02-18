package com.zhang.hot100;

/**
 * ClassName: _028_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/19 0:46
 * @Version 1.0
 */
public class _028_ {
    public static void main(String[] args) {
        int[] arr1 = {3,7};
        int[] arr2 = {9,2};
        ListNode l1 = _027_.generateListNode(arr1);
        ListNode l2 = _027_.generateListNode(arr2);

        new _028_().addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode p1 = l1;
        ListNode p2 = l2;

        int last = 0;
        ListNode n_head = new ListNode(-1);
        ListNode p = n_head;
        while (p1 != null && p2 != null) {
            ListNode node = new ListNode((p1.val + p2.val + last) % 10);
            last = (p1.val + p2.val + last) >= 10 ? (p1.val + p2.val + last) / 10 : 0;
            p.next = node;
            p = p.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        ListNode tmp = p1 != null ? p1 : p2;

        if(last == 0){
            p.next = tmp;
        }else{
            while (tmp != null){
                ListNode node = new ListNode((tmp.val + last) % 10);
                last = (tmp.val + last) >= 10 ? 1:0;
                p.next = node;
                p = p.next;
                tmp = tmp.next;
            }
            if(last != 0){
                ListNode node = new ListNode(last);
                p.next = node;
            }
        }
        return n_head.next;
    }

}
