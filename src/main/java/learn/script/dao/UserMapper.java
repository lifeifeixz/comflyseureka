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
package script.dao;

import script.common.annotations.Drop;
import script.common.annotations.NameSpace;
import script.core.BaseMapper;
import script.entity.User;

/**
 * @author flysLi
 * @ClassName UserMapper
 * @Decription TODO
 * @Date 2018/12/17 14:04
 * @Version 1.0
 */
@NameSpace(path = "D:\\workspace_srudent\\comflyseureka\\src\\main\\java\\script\\mapper\\userMapper.js")
public interface UserMapper extends BaseMapper<User, Integer> {

    @Drop(type = "Select")
    User showName(String name);

    @Drop(type = "Select")
    User findOne(int id);
}
