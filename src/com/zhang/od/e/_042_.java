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
        StringBuilder sb = new StringBuilder();
        //记录要重复的子串在sb中的起始位置
        Stack<Integer> ids = new Stack<>();
        //记录要重复子串的次数
        Stack<Integer> nums = new Stack<>();

        String repeatStr = "";
        String num = "";
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if(c == '['){
                if(!"".equals(num)){
                    nums.push(Integer.parseInt(num));
                    num = "";
                }
                int start = sb.length();
                ids.push(start);
            }else if(c == ']'){
                int start = ids.pop();
                int num2 = nums.pop();
                for (int j = 0; j < num2; j++) {
                    repeatStr += sb.substring(start);
                }
                sb.replace(start, sb.length(), repeatStr);
                repeatStr = "";
            }else if(c >= '0' && c<='9'){
                num += c;
            }else{
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }

}
