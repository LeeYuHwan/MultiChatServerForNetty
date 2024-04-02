## Netty Toy Project MultiChatServer


#### 시스템 구성도

![image](https://github.com/LeeYuHwan/MultiChatServerForNetty/assets/66478929/a385f21f-f300-4fa7-9303-28e0ad665850)

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
"userId": userId
"roomId": roomId,
"task":"createRoom"
}

--------------------
## 방 입장
{
"userId": userId
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
"userId": userId,
"userName": userName,
"msg": Message,
"task":"sendRoom"
}
