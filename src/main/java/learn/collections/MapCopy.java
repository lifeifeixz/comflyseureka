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
package learn.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * 探讨map的深拷贝和浅拷贝问题
 *
 * @author flysLi
 * @ClassName MapCopy
 * @Decription TODO
 * @Date 2019/2/27 15:07
 * @Version 1.0
 */
public class MapCopy {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(2);
        map.put("name", "Jams");
        Map<String, String> map2 = new HashMap<>(2);
        map2 = map;
        System.out.println(map2);
    }
}
