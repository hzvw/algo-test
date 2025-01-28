package com.zhang.od.e;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * ClassName: _011_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/28 16:36
 * @Version 1.0
 */
public class _011_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        ExamRoom examRoom = new ExamRoom(n);

        int[] nums = Arrays.stream(sc.nextLine().replaceAll("[\\[\\]]", "").split(", ")).mapToInt(Integer::parseInt).toArray();

        int res = -1;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 1){
                res = examRoom.seat();
            }else{
                int j = -nums[i];
                examRoom.leave(j);
            }
        }
        System.out.println(res);
    }

    static class ExamRoom {
        int n ;

        TreeSet<Integer> seats;

        public ExamRoom(int n){
            this.n = n;
            this.seats = new TreeSet<>();
        }

        public int seat(){
            if(seats.size() == n){
                return -1;
            }
            if(seats.size() == 0){
                seats.add(0);
                return 0;
            }
            int n_seat = 0;
            int max_dist = 0;
            Integer pre = null;
            for(Integer seat : seats){
                if(pre == null){
                    int dist = seat;
                    if(dist > max_dist){
                        max_dist = dist;
                        n_seat = 0;
                    }
                }else{
                    int dist =  (seat - pre ) /2;
                    if(dist > max_dist){
                        max_dist = dist;
                        n_seat = pre + dist;
                    }
                }

                pre = seat;
            }

            if(n-1-seats.last() > max_dist){
                max_dist = n-1-seats.last();
                n_seat = n-1;
            }
            seats.add(n_seat);
            return n_seat;
        }

        public void leave(int p){
            seats.remove(p);
        }


    }

}
