package net.coderdaily.rabbitmq.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2018/4/1 下午11:52
 * Blog: coderdaily.net
 */
public class Send {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello World !";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("[x] Sent ’" + message + "'");
//            关闭
//            connection.close();
//            channel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
