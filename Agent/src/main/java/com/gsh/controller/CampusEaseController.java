package com.gsh.controller;

import com.gsh.assistant.CampusEaseAgent;
import com.gsh.bean.ChatForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * ClassName: CampusEaseController
 * Package: com.gsh.controller
 * Description:
 *
 * @Author Gush
 * @Create 2025/5/20 16:59
 */
@Tag(name = "CampusEaseAgent智能助手")
@RestController
@RequestMapping("/xiaozhi")
public class CampusEaseController {
    @Autowired
    private CampusEaseAgent campusEaseAgent;
    @Operation(summary = "对话")
    @PostMapping(value = "/chat", produces = "text/stream;charset=utf-8")
    public Flux<String> chat(@RequestBody ChatForm chatForm) {
        return campusEaseAgent.chat(chatForm.getMemoryId(), chatForm.getMessage());
    }
}
