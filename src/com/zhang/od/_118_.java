package com.zhang.od;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * ClassName: _118_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/26 23:57
 * @Version 1.0
 */
public class _118_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int res = 0;
        Deque<Character> st = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(c == '('){
                st.push(')');
            }else if(c == '['){
                st.push(']');
            }else if(c == '{'){
                st.push('}');
            }else{
                if( st.isEmpty() || c != st.peek()){
                    System.out.println(0);
                    return;
                }
                st.pop();
            }
            res = Math.max(res, st.size());
        }

        if(!st.isEmpty()){
            System.out.println(0);
            return;
        }else{
            System.out.println(res);
        }

    }
}
