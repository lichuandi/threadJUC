package com.lichuandi.threadjuc;

import com.lichuandi.netty.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;

/**
 * @Auther digege
 * @Date 2021/1/11
 * @Description：com.lichuandi.threadjuc version：1
 */
@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
        //启动服务端
        NettyServer nettyServer = new NettyServer();
        nettyServer.start(new InetSocketAddress("127.0.0.1", 8090));
    }

}
