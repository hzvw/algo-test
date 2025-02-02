package com.zhang.od.e;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _035_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/2/2 17:22
 * @Version 1.0
 */
public class _035_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] arr = new int[N][2];
        for(int i = 0; i<N; i++){
            int start = sc.nextInt();
            int end = start + sc.nextInt();

            arr[i][0] = start;
            arr[i][1] = end;
        }

        Arrays.sort(arr, (a,b)-> a[1]- b[1]);

        int count = 1;
        int last_end = arr[0][1];
        for(int i = 1; i<N; i++){
            if(arr[i][0] - last_end >= 15){
                count++;
                last_end = arr[i][1];
            }
        }
        System.out.println(count);

    }

}
