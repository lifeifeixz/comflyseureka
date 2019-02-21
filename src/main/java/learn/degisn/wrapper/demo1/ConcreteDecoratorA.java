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
package learn.degisn.wrapper.demo1;

/**
 * @author flysLi
 * @ClassName ConcreteDecoratorA
 * @Decription TODO
 * @Date 2018/12/13 17:19
 * @Version 1.0
 */
public class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void sampleOperation() {
        System.out.println("before");
        super.sampleOperation();
        System.out.println("after");
    }
}
