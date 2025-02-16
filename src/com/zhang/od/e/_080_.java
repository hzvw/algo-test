package com.zhang.od.e;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * ClassName: _080_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/16 18:06
 * @Version 1.0
 */
public class _080_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[][] lines = new int[n][];
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < n; i++) {
            lines[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int ans = compute(lines[i]);
            sj.add(ans+"");
        }
        System.out.println(sj.toString());

    }

    static int[][] matrix = new int[64][64];

    static  int[][] directions = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
    private static int compute(int[] line) {
        int num = line[0];
        int count = 0;
        int n = line.length / 2;
        for (int i = 0; i < n; i++) {
            int x = line[i * 2 + 1];
            int y = line[i * 2 + 2];
            matrix[x][y] = num;
        }
        for (int i = 0; i < n; i++) {
            int x = line[i*2 + 1];
            int y = line[i*2 + 2];

            if(matrix[x][y] != num){
                continue;
            }
            for (int[] direction : directions) {
                int n_x = x + direction[0];
                int n_y = y + direction[1];

                if(n_x <0 || n_x >= 64 || n_y < 0 || n_y >= 64 || matrix[n_x][n_y] != num){
                    count++;
                }
            }

        }
        return count;
    }


}
