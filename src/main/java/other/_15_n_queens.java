package other;

import java.util.*;

public class _15_n_queens {
    List<List<String>> res = new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
        List<String> buffer = new ArrayList<String>();
        sol(n, buffer);
        return res;
    }

    void sol(int n, List<String> buffer){
        if(n == buffer.size()) {
            res.add(new ArrayList<>(buffer));
            return;
        }

        for(int i = 0; i<n; i++){
            List<Integer> buffer2 = new ArrayList<>();
            for(int j = 0; j<buffer.size(); j++){
                String str = buffer.get(j);
                int index = 0;
                while(index < str.length()){
                    if(str.charAt(index) == 'Q'){
                        break;
                    }
                    index++;
                }
                buffer2.add(index);
            }
            if(!isOK(i, buffer2)){
                continue;
            }

            StringBuilder sb = new StringBuilder();
            for(int j = 0; j<n; j++){
                if(j == i){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            buffer.add(sb.toString());
            sol(n,buffer);
            buffer.remove(buffer.size()-1);
        }
    }

    boolean isOK(int i, List<Integer> buffer2){
        if(buffer2.size() == 0){
            return true;
        }
        if(buffer2.contains(i)){
            return false;
        }
        for(int j = 0; j<buffer2.size(); j++){
            int i1 = i - buffer2.get(j);
            int i2 = buffer2.size() - j;

            if(i1 == i2 || i1 + i2 == 0){
                return false;
            }
            // j,buffer2.get(j)
            // buffer2.size(),i
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 8;
        List<List<String>> res = new _15_n_queens().solveNQueens(n);
        for(List li : res){
            for(int i = 0; i<li.size(); i++){
                System.out.println(li.get(i));
            }
            System.out.println("================");
        }
    }

}
