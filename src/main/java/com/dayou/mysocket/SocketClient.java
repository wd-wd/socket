package com.dayou.mysocket;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Desc :客户端
 * Created by WangDong on 2017/9/15.
 */

public class SocketClient {
    private static final String TAG = "SocketClient";

    public static void sendMessage() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Socket client = null;
                try {
                    client = new Socket("127.0.0.1", 6666);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    String line = bufferedReader.readLine();
                    Log.d(TAG, line);
                    bufferedReader.close();
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
