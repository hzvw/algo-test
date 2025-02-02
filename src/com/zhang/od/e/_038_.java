package com.zhang.od.e;

import java.util.*;

/**
 * ClassName: _038_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/2/2 17:47
 * @Version 1.0
 */
public class _038_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] ints = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < ints.length; i++) {
            queue.offer(new int[]{ints[i], i});
        }
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            int[] ele = queue.poll();

            boolean flag = true;
            for(int ele2[] : queue){
                if(ele2[0] > ele[0]){
                    queue.offer(ele);
                    flag = false;
                    break;
                }
            }
            if(flag){
                res.add(ele[1]);
            }
        }

        int[][] arr = new int[ints.length][2];
        for (int i = 0; i < res.size(); i++) {
            arr[i][0] = res.get(i);
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a,b) -> a[0] - b[0]);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][1]);
            if(i != arr.length-1){
                System.out.print(",");
            }
        }


    }

}
