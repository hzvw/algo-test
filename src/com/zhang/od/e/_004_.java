package com.zhang.od.e;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ClassName: _004_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/26 17:51
 * @Version 1.0
 */
public class _004_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 输入的句子，每个元素是一个待分词的句子
        LinkedList<String> queue = Arrays.stream(sc.nextLine().split("[,.;]")).collect(Collectors.toCollection(LinkedList::new));
        //词库
        Set<String> set = Arrays.stream(sc.nextLine().split("[,]")).collect(Collectors.toSet());

        ArrayList<String> res = new ArrayList<>();
        while(queue.size() > 0){
            String sen = queue.removeFirst();

            int j = sen.length();
            while(j > 0){
                String tmp = sen.substring(0, j);
                if(set.contains(tmp)){
                    res.add(tmp);
                    set.remove(tmp);
                    if(j != sen.length()){
                        queue.addFirst(sen.substring(j));
                    }
                    break;
                }
                j--;
            }

            if(j == 0){
                res.add(sen.charAt(0) + "");
                if(sen.length() > 1){
                    queue.addFirst(sen.substring(1));
                }
            }
        }

        System.out.print(String.join(",", res));


    }

}
