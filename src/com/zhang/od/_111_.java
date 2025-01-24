package com.zhang.od;

import java.util.*;

/**
 * ClassName: _111_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/24 20:58
 * @Version 1.0
 */
public class _111_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

//        Pattern pattern = Pattern.compile("[0-9a-f]+");
//        Matcher matcher = pattern.matcher(s1);
        List<String> buffer = new ArrayList<>();
//        while(matcher.find()){
//            buffer.add(matcher.group(1));
//        }
        String[] words = s1.split("[0-9a-f]+");
        for (int i = 0; i < words.length; i++) {
            buffer.add(words[i]);
        }

        Set<Character> set2 = new HashSet<>();
        for (char c : s2.toCharArray()) {
            set2.add(c);
        }

        List<String> res = new ArrayList<>();
        int min_diff = Integer.MAX_VALUE;
        int size2 = set2.size();
        for(String str : buffer){
            Set<Character> set = new HashSet<>();
            for(char c : str.toCharArray()){
                set.add(c);
            }
            int size1 = set.size();
            if(size1 <= size2){
                if(size2 - size1 < min_diff ){
                    min_diff = size2 - size1;
                    res.clear();
                    res.add(str);
                }else if(size2 - size1 == min_diff){
                    res.add(str);
                }
            }

        }
        res.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        if(res.size() == 0 || res.get(0) == null || "".equals(res.get(0)) ){
            System.out.println("Not Found");
        }else{
            System.out.println(res.get(0));
        }



    }

}
