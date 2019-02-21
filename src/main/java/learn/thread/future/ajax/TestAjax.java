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
package thread.future.ajax;

/**
 * @author flysLi
 * @ClassName TestAjax
 * @Decription TODO
 * @Date 2018/10/29 16:41
 * @Version 1.0
 */
public class TestAjax {
    public static void main(String[] args) {
        Ajax.get("https://blog.csdn.net/lmy86263/article/details/60479350",
                o -> System.out.println(o.toString()));
        System.out.println("执行下一步程序");
    }
}
