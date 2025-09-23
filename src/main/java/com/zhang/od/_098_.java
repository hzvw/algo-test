package com.zhang.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _098_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/23 3:07
 * @Version 1.0
 */
public class _098_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] arr = new int[N][5];

        List<P> buffer = new ArrayList<>();
        for(int i = 0; i<N; i++){
            for(int j = 0; j<5; j++){
                arr[i][j] = sc.nextInt();
            }
            int x = (arr[i][1] + arr[i][3])/2;
            int y = (arr[i][2] + arr[i][4])/2;
            int r = (arr[i][3] - arr[i][1])/2;
            buffer.add(new P(arr[i][0], x,y,r));
        }

        buffer.sort((a,b) -> a.y == b.y ? a.x-b.x : a.y-b.y);
        List<P> light = new ArrayList<>();
        P base = buffer.get(0);
        light.add(base);

        List<Integer> res = new ArrayList<>();
        for(int i = 1; i<buffer.size(); i++){
            P cur = buffer.get(i);

            if(Math.abs(cur.y- base.y) <= base.r){
                light.add(cur);
            }else{
                for(P p : light){
                    res.add(p.id);
                }
                light = new ArrayList<>();
                base = cur;
                light.add(base);
            }
        }

        if(light.size() > 0){
            for(P p : light){
                res.add(p.id);
            }
        }

        res.forEach(x-> System.out.print(x + " "));


    }

    static class P{

        int id;
        int x;
        int y;

        int r;

        public P(int id, int x, int y, int r){
            this.id = id;
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }

}
