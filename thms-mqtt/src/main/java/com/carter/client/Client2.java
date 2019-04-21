package com.carter.client;

import com.carter.server.PushCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledExecutorService;

@Component
public class Client2 {
    public static final String SERVER_URL = "tcp://115.29.175.26:1883";
    public static final String TOPIC = "$SYS/broker/clients/connected";
    public static final String clientid  = "client2";

    private MqttClient client;
    private MqttConnectOptions options;
    private String userName = "mosquitto";
    private String passWord = "mosquitto";

    @Autowired
    PushCallback pushCallback;

    private ScheduledExecutorService scheduler;

    public void start() throws Exception{
        client = new MqttClient(SERVER_URL, clientid, new MemoryPersistence());
        options = new MqttConnectOptions();
        options.setCleanSession(true);
        options.setUserName(userName);
        options.setPassword(passWord.toCharArray());
        options.setConnectionTimeout(20);
        options.setKeepAliveInterval(20);
        client.setCallback(pushCallback);
        MqttTopic topic = client.getTopic(TOPIC);
        client.connect(options);
        int[] Qos = {1};
        String[] topic1 = {TOPIC};
        client.subscribe(topic1,Qos);
    }


    public  static void main (String[] args) throws Exception{
        Client2 client = new Client2();
        client.start();
    }
}
