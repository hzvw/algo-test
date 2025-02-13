package dp;

/**
 * 有N个小朋友站在一排，每个小朋友都有一个评分
 * 你现在要按以下的规则给孩子们分糖果：
 * 每个小朋友至少要分得一颗糖果
 * 分数高的小朋友要他比旁边得分低的小朋友分得的糖果多
 * 你最少要分发多少颗糖果？
 *
 *
 */
public class _03_candy {
    public int candy(int[] ratings) {
        int[] dp = new int[ratings.length];

        dp[0] = 1;
        for(int i=1;i<ratings.length; i++){
            if(ratings[i] > ratings[i-1]){
                dp[i] = dp[i-1] + 1;
            }else if(ratings[i] == ratings[i-1]){
                dp[i] = 1;
            }else{
                dp[i] = 1;
                if(dp[i-1] == 1){
                    for(int j = i-1; j>=0; j--){
                        if(ratings[j] > ratings[j+1] && dp[j] <= dp[j+1]){
                            dp[j]++;
                        }else{
                            break;
                        }

                    }
                }
            }
        }

        int sum= 0;
        for(int i : dp){
            sum += i;
        }
        return sum;


    }
}
