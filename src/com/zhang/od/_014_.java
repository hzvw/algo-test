package com.zhang.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _014_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/14 19:41
 * @Version 1.0
 */
public class _014_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for(int i = 0; i<n1; i++){
            arr1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for(int i = 0; i<n2; i++){
            arr2[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        List<Integer> pairs = new ArrayList<>();
        for(int i : arr1){
            for(int j : arr2){
                pairs.add(i+j);
            }
        }

        pairs.sort((x,y) -> x-y);
        int sum = 0;
        for(int i = 0; i<k ;i++){
            sum += pairs.get(i);
        }
        System.out.println(sum);

    }

}
