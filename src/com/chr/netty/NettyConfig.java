package com.chr.netty;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * �洢�������̵�ȫ�ֱ���
 * */
public class NettyConfig {

	//�洢ÿһ���ͻ��˽������ʱ��channel����
	public static ChannelGroup group=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
}
