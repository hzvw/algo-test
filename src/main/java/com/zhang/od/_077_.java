package com.zhang.od;

import java.util.*;

/**
 * ClassName: _077_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/21 0:18
 * @Version 1.0
 */
public class _077_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String line = sc.nextLine();

        int[][] buffer = new int[N][2];
        for(int i =0;i<N; i++){
            buffer[i][1] = -1;
        }
        for(int i = 0; i<30; i++){
            int[]  arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for(int j = 0; j<arr.length; j++){
                buffer[arr[j]][0]++;
                if(buffer[arr[j]][1] == -1){
                    buffer[arr[j]][1] = i;
                }
            }
        }

        List<P> res = new ArrayList<>();
        for(int i = 0; i<N; i++){
            int id = i;
            int first = buffer[i][1];
            int cnt = buffer[i][0];

            if(cnt != 0){
                res.add(new P(id, first, cnt));
            }

        }

        res.sort(new Comparator<P>() {
            @Override
            public int compare(P o1, P o2) {
                if(o1.cnt == o2.cnt){
                    if(o1.first == o2.first){
                        return Integer.compare(o1.id, o2.id);
                    }else{
                        return o1.first - o2.first;
                    }
                }else{
                    return o2.cnt - o1.cnt;
                }
            }
        });
        if(res.size() >= 5){
            res.stream().limit(5).forEach(x-> System.out.print(x.id+ " "));
        }else{
            res.stream().forEach(x -> System.out.print(x.id + " "));
        }

    }

    static class P{
        int id;
        int first;
        int cnt;

        public P(int id, int first, int cnt){
            this.id = id;
            this.first = first;
            this.cnt = cnt;
        }
    }


}
