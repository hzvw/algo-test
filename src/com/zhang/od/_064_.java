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
 * @Author 张汉至
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
        int n = arr.length;
        int[] t = new int[n+1];
        for(int i = 1; i<n+1; i++){
            t[i] = t[i-1] + arr[i-1];
        }

        List<int[]> buffer = new ArrayList<>();
        int min_length = 0;
        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                int sum = t[j+1] - t[i];
                int i1 = minA * (j-i+1);

                int len = j-i+1;
                if(sum <= i1){
                    if(len >= min_length){
                        if(len > min_length){
                            buffer = new ArrayList<>();
                        }
                        min_length = len;
                        buffer.add(new int[]{i, j});
                    }
                }
            }
        }

//        for(int[] i : buffer){
//            System.out.println(i[0] + ":" + i[1]);
//        }

        if(buffer.size() == 0){
            System.out.println("NULL");
            return;
        }

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
