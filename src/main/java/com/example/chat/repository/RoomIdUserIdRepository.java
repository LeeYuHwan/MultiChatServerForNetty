package com.example.chat.repository;


import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class RoomIdUserIdRepository {
    private final MultiValueMap<String, String> roomIdUserIdMap = new LinkedMultiValueMap<>();

    public MultiValueMap<String, String> getRoomIdUserIdMap(){
        return roomIdUserIdMap;
    }

}
