package com.zhang.od;

import java.util.*;

/**
 * ClassName: _085_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/22 0:29
 * @Version 1.0
 */
public class _085_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Integer[] arr = new Integer[M-N+1];
        for(int i = 0; i<=M-N; i++){
            int k = N+i;
            arr[i] = k * k;
        }

        HashSet<Integer> set = new HashSet<>();
        Collections.addAll(set, arr);

        List<String> res = new ArrayList<>();

        for(int i = 0; i<=M-N; i++){
            for(int j = i+1; j<=M-N; j++){
                int sum = arr[i] + arr[j];
                if(set.contains(sum)){
                    int a = (int)Math.sqrt(arr[i]);
                    int b = (int) Math.sqrt(arr[j]);
                    int c = (int)Math.sqrt(sum);

                    if(p(a,b) || p(a,c) || p(b,c)){
                        res.add(a + " " + b + " " + c);
                    }
                }
            }
        }
        if(res.size() > 0){
            res.forEach(System.out::println);
        }else{
            System.out.println("NA");
        }

    }

    static boolean p(int x, int y){
//        if(x < y ){
//            int t = x;
//            x = y;
//            y = t;
//        }
//
//        int res = p1(x, y);
//        if(res == 1){
//            return true;
//        }else{
//            return false;
//        }
        return isRelativePrime(x,y);
    }

    static int p1(int x, int y){
      if(x % y == 0){
          return y;
      }else{
          return p1(y, x % y);
      }
    };

    // 判断两个数是否互质，辗转相除
    public static boolean isRelativePrime(int x, int y) {
        while (y > 0) {
            int mod = x % y;
            x = y;
            y = mod;
        }
        return x == 1;
    }

}
