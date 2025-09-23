package com.zhang.od2._100;

import java.util.*;

/**
 * ClassName: _020_
 * Package: com.zhang.od2._100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/31 15:23
 * @Version 1.0
 */
public class _020_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr1 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int a = arr1[0];// 产品数
        int b = arr1[1];// 总投资额
        int c = arr1[2];// 可接受的总风险

        // 投资回报率序列
        int[] arr2 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 风险值序列
        int[] arr3 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 最大投资额度序列
        int[] arr4 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();;

        // 记录每种产品最后的投资额
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int profile = 0;

        for (int i = 0; i < a; i++) {
            if(arr3[i] > c){
                continue;
            }else{
                // 投资额
                int i1 = Math.min(arr4[i], b);
                if(i1 * arr2[i] > profile){
                    profile = i1 + arr2[i];
                    map.clear();
                    map.put(i, i1);
                }
            }

            for (int j = i+1; j < a; j++) {
                if(arr3[i] + arr3[j] > c){
                    continue;
                }else{
                    if(arr2[i] > arr2[j]){
                        int i1 = Math.min(arr4[i], b);
                        int j1 = Math.min(arr4[j], b - i1);

                        int t = i1 * arr2[i] + j1 * arr2[j];
                        if(t > profile){
                            profile = t;
                            map.clear();
                            map.put(i, i1);
                            map.put(j, j1);
                        }
                    }else{
                        int j1 = Math.min(arr4[j], b);
                        int i1 = Math.min(arr4[i], b-j1);

                        int t = i1 * arr2[i] + j1 * arr2[j];
                        if(t > profile){
                            profile = t;
                            map.clear();
                            map.put(i, i1);
                            map.put(j, j1);
                        }
                    }
                }
            }

        }
        for (int i = 0; i < a; i++) {
            if(map.containsKey(i)){
                System.out.print(map.get(i) + " ");
            }else {
                System.out.print("0 ");
            }
        }

    }
}
