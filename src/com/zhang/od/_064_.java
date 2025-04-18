package com.zhang.od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _064_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/19 19:26
 * @Version 1.0
 */
public class _064_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int minA = Integer.parseInt(sc.nextLine());

        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        p(minA, arr);


    }

    static void p(int minA, int[] arr){
        List<int[]> buffer = new ArrayList<>();
        int n = arr.length;
        int[] pre = new int[arr.length+1];
        for (int i = 1; i <= n  ; i++) {
            pre[i] = pre[i-1] + arr[i-1];
        }

        int max_len = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n ; j++) {
                int len = j - i + 1;
                int sum = pre[j+1] - pre[i];
                if(minA * len >= sum){
                    if(len >= max_len){
                        if(len > max_len){
                            buffer = new ArrayList<>();
                        }
                        buffer.add(new int[]{i, j});
                        max_len = len;
                    }
                }
            }
        }

        if(buffer.size() == 0){
            System.out.println("NULL");
            return;
        }
        buffer.sort((a,b) -> a[0] - b[0]);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<buffer.size(); i++){
            int start = buffer.get(i)[0];
            int end = buffer.get(i)[1];

            sb.append(start + "-"+ end);

            if(i != buffer.size()-1){
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }




}
