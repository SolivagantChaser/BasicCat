package com.july.mymall.chatroomservice.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class NettyServerRunner implements CommandLineRunner {
    private final ServerBootstrap serverBootstrap;

    private final int port;

    public NettyServerRunner(ServerBootstrap serverBootstrap, @Value("${netty.server.port:9090}") int port) throws InterruptedException {
        this.serverBootstrap = serverBootstrap;
        this.port = port;
    }

    @Override
    public void run(String... args) throws Exception {
        // 绑定端口并启动服务器
        ChannelFuture channelFuture = serverBootstrap.bind(port).sync();

        // 等待服务器关闭（阻塞当前线程）
        channelFuture.channel().closeFuture().sync();
    }
}
