package com.lichuandi.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @Auther digege
 * @Date 2021/1/11
 * 客户端初始化器
 * @Description：com.lichuandi.netty version：1
 */

public class NettyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast("decoder", new StringDecoder());
        socketChannel.pipeline().addLast("encoder", new StringEncoder());
        socketChannel.pipeline().addLast(new NettyClientHandler());
    }
}