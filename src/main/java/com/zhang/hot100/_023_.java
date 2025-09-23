package com.zhang.hot100;

/**
 * ClassName: _023_
 * Package: com.zhang.hot100
 * Description:// 反转链表
 *
 * @Author Harizon
 * @Create 2025/2/18 23:19
 * @Version 1.0
 */
public class _023_ {
    public static void main(String[] args) {
        int[] A = {4,1,8,4,5};
        ListNode head = generateListNode(A);
        ListNode  cur = reverse(head);
        //ListNode cur = head;
        while(cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }

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

    static ListNode reverse(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode p = head;
        ListNode pre = null;
        while (p != null){
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }
}
