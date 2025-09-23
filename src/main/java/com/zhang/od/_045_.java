package com.zhang.od;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _045_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/18 12:47
 * @Version 1.0
 */
public class _045_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] arr = new int[r][c];

        HashMap<Integer, List<P>> buffer = new HashMap<>();
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                arr[i][j] = sc.nextInt();
                if(buffer.get(arr[i][j]) != null){
                    List<P> t = buffer.get(arr[i][j]);
                    t.add(new P(i,j));
                }else{
                    List<P> t = new ArrayList<>();
                    t.add(new P(i,j));
                    buffer.put(arr[i][j], t);
                }
            }
        }

        int[][] res = new int[r][c];
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                List<P> t = buffer.get(arr[i][j]);
                if(t.size() == 1){
                    //System.out.println(-1);
                    res[i][j] = -1;
                }else{
                    int diff = Integer.MAX_VALUE;
                    for(P p : t){
                        if(i == p.x && j == p.y){
                            continue;
                        }else{
                            diff =Math.min(diff, Math.abs(i - p.x) + Math.abs(j-p.y)) ;
                        }
                    }
                    //System.out.println(diff);
                    res[i][j] = diff;
                }
            }
        }
        System.out.println(my_print(res));

    }

    static String my_print(int[][] arr){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i<arr.length; i++){
            sb.append("[");

            for(int j = 0; j<arr[0].length; j++){
                sb.append(arr[i][j]);
                if(j != arr[0].length-1){
                    sb.append(", ");
                }
            }
            sb.append("]");
            if(i != arr.length-1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    static class P{
        int x;
        int y;

        public P(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
