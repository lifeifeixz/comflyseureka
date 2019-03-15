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
package other;

/**
 * @author flysLi
 * @ClassName CalculationHash
 * @Decription TODO
 * @Date 2019/3/12 10:28
 * @Version 1.0
 */
public class CalculationHash {
    public static void main(String[] args) {
        String str = "https://fanyi.baidu.com/?aldtype=16047#zh/en/%E8%AE%A1%E7%AE%97";
        int code = str.hashCode();
        System.out.println(code);
    }
}
