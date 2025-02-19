package com.zhang.hot100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * ClassName: _035_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/19 17:45
 * @Version 1.0
 */
public class _035_ {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }

    static class LRUCache {

        static class Node{
            int version;
            int value;

            public Node(int version, int value) {
                this.version = version;
                this.value = value;
            }
        }
        int version = 0;

        TreeMap<Integer, Node> kv = new TreeMap<>();
        TreeMap<Integer, Integer> vk = new TreeMap<>();

        int capacity = 0;
        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            version++;
            if(kv.containsKey(key)){
                Node node = kv.get(key);
                increaseVersion(key, true);
                return node.value;
            }else{
                return -1;
            }
        }

        public void put(int key, int value) {
            version++;
            if(kv.containsKey(key)){
                Node node = kv.get(key);
                node.value = value;
                increaseVersion(key, true);
            }else{
                if(kv.keySet().size() == capacity){
                    //
                    int first_version = vk.firstKey();
                    kv.remove(vk.get(first_version));
                    vk.remove(first_version);

                    kv.put(key, new Node(version, value));
                    increaseVersion(key, false);
                }else{
                    kv.put(key, new Node(version, value));
                    increaseVersion(key, false);
                }
            }
        }

        void increaseVersion(int key, boolean isExist){
            if(isExist){
                Node node = kv.get(key);
                int old_version = node.version;
                int n_version = version;
                node.version = n_version;

                vk.remove(old_version);
                vk.put(n_version, key);
            }else{
                vk.put(version, key);
            }
        }
    }
}
