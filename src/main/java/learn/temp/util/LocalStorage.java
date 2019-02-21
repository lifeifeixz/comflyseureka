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
package temp.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author flysLi
 * @ClassName LocalStorage
 * @Decription TODO
 * @Date 2018/11/19 11:19
 * @Version 1.0
 */
public class LocalStorage {
    private String path;
    private boolean exits;

    public LocalStorage(String path) {
        this.path = path;
    }

    public LocalStorage(String path, boolean exits) {
        this.path = path;
        this.exits = exits;
    }

    @SuppressWarnings("all")
    public void writer(String content) {
        File file = new File(this.path);
        FileOutputStream fop = null;
        try {
            fop = new FileOutputStream(file, true);
            byte[] bytes = content.getBytes();
            try {
                fop.write(bytes);
                fop.flush();
                fop.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
