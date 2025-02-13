package com.zhang.od;

import java.util.*;

/**
 * ClassName: _099_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/23 13:18
 * @Version 1.0
 */
public class _099_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = Integer.parseInt(sc.nextLine());
        int[] FI = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] SI = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] count = new int[1001];
        Map<Integer, Integer> id_cost = new HashMap<>();
        for(int i = 0; i<FI.length; i++){
            count[FI[i]]++;
            id_cost.put(FI[i], SI[i]);
        }
        // id, isCache
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int id : id_cost.keySet()){
            int cost = id_cost.get(id) * count[id];
            int cacheCost = M + id_cost.get(id);
            if(cacheCost < cost){
                map.put(id, true);
            }else{
                map.put(id, false);
            }
        }

        int cost_all = 0;
        HashSet<Integer> hasCache = new HashSet<>();
        for(int i = 0; i<FI.length; i++){
            boolean isCache = map.get(FI[i]);
            if(isCache){
                if(hasCache.contains(FI[i])){
                    cost_all += 0;
                }else{
                    cost_all += SI[i];
                    hasCache.add(FI[i]);
                    cost_all += M;
                }
            }else{
                cost_all += SI[i];
            }
        }

        System.out.println(cost_all);

    }

}
