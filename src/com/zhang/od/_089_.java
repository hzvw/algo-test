package com.zhang.od;

import java.util.*;

/**
 * ClassName: _089_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/22 17:22
 * @Version 1.0
 */
public class _089_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        HashMap<Integer, P> map = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            P p = map.get(arr[i]);
            if(p == null){
                p = new P();
                p.num = arr[i];
                p.first_i = i;
                p.cnt = 1;
                map.put(arr[i], p);
            }else{
                p.cnt++;
            }
        }

        List<P> buffer = new ArrayList<>();
        for(int arri : map.keySet()){
            buffer.add(map.get(arri));
        }

        buffer.sort(new Comparator<P>() {
            @Override
            public int compare(P o1, P o2) {
                if(o1.cnt == o2.cnt) {
                    return o1.first_i - o2.first_i;
                }else{
                    return o2.cnt - o1.cnt;
                }
            }
        });
        StringJoiner joiner = new StringJoiner(",");
        buffer.stream().forEach(x->joiner.add(x.num+""));
        System.out.println(joiner.toString());


    }

    static class P{
        int num;
        int first_i;
        int cnt = 0;
    }

}
