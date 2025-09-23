package com.zhang.hot100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: _071_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/21 1:20
 * @Version 1.0
 */
public class _071_ {

    public static void main(String[] args) {
        System.out.println(new _071_().decodeString("3[a2[c]]"));
    }
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> ids = new LinkedList<>();
        Deque<Integer> nums = new LinkedList<>();

        String num = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLowerCase(c)){
                sb.append(c);
            }else if(Character.isDigit(c)){
                num += c;
            }else if(c == '['){
                if(!"".equals(num)){
                    nums.push(Integer.parseInt(num));
                    num = "";
                }
                int start = sb.length();
                ids.push(start);
            }else{
                int start = ids.pop();
                int count = nums.pop();
                String tmp = "";
                for (int j = 0; j < count; j++) {
                    tmp += sb.substring(start);
                }
                sb.replace(start, sb.length(), tmp);
            }
        }
        return sb.toString();
    }
}
