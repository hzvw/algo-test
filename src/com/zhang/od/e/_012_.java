package com.zhang.od.e;

import java.util.Scanner;

/**
 * ClassName: _012_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/29 2:18
 * @Version 1.0
 */
public class _012_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean flag1 = false;
        boolean flag2 = false;
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            char[] cs = str.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                char c = cs[i];


                if(c == '\''){
                    if(i == 0 || (i> 0 && cs[i-1] != '\\')){
                        flag2 = !flag2;
                        continue;
                    }
                }

                if(c == '"'){
                    if(i == 0 || (i> 0 && cs[i-1] != '\\')){
                        flag1 = !flag1;
                        continue;
                    }
                }

                if(flag1 || flag2){
                    sb.append(" ");
                    continue;
                }

                if(cs[i] == '-' && (i+1 < str.length() && cs[i+1]  == '-')){
                    break;
                }

                if(cs[i] == ' ' || cs[i] == '\t'){
                    continue;
                }
                sb.append(c);
            }
        }
        sb.append(";");
        int ans = 0;
        int last = -1;
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == ';'){
                if(i - last > 1){
                    ans++;
                }
                last = i;
            }
        }
        System.out.println(ans);
    }

}
