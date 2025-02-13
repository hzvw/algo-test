package other;

import java.util.*;

/*
* leetcode 146
*
*
* */
public class _17_LRU {

    static class LRUCache{
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
        int cap = 0;
        public LRUCache(int capacity) {
            this.cap = capacity;
        }

        public int get(int key) {
            if(!cache.containsKey(key)){
                return -1;
            }
            makeRecently(key);
            return cache.get(key);
        }

        public void put(int key, int value) {
            if(cache.containsKey(key)){
                cache.put(key, value);
                makeRecently(key);
                return;
            }else{
                if(cache.size() == cap){
                    int oldest = cache.keySet().iterator().next();
                    cache.remove(oldest);
                }
                cache.put(key, value);
                return;
            }
        }

        void makeRecently(int key){
            int val = cache.get(key);
            cache.remove(key);
            cache.put(key, val);
        }
    }



}
