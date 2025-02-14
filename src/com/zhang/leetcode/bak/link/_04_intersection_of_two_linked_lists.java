package link;

import common.ListNode;

public class _04_intersection_of_two_linked_lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        ListNode p_a = headA;
        ListNode p_b = headB;

        while(p_a != p_b){
            if(p_a != null){
                p_a = p_a.next;
            }else{
                p_a = headB;
            }

            if(p_b != null){
                p_b = p_b.next;
            }else{
                p_b = headA;
            }
        }
        return p_a;
    }

}
