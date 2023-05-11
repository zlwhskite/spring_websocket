# spring_websocket
- 웹소켓 공부


## WebSocketConfigurer
~~~
@Override
public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
  registry.addHandler(핸들러, "웹소켓시작주소").setAllowedOrigins("*"); //CORS처리
}
~~~

## TextWebSocketHandler
- public void afterConnectionEstablished(WebSocketSession session) throws Exception -> 웹소켓 성공 시 호출됨
- public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception -> 웹소켓이 접속이 끊어지면 호출됨
- protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception -> 사용자의 메시지를 받게되면 동작하는 메소드



참고블로그 https://lts0606.tistory.com/569
