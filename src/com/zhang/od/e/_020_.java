package com.zhang.od.e;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * ClassName: _020_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/2/1 17:37
 * @Version 1.0
 */
public class _020_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String reg = "^(01)+0$";
        Pattern p = Pattern.compile(reg);

        String res = null;
        int maxLen = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == '0'){
                //碰到连续的两个0
                if(sb.length() > 0 && sb.charAt(sb.length()-1) == '0'){
                    if(p.matcher(sb.toString()).find()){
                        if(sb.length() > maxLen){
                            maxLen = sb.length();
                            res = sb.toString();
                        }
                    }
                    sb = new StringBuilder();
                }
            }
            sb.append(c);
        }
        if(sb.length() > 0 && p.matcher(sb.toString()).find()){
            if(sb.length() > maxLen){
                maxLen = sb.length();
                res = sb.toString();
            }
        }


        System.out.println(res == null ? -1:res);

    }

}
