package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _003_
 * Package: com.zhang.od
 * Description:靠谱的车
 *
 * @Author Harizon
 * @Create 2025/1/4 22:51
 * @Version 1.0
 */
public class _003_ {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String str = sc.nextLine();
       char[] cs = str.toCharArray();

       int res = 0;
       for(int i = cs.length-1; i>=0; i--){
           if(cs[i] <= '3'){
               res += (cs[i] - '0') * my_power(cs.length-1-i);
           }else{
               res += (cs[i] - '0' - 1) * my_power(cs.length-1-i);
           }
       }
       System.out.println(res);

    }

    static int my_power(int N){
        int res = 1;
        for(int i = 0; i<N; i++){
            res *= 9;
        }
        return res;
    }


}
