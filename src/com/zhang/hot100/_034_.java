package com.zhang.hot100;

import java.util.PriorityQueue;

/**
 * ClassName: _034_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/19 17:35
 * @Version 1.0
 */
public class _034_ {
    public static void main(String[] args) {


    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);

        for (ListNode head : lists) {
            ListNode p = head;
            while (p != null){
                pq.offer(p);
                p = p.next;
            }
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
