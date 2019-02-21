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
package scoket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author flysLi
 * @ClassName Server
 * @Decription TODO
 * @Date 2018/12/20 14:18
 * @Version 1.0
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(9999);
            while (true) {
                System.out.println("开始监听");
                Socket client = server.accept();
                InputStream is = client.getInputStream();
                byte[] data = new byte[is.available()];
                is.read(data);
                String text = new String(data);
                System.out.println(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
