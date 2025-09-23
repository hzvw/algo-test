package com.zhang.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _041_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/18 1:25
 * @Version 1.0
 */
public class _041_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        List<List<Integer>> buffer = new ArrayList<>();
        for(int i = 0; i<N; i++){
            List<Integer> tmp = new ArrayList<>();
            for(int j = 0; j<D; j++){
                tmp.add(sc.nextInt());
            }
            buffer.add(tmp);
        }

        List<Integer> i1 = new ArrayList<>();
        for(List<Integer> tmp : buffer){
            int diff = 0;

            for(int i = 0; i<D-1; i++){
                int j = i+1;
                if(tmp.get(j) - tmp.get(i) > 0){
                    diff += tmp.get(j) - tmp.get(i);
                }

            }
            i1.add(diff);
        }

        int sum = 0;
        for(int i = 0; i<N; i++){
            sum += arr[i] * i1.get(i);
        }
        System.out.println(sum);


    }

}
