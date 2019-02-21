/*
 * Copyright (c) 2018, 2018, Travel and/or its affiliates. All rights reserved.
 * TRAVEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package strucutre.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author flysLi
 * @ClassName LRUCache1
 * @Decription TODO
 * @Date 2018/11/14 16:32
 * @Version 1.0
 */
public class LRUCache1<K, V> {
    private final int MAX_CACHE_SIZE;
    private Entry first;
    private Entry last;
    private HashMap<K, Entry<K, V>> hashMap;

    public LRUCache1(int maxCacheSize) {
        MAX_CACHE_SIZE = maxCacheSize;
        hashMap = new HashMap<>(maxCacheSize);
    }

    public void put(K key, V value) {
        Entry entry = getEntry(key);
        if (entry == null) {
            if (hashMap.size() >= MAX_CACHE_SIZE) {
                hashMap.remove(last.key);
            }
        }
    }

    public Entry<K, V> getEntry(K key) {
        if (key == null) {
            return null;
        }
        return hashMap.get(key);
    }


}

class Entry<K, V> {
    public Entry pre;
    public Entry next;
    public K key;
    public V value;
}
