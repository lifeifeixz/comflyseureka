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
package learn.degisn.command;

/**
 * @author flysLi
 * @ClassName ConcreteCommand
 * @Decription TODO
 * @Date 2019/3/11 10:29
 * @Version 1.0
 */
public class ConcreteCommand implements Command{

    private Receiver receiver;

    @Override
    public void excute() {
        receiver.action();
    }

    @Override
    public void unDo() {
        receiver.unAction();
    }

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }
}
