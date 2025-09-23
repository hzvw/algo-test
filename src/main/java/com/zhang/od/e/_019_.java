package com.zhang.od.e;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * ClassName: _019_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/1 16:20
 * @Version 1.0
 */
public class _019_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nm = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];

        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            List<Character> collect = Arrays.stream(sc.nextLine().split(",")).map(x -> x.charAt(0)).collect(Collectors.toList());

            for (int j = 0; j < collect.size(); j++) {
                arr[i][j] = collect.get(j);
            }
        }

        int[][] directions = new int[][]{{0,-1},{-1,-1},{-1,0},{-1,1}};
        int max = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){

                if(arr[i][j] != 'M'){
                    continue;
                }
                for(int[] dir : directions){
                    int last_x = i + dir[0];
                    int last_y = j + dir[1];

                    //已经搜索过了
                    if(last_x >=0 && last_x<n && last_y >=0 && last_y < m && arr[last_x][last_y] == 'M'){
                        continue;
                    }

                    int n_x = i - dir[0];
                    int n_y = j - dir[1];
                    if(n_x >= 0 && n_x < n && n_y >=0 && n_y < m && arr[n_x][n_y] != 'M'){
                        continue;
                    }

                    int len = 1;
                    while(n_x >= 0 && n_x < n && n_y >=0 && n_y < m &&arr[n_x][n_y] == 'M'){
                        len++;
                        if(len > max){
                            max = len;
                        }
                        n_x -= dir[0];
                        n_y -= dir[1];
                    }
                }
            }
        }
        System.out.println(max);


    }



}
