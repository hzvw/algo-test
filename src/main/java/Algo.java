public class Algo {
    public int solution(int[] A){
        int length = A.length;

        int[] dp = new int[length];
        for(int i = 0; i<length; i++){
            dp[i] = 1;
        }

        int last = A[0];
        int last_max = A[0];
        for(int i = 1; i<A.length; i++){
            int current = A[i];
            if(current > last_max){
                dp[i] = dp[i-1] + 1;
                last_max = dp[i];
            }else{
                dp[i] = last_max;
            }
            last = current;
        }

        return dp[length-1];
    }


}
