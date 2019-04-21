package com.carter.dubbo.service;

import org.eclipse.paho.client.mqttv3.MqttMessage;

public interface GetMqttMessageService {
    MqttMessage getMqttMessage() throws Exception;
}
