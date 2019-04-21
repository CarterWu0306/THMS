package com.carter.server;

import com.carter.pojo.ResponseMessage;
import com.carter.websocket.ScoketClient;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PushCallback implements MqttCallback {

    ResponseMessage responseMessage = new ResponseMessage();

    @Autowired
    private ScoketClient scoketClient;


    public ResponseMessage getResponseMessage() {
        return responseMessage;
    }

    @Override
    //处理链接断开
    public void connectionLost(Throwable throwable) {
        // 连接丢失后，一般在这里面进行重连
        System.out.println(throwable.getMessage());
        System.out.println("连接断开，可以做重连");
    }

    @Override
    //处理消息送达
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        String msg = new String(mqttMessage.getPayload());
        System.out.println("接收消息主题 : " + s);
        System.out.println("接收消息Qos : " + mqttMessage.getQos());
        System.out.println("接收消息内容 : " + msg);
        responseMessage.setMqttMessage(mqttMessage);
        scoketClient.groupSending(msg);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
    }
}