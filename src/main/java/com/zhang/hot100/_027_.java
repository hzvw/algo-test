package com.zhang.hot100;

import java.util.List;

/**
 * ClassName: _027_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/19 0:26
 * @Version 1.0
 */
public class _027_ {
    public static void main(String[] args) {
        ListNode l1 = generateListNode(new int[]{1,2,4});
        ListNode l2 = generateListNode(new int[]{1,3,4});
        mergeTwoLists(l1, l2);

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

    public static  ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){
            return null;
        }
        if(list1 == null ){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        ListNode cur1 = list1;
        ListNode cur2 = list2;

        ListNode n_head = new ListNode(-1);
        ListNode cur = n_head;
        while (cur1 != null && cur2 != null){
            if(cur1.val < cur2.val){
                cur.next = cur1;
                cur1 = cur1.next;
            }else{
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }

        if(cur1 != null){
            cur.next = cur1;
        }
        if(cur2 != null){
            cur.next = cur2;
        }
        return n_head.next;
    }
}
