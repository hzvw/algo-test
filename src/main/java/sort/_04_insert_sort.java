package sort;

public class _04_insert_sort {
    void insert_sort(int[] A, int length)
    {
        if(A == null)
        {
            return;
        }
        int i = 0;
        for(i = 1; i<length; i++)
        {
            int key = A[i];
            int j = i-1;
            while(j>=0)
            {
                if(A[j] > key)
                {
                    A[j+1] = A[j];
                    j--;
                }
                else
                {
                    break;
                }
            }
            A[j+1] = key;
        }
    }

}
