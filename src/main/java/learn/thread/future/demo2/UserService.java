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
package thread.future.demo2;


/**
 * @author flysLi
 * @ClassName UserService
 * @Decription TODO
 * @Date 2018/10/29 14:56
 * @Version 1.0
 */
public class UserService {
    public static User getUser() {
        try {
            System.out.println("开始获取用户信息...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new User();
    }
}
