package other;

import java.util.*;

public class _18_LFU {
    static class LFUCache {
        // key 到 val 的映射，我们后文称为 KV 表
        HashMap<Integer, Integer> kv;
        // key 到 freq 的映射，我们后文称为 KF 表
        HashMap<Integer, Integer> kf;
        // freq 到 key 列表的映射，我们后文称为 FK 表
        HashMap<Integer, LinkedHashSet<Integer>> fk;
        // 记录最小的频次
        int min_f;
        // 记录 LFU 缓存的最大容量
        int cap;

        public LFUCache(int capacity) {
            kv = new HashMap<>();
            kf = new HashMap<>();
            fk = new HashMap<>();
            this.cap = capacity;
            this.min_f = 0;
        }

        public int get(int key) {
            if (!kv.containsKey(key)) {
                return -1;
            }
            // 增加 key 对应的 freq
            increaseFreq(key);
            return kv.get(key);
        }

        public void put(int key, int val) {
            if (this.cap <= 0) return;

            /* 若 key 已存在，修改对应的 val 即可 */
            if (kv.containsKey(key)) {
                kv.put(key, val);
                // key 对应的 freq 加一
                increaseFreq(key);
                return;
            }

            /* key 不存在，需要插入 */
            /* 容量已满的话需要淘汰一个 freq 最小的 key */
            if (this.cap <= kv.size()) {
                removeMinFreqKey();
            }

            /* 插入 key 和 val，对应的 freq 为 1 */
            // 插入 KV 表
            kv.put(key, val);
            // 插入 KF 表
            kf.put(key, 1);
            // 插入 FK 表
            fk.putIfAbsent(1, new LinkedHashSet<>());
            fk.get(1).add(key);
            // 插入新 key 后最小的 freq 肯定是 1
            this.min_f = 1;
        }

        private void removeMinFreqKey() {
            // freq 最小的 key 列表
            LinkedHashSet<Integer> keyList = fk.get(this.min_f);
            // 其中最先被插入的那个 key 就是该被淘汰的 key
            int deletedKey = keyList.iterator().next();
            /* 更新 FK 表 */
            keyList.remove(deletedKey);
            if (keyList.isEmpty()) {
                fk.remove(this.min_f);
                // 问：这里需要更新 minFreq 的值吗？
            }
            /* 更新 KV 表 */
            kv.remove(deletedKey);
            /* 更新 KF 表 */
            kf.remove(deletedKey);
        }
        private void increaseFreq(int key) {
            int freq = kf.get(key);
            /* 更新 KF 表 */
            kf.put(key, freq + 1);
            /* 更新 FK 表 */
            // 将 key 从 freq 对应的列表中删除
            fk.get(freq).remove(key);
            // 将 key 加入 freq + 1 对应的列表中
            fk.putIfAbsent(freq + 1, new LinkedHashSet<>());
            fk.get(freq + 1).add(key);
            // 如果 freq 对应的列表空了，移除这个 freq
            if (fk.get(freq).isEmpty()) {
                fk.remove(freq);
                // 如果这个 freq 恰好是 minFreq，更新 minFreq
                if (freq == this.min_f) {
                    this.min_f++;
                }
            }
        }

    }

}
