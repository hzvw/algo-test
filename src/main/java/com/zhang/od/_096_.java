package com.zhang.od;

import java.util.*;
/**
 * ClassName: _096_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/23 2:29
 * @Version 1.0
 */
public class _096_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        int index = line.lastIndexOf(',');
        int[] arr = Arrays.stream(line.substring(1, index - 1).split(",")).mapToInt(Integer::parseInt).toArray();

        int k = Integer.parseInt(line.substring(index+1, line.length()));

        int N = arr.length;

        int mid = Arrays.stream(arr).sorted().toArray()[N/2];

        int window = arr[0];
        for(int i = 1; i<=k-1; i++){
            window -= arr[i];
        }

        int min_diff = Math.abs(window - mid);
        int res = 0;

        for(int i = 1; i<=N-k; i++){
            window = window - arr[i-1] + 2 * arr[i] - arr[i+k-1];
            int diff = Math.abs(window- mid);
            if(diff  <= min_diff){
                min_diff = diff;
                res = i;
            }
        }
        System.out.println(res);


    }


}
