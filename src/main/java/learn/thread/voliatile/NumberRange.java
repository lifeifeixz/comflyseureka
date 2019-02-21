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
package thread.voliatile;

/**
 * @author flysLi
 * @ClassName NumberRange
 * @Decription TODO
 * @Date 2018/10/25 10:16
 * @Version 1.0
 */
public class NumberRange {
    private int lower = 0;
    private int upper = 5;

    public int getLower() {
        return lower;
    }

    public void setLower(int lower) {
        if (lower > upper) {
            throw new RuntimeException("lower必须不能大于upper的值");
        }
        //设置好值之后程序阻塞0.1秒
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.lower = lower;
    }

    public int getUpper() {
        return upper;
    }

    public void setUpper(int upper) {
        if (upper < lower) {
            throw new RuntimeException("upper不能小于lower的值");
        }
        this.upper = upper;
    }

    @Override
    public String toString() {
        return "NumberRange{" +
                "lower=" + lower +
                ", upper=" + upper +
                '}';
    }
}
