package com.carter.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.carter.dubbo.service.GetMqttMessageDubboService;
import com.carter.dubbo.service.SocketClientDubboService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SocketClientDubboServiceImpl implements SocketClientDubboService {

    @Autowired
    private GetMqttMessageDubboService getMqttMessageDubboServiceImpl;

    @Override
    public String msg() throws Exception {
        byte[] payload = getMqttMessageDubboServiceImpl.getMqttMessage().getPayload();
        String msg = new String(payload);
        return msg;
    }
}
