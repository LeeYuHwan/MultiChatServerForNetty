package com.example.chat.service;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatService {

    private ChannelHandlerContext currentChattingClient;

    public void addClient(ChannelHandlerContext ctx) {

    }

}
