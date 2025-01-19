package com.zhang.od;

import java.util.HashMap;
import java.util.Scanner;

/**
 * ClassName: _068_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/19 22:20
 * @Version 1.0
 */
public class _068_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String head = sc.next();
        int N = sc.nextInt();

        HashMap<String, Node> map = new HashMap<>();
        for(int i = 0; i<N; i++){
            Node node = new Node();
            node.addr = sc.next();
            node.val = sc.nextInt();
            node.next = sc.next();
            map.put(node.addr, node);
        }

        Node slow = map.get(head);
        Node fast = map.get(slow.next);

        while(fast != null){
            slow = map.get(slow.next);
            fast = map.get(fast.next);
            if(fast != null){
                fast = map.get(fast.next);
            }else{
                break;
            }
        }
        System.out.println(slow.val);
    }

    static class Node{
        String addr;
        int val;
        String next;
    }


}
