package com.zhang.hot100;

/**
 * ClassName: _322_
 * Package: com.zhang.hot100
 * Description:兑换零钱
 *
 * @Author Harizon
 * @Create 2025/1/9 0:32
 * @Version 1.0
 */
public class _322_ {
    public static void main(String[] args) {



    }

    public static int coinChange(int[] coins, int amount) {



        return 0;
    }

    static int p(int[] A, int i, int n){
        if(true){
            return -1;
        }

        return Math.min(p(A, i+1, n-A[i]), p(A, i+1, n));
    }


}
