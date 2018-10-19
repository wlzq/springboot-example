package org.allen.demo.service;

public interface MessageDao {

    /**
     * 发送队列消息
     * @param dest
     * @param msg
     */
    void sendMessage(String dest, String msg);

    /**
     *发送topic消息
     * @param dest
     * @param msg
     */
    void sendTopicMessage(String dest, String msg);

}
