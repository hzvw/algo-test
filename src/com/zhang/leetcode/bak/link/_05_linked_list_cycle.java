package link;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class _05_linked_list_cycle {
    public boolean hasCycle(ListNode h) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while(h != null){
            if(!seen.add(h)){
                return true;
            }
            h = h.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode h) {
        if(h == null || h.next == null){
            return false;
        }

        ListNode slow = h;
        ListNode fast = h.next;

        while(fast != null && fast.next != null){
            if(fast == slow){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

}
