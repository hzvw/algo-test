package com.zhang.od.e;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _041_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/31 3:15
 * @Version 1.0
 */
public class _041_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            int si = sc.nextInt();
            int ei = sc.nextInt();

            list.add(new int[]{si,ei});
            max = Math.max(max, Math.max(si,ei));
        }

        int[] count = new int[max+1];
        for(int[] ints : list){
            if(ints[0] == ints[1]){
                count[ints[0]]++;
                continue;
            }
            for(int j = ints[0]; j<=ints[1]; j++){
                count[j]++;
            }
        }

        System.out.println(Arrays.stream(count).max().getAsInt());



    }

}
