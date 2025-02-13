package link;

import common.RandomListNode;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，
 * 一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要
 * 返回参数中的节点引用，否则判题程序会直接返回空
 *
 *
 */

public class _03_random_list_clone {
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null){
            return null;
        }

        RandomListNode current = pHead;
        while(current != null){
            RandomListNode bro = new RandomListNode(current.label);
            RandomListNode next = current.next;
            current.next = bro;
            bro.next = next;
            current = next;
        }

        current = pHead;
        while(current != null){
            RandomListNode bro = current.next;
            bro.random = current.random == null ? null : current.random.next;
            current = bro.next;
        }

        current = pHead;
        RandomListNode head = current.next;
        while(current != null){
            RandomListNode bro = current.next;
            current.next = bro.next;
            bro.next = bro.next == null ? null : bro.next.next;
            current = current.next;
        }
        return head;
    }

}
