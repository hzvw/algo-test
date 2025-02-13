package other;

import java.util.Arrays;

public class _05_merge_sorted_array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while(i >=0 && j >= 0){
            if(nums2[j] > nums1[i]){
                nums1[k] = nums2[j];
                j--;
            }else{
                nums1[k] = nums1[i];
                i--;
            }
            k--;
        }
        if(i>=0){
            while(i>=0){
                nums1[k] = nums1[i];
                k--;
                i--;
            }
        }
        if(j>=0){
            while(j>=0){
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {7,8,9,0,0,0,0,0,0,0};
        int[] nums2  = {1,1,1,2,5,6,7};

        new _05_merge_sorted_array().merge(nums1,3,nums2,7);
        System.out.println(Arrays.toString(nums1));
    }

}
