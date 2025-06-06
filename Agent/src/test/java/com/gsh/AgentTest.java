package com.gsh;

import com.gsh.assistant.CampusEaseAgent;
import com.gsh.entity.Order;
import com.gsh.service.OrderService;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

/**
 * ClassName: com.gsh.AgentTest
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author Gush
 * @Create 2025/5/20 15:43
 */
@SpringBootTest
public class AgentTest {
    @Autowired
    private OpenAiChatModel openAiChatModel;
    @Test
    public void test() {
        //向模型提问
        String answer = openAiChatModel.chat("你好");
        //输出结果
        System.out.println(answer);
    }

    @Autowired
    private CampusEaseAgent campusEaseAgent;
    @Test
    public void test2(){
        //向模型提问
//        String answer = campusEaseAgent.chat(1L, "你是什么模型？");
        //输出结果
//        System.out.println(answer);
    }

    @Autowired
    private OrderService orderService;
    @Test
    void testGetOne() {
        Order appointment = new Order();
        appointment.setUserId(145L);
        appointment.setVoucherId(10L);
        appointment.setCreateTime(LocalDateTime.of(2024, 12, 11, 16, 44, 41));
        Order appointmentDB = orderService.getOne(appointment);
        System.out.println(appointmentDB);
    }
    @Test
    void testRemoveById() {
        orderService.removeById(399175467376050290L);
    }
}
