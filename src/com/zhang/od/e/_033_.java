package com.zhang.od.e;

import java.util.*;

/**
 * ClassName: _033_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/30 0:01
 * @Version 1.0
 */
public class _033_ {
    static HashMap<Integer, String> map = new HashMap<>();
    static{
        map.put(0, "abc");
        map.put(1, "def");
        map.put(2, "ghi");
        map.put(3, "jkl");
        map.put(4, "mno");
        map.put(5, "pqr");
        map.put(6, "st");
        map.put(7, "uv");
        map.put(8, "wx");
        map.put(9, "yz");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String bad = sc.nextLine();

        char[] cs = line.toCharArray();

        List<String> res = new ArrayList<>();
        p(cs, 0, new LinkedList<>(), res);

        List<String> ret = new ArrayList<>();
        for(String s : res){
            if(!ismatch(s, bad)){
                ret.add(s);
            }
        }
        ret.add("");
        System.out.print(String.join(",", ret));;

    }

    static boolean ismatch(String str, String bad){
        for(char c : bad.toCharArray()){
            if(!str.contains(c+"")){
                return false;
            }
        }
        return true;

    }

    static void p(char[] cs,  int level, LinkedList<Character> buckets,List<String> res){
        if(cs.length == buckets.size()){
            res.add(buckets.stream().map(x -> x+"").reduce("",String::concat));
            return;
        }
        for(int i = level; i < cs.length; i++){
            String value = map.get(cs[i]-'0');
            char[] vs = value.toCharArray();
            for(int j = 0; j<vs.length; j++){
                buckets.addLast(vs[j]);
                p(cs, i+1, buckets, res);
                buckets.removeLast();
            }
        }
    }



}
