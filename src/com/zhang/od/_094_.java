package com.zhang.od;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _094_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/22 23:37
 * @Version 1.0
 */
public class _094_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        List<R> buffer = new ArrayList<>();
        for(int i = 0; i<N; i++){
            R r = new R();
            r.start = i*100 - arr[i];
            r.end = i*100 + arr[i];

            buffer.add(r);
        }

        buffer.sort(new Comparator<R>() {
            @Override
            public int compare(R o1, R o2) {
                if(o1.start == o2.start){
                    if(o1.end == o2.end){
                        return -1;
                    }else{
                        return o2.end - o1.end;
                    }
                }else{
                    return o1.start - o2.start;
                }
            }
        });


        int last_start = buffer.get(0).start;
        int last_end = buffer.get(0).end;
        int len = 0;
        for(int i = 1; i<buffer.size(); i++){
            int start = buffer.get(i).start;
            int end = buffer.get(i).end;

            if(start < last_end){
                //有交集
                last_end = Math.max(last_end, end);
            }else{
                //
                int diff = start - last_end;
                len += diff;

                last_end = end;
                last_start = start;
            }
        }

        System.out.println(len);



    }

    static class R{
        int start;
        int end;
    }

}
