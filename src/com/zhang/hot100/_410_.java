package com.zhang.hot100;

import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: _410_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/25 15:00
 * @Version 1.0
 */
public class _410_ {


    public int splitArray(int[] nums, int k) {
        int N = nums.length;
        //

        return 0;
    }

    static void backtrace(int[] nums, LinkedList<Integer> path, int k, int i, int min, List<Integer> res){
        if(path.size() == k-1){
            res.add(path.stream().max((a,b) -> b-a).get());
            return;
        }

        int N = nums.length;
        for(int j = 0; j<=N-2; j++){
            path.addLast(j);
            backtrace(nums, path, k, i+1, min, res);
            path.removeLast();
        }
    }

    static int getMin(int[] nums, LinkedList<Integer> path){
//        path.sort((a,b) -> a-b);
//        if(path.size() == 1){
//            return
//        }
//
//        int i = path.get(0);
//        int j =
//        for(int i = 0; i<size; i++){
//            int j = path.get(j);
//        }
        return 0;

    };

    //做完第i个选择，能获得的最优解
    static int p(int i, int[] nums, int k, int sub_sum){
        if(i == k-1){
            //k个选择已经做完
            return sub_sum;
        }


        int res = 0;
        //很显然，第i个选择可以选择的地方很多，所以要用for循环去尝试
        for(int j = i; j<nums.length-1; j++){
            //
            sub_sum += nums[j];

            //做完i这个选择的情况下，i+1的选择形成的最小值是什么呢
            int i1 = p(i+1, nums, k, sub_sum);

            //两边要pk一下，到底把谁作为返回值
            if(sub_sum < i1){
                res = sub_sum;
            }else{
                res = i1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {7,2,5,10,8};
        int k = 3;
        System.out.println(p(0, arr, k, 0));


    }





}
