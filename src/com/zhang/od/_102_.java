package com.zhang.od;

import java.util.*;
import java.util.Scanner;

/**
 * ClassName: _102_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/23 19:49
 * @Version 1.0
 */
public class _102_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for(int i = 0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(p1(N,M,arr));

//        int N = 1000;
//        int M = 1000000;
//        int[] arr = new int[N];
//        Random r = new Random();
//        for(int i = 0; i<N; i++){
//            arr[i] = r.nextInt() % 1000;
//        }
//        long t1 = System.currentTimeMillis();
//        p1(N, M, arr);
//        long t2 = System.currentTimeMillis();
//        int res = getResult(N, M, arr);
//        System.out.println(res);
//        long t3 = System.currentTimeMillis();
//
//        System.out.println((t2-t1) + " : " + (t3-t2));
//
//
        System.out.println(getResult(M, arr));
//
//        long t4 = System.currentTimeMillis();
//        System.out.println(t4-t3);
    }

    static int p1(int N, int M, int[] arr){
        HashMap<Integer, Integer> count = new HashMap<>();
        Arrays.stream(arr).forEach(e -> count.put(e, count.getOrDefault(e, 0) +1));

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        count.keySet().stream().forEach(x-> queue.offer(new int[]{x, count.get(x)}));
        int k = M;
        while (k>0){
           if(queue.size() == 1){
               int[] todo = queue.poll();
               return todo[0] + k/todo[1];
           }

           //如果长度大于1
           int[] i1 = queue.poll();
           int[] i2 = queue.peek();

           int diff = i2[0] - i1[0];
           if(diff * i1[1] > k){
               return i1[0] + k/i1[1];// why
//               return i1[0];
           }else if(diff * i1[1] == k){
               return i1[0] + diff;
           }else{
               i2[1] += i1[1];
               k -= diff * i1[1];
           }
        }
        return queue.peek()[0];
    }



    public static int getResult(int n, int m, int[] arr) {
        // 木板长度升序
        Arrays.sort(arr);

        // dp用于保存将所有arr[i-1]长度的木板补足到arr[i]长度，所需要的木料长度
        int dp = 0;
        for (int i = 1; i < n; i++) {
            // 比如将arr[0]长度的木板补足到arr[1]所需的木料长度为arr[1] - arr[0]
            // 比如将arr[1]长度的木板补足到arr[2]所需的木料长度为(arr[2] - arr[1]) *
            // 2，注意这里*2的原因是arr[0]已经被补足到arr[1]长度了，因此arr[1]长度此时有2个
            int need = (arr[i] - arr[i - 1]) * i;

            // 如果m可用木料不满足上面，则将剩余可用m-dp的材料均分给i根木料，返回此时的最短木料
            if (dp + need > m) {
                return (m - dp) / i + arr[i - 1];
            }

            dp += need;
        }

        // 如果将所有木板都补足到最长木板的长度了，还有剩余木料可用，则均分
        return (m - dp) / n + arr[n - 1];
    }

    // 返回最小值所在的索引
    static int min_index(int[] arr){
        int N = arr.length;
        int min = arr[0];
        int res = 0;
        for(int i = 0; i<N; i++){
            if(arr[i] < min){
                min = arr[i];
                res = i;
            }
        }
        return res;
    }

    static boolean isAllValEql(int[] arr){
        int N = arr.length;
        int avg = Arrays.stream(arr).sum() / N;

        for(int i = 0; i<N; i++){
            if(arr[i] != avg){
                return false;
            }
        }
        return true;
    }

    public static int getResult(int m, int[] a) {
        // 统计每种长度板的数量，记录到woods中，key是板长度，val是板数量
        HashMap<Integer, Integer> woods = new HashMap<>();
        for (Integer ai : a) {
            if (woods.containsKey(ai)) {
                Integer val = woods.get(ai);
                woods.put(ai, ++val);
            } else {
                woods.put(ai, 1);
            }
        }

        // 将统计到的板，按板长度排优先级，长度越短优先级越高，这里使用优先队列来实现优先级
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((b, c) -> b[0] - c[0]);
        for (Integer wood : woods.keySet()) {
            pq.offer(new Integer[] {wood, woods.get(wood)});
        }

        // 只要还有剩余的m长度，就将他补到最短板上
        while (m > 0) {
            // 如果只有一种板长度，那么就尝试将m平均分配到各个板上
            if (pq.size() == 1) {
                Integer[] info = pq.poll();
                int len = info[0];
                int count = info[1];
                return len + m / count;
            }

            // 如果有多种板长度
            // min1是最短板
            Integer[] min1 = pq.poll();
            // min2是第二最短板
            Integer[] min2 = pq.peek();

            // diff是最短板和第二最短板的差距
            int diff = min2[0] - min1[0];
            // 将所有最短板补足到第二短板的长度，所需要总长度total
            int total = diff * min1[1];

            // 如果m的长度不够补足所有最短板，那么说明此时最短板的长度就是题解
            if (total > m) {
                return min1[0] + m / min1[1];
            }
            // 如果m的长度刚好可以补足所有最短板，那么说明最短板可以全部升级到第二短板，且刚好用完m，因此第二短板的长度就是题解
            else if (total == m) {
                return min2[0];
            }
            // 如果m的长度足够长，能补足所有最短板到第二短板，还能有剩余，则将最短的数量加到第二短板的数量上，继续下轮循环
            else {
                m -= total;
                min2[1] += min1[1];
            }
        }

        return pq.peek()[0];
    }

}
