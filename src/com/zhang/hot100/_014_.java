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
        Arrays.sort(intervals, (a,b) -> a[0] != b[0] ? a[0]-b[0] : b[1]- a[1]);
        LinkedList<int[]> list = new LinkedList<>();
        list.add(new int[]{intervals[0][0], intervals[0][1]});

        int last_start = intervals[0][0];
        int last_end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(start == last_start){
                continue;
            }else if(start > last_start){
                if(start < last_end){
                    if(end <= last_end){
                        continue;
                    }else{
                        last_end = end;
                        list.getLast()[1] = end;
                    }
                }else if(start == last_end){
                    last_end = end;
                    list.getLast()[1] = end;
                }else{
                    last_start = start;
                    last_end = end;

                    list.add(new int[]{start, end});
                }
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
