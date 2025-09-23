package com.zhang.hot100;

/**
 * ClassName: _022_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/18 23:13
 * @Version 1.0
 */
public class _022_ {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2){
            if(p1 != null){
                p1 = p1.next;
            }else{
                p1 = headB;
            }
            if(p2 != null){
                p2 = p2.next;
            }else{
                p2 = headA;
            }
        }
        return p1;
    }

    ListNode generateListNode(int[] A){
        ListNode head = new ListNode(A[0]);
        ListNode current = head;
        for(int i = 1; i<A.length; i++){
            ListNode tmp = new ListNode(A[i]);
            current.next = tmp;
            current = tmp;
        }

        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
