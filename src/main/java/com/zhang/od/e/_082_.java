package com.zhang.od.e;

import java.sql.SQLOutput;
import java.util.*;

/**
 * ClassName: _082_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/16 20:30
 * @Version 1.0
 */
public class _082_ {
    static int n;
    static int m;
    static int[][] matrix;

    static int k ;

    static int[] target;

    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        matrix = new int[n][m];
        for (int i = 0; i < m; i++) {
            list.add(new ArrayList<>());
        }
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
                list.get(j).add(matrix[i][j]);
                count.put(matrix[i][j], 0);
            }
        }
        k = sc.nextInt();
        target = new int[k];

        for (int i = 0; i < k; i++) {
            target[i] = sc.nextInt();
            if(!count.containsKey(target[i])){
                System.out.println(-1);
                return;
            }
            count.put(target[i], count.get(target[i]) + 1);
        }

        int min_len = Integer.MAX_VALUE;
        int target_len = k;
        int i = 0;
        int j = 0;
        while(j < m){
            List<Integer> c = list.get(j);
            for (Integer p : c) {
                if(count.get(p) > 0){
                    target_len--;
                }
                count.put(p, count.get(p)-1);
            }

            while(target_len == 0){
                if(min_len > j-i+1){
                    min_len = j-i+1;
                }

                List<Integer> tmp = list.get(i);
                for (Integer q : tmp) {
                    if(count.get(q) >= 0){
                        target_len++;
                    }
                    count.put(q, count.get(q) + 1);
                }
                i++;
            }

            j++;
        }
        System.out.println(min_len == Integer.MAX_VALUE ? -1 : min_len);
    }

}
