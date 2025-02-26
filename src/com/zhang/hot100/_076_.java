package com.zhang.hot100;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ClassName: _076_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/21 16:56
 * @Version 1.0
 */
public class _076_ {
//    public static void main(String[] args) {
//        MedianFinder finder = new MedianFinder();
//        finder.addNum(1);
//        finder.addNum(2);
//        finder.addNum(3);
//        System.out.println(finder.findMedian());
//    }

     class MedianFinder {
        //小顶堆，存较大元素
//        MyPQ<Integer> min = new MyPQ<>((a,b) -> a-b);
//        //大顶堆，存较小元素
//        MyPQ<Integer> max = new MyPQ<>((a,b) -> b-a);

         PriorityQueue<Integer> min = new PriorityQueue<>();
         PriorityQueue<Integer> max = new PriorityQueue<>((a,b)->b-a);

        public MedianFinder() {

        }

        public void addNum(int num) {
           max.offer(num);
           min.offer(max.poll());
           if(min.size() - max.size() > 1){
               max.offer(min.poll());
           }
        }

        public double findMedian() {
            return min.size() == max.size() ? (min.peek() + max.peek())/ 2.0 : min.peek();
        }

        class MyPQ<T>{
            int size = 0;
            ArrayList<T> buffer = new ArrayList<>();

            Comparator<T> comparator;
            public MyPQ(Comparator<T> comparator){
                this.comparator = comparator;
            }

            T peek(){
                return buffer.get(0);
            }

            int size(){
                return size;
            }

            T poll(){
                T t = buffer.get(0);
                swap(0, size-1);
                size--;
                buffer.remove(size);
                heapify(0);
                return t;
            }

            void offer(T t){
                buffer.add(t);
                heapInsert(size);
                size++;
            }

            void swap(int i, int j ){
                T t = buffer.get(i);
                buffer.set(i, buffer.get(j));
                buffer.set(j, t);
            }

            void heapInsert(int i ){
                while (comparator.compare(buffer.get(i), buffer.get((i-1)/2)) < 0){
                    swap(i, (i-1)/2);
                    i = (i-1)/2;
                }
            }

            void heapify(int i){
                int l = i * 2 + 1;
                while (l < size){
                    int best = l+1 < size && comparator.compare(buffer.get(l+1), buffer.get(l)) < 0 ? l+1 : l;
                    best = comparator.compare(buffer.get(best), buffer.get(i)) < 0 ? best : i;
                    if(best == i){
                        break;
                    }
                    swap(best, i);
                    i = best;
                    l = i * 2 + 1;
                }
            }

        }

    }



}
