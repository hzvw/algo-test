package com.zhang.od.e;

import java.util.*;

/**
 * ClassName: _057_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/13 15:44
 * @Version 1.0
 */
public class _057_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        str = str.replaceAll("\\[|\\]", "");

        int[] arr = Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
        int n = arr.length /2;
        List<P> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(new P(arr[i*2], arr[i*2+1]));
        }
        list.sort((a,b) -> b.x != a.x ? b.x-a.x : b.y - a.y);
        int left = 1;
        int right = n;
        while(left <= right){
            int mid = (right + left)/2;
            if(check(mid, list)){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        System.out.println(right);
    }

    static boolean check(int mid, List<P> list){
        List<Integer> res = new LinkedList<>();
        dfs(0, mid, new LinkedList<>(), list, new boolean[list.size()], res);
        return res.size() > 0;
    }

    static void dfs(int level, int mid, LinkedList<P> buckets, List<P> list, boolean[] visited, List<Integer> res){
        if(level == mid){
            res.add(1);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if(res.size() > 0){
                return;
            }

            if(visited[i]){
                continue;
            }

            if(buckets.isEmpty() || (buckets.getLast().x > list.get(i).x && buckets.getLast().y > list.get(i).y)){
                if(i > 1 && list.get(i).x == list.get(i-1).x && list.get(i).y == list.get(i-1).y){
                    continue;
                }

                buckets.addLast(list.get(i));
                visited[i] = true;

                dfs(level+1, mid, buckets, list, visited, res);

                buckets.removeLast();
                visited[i] = false;
            }
        }
    }


    static class P{
        int x;
        int y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
