package com.zhang.leetcode.bak;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * ClassName: _1626_
 * Package: com.zhang.leetcode.bak
 * Description:
 *
 * @Author Harizon
 * @Create 2025/4/20 14:52
 * @Version 1.0
 */
public class _1626_ {
    public static void main(String[] args) {
        String s = "3/2";
        System.out.println(new _1626_().calculate(s));

    }
    Map<Character, Integer> priority = new HashMap<>();

    public int calculate(String s) {
        s = s.replaceAll(" ","");
        s += "+";

        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);

        Deque<Integer> nums = new LinkedList<>();
        Deque<Character> ops = new LinkedList<>();
        String num = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                int j = i;
                for (; j < s.length() && Character.isDigit(s.charAt(j)); j++) {
                    num += s.charAt(j);
                }
                i = j;
                if(!"".equals(num)){
                    nums.push(Integer.parseInt(num));
                    num = "";
                }
            }

            c = s.charAt(i);
            if(!Character.isDigit(c)){
                while (!ops.isEmpty() && priority.get(ops.peek()) >= priority.get(c)){
                    int a = nums.pop();
                    int b = nums.pop();
                    char op = ops.pop();
                    if(op == '*'){
                        nums.push(a * b);
                    }else if(op == '/'){
                        nums.push(b / a);
                    }else if(op == '+'){
                        nums.push(a + b);
                    }else{
                        nums.push(b - a);
                    }
                }
                ops.push(c);
            }

        }


        return nums.peek();
    }
}
