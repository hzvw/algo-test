package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _024_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/16 19:28
 * @Version 1.0
 */
public class _024_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long N = sc.nextLong();
        System.out.println(p(N));
    }

    static int p(Long x){
        if(x == 1){
            return 0;
        }
        if(x % 2 == 0){
            return 1 + p(x/2);
        }else{
            return 1 + Math.min(p(x+1), p(x-1));
        }
    }

}
