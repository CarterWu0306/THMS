package com.carter.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.carter.dubbo.service.GetMqttMessageDubboService;
import com.carter.dubbo.service.SocketClientDubboService;
import com.carter.websocket.ScoketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class WebSocketController {
    @Reference
   private SocketClientDubboService socketClientDubboServiceImpl;

    @Autowired
    private ScoketClient webScoketClient;

    //,@PathVariable String cid

    @RequestMapping("socketClient")
    public ModelAndView socketClient(Model model) throws Exception {
        String msg = socketClientDubboServiceImpl.msg();
        ModelAndView mav=new ModelAndView("/socket");
        model.addAttribute("msg",msg);
        model.addAttribute("cid",123);
        return mav;
    }

//    public ModelAndView socketHumiture(Model model){
//        ModelAndView mav = new ModelAndView("/socket");
//        return mav;
//    }

//    @RequestMapping("showClient")
//    @ResponseBody
//    public String show() throws Exception {
//        byte[] payload = getMqttMessageDubboServiceImpl.getMqttMessage().getPayload();
//        String s = new String(payload);
//        return s;
//    }

    @GetMapping("/sendMessage")
    public String sendMessage(String message){
        message="testMessage";
        webScoketClient.groupSending(message);
        return "index";
    }
}
