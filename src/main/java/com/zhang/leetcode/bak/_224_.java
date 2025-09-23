package com.zhang.leetcode.bak;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: _224_
 * Package: com.zhang.leetcode.bak
 * Description:
 *
 * @Author Harizon
 * @Create 2025/4/20 15:20
 * @Version 1.0
 */
public class _224_ {
    public static void main(String[] args) {
        String s = "1 + (1+(4+5+2)-3)+(6+8)-2";
        System.out.println(new _224_().calculate(s));


    }

    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        s += "+";
        Deque<Integer> nums = new LinkedList<>();
        Deque<Character> ops = new LinkedList<>();

        String num = "";
        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))){
                while (i < s.length() && Character.isDigit(s.charAt(i))){
                    num += s.charAt(i);
                    i++;
                }
            }
            if(!"".equals(num)){
                nums.push(Integer.parseInt(num));
                num = "";
            }
            char c = s.charAt(i);
            if(c == '('){
                ops.push(c);
            }else if(c == ')'){
                while (!ops.isEmpty() && ops.peek() != '('){
                    int b = nums.pop();
                    int a = nums.pop();
                    char op = ops.pop();

                    if(op == '+'){
                        nums.push(a + b);
                    }else{
                        nums.push(a - b);
                    }
                }
                ops.pop();
            }else{
                while (!ops.isEmpty() && ops.peek() != '('){
                    int b = nums.pop();
                    int a = nums.pop();
                    char op = ops.pop();

                    if(op == '+'){
                        nums.push(a + b);
                    }else{
                        nums.push(a - b);
                    }
                }
                ops.push(c);
            }


        }
        return nums.peek();
    }

}
