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
package thread;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author flysLi
 * @ClassName MyQueuedSynchronizer
 * @Decription TODO
 * @Date 2018/10/23 9:33
 * @Version 1.0
 */
public class MyQueuedSynchronizer extends AbstractQueuedSynchronizer {

    /**
     * 独占式获取同步状态，试着获取，成功返回true，反之为false
     *
     * @param arg
     * @return
     */
    @Override
    protected boolean tryAcquire(int arg) {
        return super.tryAcquire(arg);
    }

    /**
     * 独占式释放同步状态，等待中的其他线程此时将有机会获取到同步状态
     *
     * @param arg
     * @return
     */
    @Override
    protected boolean tryRelease(int arg) {
        return super.tryRelease(arg);
    }

//    /**
//     * 共享式获取同步状态，返回值大于等于0，代表获取成功；反之获取失败
//     *
//     * @param arg
//     * @return
//     */
//    @Override
//    protected int tryAcquireShared(int arg) {
//        return super.tryAcquireShared(arg);
//    }
//
//    /**
//     * 共享式释放同步状态，成功为true，失败为false
//     *
//     * @param arg
//     * @return
//     */
//    @Override
//    protected boolean tryReleaseShared(int arg) {
//        return super.tryReleaseShared(arg);
//    }

    /**
     * 是否在独占模式下被线程占用
     *
     * @return
     */
    @Override
    protected boolean isHeldExclusively() {
        return getState() == 1;
    }
}
