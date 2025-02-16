package com.zhang.od.e;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * ClassName: _081_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/16 20:02
 * @Version 1.0
 */
public class _081_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(sc.nextLine());
        HashSet<Integer> idx = new HashSet<>();

        compute(arr, idx, true, k);
        rev(arr);
        compute(arr, idx, false, k);

        System.out.println(idx.size());
    }

    private static void compute(int[] arr, HashSet<Integer> idx, boolean b,int  k) {
        int j = 0;
        int n = arr.length;
        while(j < n && arr[j] != 0){
            j++;
        }

        int cost = 0;

        for (int i = j+1; i < n; i++) {
            if(arr[i] == 0){
                cost = 0;
                continue;
            }

            int diff = arr[i] - arr[i-1];
            if(diff > 0){
                cost += 3 * diff;
                if(i+1 >= n || arr[i] > arr[i+1]){
                    if(cost < k){
                        if(b){
                            idx.add(i);
                        }else{
                            idx.add(n-i-1);
                        }
                    }
                }
            }else if(diff == 0){

            }else{
                cost -= 3 * diff;
            }
        }

    }

    static void rev(int[] arr){
        int i = 0;
        int j = arr.length - 1;

        while(i<j){
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
