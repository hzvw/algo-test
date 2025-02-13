package com.zhang.od;

import java.util.*;

/**
 * ClassName: _083_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/21 21:16
 * @Version 1.0
 */
public class _083_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr1 = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int M = arr1[0];
        int N = arr1[1];

        if(M < 3 || M > 10){
            System.out.println(-1);
            return;
        }

        if(N < 3 || N >100){
            System.out.println(-1);
            return;
        }

        int[][] A = new int[N+1][11];//每个得分各多少个
        int[] B = new int[N+1];//总分

        //评委
        for(int i = 1; i<=M; i++){
            int[] arr = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            //选手
            for(int j = 1; j<=N; j++){
                if(arr[j-1] < 1 || arr[j-1] > 10){
                    System.out.println(-1);
                    return;
                }
                int t = arr[j-1];
                A[j][t]++;
                B[j] += t;
            }
        }

        List<Integer> buffer = new ArrayList<>();
        for(int i = 1; i<=N; i++){
            buffer.add(i);
        }

        StringJoiner sj = new StringJoiner(",");

        buffer.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                if(B[i1] == B[i2]){
                    int j = 10;
                    while(j >= 0){
                        if(A[i1][j] > A[i2][j]){
                            return -1;
                        }else if(A[i1][j] < A[i2][j]){
                            return 1;
                        }else{
                            // go on
                        }
                        j--;
                    }
                }else{
                    return B[i2] - B[i1];
                }
                return 0;
            }
        }).limit(3).forEach(x -> sj.add(x+""));

        System.out.println(sj.toString());
    }



}
