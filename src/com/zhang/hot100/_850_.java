package com.zhang.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: _850_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/3 1:54
 * @Version 1.0
 */
public class _850_ {

    public static void main(String[] args) {


//        new _850_().rectangleArea();

    }

    //rectangles = [[0,0,2,2],[1,0,2,3],[1,0,3,1]]
    public int rectangleArea(int[][] arr) {
        long ans = 0L;
        List<Integer> x_list = new ArrayList<>();
        // 横坐标纳入集合
        for(int[] ints : arr){
            x_list.add(ints[0]);
            x_list.add(ints[2]);
        }
        //升序
        x_list.sort((a,b) -> a-b);

        for(int i = 1; i<x_list.size(); i++){
            int last_x = x_list.get(i-1);
            int cur_x = x_list.get(i);
            if(cur_x == last_x){
                continue;
            }

            int width = cur_x - last_x;

            List<int[]> line_y = new ArrayList<>();
            for(int[] ints : arr){
                int x1 = ints[0];
                int y1 = ints[1];
                int x2 = ints[2];
                int y2 = ints[3];
                if(x1<=last_x && x2>=cur_x){
                    line_y.add(new int[]{y1, y2});
                }
            }
            line_y.sort((a,b)->a[0]!=b[0]? a[0]-b[0] : b[1]-a[1]);

            int last_end = -1;
            int h =0;
            for(int[] is : line_y){
                int start = is[0];
                int end = is[1];

                if(last_end < end){
                    h += end - Math.max(last_end, start);
                    last_end = end;
                }
            }
            ans += (long) width * h;
            ans = ans % (int)(1e9 + 7);
        }

        return (int) ans;
    }




}
