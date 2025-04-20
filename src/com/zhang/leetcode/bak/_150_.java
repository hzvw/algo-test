package com.zhang.leetcode.bak;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * ClassName: _150_
 * Package: com.zhang.leetcode.bak
 * Description:
 *
 * @Author Harizon
 * @Create 2025/4/20 16:01
 * @Version 1.0
 */
public class _150_ {

    public int evalRPN(String[] tokens) {
        Set<String> ops = new HashSet<>();
        ops.add("+");
        ops.add("-");
        ops.add("*");
        ops.add("/");

        Deque<Integer> st = new LinkedList<>();

        for (String token : tokens) {
            if(!ops.contains(token)){
                st.push(Integer.parseInt(token));
            }else{
                int b = st.pop();
                int a = st.pop();
                String op = token;
                if(op.equals("+")){
                    st.push(a + b);
                }else if(op.equals("-")){
                    st.push(a-b);
                }else if(op.equals("*")){
                    st.push(a * b);
                }else{
                    st.push(a / b);
                }

            }
        }
        return st.peek();
    }

}
