package com.carter.dubbo.service;

import org.eclipse.paho.client.mqttv3.MqttMessage;

public interface GetMqttMessageDubboService {
    MqttMessage getMqttMessage() throws Exception;
}
