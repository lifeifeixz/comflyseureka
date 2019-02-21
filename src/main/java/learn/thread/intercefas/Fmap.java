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
package thread.intercefas;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author flysLi
 * @ClassName Fmap
 * @Decription TODO
 * @Date 2018/10/23 10:16
 * @Version 1.0
 */
public class Fmap<K, V> extends AbstractMap<K, V>
        implements Map<K, V> {
    private List<K> keys;
    private List<V> values;
    private int notNullIndex = 0;

    public static final int DEFAULT_CAPACITY = 1 << 4;


    public Fmap() {
        keys = new ArrayList<>(1);
        values = new ArrayList<>(1);
    }

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return keys.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values.contains(value);
    }

    @Override
    public V get(Object key) {
        for (int i = 0; i < keys.size(); i++) {
            if (keys.equals(key)) {
                return values.get(i);
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        if (!this.containsKey(key)) {
            keys.add(notNullIndex, key);
            values.add(notNullIndex, value);
            notNullIndex++;
        } else {
            values.add(keys.indexOf(key), value);
        }
        return value;
    }

    @Override
    public void putAll(Map m) {
    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        Set<K> var1 = new HashSet<K>(notNullIndex);
        for (int i = 0; i < keys.size(); i++) {
            var1.add(keys.get(i));
        }
        return var1;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public Object getOrDefault(Object key, Object defaultValue) {
        return null;
    }

    @Override
    public void forEach(BiConsumer action) {

    }

    @Override
    public void replaceAll(BiFunction function) {

    }

    @Override
    public Object putIfAbsent(Object key, Object value) {
        return null;
    }

    @Override
    public boolean remove(Object key, Object value) {
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i).equals(key)) {
                keys.remove(i);
                values.remove(i);
                notNullIndex--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean replace(Object key, Object oldValue, Object newValue) {
        return false;
    }

    @Override
    public Object replace(Object key, Object value) {
        return null;
    }

    @Override
    public Object computeIfAbsent(Object key, Function mappingFunction) {
        return null;
    }

    @Override
    public Object computeIfPresent(Object key, BiFunction remappingFunction) {
        return null;
    }

    @Override
    public Object compute(Object key, BiFunction remappingFunction) {
        return null;
    }

    @Override
    public Object merge(Object key, Object value, BiFunction remappingFunction) {
        return null;
    }
}
