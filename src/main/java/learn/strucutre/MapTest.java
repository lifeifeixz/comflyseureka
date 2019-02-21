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
package strucutre;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author flysLi
 * @ClassName MapTest
 * @Decription TODO
 * @Date 2018/10/30 16:21
 * @Version 1.0
 */
public class MapTest {
    public static void main(String[] args) {
//        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap(100);
//        linkedHashMap.put("apple", "苹果");
//        linkedHashMap.put("window", "微软");
//        linkedHashMap.put("google", "谷歌");
//        Set<String> keys = linkedHashMap.keySet();
//        for (String key : keys) {
//            String str = linkedHashMap.get(key);
//            System.out.println(str);
//        }

        Map<String, Object> stringObjectMap = new HashMap<>(1);
        stringObjectMap.put("name", "李飞飞");
        stringObjectMap.get("name");
        Map<String, Object> map = new ConcurrentHashMap<>(1);
        map.put("name", "flys·Li");
        map.keySet();
    }
}
