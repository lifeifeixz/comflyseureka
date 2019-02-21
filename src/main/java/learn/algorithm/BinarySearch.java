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
package learn.algorithm;

/**
 * @author flysLi
 * @ClassName BinarySearch
 * @Decription TODO
 * @Date 2018/12/4 15:23
 * @Version 1.0
 */
public class BinarySearch {

    public static int biSearch(int[] array, int a) {
        int lo = 0;
        int hi = array.length - 1;
        int mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (array[mid] == a) {
                return mid + 1;
            } else if (array[mid] < a) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }


}
