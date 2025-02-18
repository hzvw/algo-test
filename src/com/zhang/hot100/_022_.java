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
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA != pB){
            if(pA == null){
                pA = headB;
            }else{
                pA = pA.next;
            }

            if(pB == null){
                pB = headA;
            }else{
                pB = pB.next;
            }
        }
        return pA;
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
