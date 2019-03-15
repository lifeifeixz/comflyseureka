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
 * @ClassName Client
 * @Decription TODO
 * @Date 2019/3/11 10:33
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        //创建命令的接受者
        Receiver receiver = new Receiver();
        //创建命令对象，并设定他的接受者
        Command command = new ConcreteCommand(receiver);
        //创建命令执行者，并将相应的命令作为参数传递给Invoker
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        //执行命令和撤销命令测试
        invoker.executeCommand();
        invoker.undoCommand();
    }
}
