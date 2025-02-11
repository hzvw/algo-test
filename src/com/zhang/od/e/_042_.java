package com.zhang.od.e;

import java.util.Scanner;
import java.util.Stack;

/**
 * ClassName: _042_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/2/2 19:24
 * @Version 1.0
 */
public class _042_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        //要重复子串的起始位置，在sb中的起始位置
        Stack<Integer> idx = new Stack<>();
        //要重复子串的重复次数
        Stack<Integer> numStack = new Stack<>();

        //保存最终的结果
        StringBuilder sb = new StringBuilder();
        //暂时存储数字
        StringBuilder num = new StringBuilder();
        //暂时存储要重复的字符串
        StringBuilder repeat = new StringBuilder();
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];

            if(c == '['){
                //说明数字结束
                if(num.length() > 0){
                    numStack.push(Integer.parseInt(num.toString()));
                    num = new StringBuilder();
                }
                idx.push(sb.length());
            }else if(c == ']'){
                int num_i = numStack.pop();
                int start = idx.pop();
                String tmp = sb.substring(start);
                String tmp2 = "";
                for (int j = 0; j < num_i; j++) {
                    tmp2 += tmp;
                }
                sb.replace(start, sb.length(), tmp2);
            }else if(c >= '0' && c <= '9'){
                num.append(c);
            }else{
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }

}
