package com.zhang.od.e;

import java.util.*;
import java.util.stream.Stream;

/**
 * ClassName: _008_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/27 3:48
 * @Version 1.0
 */
public class _008_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        String str = words[0];
        int N = Integer.parseInt(words[1]);

        char[] arr = str.toCharArray();
        Stream<Character> characterStream = new String(arr).chars().mapToObj(x -> (char) x);
        if(characterStream.anyMatch(x -> !Character.isLowerCase(x))){
            System.out.println(0);
            return;
        }
        Arrays.sort(arr);
        List<String> res = new ArrayList<>();
        boolean[] visited = new boolean[arr.length];
        p(arr, 0, -1, N, new LinkedList<Character>(), visited, res);
        System.out.println(res.size());
    }

    static void p(char[] arr, int level, int pre, int n, LinkedList<Character> buckets, boolean[] visited, List<String> res){
        if(level == n){
            res.add(buckets.stream().map(x -> x + "").reduce("", String::concat));
            return;
        }

        for(int i = 0; i<arr.length; i++){
            if(visited[i]){
                continue;
            }

            if(pre >= 0 && arr[pre] == arr[i]){
                continue;
            }

            if(i > 0  && arr[i-1] == arr[i] && !visited[i-1]){
                continue;
            }
            buckets.addLast(arr[i]);
            visited[i] = true;

            p(arr, level +1, i, n, buckets, visited, res);

            buckets.removeLast();
            visited[i] = false;
        }
    }




}
