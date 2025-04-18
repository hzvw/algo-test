package com.zhang.od2.a;

import java.util.*;

/**
 * ClassName: _003_
 * Package: com.zhang.od2.a
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/31 16:46
 * @Version 1.0
 */
public class _003_ {
    static Map<Integer, Set<Integer>> map = new HashMap<>();
    static Map<Integer, Integer> sizeMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int id = sc.nextInt();
            int size = sc.nextInt();
            sizeMap.put(id, size);

            String str = sc.next().replaceAll("\\(|\\)", "");

            if("".equals(str)){
            }else{
                int[] child = Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
                Set<Integer> set = new HashSet<>();
                for (int chind_id : child) {
                    set.add(chind_id);
                }
                map.put(id, set);
            }
        }
        System.out.println(size(n));
    }

    static int size(int id){
        if(!map.containsKey(id)){
            return sizeMap.get(id);
        }else{
            Set<Integer> set = map.get(id);
            int res = sizeMap.get(id);
            for (Integer child_id : set) {
                res += size(child_id);
            }
            return res;
        }
    }
}
