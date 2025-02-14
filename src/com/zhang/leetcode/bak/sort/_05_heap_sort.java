package sort;

public class _05_heap_sort {
    void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    void max_heapify(int[] A, int index, int length)
    {
        if(A == null)
        {
            return ;
        }
        int li = index*2 + 1;
        int ri = index*2 + 2;
        int max_index = index;
        if(li < length && A[li] > A[max_index])
        {
            max_index = li;
        }
        if(ri < length && A[ri] > A[max_index])
        {
            max_index = ri;
        }
        if(max_index != index)
        {
            swap(A, max_index, index);
            max_heapify(A, max_index, length);
        }
    }

    void heap_sort(int[] A, int length)
    {
        if(A == null)
        {
            return;
        }

        int i = 0;
        for(i = length/2 - 1; i>=0; i--)
        {
            max_heapify(A, i, length);
        }

        for(i = length-1; i>0; i--)
        {
            swap(A, 0, i);
            max_heapify(A, 0, i-1);
        }

    }
}
