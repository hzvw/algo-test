package com.zhang.od.e;

import java.util.Scanner;

/**
 * ClassName: _012_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/29 2:18
 * @Version 1.0
 */
public class _012_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        boolean flag1 = false;//单引号
        boolean flag2 = false;//双引号
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            char[] cs = str.toCharArray();

            for(int i = 0; i<cs.length; i++){
                if(cs[i] == '\''){
                    if(i == 0 || (i-1>=0 && cs[i-1] != '\\')){
                        flag1 = !flag1;
                    }
                }

                if(cs[i] == '\"'){
                    if(i == 0 || i-1>=0 && cs[i-1] != '\\'){
                        flag2 = !flag2;
                    }
                }

                if(flag1 || flag2){
                    continue;
                }

                if(cs[i] == '-' && i+1 <cs.length && cs[i+1] == '-'){
                    break;
                }
                if(cs[i] == ' ' || cs[i] == '\t'){
                    continue;
                }
                sb.append(cs[i]);
            }
        }
        sb.append(";");
        int last = -1;
        int ans = 0;
        for(int i = 0; i<sb.length(); i++){
            if(sb.charAt(i) == ';'){
                if(i-last > 1){
                    ans++;
                }
                last = i;
            }
        }
        System.out.print(ans);


    }

}
