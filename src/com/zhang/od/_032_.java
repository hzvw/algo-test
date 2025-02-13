package com.zhang.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _032_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/17 12:24
 * @Version 1.0
 */
public class _032_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();

        List<Me> buffer = new ArrayList<>();

        String[] words1 = line1.split(",");
        for(int i = 0; i< words1.length; i++){
            String[] t = words1[i].split(":");
            int p = Integer.parseInt(t[0]);
            int n = Integer.parseInt(t[1]);
            buffer.add(new Me(p, n));
        }

        String[] words2 = line2.split(",");
        List<Integer> i1 = new ArrayList<>();
        for(int i = 0; i<words2.length; i++){
            if("".equals(words2[i])){
                continue;
            }
            i1.add(Integer.parseInt(words2[i]));
        }

        buffer.sort((x,y) -> x.p - y.p);
        List<String> res = new ArrayList<>();

        for(int i = 0; i<i1.size(); i++){
            int index = biS(buffer, i1.get(i));

            if(index < buffer.size()){
                res.add("true");
                buffer.get(index).n--;

                if(buffer.get(index).n == 0){
                    buffer.remove(index);
                }
                // 找到了
            }else {
                res.add("false");
            }
        }

        System.out.println(String.join(",", res));;





    }

    static int biS(List<Me> buffer, int target){
        int l = 0;
        int r = buffer.size()-1;
        while(l <= r){
            int mid = (l+r) / 2;
            if(target < buffer.get(mid).p){
                r = mid -1;
            }else if(target > buffer.get(mid).p){
                l = mid + 1;
            }else{
                return mid;
            }
        }
        return l;
    }


    static class Me{
        int p;//容量
        int n;//数量

        public Me(int p, int n){
            this.p = p;
            this.n = n;
        }
    }

}
