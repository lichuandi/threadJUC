package com.lichuandi.threadjuc;

import com.lichuandi.netty.NettyClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther digege
 * @Date 2021/1/11
 * @Description：com.lichuandi.threadjuc version：1
 */
@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
        //启动netty客户端
        NettyClient nettyClient = new NettyClient();
        nettyClient.start();
    }
}