package search;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 *
 *
 */
public class _01_min_number_in_rotate_array {
    int binary_search(int[] A, int left, int right, int target)
    {
        if(left > right)
        {
            return -1;
        }
        int mid = (left + right) / 2;

        if(target < A[mid])
        {
            return binary_search(A, left, mid-1, target);
        }else if(target > A[mid])
        {
            return binary_search(A, mid+1, right, target);
        }else{
            return mid;
        }
    }

    public int minNumberInRotateArray(int[] A) {
        if(A == null || A.length == 0){
            return 0;
        }

        int i = 0;
        int j = A.length - 1;
        //int mid = ()
        // boolean flag = true;
        while(true){
            int mid = (i + j) / 2;

            if(A[mid] == A[i] && A[mid] == A[j]){
                int min = A[i];
                for(int k = i; k<=j; k++){
                    if(A[k] < min){
                        min = A[k];
                    }
                }
                return min;
            }
            if(A[mid] >= A[i]){
                // 最小值在后半部分
                i = mid;
            }else{
                // 最小值在前半部分
                j = mid;
            }
            if(j - i == 1){
                return A[j];
            }
        }
        //return 0;
    }

    @Test
    public void testMinNumberInRotateArray(){
        int[] A = {3,4,5,6,1,2};
        _01_min_number_in_rotate_array obj = new _01_min_number_in_rotate_array();
        int ret =obj.minNumberInRotateArray(A);

        Assert.assertEquals(1, ret);
    }

    /*
    int search(int[] A, int left, int right){

    }*/

    int max_sub_array(int[] A, int length)
    {
        int[] p = new int[length];
        p[0] = A[0];

        int i = 0;
        for(i = 1; i<length; i++)
        {
            if(A[i] > 0)
            {
                p[i] = p[i-1] + A[i];
            }else
            {
                p[i] = p[i-1];
            }
        }
        return p[length-1];
    }

    int min_path_sum(int[][] A, int row, int column)
    {
        int[][] p = new int[row][column];
        int i = 0;
        int j = 0;
        for(i = 0; i<row; i++)
        {
            p[i] = new int[column];
        }
        p[0][0] = A[0][0];

        for(i = 1; i<row; i++)
        {
            p[i][0] = p[i-1][0] + A[i][0];
        }
        for(j = 1; j<column; j++)
        {
            p[0][j] = p[0][j-1] + A[0][j];
        }

        for(i = 1; i<row; i++)
        {
            for(j = 1; j<column; j++)
            {
                if(p[i][j-1] < p[i-1][j])
                {
                    p[i][j] = A[i][j] + p[i][j-1];
                }else
                {
                    p[i][j] = A[i][j] + p[i-1][j];
                }

                System.out.println(p[i][j]);
            }
        }
        return p[row-1][column-1];
    }

    @Test
    public void testQuickSort(){
        int[] A = {3,4,5,1,2};
        System.out.println(Arrays.toString(A));

        _01_min_number_in_rotate_array obj = new _01_min_number_in_rotate_array();
        //obj.quick_sort(A, 0, A.length-1);
        System.out.println(Arrays.toString(A));
    }

}
