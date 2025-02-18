package com.zhang.hot100;

import java.util.*;

/**
 * ClassName: _014_
 * Package: com.zhang.hot100
 * Description: 合并区间
 *
 * @Author Harizon
 * @Create 2025/2/18 17:29
 * @Version 1.0
 */
public class _014_ {
    public static void main(String[] args) {


    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] != b[0] ? a[0]-b[0] : a[1] - b[1]);

        int last_start = intervals[0][0];
        int last_end = intervals[0][1];

        LinkedList<int[]> res = new LinkedList<>();
        res.add(intervals[0]);

        int[] last = res.getLast();
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(start == last[0]){
                last[1] = end;
            }else if(start <= last[1]){
                if(end <= last[1]){

                }else{
                    last[1] = end;
                }
            }else{
                res.add(intervals[i]);
                last = intervals[i];
            }
        }
        int[][] arr = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
