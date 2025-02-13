package sort;

public class _03_select_sort {
    void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    void select_sort(int[] a, int length)
    {
        int i = 0;
        int j = 0;
        for(i = 0; i<length; i++)
        {
            int min_index = i;
            for(j = i+1; j<length; j++)
            {
                if(a[j] < a[min_index])
                {
                    min_index = j;
                }
            }
            if(min_index != i)
            {
                swap(a, min_index, i);
            }

        }

    }
}
