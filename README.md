## Netty Toy Project MultiChatServer


#### 시스템 구성도

![image](https://github.com/LeeYuHwan/MultiChatServerForNetty/assets/66478929/dfb3a2fa-2898-44de-85da-a0f4b0a29c0b)

--------------------

#### Socket 통신 명세
--------------------
JSON Data를 이용하여 통신
--------------------
## 로그인
{
"userId": userId,
"password": password,
"task":"login"
}

--------------------
## 방 생성
{
"roomId": roomId,
"task":"createRoom"
}

--------------------
## 방 입장
{
"roomId": roomId,
"task":"enterRoom"
}

--------------------
## 방 퇴장
{
"roomId": roomId,
"task":"exitRoom"
}

--------------------
## 메시지 전송
{
"userName": userName,
"msg": Message,
"task":"sendRoom"
}
