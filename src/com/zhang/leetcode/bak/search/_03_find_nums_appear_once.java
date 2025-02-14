package search;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 *
 */
public class _03_find_nums_appear_once {

    //
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : array){
            if(map.containsKey(i)){
                map.remove(i);
            }else{
                map.put(i, 1);
            }
        }

        Set<Integer> keySet = map.keySet();
        int index = 0;
        int ret[] = new int[2];
        for(int i : keySet){
            ret[index] = i;
            index++;
        }
        num1[0] = ret[0];
        num2[0] = ret[1];
    }


}
