package com.example.chat.repository;

import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserIdChannelRepository {

    private final Map<String, Channel> userIdChannelMap = new ConcurrentHashMap<>();

    public Map<String, Channel> getUserIdChannelMap(){
        return userIdChannelMap;
    }

}
