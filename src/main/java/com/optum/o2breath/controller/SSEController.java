package com.optum.o2breath.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/sse")
public class SSEController {

    private final SseEmitter sseEmitter = new SseEmitter();

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter handleSSE() {
        return sseEmitter;
    }

    @GetMapping("/send")
    public void sendMessage() {
        try {
            sseEmitter.send(SseEmitter.event().name("message").data("Hello, from the server!"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
