package com.zhang.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _34_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/17 14:13
 * @Version 1.0
 */
public class _034_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        List<String> input = new ArrayList<>();
        for(int i = 0; i<words.length; i++){
            input.add(words[i]);
        }

        input.sort((x,y) -> p(x)-p(y));

        List<List<String>> buffer = new ArrayList<>();
        for(int i = 0; i<input.size(); i++){
            String str = input.get(i);
            if(buffer.size() == 0){
                List<String> tmp = new ArrayList<>();
                tmp.add(str);
                buffer.add(tmp);
            }else{
                int j = 0;
                boolean flag = false;//放进去了没有
                while(j<buffer.size()){
                    List<String> list = buffer.get(j);
                    if(p(list.get(list.size()-1)) - p(str) == -1){
                        //
                        list.add(str);
                        flag = true;
                        break;
                    }
                    j++;
                }
                if(!flag){
                    List<String> tmp = new ArrayList<>();
                    tmp.add(str);
                    buffer.add(tmp);
                }

            }
        }

        int cnt = 0;
        for(int i = 0; i<buffer.size(); i++){
            if(buffer.get(i).size() >= 5){
                cnt++;
            }
        }
        if(cnt > 0 ){
            for(int i = 0; i<buffer.size(); i++){
                if(buffer.get(i).size() >= 5){
                    buffer.get(i).forEach(x-> System.out.print(x + " "));
                }
                System.out.println();
            }
        }else{
            System.out.println("No");
        }


    }

    static int p(String input){
        switch (input){
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            case "2":
                return 16;
            default:
                return Integer.parseInt(input);
        }
    }

}
