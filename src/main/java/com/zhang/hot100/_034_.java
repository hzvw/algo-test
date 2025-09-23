package com.zhang.hot100;

import com.zhang.datastruct.MyPriorityQueue;

import java.util.Comparator;
import java.util.LinkedList;
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

    static class MyPriorityQueue{


        int size = 0;
        LinkedList<Integer> buffer = new LinkedList<>();

        void offer(int num){
            buffer.add(num);
            size++;
            heapInsert(size-1);
        }

        int poll(){
            int res = buffer.get(0);
            swap(0, size-1);
            buffer.removeLast();
            size--;
            heapify(0);
            return res;
        }

        boolean isEmpty(){
            return size == 0;
        }

        private void heapInsert(int i){
            while (buffer.get(i) > buffer.get((i-1)/2)){
                swap(i, (i-1)/2);
                i = (i-1)/2;
            }
        }

        private void heapify(int i){
            int l = i * 2 + 1;
            while (l <size){
                int best = (l+1) < size && buffer.get(l+1) > buffer.get(l) ? (l+1) : l;
                best = buffer.get(best) > buffer.get(i) ? best : i;
                if(best == i){
                    break;
                }
                swap(i, best);

                i = best;
                l = i * 2 + 1;
            }
        }

        private void swap(int i , int j){
            int t = buffer.get(i);
            buffer.set(i, buffer.get(j));
            buffer.set(j, t);
        }
    }
}
