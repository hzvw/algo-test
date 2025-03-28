package com.zhang.od2._100;

import java.util.*;

/**
 * ClassName: _001_
 * Package: com.zhang.od2._100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/29 0:00
 * @Version 1.0
 */
public class _001_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 记录启动时刻
        int[] time = new int[n];
        Arrays.fill(time, 1000);
        for (int i = 0; i < nums.length; i += 2) {

            int p = nums[i];//发动机的位置编号
            int t = nums[i+1];//手动启动时刻
            time[p] = t;
        }

        // 假设位置为i的发动机启动时间为time[i]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int inDis = Math.abs(i-j);
                int outDis = n-inDis;

                int dis = Math.min(inDis, outDis);

                time[j] = Math.min(time[j], time[i] + dis);
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(time[i] + " ");
        }

//        List<Integer> res = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            if(res.size() == 0){
//                res.add(i);
//            }else{
//                if(time[res.get(0)] == time[i]){
//                    res.add(i);
//                }else if(time[res.get(0)] > time[i]){
//                    continue;
//                }else{
//                    res.clear();
//                    res.add(i);
//                }
//            }
//        }
//        System.out.println(res.size());
//        for (Integer i : res) {
//            System.out.print(i + " ");
//        }

    }

}
