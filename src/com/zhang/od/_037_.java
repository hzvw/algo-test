package com.zhang.od;

import java.util.*;

/**
 * ClassName: _037_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/17 16:02
 * @Version 1.0
 */
public class _037_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String p2 = p2(str);

        if("!error".equals(p2) || !str.equals(p1(p2(str)))){
            System.out.println("!error");
        }else{
            System.out.println(p2);
        }


    }

    static boolean isDig(char c){
        return c >='0' && c<='9';
    }

    static boolean isChar(char c){
        return c >='a' && c<='z';
    }

    // 压缩算法
    static String p1(String s){
        StringBuilder sb = new StringBuilder();

        s = s+" ";
        char[] cs = s.toCharArray();

        char last_char = cs[0];
        int last_cnt = 1;
        for(int i = 1; i<cs.length; i++){
            char c = cs[i];

            if(c == last_char){
                last_cnt++;
            }else{
                if(last_cnt >= 3){
                    sb.append(last_cnt + "");
                    sb.append(last_char);
                }else if(last_cnt == 2){
                    sb.append(last_char);
                    sb.append(last_char);
                }else{
                    sb.append(last_char);
                }

                last_char = c;
                last_cnt = 1;
            }
        }
        return sb.toString();
    }

    //解压缩算法
    static String p2(String str){
        StringBuilder sb = new StringBuilder();
        char[] cs = str.toCharArray();

        int i = 0;
        while(i < cs.length){
            char c = cs[i];
            if(isDig(c)){
                StringBuilder num = new StringBuilder();
                while(i < cs.length && isDig(cs[i])){
                    num.append(cs[i]);
                    i++;
                }
                int i_num = Integer.parseInt(num.toString());

                if(i<cs.length && isChar(cs[i])){
                    if(i_num >= 3 && isChar(cs[i])){
                        for(int j = 0; j<i_num; j++){
                            sb.append(cs[i]);
                        }
                    }else{
                        return "!error";
                    }
                }else{
                    return "!error";
                }

            }else if(isChar(c)){
                sb.append(c);
            }else{
                return "!error";
            }
            i++;
        }
        return sb.toString();
    }





}
