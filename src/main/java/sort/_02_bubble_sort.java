package sort;

public class _02_bubble_sort {
    void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    void bubble_sort(int[] A, int length)
    {
        int i = 0;
        int j = 0;
        for(i = 0; i<length-1; i++)
        {
            for(j = 0; j<length-1-i; j++)
            {
                if(A[j] > A[j+1])
                {
                    swap(A, j, j+1);
                }
            }
        }
    }

}
