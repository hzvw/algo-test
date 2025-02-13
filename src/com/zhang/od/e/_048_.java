package com.zhang.od.e;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _048_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/11 19:41
 * @Version 1.0
 */
public class _048_ {

    static int[] arr;
    static int days;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        days = Integer.parseInt(sc.nextLine());

        if(days >= arr.length){
            System.out.println(0);
            return;
        }

        int left = 0;
        int right = Arrays.stream(arr).sum();
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(check(mid)){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        System.out.println(left);
    }

    /**
     *
     * @param T 这么多天中，最多的耗时
     * @return
     */
    static boolean check(int T){
        int day = 1;//实际消耗的天数
        int i = 0;
        int max_cost = 0;
        int sum_cost = 0;
        boolean canHelp = true;
        while(i < arr.length){
            sum_cost += arr[i];
            max_cost = Math.max(max_cost, arr[i]);

            if(sum_cost <= T){
                i++;
            }else{
                if(canHelp){
                    sum_cost -= max_cost;
                    canHelp = false;
                    i++;
                }else{
                    day++;
                    canHelp = true;
                    sum_cost = 0;
                    max_cost = 0;
                }
            }
        }
        return day<=days;
    }


}
