package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {

        public void bind(int port) throws Exception {
            EventLoopGroup bossGroup = new NioEventLoopGroup(2);
            EventLoopGroup workerGroup = new NioEventLoopGroup(4);

            try {
                ServerBootstrap serverBootstrap = new ServerBootstrap();
                serverBootstrap.group(bossGroup, workerGroup)
                        .channel(NioServerSocketChannel.class)

                        .childHandler(new ChannelInitializer<SocketChannel>() {
                            protected void initChannel(SocketChannel socketChannel) throws Exception {
                                socketChannel.pipeline().addLast(new SimpleNettyServerHandler());

                            }
                        });

                ChannelFuture channelFuture = serverBootstrap.bind(port);

                System.out.println("server start");
                channelFuture.channel().closeFuture().sync();
            } finally {
                bossGroup.shutdownGracefully();
                workerGroup.shutdownGracefully();
            }

        }

    public static void main(String[] args) throws Exception {
        new netty.NettyServer().bind(8080);
    }
}
