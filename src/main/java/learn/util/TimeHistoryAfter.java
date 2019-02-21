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
package util;

import org.jsoup.nodes.Document;
import temp.util.IOUtil;

/**
 * @author flysLi
 * @ClassName TimeHistoryAfter
 * @Decription TODO
 * @Date 2018/12/28 11:07
 * @Version 1.0
 */
public class TimeHistoryAfter implements After {
    @Override
    public Object some(Document document) {
        String dom = document.getElementById("content").html();
        IOUtil.append("D:\\L临时数据\\时间简史.txt", dom);
        System.out.println("---");
        return null;
    }
}
