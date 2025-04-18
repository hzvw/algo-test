package com.zhang.od;

import java.util.*;

/**
 * ClassName: _085_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/22 0:29
 * @Version 1.0
 */
public class _085_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Integer[] nums = new Integer[m-n+1];
        for (int i = n; i <=m ; i++) {
            nums[i-n] = i * i;
        }
        Set<Integer> set = new HashSet<>();
        Collections.addAll(set, nums);
        List<String> res = new ArrayList<>();
        for (int i = 0; i <=m-n ; i++) {
            for (int j = i+1; j <=m-n ; j++) {
                int sum = nums[i] + nums[j];
                if(set.contains(sum)){
                    int a = (int) Math.sqrt(nums[i]);
                    int b = (int) Math.sqrt(nums[j]);
                    int c = (int) Math.sqrt(sum);

                    if(p(a,b) && p(a,c) && p(b,c)){
                        res.add(a + " " + b + " " +c);
                    }
                }
            }
        }
        if(res.size() == 0){
            System.out.println("NA");
            return;
        }
        for (String s : res) {
            System.out.println(s);
        }

    }

    // 判断两个数是否互质，辗转相除
    static boolean p(int x, int y){
        while (y > 0){
            int mod = x % y;
            x = y;
            y = mod;
        }
        return x == 1;
    }



}
