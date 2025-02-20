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
        //数字索引，在sb中的索引
        Deque<Integer> ids = new LinkedList<>();
        //重复次数
        Deque<Integer> nums = new LinkedList<>();

        String num = "";
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c >= '0' && c<= '9'){
                num += c;
            }else if(c >= 'a' && c <= 'z'){
                sb.append(c);
                //str += c;
            }else if(c == '['){
                // 数字结束的标志
                if(!"".equals(num)){
                    nums.push(Integer.parseInt(num));
                    num = "";
                }
                int start = sb.length();
                ids.push(start);
            }else{
                //右括号
                //字符串结束的标志
                int start = ids.pop();
                int count = nums.pop();
                //StringBuilder sb2 = new StringBuilder();
                for (int j = 0; j < count; j++) {
                    str += sb.substring(start) ;
                    //sb2.append(str);
                }
                sb.replace(start, sb.length(), str);
                str = "";
            }
        }
        return sb.toString();
    }
}
