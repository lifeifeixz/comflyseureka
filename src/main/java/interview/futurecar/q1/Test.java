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
 * @ClassName Test
 * @Decription TODO
 * @Date 2019/2/20 16:44
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        MessageFactory factory = MessageFactoryImpl.newInstance();
        factory.newMessage("000111").printMessage();
    }
}
