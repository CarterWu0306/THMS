package com.carter.pojo;

import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.io.Serializable;

public class ResponseMessage implements Serializable {

    private MqttMessage mqttMessage;

    public MqttMessage getMqttMessage() {
        return mqttMessage;
    }

    public void setMqttMessage(MqttMessage mqttMessage) {
        this.mqttMessage = mqttMessage;
    }
}
