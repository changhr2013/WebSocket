package com.chr.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 程序的入口，负责启动应用
 * @author changhr2013
 *
 */
public class Main {
	public static void main(String[] args) {
		EventLoopGroup bossGroup=new NioEventLoopGroup();
		EventLoopGroup workGroup=new NioEventLoopGroup();
		try {
			ServerBootstrap sbs=new ServerBootstrap();
			sbs.group(bossGroup, workGroup);
			sbs.channel(NioServerSocketChannel.class);
			sbs.childHandler(new MyWebSocketChannelHandler());
			System.out.println("changhr服务端开启等待客户端连接...");
			Channel ch = sbs.bind(8888).sync().channel();
			ch.closeFuture().sync();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
	}

}
