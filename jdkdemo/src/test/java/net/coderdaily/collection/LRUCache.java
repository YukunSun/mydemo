package net.coderdaily.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author sunyk
 **/
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int MAX_CACHE_SIZE;

    public LRUCache(int initialCapacity) {
        super((int) Math.ceil(initialCapacity / 0.75) + 1, 0.75f, true);
        MAX_CACHE_SIZE = initialCapacity;
    }

    public LRUCache(int initialCapacity, float loadFactor, int max_cache_size) {
        super(initialCapacity, loadFactor);
        MAX_CACHE_SIZE = max_cache_size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAX_CACHE_SIZE;
    }


    public static void main(String[] args) {
        LRUCache lru = new LRUCache<Integer, Integer>(3);
        lru.put(1, 1.1);
        lru.put(2, 2.1);
        lru.put(1, 1.2);
        lru.put(3, 3.1);
        System.out.println(lru);
        //accessOrder=true:{2=2.1, 1=1.2, 3=3.1},按的是访问的顺序从早到晚排列的
        //accessOrder=false:{1=1.2, 2=2.1, 3=3.1},按的是插入的顺序排列的
    }
}
