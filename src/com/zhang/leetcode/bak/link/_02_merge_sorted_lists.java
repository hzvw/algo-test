package link;

import common.ListNode;

/**
 * 合并两个排序的链表
 *
 *
 */
public class _02_merge_sorted_lists {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;

        if(p1 == null){
            return p2;
        }
        if(p2 == null){
            return p1;
        }

        ListNode p_n = null;
        if(p1.val < p2.val){
            p_n = p1;
            p_n.next = Merge(p1.next, p2);
        }else{
            p_n = p2;
            p_n.next = Merge(p1, p2.next);
        }

        return p_n;

    }

}
