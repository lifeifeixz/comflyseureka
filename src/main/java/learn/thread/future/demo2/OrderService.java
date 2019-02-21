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
 * @ClassName OrderService
 * @Decription TODO
 * @Date 2018/10/29 14:57
 * @Version 1.0
 */
public class OrderService {

    public static Order getOrder() {
        try {
            System.out.println("开始查询订单信息...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Order();
    }
}
