package com.zhang.hot100;

/**
 * ClassName: _234_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/8 23:55
 * @Version 1.0
 */
public class _234_ {
    public static void main(String[] args) {
        int[] A = {4,1,8,4,5};
        ListNode head = generateListNode(A);
        ListNode cur = reverseList(head);
        while(cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }



    }

    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null){
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }
            slow = slow.next;
        }

        ListNode head_n = reverseList(slow);
        ListNode tmp = head;
        while (head_n != null){
            if(head_n.val != tmp.val){
                return false;
            }
            tmp = tmp.next;
            head_n = head_n.next;
        }
        return true;
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

    public static ListNode reverseList(ListNode head){
        if(head == null ){
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;

            cur = tmp;
        }
        return pre;
    }

  static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


}
