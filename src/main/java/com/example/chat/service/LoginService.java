package com.example.chat.service;

import com.example.chat.domain.User;
import com.example.chat.repository.*;
import io.netty.channel.Channel;
import io.netty.channel.ChannelId;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LoginService {
    private final UserRepository userRepository;
    private final ChannelIdUserIdRepository channelIdUserIdRepository;
    private final UserIdChannelRepository userIdChannelRepository;
    private final UserIdRoomIdRepository userIdRoomIdRepository;
    private final RoomIdUserIdRepository roomIdUserIdRepository;

    public void login(Channel channel, String task, Map<String, Object> requestData, Map<String, Object> responseData) throws Exception {
        String userId = (String) requestData.get("userId");
        String password = (String) requestData.get("password");

        if (userId == null || password == null) {
            //messageService.returnMessage(channel, result, new Exception("아이디 또는 비밀번호를 입력하세요."), "1002");
            return;
        }

        User user = userRepository.findById(userId).orElseThrow(Exception::new);

        if (user == null) {

            //messageService.returnMessage(channel, requestData, new Exception("사용자 아이디가 존재하지 않습니다."), "1003");
            return;

        } else if (!StringUtils.equals(password, user.getPassword())) {

            //messageService.returnMessage(channel, requestData, new Exception("비밀번호가 일치하지 않습니다."), "1004");
            return;

        }

        channelIdUserIdRepository.getChannelIdUserIdMap().put(channel.id(), userId);
        userIdChannelRepository.getUserIdChannelMap().put(userId, channel);

        //messageService.returnMessage(channel, requestData, task);
    }

    public void logout(Channel channel) {

        String userId = channelIdUserIdRepository.getChannelIdUserIdMap().get(channel.id());

        if(!StringUtils.isEmpty(userId)) {
            userIdChannelRepository.getUserIdChannelMap().remove(userId);
            String roomId = userIdRoomIdRepository.getUserIdRoomIdMap().get(userId);

            if(!StringUtils.isEmpty(roomId)){
                roomIdUserIdRepository.getRoomIdUserIdMap().remove(roomId, userId);
                userIdRoomIdRepository.getUserIdRoomIdMap().remove(userId);
            }

            channelIdUserIdRepository.getChannelIdUserIdMap().remove(channel.id());
        }

    }

}
