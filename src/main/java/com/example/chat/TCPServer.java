package com.example.chat;

import com.example.chat.netty.NettyChatServer;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TCPServer {
    private final NettyChatServer nettyChatServer;

    @PostConstruct
    public void init() throws InterruptedException {
        nettyChatServer.run();
    }

    @PreDestroy
    private void destroy() throws Exception {
        nettyChatServer.stop();
    }
}
