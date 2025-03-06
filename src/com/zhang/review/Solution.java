package com.zhang.review;

import com.zhang.hot100.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ClassName: Solution
 * Package: com.zhang.review
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/6 10:39
 * @Version 1.0
 */
public class Solution {
    public static void main(String[] args) {
        //个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
        // 在字符串中增加空格来构造一个句子，使得句子中的所有单词都在字典中。返回所有可能的句子。

        //
//        输入：
//        s = "catsanddog"
//        wordDict = ["cat","cats","and","sand","dog"]



//        输出：
//[
//        "cats and dog",
//                "cat sand dog"
//]



    }

    List<List<String>> m1(String s, String[] wordDict){
        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }

        int i = 0;
        int j = 0;
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        while (j < s.length()){
            if(set.contains(s.substring(i,j))){
                list.add(s.substring(i,j));
                i = j;
            }
            j++;
        }


        return res;
    }


    List<List<String>> m2(String s, String[] wordDict){
        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }

        int i = 0;
        int j = 0;
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        while (j < s.length()){
            if(set.contains(s.substring(i,j))){
                list.add(s.substring(i,j));
                i = j;
            }
            j++;
        }
        return res;
    }

//    public static void main(String[] args) {
//        //Scanner in = new Scanner(System.in);
//        //int a = in.nextInt();
//        //System.out.println(a);
//        System.out.println("Hello World!");
//    }

    ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }

        ListNode n_head = new ListNode(-1);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p = n_head;
        while (p1!=null && p2 != null){
            if(p1.val < p2.val){
                p.next = p1;
                p1 = p1.next;
            }else{
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if(p1 != null){
            p.next = p1;
        }else{
            p.next = p2;
        }
        return n_head.next;
    }



}
