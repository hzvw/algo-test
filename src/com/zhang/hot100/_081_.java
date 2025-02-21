package com.zhang.hot100;

/**
 * ClassName: _081_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/22 0:34
 * @Version 1.0
 */
public class _081_ {

    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }

        int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 3; i < n+1; i++) {
            c = a+b;
            a = b;
            b = c;
        }

        return c;
    }
}
