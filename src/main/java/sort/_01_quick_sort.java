package sort;

public class _01_quick_sort {
    void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    void quick_sort(int[] A, int left, int right){
        if(left > right){
            return;
        }
        int i = left;
        int j = right;
        int key = A[left];

        while(i < j){
            while(A[j] >= key && i<j){
                j--;
            }
            while(A[i] <= key && i<j){
                i++;
            }
            if(i < j){
                swap(A, i, j);
            }
        }

        A[left] = A[i];
        A[i] = key;

        quick_sort(A, left, i-1);
        quick_sort(A, i+1, right);
    }

}
