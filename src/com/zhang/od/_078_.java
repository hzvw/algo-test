package com.zhang.od;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * ClassName: _078_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/21 0:45
 * @Version 1.0
 */
public class _078_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int N = sc.nextInt();

        LinkedList<Integer> stack = new LinkedList<>();

        int cnt = 0;
        for(int i = 0; i<str.length(); i++){
            int t = str.charAt(i) - '0';
            while (stack.size() > 0 && stack.getLast() > t && cnt < N){
                stack.removeLast();
                cnt++;
            }
            stack.addLast(t);
        }

        while(stack.size() > str.length() - N){
            stack.removeLast();
        }

        while(stack.getFirst() == 0 && stack.size() != 1){
            stack.removeFirst();
        }

        for(int i : stack){
            System.out.print(i);
        }

    }

}
