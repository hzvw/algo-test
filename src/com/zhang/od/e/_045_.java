package com.zhang.od.e;

import java.util.Scanner;

/**
 * ClassName: _052_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/2/2 23:46
 * @Version 1.0
 */
public class _045_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][5];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.next().charAt(0);
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
            arr[i][3] = sc.nextInt();
            arr[i][4] = sc.nextInt();
        }

        int min_x = Integer.MAX_VALUE;
        int max_x = Integer.MIN_VALUE;
        int min_y = Integer.MAX_VALUE;
        int max_y = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            min_x = Math.min(min_x, Math.min(arr[i][1],arr[i][3]));
            max_x = Math.max(max_x, Math.max(arr[i][1],arr[i][3]));
            min_y = Math.min(min_y, Math.min(arr[i][2],arr[i][4]));
            max_y = Math.max(max_y, Math.max(arr[i][2],arr[i][4]));
        }

        int[][] map = new int[max_x-min_x+1][max_y-min_y+1];
        for (int i = 0; i < n; i++) {
            int x1 = arr[i][1] - min_x;
            int y1 = arr[i][2] - min_y;
            int x2 = arr[i][3] - min_x;
            int y2 = arr[i][4] - min_y;
            if(arr[i][0] == 'd'){
                for (int j = x1; j <x2 ; j++) {
                    for (int k = y2; k <y1 ; k++) {
                        map[j][k] = 1;
                    }
                }
            }else{
                for (int j = x1; j <x2 ; j++) {
                    for (int k = y2; k <y1 ; k++) {
                        map[j][k] = 0;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int i1 = 0; i1 < map[i].length; i1++) {
                if(map[i][i1] == 1){
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}

/*
class Solution {
    public int rectangleArea(int[][] rectangles) {
        // 统计所有矩形的左边边、右边边所在位置的x坐标
        ArrayList<Integer> listX = new ArrayList<>();
        for (int[] rect : rectangles) {
            listX.add(rect[0]);
            listX.add(rect[2]);
        }

        // 所有x坐标升序（每个x视为一条扫描线）
        listX.sort((a, b) -> a - b);

        // 记录所有矩形并集面积
        long ans = 0;

        for (int i = 1; i < listX.size(); i++) {
            // 前一个扫描线x坐标
            int preX = listX.get(i - 1);
            // 当前扫描线x坐标
            int curX = listX.get(i);

            // 相邻两个扫描线的距离
            int width = curX - preX;

            // 距离为0, 则跳过
            if (width == 0)
                continue;

            // 将在[x1,x2]区间上的矩形片段（垂直方向高度区间）收集起来
            ArrayList<int[]> lines = new ArrayList<>();

            // 遍历每个矩形
            for (int[] rect : rectangles) {
                // 矩形左下角坐标(x1,y1), 矩形右上角坐标(x2,y2)
                int x1 = rect[0], y1 = rect[1], x2 = rect[2], y2 = rect[3];

                // 如果矩形包含了 [x1, x2] 区间
                if (x1 <= preX && curX <= x2) {
                    // 那么该矩形在 水平方向区间[x1, x2] 对应的 垂直方向区间为 [y1, y2]
                    lines.add(new int[] { y1, y2 });
                }
            }

            // 将处于水方向区间 [x1, x2] 的所有垂直方向区间排序：按照起始位置升序, 如果起始位置相同,则按照结束位置降序，
            // 这样排序的目的是保证排序后，前面的区间尽可能可以覆盖后面的区间
            lines.sort((lineA, lineB) -> lineA[0] != lineB[0] ? lineA[0] - lineB[0] : lineB[1] - lineA[1]);

            // 记录lines多个区间，求长度之和，（重叠部分只计算一次）
            int height = 0;

            int last_end = -1;
            for (int[] line : lines) {
                int start = line[0];
                int end = line[1];

                // 如果 last_end >= end, 则当前区间被上一个区间完全覆盖，因此可以跳过
                // 如果 last_end < end
                if (last_end < end) {
                    // 则当前区间的不重叠部分是 [max(start, last_end), end]
                    height += end - Math.max(start, last_end);
                    // 更新last_end
                    last_end = end;
                }
            }

            // 当前扫描线扫描到的面积为 width * height
            ans += (long) width * height;
            ans %= (int) (1e9 + 7);
        }

        return (int) ans;
    }
}*/
