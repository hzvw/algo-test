package com.zhang.od.e;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * ClassName: _017_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/1 14:29
 * @Version 1.0
 */
public class _017_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        int n = 0;
        int m = 0;
        int[] arr = null;
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            if(i % 2 == 0){
                String[] words = str.split(" ");
                n = Integer.parseInt(words[0]);
                m = Integer.parseInt(words[1]);
            }else{
                arr = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();

                if(p(n,m,arr)){
                    System.out.println("1");
                }else{
                    System.out.println("0");
                }
            }
            i++;
        }

    }


    static boolean p(int n, int m, int[] arr){
        int[] pre = new int[n+1];
        for(int i = 1; i<n+1; i++){
            pre[i] = pre[i-1] + arr[i-1];
        }

        // a%k == b%k
        // 等价于 (a-b) % k == 0
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i<n+1; i++){
            if(set.contains(pre[i] % m)){
                return true;
            }else{
                set.add(pre[i] % m);
            }
        }
        return false;
    }

}
