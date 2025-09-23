package com.zhang.leetcode.bak;

/**
 * ClassName: _443_
 * Package: com.zhang.leetcode.bak
 * Description:
 *
 * @Author Harizon
 * @Create 2025/4/20 17:17
 * @Version 1.0
 */
public class _443_ {
    public static void main(String[] args) {
        String s = "aabbccc";
        char[] chars = s.toCharArray();
        System.out.println(new _443_().compress(chars));


    }
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int n = chars.length;

        char last = chars[0];
        int count = 1;
        sb.append(last);

        for (int i = 1; i < n; i++) {
            char c = chars[i];
            if(c == last){
                count++;
            }else{
                if(count == 1){

                }else{
                    sb.append(count);
                }
                sb.append(c);
                last = c;
                count = 1;
            }
        }
        if(count == 1){

        }else{
            sb.append(count);
        }
        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }
}
