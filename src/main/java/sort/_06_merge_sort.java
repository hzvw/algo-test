package sort;

public class _06_merge_sort {
    private static void merge(int[] A, int start, int mid, int end){
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid+1;
        int index = 0;
        while(i<=mid && j<=end){
            if(A[i] < A[j]){
                temp[index] = A[i];
                i++;
            }else{
                temp[index] = A[j];
                j++;
            }
            index++;
        }
        while(i<=mid){
            temp[index] = A[i];
            i++;
            index++;
        }
        while(j<=end){
            temp[index] = A[j];
            j++;
            index++;
        }
        index = 0;
        for(int k = start; k<=end; k++){
            A[k] = temp[index];
            index++;
        }
    }

    static void merge_sort(int[] A, int start, int end) {
        if(start < end){
            int mid = start + (end - start) / 2;

            merge_sort(A, start, mid);
            merge_sort(A, mid+1, end);

            merge(A, start, mid, end);
        }
    }
}
