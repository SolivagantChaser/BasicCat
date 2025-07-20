package com.july.mymall.chatroomservice.client.config;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NettyClientConfig {

    @Bean(destroyMethod = "shutdownGracefully")
    public EventLoopGroup clientWorkerGroup() {
        return new NioEventLoopGroup();
    }

    @Bean
    public Bootstrap bootstrap(EventLoopGroup clientWorkerGroup) {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(clientWorkerGroup)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {

                    }
                });
        return bootstrap;
    }
}
