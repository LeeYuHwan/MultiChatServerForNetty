package com.example.chat.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserIdRoomIdRepository {

    private final Map<String, String> userIdRoomIdMap = new ConcurrentHashMap<>();

    public Map<String, String> getUserIdRoomIdMap(){
        return userIdRoomIdMap;
    }

}
