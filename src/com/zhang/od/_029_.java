package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _029_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/16 22:37
 * @Version 1.0
 */
public class _029_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int w1 = sc.nextInt();
        int h1 = sc.nextInt();

        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int w2 = sc.nextInt();
        int h2 = sc.nextInt();

        int x3 = sc.nextInt();
        int y3 = sc.nextInt();
        int w3 = sc.nextInt();
        int h3 = sc.nextInt();

        int w = MIN(x1+w1,x2+w2,x3+w3) - MAX(x1,x2,x3);
        int h = MIN(y1,y2,y3) - MAX(y1-h1,y2-h2,y3-h3);

        if(w < 0 || h < 0 ){
            System.out.println(0);
        }else{
            System.out.println(w * h);
        }



    }

    static int MAX(int i, int j, int k){
        return Math.max(i, Math.max(j,k));
    }

    static int MIN(int i, int j, int k){
        return Math.min(i, Math.min(j,k));
    }

}
