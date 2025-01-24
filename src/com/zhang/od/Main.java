package com.zhang.od;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 输入获取
        int[] array = Arrays.stream(sc.nextLine().replaceAll("[\\[\\]]", "").split(", ")).filter(s -> !s.isEmpty()).mapToInt(Integer::parseInt).toArray();
        int num = sc.nextInt();

        // 本题没有规定输出组合内部顺序要求，但是最好排序一下
        Arrays.sort(array);

        // 将处理器编号数组array分为链路1和链路2
        ArrayList<Integer> link1 = new ArrayList<>();
        ArrayList<Integer> link2 = new ArrayList<>();

        for (int i : array) {
            // 编号0-3的处理器处于同一个链路中，编号4-7的处理器处于另外一个链路中
            if (i < 4) {
                link1.add(i);
            } else {
                link2.add(i);
            }
        }

        // 记录本题结果
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (num == 8) {
            // 如果申请8个处理器，则链路1，链路2都要有4个
            if (link1.size() == 4 && link2.size() == 4) {
                link1.addAll(link2);
                res.add(link1);
            }
        } else {
            // 构建亲和性调度原则,构建映射关系, key=申请处理器数量，val=最佳数量选择数组
            HashMap<Integer, int[]> map = new HashMap<>();
            map.put(1, new int[]{1, 3, 2, 4});
            map.put(2, new int[]{2, 4, 3});
            map.put(4, new int[]{4});

            for (int i : map.get(num)) {
                if (link1.size() == i || link2.size() == i) {
                    if (link1.size() == i) {
                        dfs(link1, num, 0, new ArrayList<>(), res);
                    }

                    if (link2.size() == i) {
                        dfs(link2, num, 0, new ArrayList<>(), res);
                    }

                    break; // 找到最优选择策略了，所以无需继续
                }
            }
        }

        // 输出打印
        System.out.println(res);
    }

    // 在link中选取level个元素的组合
    public static void dfs(ArrayList<Integer> link, int level, int index, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res) {
        if (path.size() == level) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < link.size(); i++) {
            path.add(link.get(i));
            dfs(link, level, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}