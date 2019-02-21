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
package interview.futurecar.q1;

/**
 * @author flysLi
 * @ClassName MessageImpl
 * @Decription TODO
 * @Date 2019/2/20 16:42
 * @Version 1.0
 */
public class MessageImpl implements Message {
    public String countryCode;

    public MessageImpl(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public void printMessage() {
        System.out.println("国家代码:" + countryCode);
    }
}
