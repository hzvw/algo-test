package com.zhang.od;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ClassName: _020_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/15 13:50
 * @Version 1.0
 */
public class _020_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int N = sc.nextInt();//总投资额
        int risk = sc.nextInt();//可接受的总风险
        int[] A = new int[m];//投资回报率
        int[] B = new int[m];//风险
        int[] C = new int[m];//最大投资额

        for (int i = 0; i<m; i++){
            A[i] = sc.nextInt();
        }
        for(int i = 0; i<m; i++){
            B[i] = sc.nextInt();
        }
        for(int i = 0; i<m; i++){
            C[i] = sc.nextInt();
        }

        int max_profile = 0;
        Map<Integer, Integer> buffer = new HashMap<>();
        for(int i = 0; i<m; i++){
            if(B[i] > risk){
                continue;
            }else {
                //投资额
                int i1 = Math.min(N, C[i]);
                //投资收益
                int i2 = i1 * A[i];

                if(i2 > max_profile){
                    max_profile = i2;
                    buffer.clear();
                    buffer.put(i, i1);
                }

            }

            for(int j = i+1; j<m; j++){
                if(B[i] + B[j] > risk){
                    continue;
                }else{
                    int profile_i = 0;
                    int profile_j = 0;
                    int i1 = 0;
                    int j1 = 0;

                    //优先投资回报率大的
                    if(A[i] > A[j]){
                        //投资额
                        i1 = Math.min(N, C[i]);
                        j1 = Math.min(N-i1, C[j]);
                        //收益
                        profile_i = i1 * A[i];
                        profile_j = j1 * A[j];
                    }else{
                        //投资额
                        j1 = Math.min(N, C[j]);
                        i1 = Math.min(N-j1, C[i]);

                        //收益
                        profile_i = i1 * A[i];
                        profile_j = (j1) * A[j];
                    }
                    if(profile_i + profile_j > max_profile){
                        max_profile = profile_i + profile_j;
                        buffer.clear();
                        if(profile_i > 0) buffer.put(i, i1);
                        if(profile_j>0) buffer.put(j, j1);
                    }
                }



            }
        }

        for(int i = 0; i<m; i++){
            if(buffer.get(i) != null){
                System.out.print(buffer.get(i) + " ");
            }else{
                System.out.print("0 ");
            }
        }
        System.out.println();



    }



}
