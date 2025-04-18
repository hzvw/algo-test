package com.zhang.od.e;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * ClassName: _020_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/1 17:37
 * @Version 1.0
 */
public class _020_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine() + "0";
        String reg = "^(01)+0$";
        Pattern p = Pattern.compile(reg);

        int i = 0;
        int j = 1;
        String res = "";
        for (; j< str.length(); j++){
            if(str.charAt(j) == '0' && str.charAt(j) == str.charAt(j-1)){
                String sub = str.substring(i, j);

                if(p.matcher(sub).find()){
                    if(sub.length() > res.length()){
                        res = sub;
                    }
                }

                i = j;
            }
        }

        System.out.println("".equals(res) ? "-1" : res);

    }

}
