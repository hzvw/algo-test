package dp;

import java.util.ArrayList;
import java.util.List;

public class _05_permutation {
    public static void solution(String[] A){

    }

    public static void process(char[] cs, int i, List<String> res){
        if(i == cs.length){
            res.add(String.valueOf(cs));
        }

        boolean[] visit = new boolean[26];
        for(int j = i; j<cs.length; j++){
            if(!visit[cs[j] - 'a']){
                visit[cs[j] - 'a'] = true;
                swap(cs, i, j);
                process(cs, i+1, res);
                swap(cs, i , j);
            }
        }
    }

    public static void swap(char[] cs, int i, int j){
        char t = cs[i];
        cs[i] = cs[j];
        cs[j] = t;
    }

    public static void main(String[] args) {

        List<String> ans = new ArrayList<String>();
        String s = "abc";
        process(s.toCharArray(), 0, ans);
        ans.forEach(System.out::println);
    }

}
