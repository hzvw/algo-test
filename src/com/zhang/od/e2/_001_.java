package com.zhang.od.e2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _001_
 * Package: com.zhang.od.e2
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/2 3:52
 * @Version 1.0
 */
public class _001_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int h = Integer.parseInt(sc.nextLine());
        if(h == nums.length){
            System.out.println(Arrays.stream(nums).max());
            return;
        }else if(h < nums.length){
            System.out.println(0);
            return;
        }else{
            System.out.println(solve(nums, h));
            return;
        }



    }

    static int solve(int[] nums, int h){
        return 0;
    }

}
