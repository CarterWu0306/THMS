package com.carter.pojo;

import org.eclipse.paho.client.mqttv3.MqttMessage;

public class ResponseMessage {

    private MqttMessage mqttMessage;

    public MqttMessage getMqttMessage() {
        return mqttMessage;
    }

    public void setMqttMessage(MqttMessage mqttMessage) {
        this.mqttMessage = mqttMessage;
    }
}
