package other;

public class _10_majority_element {
    public int majorityElement(int[] nums) {
        int c = 0;
        int cnt = 0;

        for(int i = 0; i<nums.length; i++){
            if(cnt == 0){
                c = nums[i];
            }

            if(nums[i] == c){
                cnt++;
            }else{
                cnt--;
            }
        }
        return c;
    }

}
