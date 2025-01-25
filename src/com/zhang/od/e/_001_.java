package com.zhang.od.e;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _001_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/26 0:55
 * @Version 1.0
 */
public class _001_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int H = Integer.parseInt(sc.nextLine());

        if(H < arr.length){
            System.out.println(0);
        }else if(H == arr.length){
            System.out.println(Arrays.stream(arr).max().getAsInt());
        }else{
            System.out.println(p(arr, H));
        }


    }

    static int p(int[] arr, int H){
        int max = Arrays.stream(arr).max().getAsInt();
        int left = 1;
        int right = max;
        int mid = 0;
        int res = 0;
        while(left <= right){
            mid = (left + right)/2;
            if(check(arr, mid, H)){
                res = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return res;
    }

    static boolean check(int[] arr, int mid, int H){
        int cnt = 0;
        for(int ele : arr){
            cnt += ele / mid + (ele % mid == 0 ? 0 : 1);
        }

        if(cnt > H){
            return false;
        }
        return true;
    }

    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;  // 计算中点，防止溢出

            if (arr[mid] == target) {
                return mid;  // 找到目标，返回索引
            } else if (arr[mid] > target) {
                right = mid - 1;  // 在左半部分查找
            } else {
                left = mid + 1;  // 在右半部分查找
            }
        }
        return -1;  // 未找到返回 -1
    }

    static int binarySearch(int[] arr, int target, int i, int j){
        if(i > j){
            return -1;
        }
        int mid = (i+j) / 2;
        if(target < arr[mid]){
            return binarySearch(arr, target, i, mid-1);
        }else if(target > arr[mid]){
            return binarySearch(arr, target, mid+1, j);
        }else{
            return mid;
        }
    }




}
