package com.july.mymall.chatroomservice.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NettyClientService {
    private final Bootstrap bootstrap;

    private final int port;

    private final String host;

    public NettyClientService(Bootstrap bootstrap, @Value("${netty.server.host:localhost}")String host,
    @Value("${netty.server.port:9090}") int port) {
        this.bootstrap = bootstrap;
        this.host = host;
        this.port = port;
    }

    public Channel connect() {
        ChannelFuture channelFuture = bootstrap.connect(host, port);
        return channelFuture.channel();
    }
}
