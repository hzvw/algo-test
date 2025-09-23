package com.zhang.hot100;

/**
 * ClassName: _054_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/20 15:58
 * @Version 1.0
 */
public class _054_ {

    static class Trie {
        Node root;


        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            int n = word.length();
            Node p = root;
            for (int i = 0; i < n; i++) {
                char c = word.charAt(i);
                if (p.children[c-'a'] == null) {
                    p.children[c-'a'] = new Node();
                }
                p = p.children[c-'a'];
                p.pre_count++;
            }
            p.count++;
        }

        public boolean search(String word) {
            int n = word.length();
            Node p = root;

            for (int i = 0; i < n; i++) {
                char c = word.charAt(i);
                if(p.children[c-'a'] == null){
                    return false;
                }
                p = p.children[c-'a'];
            }
            return p.count > 0;
        }

        public boolean startsWith(String prefix) {
            int n = prefix.length();
            Node p = root;
            for (int i = 0; i < n; i++) {
                char c = prefix.charAt(i);

                if (p.children[c-'a'] == null) {
                    return false;
                }
                p = p.children[c-'a'];
            }
            return p.pre_count > 0;
        }

        static class Node{
            int count;
            int pre_count;
            Node[] children;

            public Node() {
                this.children = new Node[26];
            }
        }
    }
}
