package com.carter.dubbo.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.carter.client.Client2;
import com.carter.dubbo.service.GetMqttMessageDubboService;
import com.carter.pojo.ResponseMessage;
import com.carter.server.PushCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;


import javax.annotation.Resource;


@Service
public class GetMqttMessageDubboServiceImpl implements GetMqttMessageDubboService {

    @Resource
    private Client2 client2;

    @Autowired
    private PushCallback pushCallback;

    private ResponseMessage responseMessage;

    @Override
    public MqttMessage getMqttMessage() throws Exception {
        client2.start();
        responseMessage=pushCallback.getResponseMessage();
        if (responseMessage.getMqttMessage()!=null){
            MqttMessage mqttMessage = responseMessage.getMqttMessage();
            return mqttMessage;
        }else {
            MqttMessage mqttMessage = new MqttMessage();
            mqttMessage.setPayload("等待接收消息".getBytes());
            return mqttMessage;
        }
    }


}
