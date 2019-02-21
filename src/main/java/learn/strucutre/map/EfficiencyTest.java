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

import strucutre.User;

import javax.swing.text.html.parser.Entity;
import java.util.*;

/**
 * @author flysLi
 * @ClassName EfficiencyTest
 * @Decription TODO
 * @Date 2018/11/13 15:27
 * @Version 1.0
 */
public class EfficiencyTest {
    public static void main(String[] args) {
//        Map<String, Object> table = new Hashtable<>();
//        table = new HashMap<>();
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 1000000; i++) {
//            table.put("key" + i, i);
//        }
//        long end = System.currentTimeMillis();
//        System.out.println((end - start) + " 毫秒");
//        int a = 9;
//        a <<= 3;
//        System.out.println(a);
        User user = new User();
        user.setName("asd");
        user.setAge(12);
        List<User> userList = new ArrayList<>(1);
        userList.add(user);
        user.setAge(14);
        System.out.println(userList.get(0).getAge());
    }
}
