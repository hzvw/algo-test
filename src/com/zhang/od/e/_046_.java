package com.zhang.od.e;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ClassName: _046_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/2/11 15:44
 * @Version 1.0
 */
public class _046_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int k = Integer.parseInt(sc.nextLine());

        List<List<Integer>> lists = new ArrayList<>();
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            List<Integer> collect = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
            lists.add(collect);
        }

        int[] arr = new int[k*n];

        int idx = 0;
        int level = 0;


        while(idx < arr.length){
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                arr[idx] = lists.get(level).remove(0);
                idx++;

                if(lists.get(level).size() == 0){
                    lists.remove(level);
                    level = level % lists.size();
                    flag = true;
                }
            }
            if(!flag){
                level++;
                level = level % lists.size();
            }
        }
        StringJoiner sj = new StringJoiner(" ");

        //按列打印，先打印列，再打印行
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < k; i++) {
                sj.add(arr[i*n + j] + "");
            }
        }
        System.out.println(sj.toString());
    }

}
