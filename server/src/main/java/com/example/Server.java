package com.example;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Gary on 16/5/28.
 */
public class Server implements Runnable{
    private Thread thread;
    private ServerSocket servSock;
    private Main main;

    public Server(Main main){

        this.main = main;
        try {
            // Detect server ip
            InetAddress IP = InetAddress.getLocalHost();
            System.out.println("IP of my system is := "+IP.getHostAddress());
            System.out.println("Waitting to connect......");

            // Create server socket
            servSock = new ServerSocket(2000);

            // Create socket thread
            thread = new Thread(this);
            thread.start();
        } catch (java.io.IOException e) {
            System.out.println("Socket啟動有問題 !");
            System.out.println("IOException :" + e.toString());
        } finally{

        }
    }

    @Override
    public void run(){
        InputStream in;
        Socket clntSock;
        int length = 0;

        // Running for waitting multiple client
            try{
                // After client connected, create client socket connect with client
                clntSock = servSock.accept();
                System.out.println("Connected!!");
                while(true) {
                    // Transfer data
                    byte[] b = new byte[1024];
                    in = clntSock.getInputStream();
                    length = in.read(b);
                    String s = new String(b);
                    if(length > 1) {
                        this.main.setText(s+"\n");
                        length = 0;
                    }
                }
            }
            catch(Exception e) {
                //System.out.println("Error: "+e.getMessage());
            }
    }
}
