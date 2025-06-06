package com.gsh.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;

/**
 * ClassName: CampusEaseAgent
 * Package: com.gsh.assistant
 * Description:
 *
 * @Author Gush
 * @Create 2025/5/20 15:51
 */
@AiService(
        wiringMode = AiServiceWiringMode.AUTOMATIC,
//        chatModel = "deepseek-chat",
        chatMemoryProvider = "chatMemoryProviderCampusEase",
        tools = "orderTools", //tools配置
        contentRetriever = "contentRetriever" //配置向量存储
)
public interface CampusEaseAgent {
    @SystemMessage(fromResource = "promot.txt")
    Flux<String> chat(@MemoryId Long memoryId, @UserMessage String userMessage);
}
