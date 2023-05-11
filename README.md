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
- public void afterConnectionEstablished(WebSocketSession session) throws Exception -> 웹소켓 생성될 때 호출됨
- public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception -> 웹소켓이 종료될 때 호출됨
- protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception -> 로직구현하기
