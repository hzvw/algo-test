package com.zhang.od.e;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _051_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/2/12 22:10
 * @Version 1.0
 */
public class _051_ {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        List<List<Integer>> segs = new LinkedList<>();
        List<Integer> seg = new LinkedList<>();
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i-1];

            if(diff <= d){
                 seg.add(diff);
            }else{
                if(!seg.isEmpty()){
                    segs.add(seg);
                    seg = new LinkedList<>();
                }
            }
        }
        if(!seg.isEmpty()){
            segs.add(seg);
        }

        //如果差值群集合数量为0，说明没有任何两支队伍满足战力差值小于d
        if(segs.isEmpty()){
            System.out.println(-1);
            return;
        }

        int sum = 0;
        for (int i = 0; i < segs.size(); i++) {
            List<Integer> list = segs.get(i);
            sum += p(list, list.size() % 2 == 0, 0, 0);
        }
        System.out.println(sum);

    }



    // 每个差值群有一次跳过的机会
    static int p(List<Integer> seg, boolean canJump, int index, int sum){
        // 递归跳出的条件
        if(index >= seg.size()){
            return sum;
        }

        int min_diff = Integer.MAX_VALUE;
        int choose1 = p(seg, canJump, index+2, seg.get(index)+ sum);
        min_diff = choose1;
        if(canJump){
            int choose2 = p(seg, false, index+1, sum);
            if(choose2 < min_diff){
                min_diff = choose2;
            }
        }
        return min_diff;
    }

}
