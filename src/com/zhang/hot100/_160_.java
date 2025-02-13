package com.zhang.hot100;

/**
 * ClassName: _160_
 * Package: com.zhang.hot100
 * Description:相交链表
 *
 * @Author Harizon
 * @Create 2025/1/8 23:14
 * @Version 1.0
 */
public class _160_ {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA != pB){
            pA = pA == null ? headB:pA.next;
            pB = pB == null ? headA:pB.next;
        }
        return pA;
    }

    static ListNode generateListNode(int[] A){
        ListNode head = new ListNode(A[0]);
        ListNode current = head;
        for(int i = 1; i<A.length; i++){
            ListNode tmp = new ListNode(A[i]);
            current.next = tmp;
            current = tmp;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] A = {4,1,8,4,5};
        int[] B = {5,6,1,8,4,5};

        ListNode headA = generateListNode(A);
        ListNode headB = generateListNode(B);

        System.out.println(getIntersectionNode(headA, headB));




    }


}


