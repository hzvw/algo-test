package link;

import common.ListNode;

public class _09_add_two_numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return null;
        ListNode t1 = l1;
        ListNode t2 = l2;
        int flag = 0;
        ListNode head = new ListNode(-1);
        ListNode h = head;
        int temp = 0;
        while(t1 != null || t2 != null){
            if(t1 != null && t2 != null){
                temp = t1.val + t2.val + flag;
            }else if(t1 != null && t2 == null){
                temp = t1.val + flag;
            }else if(t1 == null && t2 != null){
                temp = t2.val + flag;
            }
            flag = 0;
            if(temp >= 10) {
                flag = 1;
                temp = temp % 10;
            }
            h.next = new ListNode(temp);
            h = h.next;
            if(t1 != null) t1 = t1.next;
            if(t2 != null) t2 = t2.next;
        }
        if(flag != 0){
            h.next = new ListNode(1);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode x1 = new ListNode(4);
        ListNode y1 = new ListNode(3);
        l1.next= x1;
        x1.next = y1;

        ListNode l2 = new ListNode(5);
        ListNode x2 = new ListNode(6);
        ListNode y2 = new ListNode(4);
        l2.next = x2;
        x2.next = y2;

        new _09_add_two_numbers().addTwoNumbers(l1, l2);


    }


}
