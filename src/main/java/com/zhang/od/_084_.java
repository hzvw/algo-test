package com.zhang.od;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * ClassName: _084_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/21 22:39
 * @Version 1.0
 */
public class _084_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine() + "$";

        Deque<Integer> nums = new LinkedList<>();
        Deque<Character> ops = new LinkedList<>();
        StringBuilder num = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(Character.isDigit(c)){
                int j = i;
                for (; j < str.length() && Character.isDigit(str.charAt(j)); j++) {
                    num.append(str.charAt(j));
                }
                nums.push(Integer.parseInt(num.toString()));
                num = new StringBuilder();
                i = j - 1;
            }

            if(c == '#' || c == '$'){
                while (!ops.isEmpty() && c >= ops.peek()){
                    int y = nums.pop();
                    int x = nums.pop();
                    char op = ops.pop();
                    if(op == '#'){
                        nums.push(4 * x + 3 * y + 2);
                    }else{
                        nums.push(2 * x + y + 3);
                    }
                }
                ops.push(c);
            }
        }
        System.out.println(nums.peek());
    }






}
