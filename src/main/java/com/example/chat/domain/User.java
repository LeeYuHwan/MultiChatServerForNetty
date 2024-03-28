package com.example.chat.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class User {
    private long userNumber;
    @Id
    @Column(nullable = false, length = 30)
    private String userId;
    @Column(nullable = false, length = 32)
    private String password;
}
