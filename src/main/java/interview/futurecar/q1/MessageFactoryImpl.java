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
 * @ClassName MessageFactoryImpl
 * @Decription TODO
 * @Date 2019/2/20 16:38
 * @Version 1.0
 */
public class MessageFactoryImpl implements MessageFactory {
    private static MessageFactory factory = null;

    private MessageFactoryImpl() {

    }

    @Override
    public Message newMessage(String countryCode) {
        return (Message) () -> System.out.println(countryCode);
    }

    public static MessageFactory newInstance() {
        synchronized (MessageFactoryImpl.class) {
            if (factory == null) {
                factory = new MessageFactoryImpl();
                return factory;
            } else {
                return factory;
            }
        }
    }
}
