package com.july.mymall.chatroomservice.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

public class UserChannelHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object object) {
        if (object instanceof FullHttpRequest) {
            handleFullHttpRequest(channelHandlerContext, (FullHttpRequest) object);
        } else if (object instanceof WebSocketFrame) {
            handleWebsocketFrame(channelHandlerContext, (WebSocketFrame) object);
        } else {
            throw new RuntimeException("not support");
        }
    }

    private void handleWebsocketFrame(ChannelHandlerContext ctx, WebSocketFrame socketFrame) {

    }

    private void handleFullHttpRequest(ChannelHandlerContext ctx, FullHttpRequest request) {
        Channel channel = ctx.channel();

    }
}
