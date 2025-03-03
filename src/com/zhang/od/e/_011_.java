package com.zhang.od.e;

import java.lang.invoke.VarHandle;
import java.util.*;
import java.util.stream.Collectors;

/**
 * ClassName: _011_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/28 16:36
 * @Version 1.0
 */
public class _011_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] nums = Arrays.stream(sc.nextLine().replaceAll("\\[|\\]","").split(", ")).mapToInt(Integer::parseInt).toArray();
        int ans = 0;
        Room room = new Room(n);
        for (int num : nums) {
            if(num == 1){
                ans = room.seat();
            }else{
                room.leave(-num);
            }
        }
        System.out.println(ans);
    }

    static class Room{
        int n;
        Set<Integer> set = new HashSet<>();

        public Room(int n) {
            this.n = n;
        }

        int seat(){
            if(set.size() == n){
                return -1;
            }

            if(set.size() == 0){
                set.add(0);
                return 0;
            }


            List<Integer> list = set.stream().collect(Collectors.toList());
            int pre = 0;
            int max_dis = 0;
            int ans = 0;
            for (int i = 1; i < list.size(); i++) {
                int dis = (list.get(i)-pre)/2;
                if(dis > max_dis){
                    max_dis = dis;
                    ans = pre + dis;
                }
                pre = list.get(i);
            }

            if(n-1-pre > max_dis){
                ans = n-1;
            }
            set.add(ans);
            return ans;
        }

        void leave(int index){
            set.remove(index);
        }
    }


}
