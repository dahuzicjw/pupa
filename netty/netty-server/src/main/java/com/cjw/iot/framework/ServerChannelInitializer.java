package com.cjw.iot.framework;

import com.cjw.iot.framework.handler.ServerMessageHandler;
import com.cjw.iot.framework.message.MessageDecoder;
import com.cjw.iot.framework.message.MessageEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 管道配置
 *
 * @author chenjw
 * @date 2020/7/8
 **/
@Component
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {


    @Autowired
    private ApplicationContext applicationContext;

    @Override
    protected void initChannel(SocketChannel socketChannel) {
        // 编码器
        socketChannel.pipeline().addLast("encoder", new MessageEncoder());

        // 分包解码器
        socketChannel.pipeline().addLast("subpackage decode",
                new LengthFieldBasedFrameDecoder(
                        // 最大报文长度
                        1024,
                        // 长度字段起始位置
                        14,
                        // 长度字段字节数，int类型，4字节
                        4));
        // 请求参数解码器
        socketChannel.pipeline().addLast("message decode", new MessageDecoder());

        // 心跳配置，120秒断开连接
        socketChannel.pipeline().addLast("heart attach",
                new IdleStateHandler(120, 0, 0, TimeUnit.SECONDS));

        // 业务处理handler
        socketChannel.pipeline().addLast("handler", applicationContext.getBean(ServerMessageHandler.class));

    }
}