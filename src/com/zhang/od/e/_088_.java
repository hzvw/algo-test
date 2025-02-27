package com.zhang.od.e;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _088_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/27 17:35
 * @Version 1.0
 */
public class _088_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().replaceAll("[\\[|\\]]", "").split(",")).mapToInt(Integer::parseInt).toArray();
        int count = Integer.parseInt(sc.nextLine());

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new int[]{arr[i], i});
        }
        list.sort((a,b) -> a[0] != b[0] ? a[0]-b[0] : a[1]-b[1]);

        int minIdxSum = Integer.MAX_VALUE;
        int[] res = new int[3];
        for (int i = 0; i < list.size(); i++) {
            if(i > 0 && list.get(i)[0] == list.get(i-1)[0]){
                continue;
            }

            int left = i+1;
            int right = arr.length-1;

            while (left < right){
                if(list.get(i)[0] + list.get(left)[0] + list.get(right)[0] < count){
                    left++;
                }else if(list.get(i)[0] + list.get(left)[0] + list.get(right)[0] > count){
                    right--;
                }else{
                     while (left < right-1 && list.get(right)[0] == list.get(right-1)[0]){
                        right--;
                    }
                    int tmp = list.get(i)[1] + list.get(left)[1] + list.get(right)[1];
                    if(tmp < minIdxSum){
                        minIdxSum = tmp;
                        res[0] = list.get(i)[1];
                        res[1] = list.get(left)[1];
                        res[2] = list.get(right)[1];
                        Arrays.sort(res);
                    }
                    while (left +1< right && list.get(left)[0] == list.get(left+1)[0]){
                        left++;
                    }
                    left++;
                    right--;
                }
            }


        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < res.length; i++) {
            sb.append(arr[res[i]]);
            if(i != res.length-1){
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.print(sb.toString());
    }
}
