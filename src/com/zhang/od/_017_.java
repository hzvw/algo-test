package com.zhang.od;

import java.util.*;
/**
 * ClassName: _017_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/15 0:01
 * @Version 1.0
 */
public class _017_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        int[][] arr = new int[C][2];
        for(int i = 0; i<C; i++){
            int T = sc.nextInt();
            int M = sc.nextInt();
            arr[i][0] = T;
            arr[i][1] = M;
        }

        int last = Integer.MAX_VALUE;
        for(int i = 0; i<C; i++){
            int current = arr[i][0] + (arr[i][1] < 128 ? arr[i][1] : p(arr[i][1]));
            if(current < last){
                last = current;
            }
        }
        System.out.println(last);

    }

    static int p(int m){
        String str = Integer.toBinaryString(m);

        String exp_s = str.substring(1,4);
        String mant_s = str.substring(4,8);
        int exp = Integer.parseInt(exp_s, 2);
        int mant = Integer.parseInt(mant_s, 2);
        return (mant | 0x10) << (exp+3);
    }



}
