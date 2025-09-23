package com.zhang.hot100;

import java.util.PriorityQueue;

/**
 * ClassName: _033_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/19 17:17
 * @Version 1.0
 */
public class _033_ {
    public static void main(String[] args) {
        ListNode l1 = _027_.generateListNode(new int[]{4, 2, 1, 3});

        ListNode l2 = new _033_().sortList(l1);
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode p = head;
        while (p != null){
            pq.offer(p);
            p = p.next;
        }

        ListNode pre = new ListNode(-1);
        ListNode n_head = pre;
        while (pq.size() > 0){
            ListNode node = pq.poll();
            pre.next = node;
            pre = node;
        }
        pre.next = null;
        return n_head.next;
    }


}
