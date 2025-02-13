package com.zhang.od.e;

import java.util.Scanner;
import java.util.Stack;

/**
 * ClassName: _059_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/2/13 17:36
 * @Version 1.0
 */
public class _059_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack<Integer> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();

        char[] cs = str.toCharArray();

        String num = "";
        String op = "";
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if(c == '('){
                if(!"".equals(num)){
                    s1.push(Integer.parseInt(num));
                    num = "";
                }
            }else if(c == ')'){
                if(!"".equals(num)){
                    s1.push(Integer.parseInt(num));
                    num = "";
                }

                String ops = s2.pop();
                int b = s1.pop();
                int a = s1.pop();
                try{
                    s1.push(calc(ops, a, b));
                }catch (Exception e){
                    System.out.println("error");
                    return;
                }
            }else if(Character.isDigit(c) || c == '-'){
                num += c;
            }else if(Character.isLowerCase(c)){
                op += c;
            }else{
                // 空格
                if(!"".equals(op)){
                    s2.push(op);
                    op = "";
                }
                if(!"".equals(num)){
                    s1.push(Integer.parseInt(num));
                    num = "";
                }
            }
        }

        if(!s2.isEmpty()){
            String ops = s2.pop();
            int b = s1.pop();
            int a = s1.pop();
            try{
                s1.push(calc(ops, a, b));
            }catch (Exception e){
                System.out.println("error");
                return;
            }
        }
        System.out.println(s1.pop());

    }

    static int calc(String ops, int a, int b) throws Exception{
        if(ops.equals("add")){
            return a+b;
        }else if(ops.equals("sub")){
            return a-b;
        }else if (ops.equals("mul")){
            return a * b;
        }else{
            return Math.floorDiv(a,b);
        }
    }
}
