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
package strucutre.map;

import java.util.LinkedList;

/**
 * @author flysLi
 * @ClassName ManualHashMap
 * @Decription TODO
 * @Date 2018/11/11 11:34
 * @Version 1.0
 */
public class ManualHashMap {
    LinkedList[] arr = new LinkedList[999];
    int size = 0;

    public ManualHashMap() {

    }

    public void put(Object key, Object value) {
        MapEntry node = new MapEntry(key, value);
        int hash = node.key.hashCode() % arr.length;
        hash = hash < 0 ? -hash : hash;
        if (arr[hash] == null) {
            LinkedList<MapEntry> list = new LinkedList<>();
            arr[hash] = list;
            list.add(node);
            size++;
        } else {
            LinkedList<MapEntry> list = arr[hash];
            boolean falg = false;
            for (int i = 0; i < list.size(); i++) {
                MapEntry temp = list.get(i);
                if (temp.key.equals(key)) {
                    //将原有value覆盖
                    temp.value = value;
                    falg = true;
                }
            }
            if (!falg) {
                list.add(node);
                size++;
            }
        }
    }

    public Object get(Object key) {
        int hash = key.hashCode() % arr.length;
        hash = hash < 0 ? -hash : hash;
        if (arr[hash] != null) {
            LinkedList<MapEntry> list = arr[hash];
            for (int i = 0; i < list.size(); i++) {
                MapEntry temp = list.get(i);
                if (temp.key.equals(key)) {
                    return temp.value;
                }
            }
        }
        return null;
    }
}
