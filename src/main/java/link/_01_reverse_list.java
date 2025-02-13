package link;

import common.ListNode;
import common.TreeNode;

/**
 * 反转链表
 *
 *  2022-01-21更新
 *  注意边界条件
 *  注意next可能为空，空指针异常
 *  注意head的next首先置为空，循环中不再需要置空
 *
 */
public class _01_reverse_list {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        if(head.next.next == null){
            ListNode p_t = head.next;
            head.next = null;
            p_t.next = head;
            return p_t;
        }

        ListNode p_last = head;
        ListNode p_cur = head.next;
        ListNode p_next = p_cur.next;

        head.next=null;
        while(p_cur != null){
            //p_last.next = null;
            p_cur.next = p_last;

            p_last = p_cur;
            p_cur = p_next;
            if(p_next != null){
                p_next = p_next.next;
            }
        }
        return p_last;
    }

    public static void test(TreeNode root){
        if(root == null){
            System.out.println();
        }





    }

}
