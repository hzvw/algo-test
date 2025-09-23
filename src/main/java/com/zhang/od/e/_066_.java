package com.zhang.od.e;

import java.util.Scanner;

/**
 * ClassName: _066_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/15 21:43
 * @Version 1.0
 */
public class _066_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int t = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int ans = 0;
        if((t-s) % b == 0){
            ans = 0;
            System.out.println(ans);
            return;
        }else{
            int i = 1;
            while (true){
                if((t - s - i * a) % b == 0 || (t - s + i * a) % b == 0){
                    break;
                }
                i++;
            }
            ans = i;
        }
        System.out.println(ans);

    }

}
