package com.zhang.od.e;

import java.util.*;

/**
 * ClassName: _036_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/30 0:48
 * @Version 1.0
 */
public class _036_ {
    static HashMap<Integer, Integer> map = new HashMap<>();
    static{
        map.put(2,5);
        map.put(5,2);
        map.put(6,9);
        map.put(9,6);
    }

    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        nums = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        n = nums.length;
        visited = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            res.add(nums[i] + "");
            if(map.get(nums[i]) != null){
                res.add(map.get(nums[i]) + "");
            }
        }

        dfs(0);

        List<Integer> ret = new ArrayList<>();
        res.forEach(x -> ret.add(Integer.parseInt(x)));

        ret.sort((x,y) -> Integer.compare(x,y));

        System.out.println(ret.get(Arrays.stream(nums).boxed().max((a,b)->a-b).get()-1));

    }

    static LinkedList<Integer> buckets = new LinkedList<>();

    static boolean[] visited ;

    static int n;

    static int[] nums;

    static void dfs(int level){
        if(level == n){
            res.add(buckets.stream().map( x -> x+"").reduce("", String::concat));
            return ;
        }

        for(int i = 0; i<nums.length; i++){
            if(visited[i]){
                continue;
            }
            if(map.get(nums[i]) != null){
                int[] tmp = new int[]{nums[i], map.get(nums[i])};
                for(int j = 0; j<2; j++){
                    buckets.addLast(tmp[j]);
                    visited[i] = true;

                    dfs(i+1);
                    buckets.removeLast();
                    visited[i] = false;
                }
            }else{
                buckets.addLast(nums[i]);
                visited[i] = true;

                dfs(i+1);
                buckets.removeLast();
                visited[i] = false;
            }
        }

    }



}
