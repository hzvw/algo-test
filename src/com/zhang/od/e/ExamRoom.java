package com.zhang.od.e;

import java.util.TreeSet;

public class ExamRoom {
    private int n;  // 总座位数
    private TreeSet<Integer> seats;  // 存储已经被占用的座位

    public ExamRoom(int n) {
        this.n = n;
        this.seats = new TreeSet<>();
    }

    public int seat() {
        int studentSeat = 0;  // 默认选择第一个座位

        if (!seats.isEmpty()) {
            int maxDistance = 0;  // 当前最大间距
            Integer prev = null;

            // 遍历占用的座位，找到最大间隔
            for (int seat : seats) {
                if (prev == null) {
                    // 距离最左边的间距
                    if (seat > maxDistance) {
                        maxDistance = seat;
                        studentSeat = 0;
                    }
                } else {
                    // 计算中间间距
                    int dist = (seat - prev) / 2;
                    if (dist > maxDistance) {
                        maxDistance = dist;
                        studentSeat = prev + dist;
                    }
                }
                prev = seat;
            }

            // 检查最右边的间距
            if (n - 1 - seats.last() > maxDistance) {
                studentSeat = n - 1;
            }
        }

        seats.add(studentSeat);  // 更新占用座位
        return studentSeat;
    }

    public void leave(int p) {
        seats.remove(p);  // 移除离开的座位
    }

    public static void main(String[] args) {
        ExamRoom room = new ExamRoom(10);
        System.out.println(room.seat()); // 输出: 0
        System.out.println(room.seat()); // 输出: 9
        System.out.println(room.seat()); // 输出: 4
        System.out.println(room.seat()); // 输出: 2
        room.leave(4);
        System.out.println(room.seat()); // 输出: 4
    }
}
