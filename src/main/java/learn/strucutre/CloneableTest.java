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

import java.util.Arrays;

/**
 * @author flysLi
 * @ClassName CloneableTest
 * @Decription TODO
 * @Date 2018/11/13 11:06
 * @Version 1.0
 */
public class CloneableTest {
    public static void main(String[] args) {
        User user = new User();

        Object o = new Object();

        String[] arr = new String[]{"apple", "oracle", "google"};
        Arrays.sort(arr);
        for (String str : arr) {
            System.out.println(str);
        }
    }
}
