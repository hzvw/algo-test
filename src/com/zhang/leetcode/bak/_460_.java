package com.zhang.leetcode.bak;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * ClassName: _460_
 * Package: com.zhang.leetcode.bak
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/16 23:45
 * @Version 1.0
 */
public class _460_ {

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1,1);
        lfuCache.put(2,2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3,3);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        lfuCache.put(4,4);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));
    }





    static class LFUCache {
        //key，节点
        HashMap<Integer, Node> keyMap = new HashMap<>();

        //访问次数，节点集合
        TreeMap<Integer, LinkedList<Node>> freqMap = new TreeMap<>();

        int capacity;

        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if(keyMap.containsKey(key)){
                Node node = keyMap.get(key);
                node.freq += 1;
                increaseFreq(true, keyMap.get(key));
                return keyMap.get(key).value;
            }else{
                return -1;
            }
        }

        public void put(int key, int value) {
            if(keyMap.containsKey(key)){
                Node node = keyMap.get(key);
                node.value = value;
                node.freq = node.freq + 1;
                increaseFreq(true, node);
            }else{
                if(keyMap.size() == capacity){
                    // 最低频次
                    int first_key = freqMap.firstKey();
                    //最低频次链表
                    LinkedList<Node> list = freqMap.get(first_key);
                    keyMap.remove(list.getFirst().key);
                    if(list.size() > 0){
                        list.removeFirst();
                    }
                }
                Node node = new Node(key, value, 1);
                keyMap.put(key, node);
                increaseFreq(false, node);
            }
        }

        private void increaseFreq(boolean isExist, Node node){
            if(isExist){
                int before_freq = node.freq-1;
                freqMap.get(before_freq).remove(node);
                if(freqMap.get(before_freq).size() == 0){
                    freqMap.remove(before_freq);
                }

                freqMap.putIfAbsent(node.freq, new LinkedList<>());
                freqMap.get(node.freq).add(node);
            }else{
                freqMap.putIfAbsent(node.freq, new LinkedList<>());
                freqMap.get(node.freq).add(node);
            }
        }
        static class Node{
            int key;
            int value;

            int freq;

            public Node(int key, int value, int freq) {
                this.key = key;
                this.value = value;
                this.freq = freq;
            }
        }
    }



}
