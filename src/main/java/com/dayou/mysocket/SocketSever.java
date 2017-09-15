package com.dayou.mysocket;

import android.util.Log;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Desc :开启服务套接字工具类
 * Created by WangDong on 2017/9/15.
 */

public class SocketSever {
    private static final String TAG = "SocketSever";

    /*public static void main(String[] strings) {
        sever();
    }*/

    public static void startSever() {
        sever();
    }

    private static void sever() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ServerSocket serverSocket = null;
                Socket client = null;
                PrintStream outPrint = null;//打印输出流
                try {
                    serverSocket = new ServerSocket(6666);
                    Log.d(TAG, "服务开启等待客户端连接");
                    client = serverSocket.accept();//当客户端未向服务器建立连接时阻塞
                    String fromServer = "从服务器来的数据";
                    outPrint = new PrintStream(client.getOutputStream());
                    outPrint.print(fromServer);//向客户端输出
                    //关闭socket
                    client.close();
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
