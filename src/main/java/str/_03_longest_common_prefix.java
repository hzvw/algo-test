package str;


import org.junit.Test;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 *
 */
public class _03_longest_common_prefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        for(int i = 0; i<strs.length; i++){
            if(strs[i] == null || "".equals(strs[i])){
                return "";
            }
        }
        if(strs.length == 1){
            return strs[0];
        }
        int min_length = strs[0].length();
        for(String s : strs){
            if(s.length() < min_length){
                min_length = s.length();
            }
        }

        int end = -1;
        for(int i = 0; i<min_length; i++){
            char ch = strs[0].charAt(i);
            for(int j = 1; j<strs.length; j++){
                if(strs[j].charAt(i) != ch){
                    return strs[0].substring(0, end+1);
                }
            }
            end = i;
        }
        return strs[0].substring(0, end+1);
    }

    @Test
    public void testLongestCommonPrefix(String[] args){
        String[] strs = new String[]{"a", "a", "b"};
        String ret = new _03_longest_common_prefix().longestCommonPrefix(strs);
        System.out.println(ret);
    }


}
