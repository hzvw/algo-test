package com.zhang.od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _066_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/19 21:30
 * @Version 1.0
 */
public class _066_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(p(arr));
    }

    static int p(int[] arr){
        int N = arr.length;
        Arrays.sort(arr);
        if(arr[0] == 0){
            return 1;
        }

        boolean[] flag = new boolean[N];
        int cnt = 0;
        for(int i = 0; i<N; i++){
            if(flag[i] == true){
                continue;
            }
            flag[i] = true;
            for(int j = i+1; j<N; j++){
                if(!flag[j] && arr[j] % arr[i] == 0){
                    flag[j] = true;
                }
            }
            cnt++;
        }
        return cnt;
    }

}
