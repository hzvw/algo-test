package link;

import common.ListNode;

public class _07_palindrome_linked_list {

    public boolean isPalindrome(ListNode h) {
        if(h == null || h.next == null){
            return true;
        }

        ListNode slow = h;
        ListNode fast = h;
        while(fast != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        int size = 0;







        return false;
    }
}
