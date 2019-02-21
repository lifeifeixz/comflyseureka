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

import java.util.Iterator;
import java.util.Set;

/**
 * @author flysLi
 * @ClassName Test
 * @Decription TODO
 * @Date 2018/11/14 15:59
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        LRUImpl<String, Object> lru = new LRUImpl(5);
        lru.put("1", "中国");
        lru.put("2", "日本");
        lru.put("3", "法国");
        lru.put("4", "德国");
        lru.put("5", "美国");
        Set<String> keys = lru.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            System.out.println("key: " + iterator.next() + "\t value: " + lru.get(iterator.next()));
        }
    }
}
