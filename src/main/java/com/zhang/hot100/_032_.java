package com.zhang.hot100;

/**
 * ClassName: _032_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/19 16:21
 * @Version 1.0
 */
public class _032_ {
    public static void main(String[] args) {


    }

    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        Node p = head;
        while (p != null){
            Node node = new Node(p.val);
            Node next = p.next;

            p.next = node;
            node.next = next;

            p = next;
        }
        p = head;
        while (p != null){
            Node node = p.next;
            node.random = p.random != null ? p.random.next : null;

            p = node.next;
        }

        p = head;
        Node n_p = head.next;
        while (p != null){
            Node node = p.next;
            p.next = node.next;
            node.next = node.next != null ?  node.next.next : null;

            p = p.next;
        }
        return n_p;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
