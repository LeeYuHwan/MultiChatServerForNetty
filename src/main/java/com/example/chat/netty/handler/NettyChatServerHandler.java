package com.example.chat.netty.handler;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.Map;

@Slf4j
@Component
public class NettyChatServerHandler extends ChannelInboundHandlerAdapter {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("Netty Chat Server Connected");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("Read Data : {}", msg);

        Map<String, Object> data;
        try {
            data = objectMapper.readValue((String) msg, new TypeReference<>() {});
            System.out.println(data);
        } catch (JsonParseException | JsonMappingException e) {
            log.error("JSON PARSE ERROR : {}", e);

            return;
        }


    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

        //loginService.removeUser(ctx.channel());

        ctx.close();

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
