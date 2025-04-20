package com.zhang.leetcode.bak;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: _394_
 * Package: com.zhang.leetcode.bak
 * Description:
 *
 * @Author Harizon
 * @Create 2025/4/20 16:08
 * @Version 1.0
 */
public class _394_ {
    public static void main(String[] args) {

        String s = "3[a2[c]]";
        System.out.println(new _394_().decodeString(s));
    }


    public String decodeString(String s) {
        Deque<Integer> nums = new LinkedList<>();
        Deque<Integer> idx = new LinkedList<>();
        String num = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLowerCase(c)){
                sb.append(c);
            }else if(c == '['){
                if(!"".equals(num)){
                    nums.push(Integer.parseInt(num));
                    num = "";
                }
                idx.push(sb.length());
            }else if(c == ']'){
                String tmp = "";
                int count = nums.pop();
                int index = idx.pop();
                for (int j = 0; j < count; j++) {
                    tmp += sb.substring(index);
                }
                sb.replace(index, sb.length(), tmp);
            }else{
                // 数字
                num += c;
            }
        }
        return sb.toString();
    }
}
