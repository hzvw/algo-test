package com.zhang.od;

import java.util.*;

/**
 * ClassName: _107_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/24 1:06
 * @Version 1.0
 */
public class _107_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int[] arr = Arrays.stream(line.replaceAll("[\\[\\]]", "")
                .split(", ")).filter(x -> !x.isEmpty()).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        int num = Integer.parseInt(sc.nextLine());
//        int[] arr = {0, 1, 4, 5, 6, 7};
//        int num = 4;

        HashMap<Integer, int[]> map = new HashMap<>();
        map.put(1, new int[]{1,3,2,4});
        map.put(2, new int[]{2,4,3});
        map.put(4, new int[]{4});
        map.put(8, new int[]{8});

        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= 3){
                list1.add(arr[i]);
            }else{
                list2.add(arr[i]);
            }
        }

        int size1 = list1.size();
        int size2 = list2.size();
        List<List<Integer>> res = new ArrayList<>();

        if(num == 8){
            if(size1 == 4 && size2 == 4){
                list1.addAll(list2);
                res.add(list1);
            }
        }else{
            int[] priority = map.get(num);

            for(int i = 0; i<priority.length; i++){
                int ele = priority[i];
                if(ele == size1 || ele == size2){
                    if(ele == size1){
                        p(list1, res, 0, num, new LinkedList<>());
                    }
                    if(ele == size2){
                        p(list2, res, 0, num, new LinkedList<>());
                    }
                    break;
                }
            }

        }

        System.out.println((res));;

    }

    // 求组合
    static void p(List<Integer> list1, List<List<Integer>> res, int level, int n, LinkedList<Integer> buckets){
        if(buckets.size() == n){
            res.add(new LinkedList<>(buckets));
            return;
        }

        for(int j = level; j<list1.size(); j++){
            buckets.addLast(list1.get(j));
            p(list1, res, j+1, n, buckets);
            buckets.removeLast();
        }
    }

}
