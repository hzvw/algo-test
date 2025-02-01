package com.zhang.od.e;

import java.util.Scanner;

/**
 * ClassName: _027_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/2/2 1:12
 * @Version 1.0
 */
public class _027_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] cs = str.toCharArray();
        Node node = new Node();
        for(int i = 0; i<cs.length; i++){
            char c = cs[i];
            switch (c){
                case 'L':
                    node.L();
                    break;
                case 'R':
                    node.R();
                    break;
                case 'F':
                    node.F();
                    break;
                case 'B':
                    node.B();
                    break;
                case 'A':
                    node.A();
                    break;
                case 'C':
                    node.C();
                    break;
            }
        }
        System.out.println(node.print());


    }

    static class Node{
        int left = 1;
        int right = 2;
        int front = 3;
        int behold = 4;
        int top = 5;
        int bottom = 6;

        void L(){
            int tmp = this.bottom;
            this.bottom = left;
            this.left = top;
            this.top = right;
            this.right = tmp;
        }

        void R(){
            int tmp = this.bottom;
            this.bottom = right;
            this.right = top;
            this.top = left;
            this.left = tmp;
        }

        void F(){
            int tmp = this.bottom;
            this.bottom = front;
            this.front = top;
            this.top = behold;
            this.behold = tmp;

        }

        void B(){
            int tmp = this.bottom;
            this.bottom = behold;
            this.behold= top;
            this.top = front;
            this.front = tmp;
        }

        void A(){
            int tmp = this.front;
            this.front = left;
            this.left = behold;
            this.behold = right;
            this.right = tmp;
        }

        void C(){
            int tmp = this.front;
            this.front = right;
            this.right  = behold;
            this.behold = left;
            this.left = tmp;
        }
        String print(){
            return String.valueOf(left) + String.valueOf(right) + String.valueOf(front) + String.valueOf(behold)+String.valueOf(top) + String.valueOf(bottom);
        }

    }

}
