package org.allen.demo.util;

import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wl
 * @version V1.0
 * @Description TODO
 * @date 2019-02-13 15:20
 */
public class WebSocketUtil {

    /**
     * 模拟存储   在线用户
     */
    public static final Map<String, Session> USERS_ONLINE = new ConcurrentHashMap<>();

    /**
     * 向所有在线用户发送消息
     * @param message
     */
    public static void sendMessageToAllOnlineUser(String message){
        USERS_ONLINE.forEach((username, Session) -> sendMessage(Session, message));
    }

    /**
     * 向指定用户发送消息
     * @param session 用户session
     * @param message 发送消息内容
     */
    private static void sendMessage(Session session, String message) {
        if (session == null) {
            return;
        }

        final RemoteEndpoint.Basic basic = session.getBasicRemote();
        if (basic == null) {
            return;
        }

        try {
            basic.sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
