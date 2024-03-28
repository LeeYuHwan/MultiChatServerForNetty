package com.example.chat.service;

import com.example.chat.repository.ChannelIdUserIdRepository;
import com.example.chat.repository.RoomIdUserIdRepository;
import com.example.chat.repository.UserIdChannelRepository;
import com.example.chat.repository.UserIdRoomIdRepository;
import io.netty.channel.Channel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomService {

    private final UserIdChannelRepository userIdChannelRepository;
    private final ChannelIdUserIdRepository channelIdUserIdRepository;
    private final UserIdRoomIdRepository userIdRoomIdRepository;
    private final RoomIdUserIdRepository roomIdUserIdRepository;

    public void createRoom(Channel channel, String task, Map<String, Object> responseData) throws Exception {
        String userId = channelIdUserIdRepository.getChannelIdUserIdMap().get(channel.id());
        responseData.put("task", task);

        if(channelIdUserIdRepository.getChannelIdUserIdMap().containsKey(userId)) {

            responseData.put("error", "Already entered user");
            //messageService.returnMessage(channel, responseMap, new Exception("룸에 입장해있는 사용자입니다."), "9999");
            return;
        }

        String roomId = UUID.randomUUID().toString();

        roomIdUserIdRepository.getRoomIdUserIdMap().add(roomId, userId);
        userIdRoomIdRepository.getUserIdRoomIdMap().put(userId, roomId);

        responseData.put("roomId", roomId);

        //messageService.returnMessage(channel, responseMap, task);
    }
}
