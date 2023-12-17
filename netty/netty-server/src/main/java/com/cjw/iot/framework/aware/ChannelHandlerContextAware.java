package com.cjw.iot.framework.aware;

import io.netty.channel.ChannelHandlerContext;

/**
 * ChannelHandlerContext对象注入
 * 实现接口可获得当前对象管道处理环境
 *
 * @author: chenjw
 * @date: 2020/7/16
 */
public interface ChannelHandlerContextAware extends Aware {

    /**
     * 注入ChannelHandlerContext对象
     *
     * @param channelHandlerContext
     */
    void setChannelHandlerContext(ChannelHandlerContext channelHandlerContext);
}
