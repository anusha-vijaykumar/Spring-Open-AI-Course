package com.example.openai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChatController {
    @Autowired
    @Qualifier("openAiChatClient")
    private ChatClient openAiClient;

@GetMapping("/openai/chat")
    public String openAiChat(@RequestParam("message") String message){
        return openAiClient.prompt().user(message).call().content();
    }
}
