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
 * @ClassName Invoker
 * @Decription TODO
 * @Date 2019/3/11 10:31
 * @Version 1.0
 */
public class Invoker {

    /**
     * 调用者只有一个命令对象
     **/
    Command command;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * 执行命令
     */
    public void executeCommand() {
        command.excute();
    }

    /**
     * 撤销命令
     */
    public void undoCommand() {
        command.unDo();
    }
}
