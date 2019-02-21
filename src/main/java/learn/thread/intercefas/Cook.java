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
package thread.intercefas;

/**
 * @author flysLi
 * @ClassName Cook
 * @Decription TODO
 * @Date 2018/10/22 10:58
 * @Version 1.0
 */
public interface Cook {

    default Cook brushPot() {
        System.out.println("如果你不想刷锅，就当做郭已经刷好。");
        return this;
    }

    Cook cutUpVegetables();

    Cook cooking();

    Cook outPot();
}
